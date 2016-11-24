package com.example.amirmaharjan.liverpool.Asynctasks;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TableLayout;

import com.example.amirmaharjan.liverpool.adaptors.MyPagerAdaptor;
import com.example.amirmaharjan.liverpool.adaptors.RecyclerAdapters;
import com.example.amirmaharjan.liverpool.database.databasehelper;
import com.example.amirmaharjan.liverpool.database.latestnews;
import com.example.amirmaharjan.liverpool.database.mediawatch;
import com.example.amirmaharjan.liverpool.database.ticketnews;
import com.example.amirmaharjan.liverpool.helper.ConnectionManager;
import com.example.amirmaharjan.liverpool.model.LatestNews;
import com.example.amirmaharjan.liverpool.model.TaskParams;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Amir Maharjan on 11/7/2016.
 */

public class ReadRss extends AsyncTask<Void,Void,Void> {


    Context context;
    private String address;
    ProgressDialog progressDialog;
    RecyclerView recyclerView;
    TabLayout tabLayout;
    ViewPager viewPager;
    FragmentManager fm;

    ConnectionManager connmanager;
    ArrayList<LatestNews> latest;
    ArrayList<LatestNews> ln;
    ArrayList<LatestNews> mw;
    ArrayList<LatestNews> tn;
    latestnews news;
    mediawatch media;
    ticketnews ticket;
    //final Activity activity;

    URL url;

    public ReadRss(Context context) {
        this.context = context;
       // this.tabLayout = tabLayout;
        progressDialog = new ProgressDialog(context);
        ln=new ArrayList<LatestNews>();
        mw=new ArrayList<LatestNews>();
        tn=new ArrayList<LatestNews>();
        progressDialog.setMessage("Loading....");

    }


    @Override
    protected Void doInBackground(Void... params) {
        LatestNews late = new LatestNews();

            ln=ProcessXml(getdata("http://www.liverpoolfc.com/news.rss"));
            news = new latestnews(context);
            news.Open();
            news.Deleteall();
            for(int i=0;i<ln.size();i++)
            {
                news.Insert(ln.get(i));
            }
            news.close();

            mw=ProcessXml(getdata("http://www.liverpoolfc.com/news/media-watch.rss"));
            media = new mediawatch(context);
            media.Open();
            media.Deleteall();
            for(int i=0;i<mw.size();i++)
            {
                media.Insert(mw.get(i));
            }
            tn=ProcessXml(getdata("http://www.liverpoolfc.com/news/tickets.rss"));
            ticket = new ticketnews(context);
            ticket.Open();
            ticket.Deleteall();
            for(int i=0;i<tn.size();i++)
            {
                ticket.Insert(tn.get(i));
            }




        return null;
    }

    @Override
    protected void onPreExecute() {
        progressDialog.show();
        connmanager = new ConnectionManager(context);

        super.onPreExecute();
    }



    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        progressDialog.dismiss();


    }



    private ArrayList<LatestNews> ProcessXml(Document data) {
        if (data != null) {
            latest= new ArrayList<>();
            Element root = data.getDocumentElement();
            NodeList items = root.getElementsByTagName("item");
           // Node channel = root.getChildNodes().item(1);
          //  NodeList items = channel.getChildNodes();
           Log.d("number", "" + items.getLength());
            for (int i = 0; i < items.getLength(); i++) {
                Node currentchild = items.item(i);
                //if (currentchild.getNodeName().equalsIgnoreCase("item")) {
                    LatestNews item = new LatestNews();
                    NodeList itemchild = currentchild.getChildNodes();
                    for (int j = 0; j < itemchild.getLength(); j++) {
                        Node current = itemchild.item(j);
                        if (current.getNodeName().equalsIgnoreCase("title")) {
                            item.setTitle(current.getTextContent());
                        } else if (current.getNodeName().equalsIgnoreCase("description")) {
                            item.setDescription(current.getTextContent());
                        } else if (current.getNodeName().equalsIgnoreCase("link")) {
                            item.setLink(current.getTextContent());
                        } else if (current.getNodeName().equalsIgnoreCase("thumb")) {
                            item.setThumb(current.getTextContent());
                        } else if (current.getNodeName().equalsIgnoreCase("pubDate")) {
                            item.setPublishdate(current.getTextContent());
                        }

                    }
                    latest.add(item);


              //  }


            }

        }
        return latest;


    }

    public Document getdata(String address){
        try {
            url = new URL(address);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            InputStream inputStream = conn.getInputStream();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document xmldocument = documentBuilder.parse(inputStream);
            return xmldocument;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
