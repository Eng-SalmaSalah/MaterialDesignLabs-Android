package com.salma.layoutsdemo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountryApi {
    @GET("tutorial/jsonparsetutorial.txt")
    //getWorldCountries returns list of world population
    //<JsonResponse>-->el return yrg3 yt7t feha

    Call<JsonResponse> getWorldCountries();
    // it could be written as call<List<worldPopulation>> get worldCountries;
    // but we made the class JsonResponse that represents list of world countries
    // because the json file is composed of array of world population objects
    // not composed of world population objects directly

}
