package com.aracelimontes.moviedb.fragments;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aracelimontes.moviedb.R;
import com.aracelimontes.moviedb.adapters.TVAdapter;
import com.aracelimontes.moviedb.entity.Genres;
import com.aracelimontes.moviedb.entity.TVResult;
import com.aracelimontes.moviedb.util.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by araceli.montes on 05/05/2016.
 */
public class SectionTvFragment extends SectionFragment {

    protected TVAdapter mAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        customApiClient.getService().listTvGenre(getResources().getString(R.string.API_KEY))
                .enqueue(new Callback<Genres>() {
                    @Override
                    public void onResponse(Call<Genres> call, Response<Genres> response) {
                        tvGenres = Utils.listToMap(response.body());
                        fetchData();
                    }

                    @Override
                    public void onFailure(Call<Genres> call, Throwable t) {
                        showDialog();
                    }
                });
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        mAdapter = new TVAdapter(getActivity());
        return mAdapter;
    }

    @Override
    protected void fetchData()
    {
        mLoading.setVisibility(View.VISIBLE);
        customApiClient.getService().listPopularTvShows(getResources().getString(R.string.API_KEY))
                .enqueue(new Callback<TVResult>() {
                    @Override
                    public void onResponse(Call<TVResult> call, Response<TVResult> response) {
                        mLoading.setVisibility(View.GONE);
                        if (response.body().results.size() > 0)
                        {
                            mAdapter.setData(response.body().results, tvGenres);
                        }
                    }

                    @Override
                    public void onFailure(Call<TVResult> call, Throwable t) {
                        mLoading.setVisibility(View.GONE);
                        showDialog();
                    }
                });
    }


}
