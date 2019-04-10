package com.salma.layoutsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class RelativeLayoutActivity extends AppCompatActivity {
    Worldpopulation china;
    String countryName;
    String countryRank;
    String countryPopulation;
    String countryFlag;
    TextView country;
    TextView population;
    TextView rank;
    ImageView flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
        Intent intent=getIntent();
        china=(Worldpopulation)intent.getSerializableExtra("china");
        countryName=china.getCountry();
        countryRank=String.valueOf(china.getRank());
        countryPopulation=china.getPopulation();
        countryFlag=china.getFlag();
        initializeComponents();
        setCountry();

    }


    private void initializeComponents() {
        country=findViewById(R.id.name);
        population=findViewById(R.id.population);
        rank=findViewById(R.id.rank);
        flag=findViewById(R.id.flag);
    }

    private void setCountry() {
        country.setText(countryName);
        population.setText(countryPopulation);
        rank.setText(countryRank);
        Glide.with(RelativeLayoutActivity.this).load(countryFlag).override(300,300).into(flag);
    }

}
