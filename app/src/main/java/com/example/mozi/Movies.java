package com.example.mozi;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Movies extends AppCompatActivity {
    private MyAdapter myAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_movies);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Movie[] movies = {
                new Movie("The Shawshank Redemption", "Two imprisoned men bond over a number of years.", 1500),
                new Movie("The Godfather", "The aging patriarch of an organized crime dynasty transfers control.", 2000),
                new Movie("The Dark Knight", "Batman faces the Joker, a criminal mastermind.", 1800),
                new Movie("Pulp Fiction", "The lives of two mob hitmen, a boxer, and others intertwine.", 1600),
                new Movie("Forrest Gump", "The story of a man with a low IQ and extraordinary achievements.", 1400),
                new Movie("Inception", "A thief steals secrets through dream-sharing technology.", 1900),
                new Movie("Fight Club", "An insomniac office worker forms an underground fight club.", 1500),
                new Movie("The Matrix", "A computer hacker learns about the true nature of his reality.", 1700),
                new Movie("Goodfellas", "The rise and fall of a mob associate over three decades.", 2000),
                new Movie("The Lord of the Rings", "A hobbit embarks on a journey to destroy a powerful ring.", 2200)
        };

        myAdapter = new MyAdapter(movies, R.drawable.ticket, this::openMovieDetails);
        recyclerView.setAdapter(myAdapter);

    }
    private void openMovieDetails(Movie movie) {
        Intent intent = new Intent(this, MovieDetailsActivity.class);
        intent.putExtra("MOVIE_TITLE", movie.getTitle());
        intent.putExtra("MOVIE_DESCRIPTION", movie.getDescription());
        intent.putExtra("MOVIE_PRICE", movie.getPrice());
        startActivity(intent);
    }
}