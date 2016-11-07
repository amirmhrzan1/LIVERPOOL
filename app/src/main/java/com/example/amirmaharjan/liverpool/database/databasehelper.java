package com.example.amirmaharjan.liverpool.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Amir Maharjan on 10/24/2016.
 */

public class databasehelper extends SQLiteOpenHelper{

    private static final String DATABASENAME = "NEWSFEED";
    private static int DATABASEVERSION = 1;


    //LATEST NEWS TABLE
    public static final String TABLE_LATESTNEWS = "LATESTNEWS";
    public static final String NEWS_ID = "Id";
    public static final String NEWS_TITLE = "title";
    public static final String NEWS_IMAGE = "image";
    public static final String NEWS_LINK = "link";
    public static final String NEWS_DESCRIPTION="description";
    public static final String NEWS_PUBLISHDATE="publishdate";

    private static final String CREATE_TABLE_LATESTNEWS = "CREATE TABLE "
            + TABLE_LATESTNEWS + "(" + NEWS_ID + " BIGINT PRIMARY KEY, "
            + NEWS_TITLE + " VARCHAR(50), "
            + NEWS_IMAGE + " text, "
            + NEWS_LINK + " text, "
            + NEWS_PUBLISHDATE + " text, "
            + NEWS_DESCRIPTION + " text" + ");";







    //MEDIA_WATCH
    public static final String TABLE_MEDIAWATCH = "MEDIAWATCH";
    public static final String MEDIA_ID = "Id";
    public static final String MEDIA_TITLE = "title";
    public static final String MEDIA_IMAGE = "image";
    public static final String MEDIA_LINK = "link";
    public static final String MEDIA_DESCRIPTION="description";
    public static final String MEDIA_PUBLISHDATE="publishdate";


    private static final String CREATE_TABLE_MEDIAWATCH = "CREATE TABLE "
            + TABLE_MEDIAWATCH + "(" + MEDIA_ID +" BIGINT PRIMARY KEY, "
            + MEDIA_TITLE + " TEXT, "
            + MEDIA_IMAGE + " TEXT, "
            + MEDIA_DESCRIPTION + " TEXT, "
            + MEDIA_LINK + " VARCHAR(500), "
            + MEDIA_PUBLISHDATE + " VARCHAR(250) "+")";


    //TICKET NEWS
    public static final String TABLE_TICKETNEWS = "TICKETNEWS";
    public static final String TICKET_ID = "Id";
    public static final String TICKET_TITLE = "title";
    public static final String TICKET_IMAGE = "image";
    public static final String TICKET_LINK = "link";
    public static final String TICKET_DESCRIPTION="description";
    public static final String TICKET_PUBLISHDATE="publishdate";

    private static final String CREATE_TABLE_TICKETNEWS = "CREATE TABLE "
            + TABLE_TICKETNEWS +"(" + TICKET_ID + "BIGINT PRIMARY KEY,"
            + TICKET_TITLE + " VARCHAR(500), "
            + TICKET_IMAGE + " VARCHAR(500), "
            + TICKET_DESCRIPTION + " TEXT, "
            + TICKET_LINK + " VARCHAR(500), "
            + TICKET_PUBLISHDATE + " VARCHAR(250)"+")";





    public databasehelper(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_LATESTNEWS);
        db.execSQL(CREATE_TABLE_MEDIAWATCH);
        db.execSQL(CREATE_TABLE_TICKETNEWS);


    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LATESTNEWS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEDIAWATCH);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TICKETNEWS);
        onCreate(db);

    }
}
