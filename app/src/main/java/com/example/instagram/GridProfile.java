package com.example.instagram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GridProfile extends AppCompatActivity {

    private ImageView btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_profile);
        btnHome = findViewById(R.id.btn_home);

        RecyclerView rvMain = findViewById(R.id.rv_main);

        List<MainItem> mainItems = new ArrayList<>();
        mainItems.add(new MainItem(1, R.drawable.insta_1));
        mainItems.add(new MainItem(2, R.drawable.insta_2));
        mainItems.add(new MainItem(3, R.drawable.insta_3));
        mainItems.add(new MainItem(4, R.drawable.insta_4));
        mainItems.add(new MainItem(5, R.drawable.insta_5));
        mainItems.add(new MainItem(6, R.drawable.insta_6));
        mainItems.add(new MainItem(7, R.drawable.insta_1));
        mainItems.add(new MainItem(8, R.drawable.insta_2));
        mainItems.add(new MainItem(9, R.drawable.insta_3));
        mainItems.add(new MainItem(10, R.drawable.insta_4));
        mainItems.add(new MainItem(11, R.drawable.insta_5));
        mainItems.add(new MainItem(12, R.drawable.insta_6));
        mainItems.add(new MainItem(13, R.drawable.insta_6));
        mainItems.add(new MainItem(14, R.drawable.insta_6));
        mainItems.add(new MainItem(15, R.drawable.insta_6));
        mainItems.add(new MainItem(16, R.drawable.insta_6));

        rvMain.setLayoutManager(new GridLayoutManager(this, 3));
        GridProfile.AdapterGrid adapter = new GridProfile.AdapterGrid(mainItems);

        rvMain.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnHome.setOnClickListener(view -> {
            startActivity(new Intent(GridProfile.this, MainActivity.class));
        });
    }

    public class AdapterGrid extends RecyclerView.Adapter<GridProfile.AdapterGrid.GridViewHolder> {
        private final List<MainItem> mainItems;

        public AdapterGrid(List<MainItem> mainItems) {
            this.mainItems = mainItems;
        }

        @NonNull
        @Override
        public GridProfile.AdapterGrid.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new GridProfile.AdapterGrid.GridViewHolder(getLayoutInflater().inflate(R.layout.grid_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull GridProfile.AdapterGrid.GridViewHolder holder, int position) {
            Log.d("chama", " " + position);
            MainItem mainItemCurrent = mainItems.get(position);
            holder.bind(mainItemCurrent);
        }

        @Override
        public int getItemCount() {
            return mainItems.size();
        }

        // Entenda como sendo a View da celula que está dentro do recycler
        private class GridViewHolder extends RecyclerView.ViewHolder {

            public GridViewHolder(@NonNull View itemView) {
                super(itemView);
            }

            public void bind(MainItem item) {
                ImageView imgMain = itemView.findViewById(R.id.img_main);

                imgMain.setImageResource(item.getImageId());
            }
        }
    }

}