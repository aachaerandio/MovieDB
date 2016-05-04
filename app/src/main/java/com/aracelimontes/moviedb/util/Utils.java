package com.aracelimontes.moviedb.util;

import android.text.TextUtils;

import com.aracelimontes.moviedb.entity.Genres;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by araceli.montes on 04/05/2016.
 */
public class Utils {
    public static Map<String, String> listToMap(Genres genres){
        Map<String, String> result = new HashMap<>();

        if (genres != null && genres.genres != null) {
            for (Genres.Genre genre : genres.genres) {
                result.put(genre.id, genre.name);
            }
        }

        return result;
    }

    public static String getYear(String dateString){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String year = null;
        if (dateString != null && !dateString.isEmpty()){
            try {
                Date date = sdf.parse(dateString);
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                year = String.valueOf(cal.get(Calendar.YEAR));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return year;
    }

    public static String translateAndJoin(List<Integer> genreIds, Map<String, String> mGenres) {
        List<String> genres = new ArrayList<>();
        for (Integer genreId : genreIds){
            genres.add(mGenres.get(String.valueOf(genreId)));
        }
        return TextUtils.join(", ", genres);
    }
}
