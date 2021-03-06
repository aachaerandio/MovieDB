package com.aracelimontes.moviedb.fragments;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aracelimontes.moviedb.R;
import com.aracelimontes.moviedb.adapters.PeopleAdapter;
import com.aracelimontes.moviedb.entity.PeopleResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by araceli.montes on 05/05/2016.
 */
public class SectionPeopleFragment extends SectionFragment {

    protected PeopleAdapter mAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        fetchData();
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        mAdapter = new PeopleAdapter(getActivity());
        return mAdapter;
    }

    @Override
    protected void fetchData() {
        mLoading.setVisibility(View.VISIBLE);
        customApiClient.getService().listPeople(getResources().getString(R.string.API_KEY))
                .enqueue(new Callback<PeopleResult>() {
                    @Override
                    public void onResponse(Call<PeopleResult> call, Response<PeopleResult> response) {
                        mLoading.setVisibility(View.GONE);
                        if (response.body().results.size() > 0)
                        {
                            mAdapter.setData(response.body().results);
                        }
                    }

                    @Override
                    public void onFailure(Call<PeopleResult> call, Throwable t) {
                        mLoading.setVisibility(View.VISIBLE);
                        showDialog();
                    }
                });
    }

}
