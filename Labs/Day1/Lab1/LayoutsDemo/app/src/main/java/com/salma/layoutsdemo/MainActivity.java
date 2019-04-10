package com.salma.layoutsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button gridLayout;
    Button frameLayout;
    Button relativeLayout;
    List<Worldpopulation> worldpopulation;
    JsonResponse countriesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeBtns();
        loadJson();
        addListenersToBtns();

    }


    private void initializeBtns() {
        gridLayout = findViewById(R.id.btn_grid);
        frameLayout = findViewById(R.id.btn_frame);
        relativeLayout = findViewById(R.id.btn_relative);
    }

    private void addListenersToBtns() {
        gridLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GridLayoutActivity.class);
                for (int i = 0; i < worldpopulation.size(); i++)
                    intent.putExtra("country" + i, worldpopulation.get(i));
                intent.putExtra("size", worldpopulation.size());
                startActivity(intent);

            }
        });
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FrameLayoutActivity.class);
                for (int i = 0; i < worldpopulation.size(); i++)
                    intent.putExtra("country" + i, worldpopulation.get(i));
                intent.putExtra("size", worldpopulation.size());
                startActivity(intent);
            }
        });
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RelativeLayoutActivity.class);
                intent.putExtra("china", worldpopulation.get(0));
                startActivity(intent);
            }
        });
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
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {

            }
        });
    }
}
