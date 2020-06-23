package com.example.myshopp.NetWork;


import com.example.myshopp.DataModels.Datum;
import com.example.myshopp.DataModels.LogiData;
import com.example.myshopp.DataModels.Regidata;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    @POST("login.php")
    @FormUrlEncoded
    Call<LogiData> login(@Field("user") String username, @Field("pass") String password);

    @POST("Registration")
    @FormUrlEncoded
    Call<Regidata> registeration(@Field("mob") String mob);

    @GET("slider_images")

    Call<Datum> get_slider_images();

    @GET("category")

    Call<Datum> get_category_images();
}
