package com.example.mozi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Movie[] movies;
    private int imageResource;
    private OnCardClickListener listener;

    public interface OnCardClickListener {
        void onCardClick(Movie movie);
    }

    public MyAdapter(Movie[] movies, int imageResource, OnCardClickListener listener) {
        this.movies = movies;
        this.imageResource = imageResource;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = movies[position];
        holder.titleTextView.setText(movie.getTitle());
        holder.imageView.setImageResource(imageResource);

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onCardClick(movie);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.item_title);
            imageView = itemView.findViewById(R.id.item_image);
        }
    }
}
