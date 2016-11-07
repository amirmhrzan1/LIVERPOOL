package com.example.amirmaharjan.liverpool.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.amirmaharjan.liverpool.Asynctasks.Fetching;
import com.example.amirmaharjan.liverpool.R;

/**
 * Created by Amir Maharjan on 11/7/2016.
 */

public class mediawatch extends Fragment {

    Fetching fetch;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment,container,false);
        TextView txt = (TextView)v.findViewById(R.id.text);
        txt.setText("Fragment2");
      RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recyclerview);
       fetch = new Fetching(getActivity(),recyclerView);
        fetch.execute(2);
        return v;
    }
}
