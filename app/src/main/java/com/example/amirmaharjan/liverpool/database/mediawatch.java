package com.example.amirmaharjan.liverpool.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.amirmaharjan.liverpool.model.LatestNews;

import java.util.ArrayList;

/**
 * Created by Amir Maharjan on 10/24/2016.
 */

public class mediawatch {
    databasehelper dbHelper;
    SQLiteDatabase db;
    LatestNews ln;
    public mediawatch(Context context) {
        dbHelper = new databasehelper(context);   }

    public void Open()
    {
        db = dbHelper.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public void Insert(LatestNews latestNews) {
        ContentValues values = new ContentValues();
        values.put(databasehelper.MEDIA_TITLE,latestNews.getTitle());
        values.put(databasehelper.MEDIA_LINK,latestNews.getLink());
        values.put(databasehelper.MEDIA_PUBLISHDATE,latestNews.getPublishdate());
        values.put(databasehelper.MEDIA_DESCRIPTION,latestNews.getDescription());
        values.put(databasehelper.MEDIA_IMAGE,latestNews.getThumb());
        db.insert(databasehelper.TABLE_MEDIAWATCH,null,values);

    }


    public ArrayList<LatestNews> GetAll() {
        ArrayList<LatestNews> array = new ArrayList<LatestNews>();
        String[] columns = {databasehelper.MEDIA_ID,databasehelper.MEDIA_TITLE,databasehelper.MEDIA_IMAGE,databasehelper.MEDIA_DESCRIPTION,
                databasehelper.MEDIA_LINK,databasehelper.MEDIA_PUBLISHDATE};
        Cursor cursor = db.query(databasehelper.TABLE_MEDIAWATCH,columns,null,null,null,null,null);
        while(cursor.moveToNext()){
            int index1=cursor.getColumnIndex(databasehelper.MEDIA_ID);
            int index2=cursor.getColumnIndex(databasehelper.MEDIA_TITLE);
            int index3=cursor.getColumnIndex(databasehelper.MEDIA_IMAGE);
            int index4=cursor.getColumnIndex(databasehelper.MEDIA_LINK);
            int index5=cursor.getColumnIndex(databasehelper.MEDIA_DESCRIPTION);
            int index6 = cursor.getColumnIndex(databasehelper.MEDIA_PUBLISHDATE);
            LatestNews latest = new LatestNews();
            latest.setId(cursor.getString(index1));
            latest.setTitle(cursor.getString(index2));
            latest.setThumb(cursor.getString(index3));
            latest.setLink(cursor.getString(index4));
            latest.setDescription(cursor.getString(index5));
            latest.setPublishdate(cursor.getString(index6));
            array.add(latest);

        }
        return array;

    }

    public LatestNews GetById(int id) {
        return null;
    }


    public String Update(LatestNews latestNews, int id) {
        return null;
    }

    public void Deleteall(){
        db.delete(databasehelper.TABLE_MEDIAWATCH,null,null);
    }

}
