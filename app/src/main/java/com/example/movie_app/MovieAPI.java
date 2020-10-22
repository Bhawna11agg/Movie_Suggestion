package com.example.movie_app;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieAPI {

    @GET("movie/popular")
    Call<MovieResponse> getPopularMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<modal_movie_detail> getDetails(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("movie/{id}/similar")
    Call<MovieResponse> getSimilar(@Path("id") int id , @Query("api_key") String apiKey);

}