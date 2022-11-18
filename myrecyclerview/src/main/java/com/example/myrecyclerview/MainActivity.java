package com.example.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "leo";
    private List<Bean> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 100; i++) {
            Bean bean = new Bean();
            bean.setName("学习"+i);
            data.add(bean);
        }

        RecyclerView recyclerView = findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, LinearLayout.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        MyAdapter myAdapter = new MyAdapter(data, this);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setRecyclerItemClickListener(new MyAdapter.OnRecyclerItemClickListener() {
            @Override
            public void OnRecyclerItemClick(int position) {
                Log.e(TAG, "OnRecyclerItemClick: "+position);
            }
        });
    }
}