package com.example.wechatppage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ViewPager2 viewPager2;
    private LinearLayout lw,lc,ls,lm;
    ImageView WeChat,Communicate,Search,My;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPager();

    }

    private void initPager() {
        viewPager2 = findViewById(R.id.chat);
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(BlankFragment.newInstance("微信聊天"));
        list.add(BlankFragment.newInstance("通讯录"));
        list.add(BlankFragment.newInstance("发现"));
        list.add(BlankFragment.newInstance("我"));
        RecyclerView.Adapter MyFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),getLifecycle(),list);
        viewPager2.setAdapter(MyFragmentPagerAdapter);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

    }

    private void changeTab(int position) {
        switch (position){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    @Override
    public void onClick(View view) {
        changeTab(view.getId());
    }
}