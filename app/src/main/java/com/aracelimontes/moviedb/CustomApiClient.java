package com.aracelimontes.moviedb;

import com.aracelimontes.moviedb.entity.DetailResult;
import com.aracelimontes.moviedb.entity.DetailTvResult;
import com.aracelimontes.moviedb.entity.Genres;
import com.aracelimontes.moviedb.entity.Movie;
import com.aracelimontes.moviedb.entity.MovieResult;
import com.aracelimontes.moviedb.entity.PeopleResult;
import com.aracelimontes.moviedb.entity.TVResult;
import com.aracelimontes.moviedb.entity.TVShow;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by araceli.montes on 03/05/2016.
 */
public class CustomApiClient {

    public static final String API_URL = "http://api.themoviedb.org/3/";
    public static final String TMDB_IMAGE_PATH = "http://image.tmdb.org/t/p/w500";
    public static final String API_KEY="0a08e38b874d0aa2d426ffc04357069d";

    public MovieService getService() {
        return new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MovieService.class);
    }

    public interface MovieService {
        @GET("movie/popular")
        Call<MovieResult> listPopularMovies(@Query("api_key") String apiKey);

        @GET("tv/popular")
        Call<TVResult> listPopularTvShows(@Query("api_key") String apiKey);

        @GET("person/popular")
        Call<PeopleResult> listPeople(@Query("api_key") String apiKey);

        @GET("genre/tv/list")
        Call<Genres> listTvGenre(@Query("api_key") String apiKey);

        @GET("genre/movie/list")
        Call<Genres> listMovieGenre(@Query("api_key") String apiKey);

        @GET("movie/{id}")
        Call<DetailResult> detailsMovie(@Path("id") String id, @Query("api_key") String apiKey);

        @GET("tv/{id}")
        Call<DetailTvResult> detailsTv(@Path("id") String id, @Query("api_key") String apiKey);
    }
}
