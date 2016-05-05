package com.aracelimontes.moviedb.entity;

import java.util.List;

/**
 * Created by araceli.montes on 04/05/2016.
 */
public class Genres {
    public List<Genre> genres;

    public static class Genre{
        public String id;
        public String name;

        public Genre(){
            super();
        }

        public Genre(String id, String name){
            this.id = id;
            this.name = name;
        }
    }
}
