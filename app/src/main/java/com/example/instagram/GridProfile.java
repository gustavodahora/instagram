package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

public class GridProfile extends AppCompatActivity {

    private ImageView btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_profile);
        btnHome = findViewById(R.id.btn_home);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnHome.setOnClickListener(view -> {
            startActivity(new Intent(GridProfile.this, MainActivity.class));
        });
    }
}