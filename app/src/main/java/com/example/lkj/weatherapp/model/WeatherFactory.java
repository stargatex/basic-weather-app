package com.example.lkj.weatherapp.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by LKJ .
 */

public  class WeatherFactory{
    private static   WeatherService weatherService;
    public static    WeatherService getService(){
        if (weatherService == null) {
            Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Config.API_BASE_URL)
                    .build();

            weatherService = retrofit.create(WeatherService.class);
            return weatherService;
        } else {
            return weatherService;
        }
    }

}
