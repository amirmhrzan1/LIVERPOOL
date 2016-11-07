package com.example.amirmaharjan.liverpool.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.amirmaharjan.liverpool.Asynctasks.ReadRss;
import com.example.amirmaharjan.liverpool.R;
import com.example.amirmaharjan.liverpool.adaptors.MyPagerAdaptor;
import com.example.amirmaharjan.liverpool.database.databasehelper;
import com.example.amirmaharjan.liverpool.helper.ConnectionManager;

public class MainActivity extends AppCompatActivity {
    ReadRss rss;
    databasehelper database;
    ConnectionManager connmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Latest News"));
        tabLayout.addTab(tabLayout.newTab().setText("Media Watch"));
        tabLayout.addTab(tabLayout.newTab().setText("Ticket News"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        FragmentManager fm = getSupportFragmentManager();
        database = new databasehelper(this);
        database.getWritableDatabase();
        database.close();
        connmanager = new ConnectionManager(this);
        if(connmanager.hasConnection()) {
            rss = new ReadRss(MainActivity.this,tabLayout,viewPager, fm);
            rss.execute();
        }







    }
}