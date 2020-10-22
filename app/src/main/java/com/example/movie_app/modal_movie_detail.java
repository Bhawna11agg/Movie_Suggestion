package com.example.movie_app;

import java.util.List;

public class modal_movie_detail {
    private String status;
    private int runtime;
    private String title;
    private String poster_path;
    private String overview;
    private double vote_average;
    private List<Genres> genres;
    private List<Spoken_Languages> spoken_languages;

    public List<Genres> getGenres() {
        return genres;
    }

    public int getRuntime() {
        return runtime;
    }

    public double getVote_average() {
        return vote_average;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSpoken_languages(List<Spoken_Languages> spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public List<Spoken_Languages> getSpoken_languages() {
        return spoken_languages;
    }

    public void setOverview(String overview) {
        overview = overview;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }

    public modal_movie_detail(String status, int runtime, String title, String poster_path, String overview, double vote_average, List<Genres> genres, List<Spoken_Languages> spoken_languages) {
        this.status = status;
        this.runtime = runtime;
        this.title = title;
        this.poster_path = poster_path;
        this.overview = overview;
        this.vote_average = vote_average;
        this.genres = genres;
        this.spoken_languages = spoken_languages;
    }
}
class Genres {
    String name;

    Genres( String name) {
        this.name = name;
    }

    public String get_name() {
        return name;
    }

    public void set_name(String name) {
        this.name = name;
    }
}

class Spoken_Languages{
    private String name;

    Spoken_Languages(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
