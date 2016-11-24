package com.example.amirmaharjan.liverpool.activities;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

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

        database = new databasehelper(this);
        connmanager = new ConnectionManager(this);
        if(connmanager.hasConnection()) {

            rss = new ReadRss(MainActivity.this);
            rss.execute();
        }
        else
        {


        }
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Latest News"));

        tabLayout.addTab(tabLayout.newTab().setText("Media Watch"));
        tabLayout.addTab(tabLayout.newTab().setText("Ticket News"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(connmanager.hasConnection()) {

                    rss = new ReadRss(MainActivity.this);
                    rss.execute();
                }

            }
        });



        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        FragmentManager fm = getSupportFragmentManager();

        final MyPagerAdaptor adapter = new MyPagerAdaptor
                (fm, tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {



        }

        return super.onOptionsItemSelected(item);
    }
}