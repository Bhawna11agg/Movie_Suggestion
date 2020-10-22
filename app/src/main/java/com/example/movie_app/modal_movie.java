package com.example.movie_app;

public class modal_movie {
    private String poster_path;
    private String title;
    private String release_date;
    private Double vote_average;
    private boolean adult;
    private int id;

    public modal_movie(String poster_path, String title, String release_date,
                               Double vote_average, boolean adult,int id) {
        this.poster_path = poster_path;
        this.title = title;
        this.release_date = release_date;
        this.vote_average = vote_average;
        this.adult = adult;
        this.id=id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public modal_movie(){

    }

    public String getPosterPath() {
        return  poster_path;
    }

    public void setPosterPath(String poster_path) {
        this.poster_path = poster_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getReleaseDate() {
        return release_date;
    }

    public void setReleaseDate(String release_date) {
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getVoteAverage() {
        return vote_average;
    }

    public void setVoteAverage(Double vote_average) {
        this.vote_average = vote_average;
    }
}
