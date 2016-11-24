package com.example.amirmaharjan.liverpool.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.amirmaharjan.liverpool.R;

import org.w3c.dom.Text;

/**
 * Created by Amir Maharjan on 11/15/2016.
 */

public class MyCustomFontAdvance extends TextView {
    public MyCustomFontAdvance(Context context) {
        super(context);
    }

    public MyCustomFontAdvance(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context, attrs);
    }

    public MyCustomFontAdvance(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCustomFont(context, attrs);
    }
    public void setCustomFont(Context context, AttributeSet attrs)
    {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyCustomFontAdvance,0,0);
        String fontName;
        try {
            fontName = typedArray.getString(R.styleable.MyCustomFontAdvance_fontName);
        } finally {

            typedArray.recycle();
        }
        if(fontName!=null)
        {
            Typeface typeface = selectTypeface(context, fontName);
            //Typeface bold=Typeface.create(typeface,Typeface.BOLD);
            setTypeface(typeface);

        }


    }

    public Typeface selectTypeface(Context context, String fontName) {
        if (fontName.contentEquals(context.getResources().getString(R.string.font_raleway_regular))) {
            return Fontcache.gettypeface(context, fontName);
        } else if (fontName.contentEquals(context.getResources().getString(R.string.font_raleway_bold))) {
            return Fontcache.gettypeface(context, fontName);
        } else if (fontName.contentEquals(context.getResources().getString(R.string.font_raleway_semi_bold))) {
            return Fontcache.gettypeface(context, fontName);
        } else if (fontName.contentEquals(context.getResources().getString(R.string.font_roboto_light))) {
            return Fontcache.gettypeface(context, fontName);
        } else {
            return null;//no typeface is set
        }
    }

}
