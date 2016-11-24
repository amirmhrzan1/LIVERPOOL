package com.example.amirmaharjan.liverpool.customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Amir Maharjan on 11/15/2016.
 */

public class MyCustomFont extends TextView {

    public MyCustomFont(Context context) {
        super(context);
        applyfont(context);
    }

    public MyCustomFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyfont(context);
    }

    public MyCustomFont(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyfont(context);
    }

    private void applyfont(Context context)
    {
        Typeface customfont = Fontcache.gettypeface(context,"Raleway-Bold.ttf");
        setTypeface(customfont);
    }



}
