package com.example.sendvalues.Retrofit;

import com.example.sendvalues.ModelClass.Model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

   // @POST("/posts")
    @POST("/post")
    Call<Model> savePost(@Body Model model);


}
