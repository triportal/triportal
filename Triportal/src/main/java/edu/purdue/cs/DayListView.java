package edu.purdue.cs;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.*;
import android.widget.ArrayAdapter;

import com.parse.ParseAnalytics;
import com.parse.ParseException;

import edu.purdue.cs.Adapter.DayListViewAdapter;
import edu.purdue.cs.fragments.BoardFragment;

/**
 * Created by Ge on 16/3/3.
 */
public class DayListView extends AppCompatActivity{
    private Itinerary itinerary;
    private Toolbar toolbar;
    private ListView poilist;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.daylistview);
        ParseAnalytics.trackAppOpenedInBackground(getIntent());
        //View rootView =  inflater.inflate(R.layout.trip_tab, container, false);
        toolbar = (Toolbar) findViewById(R.id.dayListViewActionBar);
        poilist = (ListView) findViewById(R.id.day_list);
        Bundle bundle = getIntent().getExtras();
        String itneraryID = bundle.getString("it_ID");

        BoardFragment fragment = BoardFragment.newInstance();
        fragment.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.day_list_frame, fragment, "fragment").commit();

      /*  Log.d("DayListView It Id", itneraryID);

        try {
            itinerary = Itinerary.getById(itneraryID);
            toolbar.setTitle(itinerary.getTitle());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            List<Day> dayList = itinerary.getDays();
            DayListViewAdapter dayListViewAdapter = new DayListViewAdapter(dayList, getApplicationContext());
            poilist.setAdapter(dayListViewAdapter);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/


    }


//    private void getData(String id){
//        try {
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        toolbar.setTitle(itinerary.getTitle());
//        View poiView = null;
//        for(int i = 0; i < itinerary.getNumberOfDays(); i++){
//            try {
//                DayListViewAdapter dayListViewAdapter = new DayListViewAdapter(itinerary.getDays(), this);
//                poiView = dayListViewAdapter.getView(i,poiView,(R.id.day_list));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//
//
//        }
//    }
}
