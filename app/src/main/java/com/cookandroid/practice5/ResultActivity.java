package com.cookandroid.practice5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.RatingBar;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        LinearLayout layout = findViewById(R.id.resultLayout);
        Button btnReturn = findViewById(R.id.btnReturn);

        float[] ratings = getIntent().getFloatArrayExtra("ratings");
        String[] names = getIntent().getStringArrayExtra("names");

        for (int i = 0; i < names.length; i++) {
            TextView tv = new TextView(this);
            tv.setText(names[i]);
            tv.setTextSize(18f);

            RatingBar rb = new RatingBar(this, null, android.R.attr.ratingBarStyleSmall);
            rb.setNumStars(5);
            rb.setStepSize(1);
            rb.setRating(ratings[i]);
            rb.setProgressTintList(getResources().getColorStateList(android.R.color.holo_orange_light));

            LinearLayout row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setPadding(0, 10, 0, 10);
            row.addView(tv);
            row.addView(rb);

            layout.addView(row);
        }

        btnReturn.setOnClickListener(v -> finish());
    }
}
