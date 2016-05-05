package com.aracelimontes.moviedb.entity;

import java.util.ArrayList;
import java.util.List;

import com.aracelimontes.moviedb.CustomApiClient;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TVShow {

    @SerializedName("backdrop_path")
    @Expose
    public String backdropPath;
    @SerializedName("first_air_date")
    @Expose
    public String firstAirDate;
    @SerializedName("genre_ids")
    @Expose
    public List<Integer> genreIds = new ArrayList<Integer>();
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("original_language")
    @Expose
    public String originalLanguage;
    @SerializedName("original_name")
    @Expose
    public String originalName;
    @SerializedName("overview")
    @Expose
    public String overview;
    @SerializedName("origin_country")
    @Expose
    public List<String> originCountry = new ArrayList<String>();
    @SerializedName("poster_path")
    @Expose
    public String posterPath;
    @SerializedName("popularity")
    @Expose
    public Double popularity;
    @SerializedName("name")
    @Expose
    public String name;
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