package com.example.mozi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MovieDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        TextView movieTitleTextView = findViewById(R.id.movie_title);
        TextView movieDescriptionTextView = findViewById(R.id.movie_description);
        TextView moviePriceTextView = findViewById(R.id.movie_price);
        ImageView movieImageView = findViewById(R.id.movie_image);

        String movieTitle = getIntent().getStringExtra("MOVIE_TITLE");
        String movieDescription = getIntent().getStringExtra("MOVIE_DESCRIPTION");
        int moviePrice = getIntent().getIntExtra("MOVIE_PRICE", 0);
        int movieImageResource = getIntent().getIntExtra("MOVIE_IMAGE", R.drawable.ticket);

        movieTitleTextView.setText(movieTitle);
        movieDescriptionTextView.setText(movieDescription);
        moviePriceTextView.setText(String.format("%d HUF", moviePrice));
        movieImageView.setImageResource(movieImageResource);

        com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MovieDetailsActivity.this, Movies.class);
                startActivity(intent);
            }
        });

        com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButtonWeb = findViewById(R.id.fabweb);
        floatingActionButtonWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Uri uri = Uri.parse("https://www.cinemacity.hu/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
