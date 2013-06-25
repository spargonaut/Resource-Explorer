package com.spargonaut.android;

import android.app.Activity;
import android.app.ListActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ResourceExplorer extends ListActivity {

    private static final String CLASS_TAG = "Resource Explorer";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // define the list which holds the information of the list
        List<Map<String, Object>> resourceNames = new ArrayList<Map<String, Object>>();

        // define the map which will hold the information for each row
        Map<String, Object> data;

        // hard coded numbers retrieved from
        // http://code.google.com/android/reference/android/R.drawable.html
        for ( int idx = 17301504; idx <= 17301655; idx++ ) {
            data = new HashMap<String, Object>();

            try {
                String stg = Resources.getSystem().getResourceName(idx);

                data.put("line1", stg );
                data.put("line2", idx );
                data.put("img", idx );
                resourceNames.add(data);
            } catch (Resources.NotFoundException nfe ) {
                Log.v(CLASS_TAG, "didn't find anything at idx: " + idx);
            }
        }

        String[] dataKeys = {"line1", "line2", "img"};
        int[] viewKeys = {R.id.text1, R.id.text2, R.id.img};
        SimpleAdapter notes = new SimpleAdapter(this, resourceNames, R.layout.row, dataKeys, viewKeys);

        setListAdapter(notes);
    }
}