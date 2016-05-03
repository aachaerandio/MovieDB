package com.aracelimontes.moviedb.entity;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieDB {

@SerializedName("page")
@Expose
public Integer page;
@SerializedName("results")
@Expose
public List<Movie> results = new ArrayList<Movie>();
@SerializedName("total_pages")
@Expose
public Integer totalPages;
@SerializedName("total_results")
@Expose
public Integer totalResults;

}