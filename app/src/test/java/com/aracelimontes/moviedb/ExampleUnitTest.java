package com.aracelimontes.moviedb;

import android.text.TextUtils;

import com.aracelimontes.moviedb.entity.Genres;
import com.aracelimontes.moviedb.entity.MovieResult;
import com.aracelimontes.moviedb.util.Utils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
@RunWith(MockitoJUnitRunner.class)
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

        MovieResult movies = customApiClient.getService().listPopularMovies(API_KEY)
                .execute().body();
        Assert.assertNotNull(movies);
    }

    @Test
    public void testGenreCalls() throws Exception {
        Assert.assertNotNull(customApiClient);

        Genres body = customApiClient.getService().listMovieGenre(API_KEY).execute().body();

        Assert.assertNotNull(body);
    }

    @Test
    public void testConverser() {
        Genres.Genre genre = new Genres.Genre("4", "ACTION");
        Genres genres = new Genres();
        genres.genres = new ArrayList<>();
        genres.genres.add(genre);

        Map<String, String> toTest = Utils.listToMap(genres);

        Assert.assertNotNull(toTest);
        Assert.assertEquals(1, toTest.size());
        Assert.assertEquals("ACTION", toTest.get("4"));
    }

    @Test
    public void testConverserNull() {
        Genres genres = new Genres();
        Map<String, String> toTest = Utils.listToMap(genres);

        Assert.assertNotNull(toTest);
        Assert.assertEquals(0, toTest.size());
    }

    @Test
    public void testDateToYearConverter() {
        String date = "2015-05-15";
        String year = Utils.getYear(date);

        Assert.assertEquals("2015", year);
    }

    @Test
    public void testDateToYearNullConverter() {
        String date = null;
        String year = Utils.getYear(date);

        Assert.assertNull(year);
    }
}