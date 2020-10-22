package com.example.movie_app;

import java.util.List;

public class MovieResponse {

    private int page;
    private List<modal_movie> results;
    private int totalResults;
    private int totalPages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<modal_movie> getResults() {
        return results;
    }

    public List<modal_movie> getMovies() {
        return results;
    }

    public void setResults(List<modal_movie> results) {
        this.results = results;
    }

    public void setMovies(List<modal_movie> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    protected MovieResponse(int page,List<modal_movie> results,int totalPages,int totalResults) {
        this.page = page;
        this.results = results;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
    }

}