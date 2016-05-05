package com.aracelimontes.moviedb.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.aracelimontes.moviedb.CustomApiClient;
import com.aracelimontes.moviedb.R;
import com.aracelimontes.moviedb.entity.DetailResult;
import com.aracelimontes.moviedb.entity.DetailTvResult;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private CustomApiClient customApiClient;
    protected TextView mTitle, mOverview, mStatus, mVoteAverage;
    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setTitle("");

        String id = getIntent().getStringExtra("id");
        String type = getIntent().getStringExtra("type");

        mTitle = (TextView)findViewById(R.id.title);
        mOverview = (TextView)findViewById(R.id.overview);
        mStatus = (TextView)findViewById(R.id.tagline);
        mVoteAverage = (TextView)findViewById(R.id.voteAverage);
        mImage = (ImageView)findViewById(R.id.imageView);

        customApiClient = new CustomApiClient();

        if(type.equals("MOVIE")) {
            customApiClient.getService().detailsMovie(id, getResources().getString(R.string.API_KEY))
                    .enqueue(new Callback<DetailResult>() {
                        @Override
                        public void onResponse(Call<DetailResult> call, Response<DetailResult> response) {
                            if (response.body() != null) {
                                DetailResult detailResult = response.body();
                                mTitle.setText(detailResult.title);
                                mOverview.setText(detailResult.overview);
                                mStatus.setText(detailResult.tagline);
                                mVoteAverage.setText(detailResult.voteAverage.toString());

                                Picasso.with(mImage.getContext())
                                        .load(detailResult.getPoster())
                                        .placeholder(R.color.colorAccent)
                                        .into(mImage);
                            }
                        }

                        @Override
                        public void onFailure(Call<DetailResult> call, Throwable t) {
                            t.printStackTrace();
                            onBackPressed();
                        }
                    });
        }
        else if(type.equals("TV")){
            customApiClient.getService().detailsTv(id, getResources().getString(R.string.API_KEY))
                    .enqueue(new Callback<DetailTvResult>() {
                        @Override
                        public void onResponse(Call<DetailTvResult> call, Response<DetailTvResult> response) {
                            if (response.body() != null) {
                                DetailTvResult detailResult = response.body();
                                mTitle.setText(detailResult.name);
                                mOverview.setText(detailResult.overview);
                                mStatus.setText(detailResult.status);
                                mVoteAverage.setText(detailResult.voteAverage.toString());

                                Picasso.with(mImage.getContext())
                                        .load(detailResult.getPoster())
                                        .placeholder(R.color.colorAccent)
                                        .into(mImage);
                            }
                        }

                        @Override
                        public void onFailure(Call<DetailTvResult> call, Throwable t) {
                            onBackPressed();
                        }
                    });
        }
    }

}
