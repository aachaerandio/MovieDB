package com.aracelimontes.moviedb.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aracelimontes.moviedb.R;
import com.aracelimontes.moviedb.entity.People;
import com.aracelimontes.moviedb.entity.TVShow;
import com.aracelimontes.moviedb.util.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by araceli.montes on 05/05/2016.
 */
public class PeopleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public ArrayList<People> mData;
    private Context mContext;

    public PeopleAdapter(Context context) {
        this.mContext = context;
        this.mData = new ArrayList<>();
    }

    public void setData(List<People> list) {
        mData.clear();
        mData.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_people, parent, false);

        return new PeopleVH(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof PeopleVH)
        {
            PeopleVH mHolder = (PeopleVH) holder;
            People item = mData.get(position);
            //full URL for image
            Picasso.with(mContext)
                    .load(item.getPoster())
                    .placeholder(R.color.colorAccent)
                    .into(mHolder.image);

            mHolder.title.setText(item.name);
        }
    }

    @Override
    public int getItemCount() {
        return (mData == null) ? 0 : mData.size();
    }

    private class PeopleVH extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView title, description;

        public PeopleVH(View v) {
            super(v);
            image = (ImageView) v.findViewById(R.id.imageView);
            title = (TextView) v.findViewById(R.id.title);
            description = (TextView) v.findViewById(R.id.description);
        }
    }
}
