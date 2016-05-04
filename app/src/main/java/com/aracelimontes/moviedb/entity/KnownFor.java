package com.aracelimontes.moviedb.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KnownFor {

@SerializedName("adult")
@Expose
public Boolean adult;
@SerializedName("backdrop_path")
@Expose
public String backdropPath;
@SerializedName("id")
@Expose
public Integer id;
@SerializedName("original_title")
@Expose
public String originalTitle;
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
@SerializedName("vote_average")
@Expose
public Double voteAverage;
@SerializedName("vote_count")
@Expose
public Integer voteCount;
@SerializedName("media_type")
@Expose
public String mediaType;

}