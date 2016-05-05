package com.aracelimontes.moviedb.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.aracelimontes.moviedb.R;
import com.aracelimontes.moviedb.fragments.SectionMovieFragment;
import com.aracelimontes.moviedb.fragments.SectionPeopleFragment;
import com.aracelimontes.moviedb.fragments.SectionTvFragment;

/**
 * Created by araceli.montes on 03/05/2016.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SectionsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
            default: return new SectionMovieFragment();

            case 1: return new SectionTvFragment();

            case 2: return new SectionPeopleFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getResources().getString(R.string.movies);
            case 1:
                return mContext.getResources().getString(R.string.tv_shows);
            case 2:
                return mContext.getResources().getString(R.string.people);
        }
        return null;
    }
}
