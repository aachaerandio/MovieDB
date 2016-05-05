package com.aracelimontes.moviedb.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aracelimontes.moviedb.R;
import com.aracelimontes.moviedb.activities.DetailActivity;
import com.aracelimontes.moviedb.entity.TVShow;
import com.aracelimontes.moviedb.util.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by araceli.montes on 04/05/2016.
 */
public class TVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public ArrayList<TVShow> mData;
    private Context mContext;
    private Map<String, String> mGenres;

    public TVAdapter(Context context) {
        this.mContext = context;
        this.mData = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_movie, parent, false);

        return new TvVH(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof TvVH)
        {
            TvVH mHolder = (TvVH) holder;
            final TVShow item = mData.get(position);
            //full URL for image
            Picasso.with(mContext)
                    .load(item.getPoster())
                    .placeholder(R.color.colorAccent)
                    .into(mHolder.image);

            mHolder.title.setText(item.name);
            mHolder.description.setText(item.overview);
            mHolder.date.setText(Utils.getYear(item.firstAirDate)); //+ mContext.getResources().getString(R.string.calendar).toUpperCase()
            mHolder.rating.setText(item.voteAverage.toString() + mContext.getResources().getString(R.string.star).toUpperCase());
            mHolder.subtitle.setText(Utils.translateAndJoin(item.genreIds, mGenres));

            mHolder.moreBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent detail = new Intent(v.getContext(), DetailActivity.class);
                    detail.putExtra("id", item.id.toString());
                    detail.putExtra("type", "TV");
                    v.getContext().startActivity(detail);
                }
            });
        }

    }

    public void setData(List<TVShow> movieList, Map<String, String> genres)
    {
        mData.clear();
        mData.addAll(movieList);
        mGenres = genres;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (mData == null) ? 0 : mData.size();
    }

    public class TvVH extends RecyclerView.ViewHolder
    {
        public ImageView image;
        public TextView title, subtitle, description, rating, date, moreBtn;

        public TvVH(View v)
        {
            super(v);
            image = (ImageView) v.findViewById(R.id.imageView);
            title = (TextView) v.findViewById(R.id.title);
            subtitle = (TextView) v.findViewById(R.id.subtitle);
            description = (TextView) v.findViewById(R.id.description);
            rating = (TextView) v.findViewById(R.id.rating);
            date = (TextView) v.findViewById(R.id.date);
            moreBtn = (TextView) v.findViewById(R.id.moreBtn);
        }
    }
}

