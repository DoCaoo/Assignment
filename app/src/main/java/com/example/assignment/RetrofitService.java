package com.example.assignment;

import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET("services/rest/")
    Call<MPhoto> getListFavo(@Query("extras") String extras,
                                 @Query("nojsoncallback") String nojsoncallback,
                                 @Query("user_id") String user_id,
                                 @Query("format") String format,
                                 @Query("api_key") String api_key,
                                 @Query("method") String method,
                                 @Query("page") int page,
                                 @Query("per_page") int per_page);

}
