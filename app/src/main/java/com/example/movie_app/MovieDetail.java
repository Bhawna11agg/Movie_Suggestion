package com.example.movie_app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * This activity is responsible for displaying the details for a selected movie.
 */
public class MovieDetail extends AppCompatActivity{
    TextView status,overview,vote_average,title,spoken,genre,runtime;
    ImageView image1;
    RecyclerView recyclerView1;
    int newString;
    private  static String apiKey = "9c9576f8c2e86949a3220fcc32ae2fb6";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        status=findViewById(R.id.status);
         overview=findViewById(R.id.overview);
        spoken=findViewById(R.id.spoken);
        vote_average=findViewById(R.id.voteAverage);
        title=findViewById(R.id.title);
        genre=findViewById(R.id.genre);
        recyclerView1=findViewById(R.id.recyclerView1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        image1=findViewById(R.id.image1);
        runtime=findViewById(R.id.runtime);
        Bundle extras = getIntent().getExtras();
        newString= extras.getInt("movies");
        try{
            RetrofitClient Client = new RetrofitClient();
            MovieAPI apiService =
                    Client.getClient().create(MovieAPI.class);
            Call<modal_movie_detail> call = apiService.getDetails(newString,apiKey);
            call.enqueue(new Callback<modal_movie_detail>() {
                @Override
                public void onResponse(Call<modal_movie_detail> call, Response<modal_movie_detail> response) {
                    Log.d("!",response.body()+"hi");
                    status.setText(response.body().getStatus());
                    overview.setText(response.body().getOverview());
                    title.setText(response.body().getTitle());
                    runtime.setText("Runtime: "+Integer.toString(response.body().getRuntime()));
                    vote_average.setText("Average Vote: "+Double.toString(response.body().getVote_average()));
                    String genres="";
                    for(int i=0;i<response.body().getGenres().size();i++){
                        if(i!=response.body().getGenres().size()-1)
                          genres+=response.body().getGenres().get(i).get_name()+", ";
                        else
                            genres+=response.body().getGenres().get(i).get_name();
                    }
                    genre.setText(genres);
                    String genres2="";
                    for(int i=0;i<response.body().getSpoken_languages().size();i++){
                        if(i!=response.body().getSpoken_languages().size()-1)
                            genres2+=response.body().getSpoken_languages().get(i).getName()+", ";
                        else
                            genres2+=response.body().getSpoken_languages().get(i).getName();
                    }
                    spoken.setText(genres2);
                    String poster = "https://image.tmdb.org/t/p/w500" + response.body().getPoster_path();
                   // Log.d("!!",response.body().ge+"hi");
                    Glide.with(getApplicationContext())
                            .load(poster)
                            .into(image1);

                }

                @Override
                public void onFailure(Call<modal_movie_detail> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                }
            });
        }catch (Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
        loadJson();
    }
    private void loadJson() {
        try{
            Log.d("@", "hi");
            RetrofitClient Client = new RetrofitClient();
            MovieAPI apiService =
                    Client.getClient().create(MovieAPI.class);
            Call<MovieResponse> call = apiService.getSimilar(newString,apiKey);
            call.enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                    List<modal_movie> movies = response.body().getResults();
                    Log.d("@", "hi"+response.body().getResults());
                    recyclerView1.setAdapter(new MovieAdapter(getApplicationContext(), movies));
                }

                @Override
                public void onFailure(Call<MovieResponse> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                }
            });
        }catch (Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}

