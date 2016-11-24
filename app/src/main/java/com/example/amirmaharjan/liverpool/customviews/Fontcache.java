package com.example.amirmaharjan.liverpool.customviews;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;


/**
 * Created by Amir Maharjan on 11/15/2016.
 */

public class Fontcache {

    private static HashMap<String, Typeface> fontCache = new HashMap<>();

    public static Typeface gettypeface(Context context, String FontName){
        Typeface typeface = fontCache.get(FontName);

        if(typeface==null)
        {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(),FontName);
            } catch (Exception e) {
                e.printStackTrace();
            }
            fontCache.put(FontName,typeface);

        }
        return typeface;
    }
}
