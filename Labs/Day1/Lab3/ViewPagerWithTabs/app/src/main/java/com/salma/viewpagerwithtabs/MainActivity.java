package com.salma.viewpagerwithtabs;

import android.annotation.SuppressLint;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;
ViewPager viewPager;
PagerAdapter pagerAdapter;
TabLayout tabLayout;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager=findViewById(R.id.viewPager);
        pagerAdapter=new PagerAdapter(getSupportFragmentManager(),3);
        viewPager.setAdapter(pagerAdapter);
        tabLayout=findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        //to disable swiping
       viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

    }
}
