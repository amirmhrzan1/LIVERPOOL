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

public class ticketnews {
    databasehelper dbHelper;
    SQLiteDatabase db;
    LatestNews ln;
    public ticketnews(Context context) {
        dbHelper = new databasehelper(context);  }

    public void Open()
    {
        db = dbHelper.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public void Insert(LatestNews latestNews) {
        ContentValues values = new ContentValues();
        values.put(databasehelper.TICKET_TITLE,latestNews.getTitle());
        values.put(databasehelper.TICKET_LINK,latestNews.getLink());
        values.put(databasehelper.TICKET_PUBLISHDATE,latestNews.getPublishdate());
        values.put(databasehelper.TICKET_DESCRIPTION,latestNews.getDescription());
        values.put(databasehelper.TICKET_IMAGE,latestNews.getThumb());
        db.insert(databasehelper.TABLE_TICKETNEWS,null,values);

    }


    public ArrayList<LatestNews> GetAll() {
        ArrayList<LatestNews> array = new ArrayList<LatestNews>();
        String[] columns = {databasehelper.TICKET_TITLE,databasehelper.TICKET_IMAGE,databasehelper.TICKET_DESCRIPTION,
                databasehelper.TICKET_LINK,databasehelper.TICKET_PUBLISHDATE};
        Cursor cursor = db.query(databasehelper.TABLE_TICKETNEWS,columns,null,null,null,null,null);
        while(cursor.moveToNext()){

            int index2=cursor.getColumnIndex(databasehelper.TICKET_TITLE);
            int index3=cursor.getColumnIndex(databasehelper.TICKET_IMAGE);
            int index4=cursor.getColumnIndex(databasehelper.TICKET_LINK);
            int index5=cursor.getColumnIndex(databasehelper.TICKET_DESCRIPTION);
            int index6 = cursor.getColumnIndex(databasehelper.TICKET_PUBLISHDATE);
            LatestNews latest = new LatestNews();

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
        db.delete(databasehelper.TABLE_TICKETNEWS,null,null);
    }

}
