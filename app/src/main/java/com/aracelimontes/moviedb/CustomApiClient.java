package com.aracelimontes.moviedb;

import com.aracelimontes.moviedb.entity.MovieDB;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by araceli.montes on 03/05/2016.
 */
public class CustomApiClient {

    private static String API_URL = "http://api.themoviedb.org/3/";
    private static final String API_KEY="0a08e38b874d0aa2d426ffc04357069d";

    public MovieService getService() {
        return new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MovieService.class);
    }

    public interface MovieService {
        @GET("movie/popular")
        Call<MovieDB> listPopularMovies(@Query("api_key") String apiKey);
    }
}