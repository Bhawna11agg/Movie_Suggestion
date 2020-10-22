package com.example.movie_app;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private  static String apiKey = "9c9576f8c2e86949a3220fcc32ae2fb6";
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        loadJson();
    }

    private void loadJson() {
        try{
            RetrofitClient Client = new RetrofitClient();
            MovieAPI apiService = Client.getClient().create(MovieAPI.class);
            Call<MovieResponse> call = apiService.getPopularMovies(apiKey);
            call.enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                    List<modal_movie> movies = response.body().getResults();
                    Log.d("1", "hi"+response.body().getResults());
                    recyclerView.setAdapter(new MovieAdapter(getApplicationContext(), movies));
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
