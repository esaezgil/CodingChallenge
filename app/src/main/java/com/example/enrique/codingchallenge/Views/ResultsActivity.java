package com.example.enrique.codingchallenge.Views;

import android.app.ListActivity;
import android.os.Bundle;

import com.example.enrique.codingchallenge.Model.ExtendedJourney;
import com.example.enrique.codingchallenge.R;
import com.example.enrique.codingchallenge.Utils.ResultsAdapter;
import com.example.enrique.codingchallenge.Utils.Utils;

import java.util.ArrayList;

public class ResultsActivity extends ListActivity {

    private ArrayList<ExtendedJourney> extendedJourneyArrayList;

    ArrayList<String> fields = new ArrayList<>();
    String [][] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_view);
        extendedJourneyArrayList = getIntent().getParcelableArrayListExtra("data");
        data = Utils.extendedJourneyListToArray(extendedJourneyArrayList);
        setupAdapter();
    }

    private void setupAdapter(){
        ResultsAdapter adaptador = new ResultsAdapter(
                this,
                R.layout.item_journey,
                R.id.distanceTextView,
                data);
        setListAdapter(adaptador);
    }
}
