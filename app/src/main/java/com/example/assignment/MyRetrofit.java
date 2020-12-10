package com.example.assignment;

import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofit {

    public static Retrofit retrofit;
    private static final String BASE_URL = "https://www.flickr.com/";
    public static RetrofitService retrofitService;

    public static RetrofitService getInstance() {
        if (retrofitService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            retrofitService = retrofit.create(RetrofitService.class);
        }
        return retrofitService;
    }
}
