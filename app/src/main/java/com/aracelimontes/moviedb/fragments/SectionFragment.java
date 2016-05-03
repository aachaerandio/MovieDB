package com.aracelimontes.moviedb.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.aracelimontes.moviedb.CustomApiClient;
import com.aracelimontes.moviedb.R;
import com.aracelimontes.moviedb.entity.MovieDB;

import junit.framework.Assert;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by araceli.montes on 03/05/2016.
 */
public class SectionFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private CustomApiClient customApiClient;

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
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        fetchData();
    }


    //TODO
    private void fetchData() {
        customApiClient = new CustomApiClient();

        customApiClient.getService().listPopularMovies(getResources().getString(R.string.API_KEY))
                .enqueue(new Callback<MovieDB>() {
                    @Override
                    public void onResponse(Call<MovieDB> call, Response<MovieDB> response) {

                        if(response.body().results.size() > 0)
                        {
                            Toast.makeText(getContext(), "movies", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieDB> call, Throwable t) {
                        Assert.fail();
                    }
                });
    }
}