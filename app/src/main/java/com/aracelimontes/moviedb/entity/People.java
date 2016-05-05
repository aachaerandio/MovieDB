package com.aracelimontes.moviedb.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class People {

    public static final String TMDB_IMAGE_PATH = "http://image.tmdb.org/t/p/w500";

    @SerializedName("adult")
    @Expose
    public Boolean adult;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("known_for")
    @Expose
    public List<KnownFor> knownFor = new ArrayList<KnownFor>();
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("popularity")
    @Expose
    public Double popularity;
    @SerializedName("profile_path")
    @Expose
    public String profilePath;

    public String getPoster() {
        return TMDB_IMAGE_PATH + profilePath;
    }

}