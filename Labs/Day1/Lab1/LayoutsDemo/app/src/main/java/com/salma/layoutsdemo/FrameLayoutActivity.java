package com.salma.layoutsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FrameLayoutActivity extends AppCompatActivity {
    private RecyclerView countriesRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    List<Worldpopulation> worldpopulation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
        worldpopulation = new ArrayList<>();
        Intent intent = getIntent();
        int size = intent.getIntExtra("size", 0);
        for (int i = 0; i < size; i++) {
            worldpopulation.add((Worldpopulation) intent.getSerializableExtra("country" + i));
        }
        loadList();

    }

    private void loadList() {

                countriesRecyclerView = findViewById(R.id.recyclerView);
                // Create adapter passing in the sample user data
                CountriesAdapter adapter = new CountriesAdapter(worldpopulation);
                // Attach the adapter to the recyclerview to populate items
                countriesRecyclerView.setAdapter(adapter);
                // use a linear layout manager
                layoutManager = new LinearLayoutManager(FrameLayoutActivity.this);
                countriesRecyclerView.setLayoutManager(layoutManager);



            }

    }
