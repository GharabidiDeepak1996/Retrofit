package com.example.sendvalues.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseApplication {
    private static Retrofit retrofit;
   // public static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
   //public static final String BASE_URL="https://reqres.in/api/";
   public static final String BASE_URL ="http://httpbin.org/";
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
