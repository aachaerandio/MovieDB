package com.aracelimontes.moviedb;

import com.aracelimontes.moviedb.entity.MovieDB;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    private static final String API_KEY="0a08e38b874d0aa2d426ffc04357069d";

    private CustomApiClient customApiClient;

    @Before
    public void setUp(){
        customApiClient = new CustomApiClient();
    }

    @Test
    public void testCallsSync() throws Exception {
        Assert.assertNotNull(customApiClient);

        MovieDB movies = customApiClient.getService().listPopularMovies(API_KEY)
                .execute().body();
        Assert.assertNotNull(movies);
    }

    @Test
    public void testCallsAsync() throws Exception {
        Assert.assertNotNull(customApiClient);

        customApiClient.getService().listPopularMovies(API_KEY)
            .enqueue(new Callback<MovieDB>() {
                @Override
                public void onResponse(Call<MovieDB> call, Response<MovieDB> response) {
                    Assert.assertNotNull(response.body());
                    Assert.assertTrue(response.body().results.size() > 0);
                }

                @Override
                public void onFailure(Call<MovieDB> call, Throwable t) {
                    Assert.fail();
                }
            });
    }
}