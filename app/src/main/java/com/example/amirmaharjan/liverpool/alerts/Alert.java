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

}
