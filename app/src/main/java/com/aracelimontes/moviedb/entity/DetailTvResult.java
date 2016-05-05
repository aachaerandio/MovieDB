package com.aracelimontes.moviedb.entity;

import java.util.ArrayList;
import java.util.List;

import com.aracelimontes.moviedb.CustomApiClient;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailTvResult {

    @SerializedName("backdrop_path")
    @Expose
    public String backdropPath;
    @SerializedName("created_by")
    @Expose
    public List<CreatedBy> createdBy = new ArrayList<CreatedBy>();
    @SerializedName("episode_run_time")
    @Expose
    public List<Integer> episodeRunTime = new ArrayList<Integer>();
    @SerializedName("first_air_date")
    @Expose
    public String firstAirDate;
    @SerializedName("genres")
    @Expose
    public List<Genre> genres = new ArrayList<Genre>();
    @SerializedName("homepage")
    @Expose
    public String homepage;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("in_production")
    @Expose
    public Boolean inProduction;
    @SerializedName("languages")
    @Expose
    public List<String> languages = new ArrayList<String>();
    @SerializedName("last_air_date")
    @Expose
    public String lastAirDate;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("networks")
    @Expose
    public List<Network> networks = new ArrayList<Network>();
    @SerializedName("number_of_episodes")
    @Expose
    public Integer numberOfEpisodes;
    @SerializedName("number_of_seasons")
    @Expose
    public Integer numberOfSeasons;
    @SerializedName("origin_country")
    @Expose
    public List<String> originCountry = new ArrayList<String>();
    @SerializedName("original_language")
    @Expose
    public String originalLanguage;
    @SerializedName("original_name")
    @Expose
    public String originalName;
    @SerializedName("overview")
    @Expose
    public String overview;
    @SerializedName("popularity")
    @Expose
    public Double popularity;
    @SerializedName("poster_path")
    @Expose
    public String posterPath;
    @SerializedName("production_companies")
    @Expose
    public List<ProductionCompany> productionCompanies = new ArrayList<ProductionCompany>();
    @SerializedName("seasons")
    @Expose
    public List<Season> seasons = new ArrayList<Season>();
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("vote_average")
    @Expose
    public Double voteAverage;
    @SerializedName("vote_count")
    @Expose
    public Integer voteCount;

    public static class CreatedBy {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("profile_path")
        @Expose
        public String profilePath;
    }

    public class Genre {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("name")
        @Expose
        public String name;
    }

    public class Network {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("name")
        @Expose
        public String name;
    }

    public class ProductionCompany {

        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("id")
        @Expose
        public Integer id;
    }

    public class Season {

        @SerializedName("air_date")
        @Expose
        public String airDate;
        @SerializedName("episode_count")
        @Expose
        public Integer episodeCount;
        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("poster_path")
        @Expose
        public String posterPath;
        @SerializedName("season_number")
        @Expose
        public Integer seasonNumber;
    }

    public String getPoster() {
        return CustomApiClient.TMDB_IMAGE_PATH + posterPath;
    }

}