package com.aracelimontes.moviedb.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aracelimontes.moviedb.R;
import com.aracelimontes.moviedb.entity.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by araceli.montes on 03/05/2016.
 */
public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public ArrayList<Movie> mData;
    private Context mContext;

    public MovieAdapter(Context context) {
        this.mContext = context;
        this.mData = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_movie, parent, false);

        return new MovieVH(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MovieVH)
        {
            MovieVH mHolder = (MovieVH) holder;
            Movie item = mData.get(position);
            //full URL for image
            Picasso.with(mContext)
                    .load(item.getPoster())
                    .placeholder(R.color.colorAccent)
                    .into(mHolder.image);

            mHolder.title.setText(item.title);
            mHolder.description.setText(item.overview);
            mHolder.date.setText(item.releaseDate);
            mHolder.rating.setText(item.voteAverage.toString());
            //mHolder.subtitle.setText() -> genreIds
        }

    }

    public void setData(List<Movie> movieList)
    {
        mData.clear();
        mData.addAll(movieList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (mData == null) ? 0 : mData.size();
    }

    public class MovieVH extends RecyclerView.ViewHolder
    {
        public ImageView image;
        public TextView title, subtitle, description, rating, date;

        public MovieVH(View v)
        {
            super(v);
            image = (ImageView) v.findViewById(R.id.imageView);
            title = (TextView) v.findViewById(R.id.title);
            subtitle = (TextView) v.findViewById(R.id.subtitle);
            description = (TextView) v.findViewById(R.id.description);
            rating = (TextView) v.findViewById(R.id.rating);
            date = (TextView) v.findViewById(R.id.date);
        }
    }
}
