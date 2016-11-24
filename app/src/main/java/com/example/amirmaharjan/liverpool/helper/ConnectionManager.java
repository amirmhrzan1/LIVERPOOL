package com.example.amirmaharjan.liverpool.helper;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.example.amirmaharjan.liverpool.R;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Amir Maharjan on 11/2/2016.
 */

public class ConnectionManager {

    private static Context context;

    public ConnectionManager(Context context){
        this.context=context;
    }

    public boolean hasConnection()
    {
        ConnectivityManager conn = (ConnectivityManager) context.getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = conn.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()){
            return true;
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(context.getResources().getString(R.string.app_name))
                    .setMessage("No Internet. Please try again later ")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();

                        }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();
            return false;


        }
    }

    /*public static boolean hasActiveInternetConnection(Context context) {
        if (isNetworkAvailable(context)) {
            try {
                HttpURLConnection urlc = (HttpURLConnection) (new URL("http://www.google.com").openConnection());
                urlc.setRequestProperty("User-Agent", "Test");
                urlc.setRequestProperty("Connection", "close");
                urlc.setConnectTimeout(1500);
                urlc.connect();
                return (urlc.getResponseCode() == 200);
            } catch (IOException e) {
                Log.e("Error", "Error checking internet connection", e);
            }
        } else {
            Log.d("Error", "No network available!");
        }
        return false;
    }*/




}
