package com.aracelimontes.moviedb.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aracelimontes.moviedb.CustomApiClient;
import com.aracelimontes.moviedb.R;

import java.util.Map;


/**
 * Created by araceli.montes on 03/05/2016.
 */
public abstract class SectionFragment extends Fragment {
    public CustomApiClient customApiClient;
    protected RecyclerView mRecyclerView;
    protected LinearLayoutManager mLayoutManager;

    protected Map<String, String> movieGenres;
    protected Map<String, String> tvGenres;
    protected View mLoading;

    public SectionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mLoading = rootView.findViewById(R.id.progressSpinner);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        customApiClient = new CustomApiClient();
        mRecyclerView.setAdapter(getAdapter());
    }

    protected abstract RecyclerView.Adapter getAdapter();

    protected abstract void fetchData();

    protected void showDialog()
    {
        DialogInterface.OnClickListener dialogClick = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                fetchData();
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Unexpected error");
        builder.setMessage("Sorry, failed to download");
        builder.setPositiveButton("Retry", dialogClick);

        builder.create().show();
    }
}