package com.example.bottomnavigationapp.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bottomnavigationapp.R;
import com.example.bottomnavigationapp.pojo.Movie;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHolder> {
    private Context context;
    private ArrayList<Movie> movies;

    public StoreAdapter(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.store_list_item, viewGroup, false);
        return new StoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreViewHolder storeViewHolder, int i) {

        Movie movie = movies.get(i);
        storeViewHolder.title.setText(movie.getTitle());
        storeViewHolder.price.setText(movie.getPrice());
        Glide.with(context)
                .load(movie.getImage())
                .into(storeViewHolder.thumbnail);


    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class StoreViewHolder extends RecyclerView.ViewHolder {

        ImageView thumbnail;
        TextView title, price;


        public StoreViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);

        }
    }
}

