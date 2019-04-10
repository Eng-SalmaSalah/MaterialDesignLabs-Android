package com.salma.navigationdrawer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    private RecyclerView countriesRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    List<Worldpopulation> worldpopulation;
    JsonResponse countriesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.navigate);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        drawerLayout.closeDrawers();
                        return true;

                    }
                });
        drawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                        Log.i("drawer status","onDrawerOpened");
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                        Log.i("drawer status","onDrawerClosed");

                    }

                    @Override
                    public void onDrawerSlide(@NonNull View view, float v) {
                        Log.i("drawer status","onDrawerSlide");

                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                        Log.i("drawer status","onDrawerStateChanged");
                    }
                }
        );
        loadJson();
    }

    private void loadJson() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.androidbegin.com/").addConverterFactory(GsonConverterFactory.create()).build();
        CountryApi request = retrofit.create(CountryApi.class);
        Call<JsonResponse> call = request.getWorldCountries();
        call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                countriesList = response.body();
                if (countriesList != null)
                    worldpopulation = countriesList.getWorldpopulation();
                Toast.makeText(MainActivity.this, "List loaded successfully", Toast.LENGTH_SHORT).show();
                loadList();

            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {

            }
        });
    }

    private void loadList() {
        countriesRecyclerView = findViewById(R.id.recyclerView);
        // Create adapter passing in the sample user data
        CountriesAdapter adapter = new CountriesAdapter(worldpopulation);
        // Attach the adapter to the recyclerview to populate items
        countriesRecyclerView.setAdapter(adapter);

        // use a linear layout manager
         layoutManager = new LinearLayoutManager(MainActivity.this);
        countriesRecyclerView.setLayoutManager(layoutManager);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}