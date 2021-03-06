package com.aracelimontes.moviedb.entity;

import java.util.ArrayList;
import java.util.List;

import com.aracelimontes.moviedb.CustomApiClient;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("adult")
    @Expose
    public Boolean adult;
    @SerializedName("backdrop_path")
    @Expose
    public String backdropPath;
    @SerializedName("genre_ids")
    @Expose
    public List<Integer> genreIds = new ArrayList<Integer>();
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("original_language")
    @Expose
    public String originalLanguage;
    @SerializedName("original_title")
    @Expose
    public String originalTitle;
    @SerializedName("overview")
    @Expose
    public String overview;
    @SerializedName("release_date")
    @Expose
    public String releaseDate;
    @SerializedName("poster_path")
    @Expose
    public String posterPath;
    @SerializedName("popularity")
    @Expose
    public Double popularity;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("video")
    @Expose
    public Boolean video;
    @SerializedName("vote_average")
    @Expose
    public Double voteAverage;
    @SerializedName("vote_count")
    @Expose
    public Integer voteCount;

    public String getPoster() {
        return CustomApiClient.TMDB_IMAGE_PATH + posterPath;
    }

    public String getBackdrop() {
        return CustomApiClient.TMDB_IMAGE_PATH  + backdropPath;
    }

}