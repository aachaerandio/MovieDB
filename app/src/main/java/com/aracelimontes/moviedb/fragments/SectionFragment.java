package com.aracelimontes.moviedb.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aracelimontes.moviedb.CustomApiClient;
import com.aracelimontes.moviedb.R;
import com.aracelimontes.moviedb.adapters.MovieAdapter;
import com.aracelimontes.moviedb.entity.Genres;
import com.aracelimontes.moviedb.entity.MovieResult;
import com.aracelimontes.moviedb.entity.PeopleResult;
import com.aracelimontes.moviedb.entity.TVResult;
import com.aracelimontes.moviedb.util.Utils;
import com.squareup.okhttp.internal.Util;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by araceli.montes on 03/05/2016.
 */
public class SectionFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private CustomApiClient customApiClient;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private MovieAdapter mAdapter;

    private Map<String, String> movieGenres;
    private Map<String, String> tvGenres;

    public SectionFragment() {
    }

    public static SectionFragment newInstance(int sectionNumber) {
        SectionFragment fragment = new SectionFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MovieAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        customApiClient = new CustomApiClient();

        customApiClient.getService().listMovieGenre(getResources().getString(R.string.API_KEY))
                .enqueue(new Callback<Genres>() {
                    @Override
                    public void onResponse(Call<Genres> call, Response<Genres> response) {
                        movieGenres = Utils.listToMap(response.body());
                        fetchData();
                    }

                    @Override
                    public void onFailure(Call<Genres> call, Throwable t) {

                    }
                });


    }


    //TODO
    private void fetchData() {

        customApiClient.getService().listTvGenre(getResources().getString(R.string.API_KEY))
                .enqueue(new Callback<Genres>() {
                    @Override
                    public void onResponse(Call<Genres> call, Response<Genres> response) {
                        tvGenres = Utils.listToMap(response.body());
                    }

                    @Override
                    public void onFailure(Call<Genres> call, Throwable t) {
                        t.printStackTrace();
                    }
                });

        customApiClient.getService().listPopularMovies(getResources().getString(R.string.API_KEY))
                .enqueue(new Callback<MovieResult>() {
                    @Override
                    public void onResponse(Call<MovieResult> call, Response<MovieResult> response) {

                        if(response.body().results.size() > 0)
                        {
                            Toast.makeText(getContext(), "movies", Toast.LENGTH_SHORT).show();
                            mAdapter.setData(response.body().results, tvGenres);
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieResult> call, Throwable t) {
                        t.printStackTrace();
                    }
                });

        customApiClient.getService().listPopularTvShows(getResources().getString(R.string.API_KEY))
                .enqueue(new Callback<TVResult>() {
                    @Override
                    public void onResponse(Call<TVResult> call, Response<TVResult> response) {

                        if (response.body().results.size() > 0)
                        {
                            Toast.makeText(getContext(), "tv shows", Toast.LENGTH_SHORT).show();
                            //mAdapter.setData(response.body().results);
                        }
                    }

                    @Override
                    public void onFailure(Call<TVResult> call, Throwable t) {
                        t.printStackTrace();
                    }
                });

        customApiClient.getService().listPeople(getResources().getString(R.string.API_KEY))
                .enqueue(new Callback<PeopleResult>() {
                    @Override
                    public void onResponse(Call<PeopleResult> call, Response<PeopleResult> response) {

                        if (response.body().results.size() > 0)
                        {
                            Toast.makeText(getContext(), "people", Toast.LENGTH_SHORT).show();
                            //mAdapter.setData(response.body().results);
                        }
                    }

                    @Override
                    public void onFailure(Call<PeopleResult> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}