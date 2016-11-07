package com.example.amirmaharjan.liverpool.alerts;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;

/**
 * Created by Amir Maharjan on 11/2/2016.
 */

public class Alert extends AlertDialog {
    Context context;
    android.app.AlertDialog alertDialog;

    protected Alert(@NonNull Context context) {
        super(context);
        this.context=context;
    }




    private Builder initAlertDialog(String title, String msg) {
        Builder builder = new Builder(context);
        if (title.isEmpty()) {
            title ="FinalRss";
        }
        builder.setTitle(title);
        builder.setMessage(msg);
        return builder;
    }


}
