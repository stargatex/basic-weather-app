package com.example.lkj.weatherapp.model;

import com.example.lkj.weatherapp.model.weathermodel.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by LKJ .
 */

public interface WeatherService {

    @GET("/data/2.5/weather?appid=" + Config.APP_ID)
    Call<Weather> getWeather(@Query("q") String city, @Query("units") String units);

    @GET("/data/2.5/weather?appid=" + Config.APP_ID)
    Call<Weather> getLatLonWeather(@Query("lat") Double lat ,@Query("lon") Double lon, @Query("units") String units);


}
