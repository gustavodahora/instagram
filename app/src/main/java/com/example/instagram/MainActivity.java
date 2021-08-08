package com.example.instagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnProfile = findViewById(R.id.btn_person);

        RecyclerView rvMain = findViewById(R.id.rv_main);

        List<MainItem> mainItems = new ArrayList<>();
        mainItems.add(new MainItem(1, R.drawable.insta_1));
        mainItems.add(new MainItem(2, R.drawable.insta_2));
        mainItems.add(new MainItem(3, R.drawable.insta_3));
        mainItems.add(new MainItem(4, R.drawable.insta_4));
        mainItems.add(new MainItem(5, R.drawable.insta_5));
        mainItems.add(new MainItem(6, R.drawable.insta_6));

        rvMain.setLayoutManager(new LinearLayoutManager(this));
        MainAdapter adapter = new MainAdapter(mainItems);

        rvMain.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnProfile.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, GridProfile.class)));
    }

    public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
        private final List<MainItem> mainItems;

        public MainAdapter(List<MainItem> mainItems) {
            this.mainItems = mainItems;
        }

        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MainViewHolder(getLayoutInflater().inflate(R.layout.feed_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MainActivity.MainAdapter.MainViewHolder holder, int position) {
            Log.d("chama", " " + position);
            MainItem mainItemCurrent = mainItems.get(position);
            holder.bind(mainItemCurrent);
        }

        @Override
        public int getItemCount() {
            return mainItems.size();
        }

        // Entenda como sendo a View da celula que está dentro do recycler
        private class MainViewHolder extends RecyclerView.ViewHolder {

            public MainViewHolder(@NonNull View itemView) {
                super(itemView);
            }

            public void bind(MainItem item) {
                ImageView imgMain = itemView.findViewById(R.id.img_main);

                imgMain.setImageResource(item.getImageId());
            }
        }
    }
}