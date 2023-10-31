package com.example.myrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.animation.BaseAnimation;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "leo";
    private List<Bean> data = new ArrayList<>();

    private RecycleViewAdapter adapter;

    private RecyclerView recyclerView;

    private View head;
    private View foot;
    private View noData;
    private Button loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv);
        loading = findViewById(R.id.loading);
        loading.setOnClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        /*recyclerView.setAdapter(myAdapter);
        myAdapter.setRecyclerItemClickListener((position) -> {
            Log.e(TAG, "OnRecyclerItemClick: " + position);
        });*/
        adapter = new RecycleViewAdapter(R.layout.recyclerview_item, data);
        head = LayoutInflater.from(this).inflate(R.layout.item_head, null);
        foot = LayoutInflater.from(this).inflate(R.layout.item_foot, null);
        noData = LayoutInflater.from(this).inflate(R.layout.item_empty, null);
        adapter.setHeaderView(head);
        adapter.setFooterView(foot);
        adapter.setEmptyView(noData);
        adapter.setAnimationWithDefault(BaseQuickAdapter.AnimationType.ScaleIn);
        adapter.setAnimationFirstOnly(false);
        adapter.setOnItemClickListener((adapter, view, position) -> Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show());
        recyclerView.setAdapter(adapter);
    }

    public void initData(){
        for (int i = 0; i < 100; i++) {
            Bean bean = new Bean();
            bean.setName("学习" + i);
            data.add(bean);
        }
    }

    @Override
    public void onClick(View v) {
        Log.e(TAG, "data数据 ");

        if(v.getId() == R.id.loading){
            initData();
            Log.e(TAG, "data数据长度 "+data.size());
            adapter.notifyDataSetChanged();
        }
    }
}