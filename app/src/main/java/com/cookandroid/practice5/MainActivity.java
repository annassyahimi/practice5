package com.cookandroid.practice5;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    int[] images = {
            R.drawable.cat,
            R.drawable.dog,
            R.drawable.rabbit,
            R.drawable.bear
    };

    String[] imageNames = {
            "Cat",
            "Dog",
            "Rabbit",
            "Bear"
    };

    float[] ratings = new float[images.length];
    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        Button btnPrev = findViewById(R.id.btnPrev);
        Button btnNext = findViewById(R.id.btnNext);
        Button btnResult = findViewById(R.id.btnResult);

        imageView.setImageResource(images[currentIndex]);
        ratingBar.setRating(ratings[currentIndex]);

        ratingBar.setOnRatingBarChangeListener((bar, rating, fromUser) -> {
            ratings[currentIndex] = rating;
        });

        btnNext.setOnClickListener(v -> {
            if (currentIndex < images.length - 1) {
                currentIndex++;
                imageView.setImageResource(images[currentIndex]);
                ratingBar.setRating(ratings[currentIndex]);
            }
        });

        btnPrev.setOnClickListener(v -> {
            if (currentIndex > 0) {
                currentIndex--;
                imageView.setImageResource(images[currentIndex]);
                ratingBar.setRating(ratings[currentIndex]);
            }
        });

        btnResult.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("ratings", ratings);
            intent.putExtra("names", imageNames);
            startActivity(intent);
        });
    }
}
