package com.example.myviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager2 viewPager2 = findViewById(R.id.viewPager2);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter();
        viewPager2.setAdapter(viewPagerAdapter);
        LayoutInflater from = getLayoutInflater().from(this);
//        View view1 = from.inflate(R.layout.layout1, null);
//        View view2 = from.inflate(R.layout.layout2, null);
//        View view3 = from.inflate(R.layout.layout3, null);
//        ArrayList<View> list = new ArrayList<>();
//        list.add(view1);
//        list.add(view2);
//        list.add(view3);
//
//        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter();
//        viewPager.setAdapter(viewPagerAdapter);
    }
}