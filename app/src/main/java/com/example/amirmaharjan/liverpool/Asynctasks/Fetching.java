package com.example.amirmaharjan.liverpool.Asynctasks;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.amirmaharjan.liverpool.adaptors.RecyclerAdapters;
import com.example.amirmaharjan.liverpool.database.databasehelper;
import com.example.amirmaharjan.liverpool.database.latestnews;
import com.example.amirmaharjan.liverpool.database.mediawatch;
import com.example.amirmaharjan.liverpool.database.ticketnews;
import com.example.amirmaharjan.liverpool.model.LatestNews;

import java.util.ArrayList;

/**
 * Created by Amir Maharjan on 11/7/2016.
 */

public class Fetching extends AsyncTask<Integer, Void, Void> {
    Context context;
    RecyclerView recyclerView;
    databasehelper database;
    ArrayList<LatestNews> latest;


    public Fetching(Context context, RecyclerView recyclerView){
        this.context = context;
        this.recyclerView = recyclerView;
    }



    @Override
    protected Void doInBackground(Integer... params) {
        int id = params[0];
        if(id==1)
        {
            latestnews news = new latestnews(context);
            news.Open();
            latest=news.GetAll();
            Log.d("latestnews",""+latest.size());
            news.close();

        }
        else if(id==2)
        {
            mediawatch media = new mediawatch(context);
            media.Open();
            latest = media.GetAll();
            Log.d("mediawatch",""+latest.size());
            media.close();

        }
        else if(id==3)
        {
            ticketnews ticket = new ticketnews(context);
            ticket.Open();
            latest = ticket.GetAll();
            Log.d("ticketnews",""+latest.size());
            ticket.close();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        database = new databasehelper(context);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        RecyclerAdapters adapter = new RecyclerAdapters(context,latest);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
    }


}
