package com.aracelimontes.moviedb.fragments;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aracelimontes.moviedb.R;
import com.aracelimontes.moviedb.adapters.MovieAdapter;
import com.aracelimontes.moviedb.entity.Genres;
import com.aracelimontes.moviedb.entity.MovieResult;
import com.aracelimontes.moviedb.util.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by araceli.montes on 05/05/2016.
 */
public class SectionMovieFragment extends SectionFragment {

    protected MovieAdapter mAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        customApiClient.getService().listMovieGenre(getResources().getString(R.string.API_KEY))
                .enqueue(new Callback<Genres>() {
                    @Override
                    public void onResponse(Call<Genres> call, Response<Genres> response) {
                        movieGenres = Utils.listToMap(response.body());
                        fetchData();
                    }

                    @Override
                    public void onFailure(Call<Genres> call, Throwable t) {
                        t.printStackTrace();
                        showDialog();
                    }
                });
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        mAdapter = new MovieAdapter(getActivity());
        return mAdapter;
    }

    @Override
    protected void fetchData()
    {
        mLoading.setVisibility(View.VISIBLE);
        customApiClient.getService().listPopularMovies(getResources().getString(R.string.API_KEY))
                .enqueue(new Callback<MovieResult>() {
                    @Override
                    public void onResponse(Call<MovieResult> call, Response<MovieResult> response) {
                        mLoading.setVisibility(View.GONE);
                        if (response.body().results.size() > 0) {
                            mAdapter.setData(response.body().results, movieGenres);
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieResult> call, Throwable t) {
                        mLoading.setVisibility(View.GONE);
                        showDialog();
                    }
                });
    }
}
