package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements Callback<MPhoto> {
    MPhoto mPhoto;
    List<Photo> list;
    Photos photos;
    RecyclerView recyclerView;
    StaggeredAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Context context = MainActivity.this;
    private static final String FULL_EXTRAS = "views,media,path_alias,url_sq,url_t,url_s,url_q,url_m,url_n,url_z,url_c,url_l,url_o";
    private static final String USER_ID = "191130142@N04";
    private static final String KEY_TOKEN = "a92a1626cfb4bc4c15112ceb23d7b182";
    private static final String GET_FAVO = "flickr.favorites.getList";
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rc_view);



        MyRetrofit.getInstance().getListFavo(FULL_EXTRAS,
                "1", USER_ID, "json", KEY_TOKEN, GET_FAVO, page,
                100).enqueue(this);
    }


    @Override
    public void onResponse(Call<MPhoto> call, Response<MPhoto> response) {
        mPhoto = response.body();
        photos = mPhoto.getPhotos();
        list = photos.getPhoto();
        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new StaggeredAdapter(context, list,MainActivity.this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailure(Call<MPhoto> call, Throwable t) {

    }
}