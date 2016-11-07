package com.example.amirmaharjan.liverpool.helper;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;

import com.example.amirmaharjan.liverpool.R;

/**
 * Created by Amir Maharjan on 11/2/2016.
 */

public class ConnectionManager {

    private static Context _ctx;

    public ConnectionManager(Context context){
        _ctx=context;
    }

    public boolean hasConnection()
    {
        ConnectivityManager conn = (ConnectivityManager) _ctx.getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = conn.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()){
            return true;
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(_ctx);
            builder.setTitle(_ctx.getResources().getString(R.string.app_name))
                    .setMessage("We cannot currently connect to the internet. Please try again soon. ")
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


}
