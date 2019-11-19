package com.example.fetchvalue.Retrofit;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitInstance  {
    private static Retrofit retrofit;
   /*// private static final String BASE_URL = "http://navjacinth9.000webhostapp.com/json/";*/
  private static final String BASE_URL = "https://api.github.com/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory( GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }
    }
