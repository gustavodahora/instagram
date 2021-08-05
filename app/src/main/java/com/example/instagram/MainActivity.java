package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProfile = findViewById(R.id.btn_person);
    }

    @Override
    protected void onStart() {
        super.onStart();

        btnProfile.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, GridProfile.class));
        });
    }
}