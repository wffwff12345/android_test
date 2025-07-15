package com.example.jizhangapplication;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class SettingsActivity extends AppCompatActivity {

    private SwitchMaterial darkModeSwitch;
    private SwitchMaterial notificationSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        darkModeSwitch = findViewById(R.id.darkModeSwitch);
        notificationSwitch = findViewById(R.id.notificationSwitch);

        setupSwitches();
    }

    private void setupSwitches() {
        // 设置深色模式开关的初始状态和监听器
        boolean isDarkMode = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES;
        darkModeSwitch.setChecked(isDarkMode);
        darkModeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            int nightMode = isChecked ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO;
            AppCompatDelegate.setDefaultNightMode(nightMode);
        });

        // TODO: 实现通知开关的功能
        notificationSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // 处理通知开关状态变化
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}