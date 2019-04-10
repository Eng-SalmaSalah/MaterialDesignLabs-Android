package com.salma.layoutsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class GridLayoutActivity extends AppCompatActivity {
    ImageView flag0;
    ImageView flag1;
    ImageView flag2;
    ImageView flag3;
    ImageView flag4;
    ImageView flag5;
    ImageView flag6;
    ImageView flag7;
    ImageView flag8;
    ImageView flag9;
    List<Worldpopulation> worldpopulation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);
        flag0 = findViewById(R.id.flag0);
        flag1 = findViewById(R.id.flag1);
        flag2 = findViewById(R.id.flag2);
        flag3 = findViewById(R.id.flag3);
        flag4 = findViewById(R.id.flag4);
        flag5 = findViewById(R.id.flag5);
        flag6 = findViewById(R.id.flag6);
        flag7 = findViewById(R.id.flag7);
        flag8 = findViewById(R.id.flag8);
        flag9 = findViewById(R.id.flag9);
        worldpopulation = new ArrayList<>();
        Intent intent = getIntent();
        int size = intent.getIntExtra("size", 0);
        for (int i = 0; i < size; i++) {
            worldpopulation.add((Worldpopulation) intent.getSerializableExtra("country" + i));
        }
        loadList();
    }

    private void loadList() {

                String flagLink0 = worldpopulation.get(0).getFlag();
                Glide.with(GridLayoutActivity.this).load(flagLink0).into(flag0);

                String flagLink1 = worldpopulation.get(1).getFlag();
                Glide.with(GridLayoutActivity.this).load(flagLink1).into(flag1);

                String flagLink2 = worldpopulation.get(2).getFlag();
                Glide.with(GridLayoutActivity.this).load(flagLink2).into(flag2);

                String flagLink3 = worldpopulation.get(3).getFlag();
                Glide.with(GridLayoutActivity.this).load(flagLink3).into(flag3);

                String flagLink4 = worldpopulation.get(4).getFlag();
                Glide.with(GridLayoutActivity.this).load(flagLink4).into(flag4);

                String flagLink5 = worldpopulation.get(5).getFlag();
                Glide.with(GridLayoutActivity.this).load(flagLink5).into(flag5);

                String flagLink6 = worldpopulation.get(6).getFlag();
                Glide.with(GridLayoutActivity.this).load(flagLink6).into(flag6);

                String flagLink7 = worldpopulation.get(7).getFlag();
                Glide.with(GridLayoutActivity.this).load(flagLink7).into(flag7);

                String flagLink8 = worldpopulation.get(8).getFlag();
                Glide.with(GridLayoutActivity.this).load(flagLink8).into(flag8);

                String flagLink9 = worldpopulation.get(9).getFlag();
                Glide.with(GridLayoutActivity.this).load(flagLink9).into(flag9);

            }
    }
