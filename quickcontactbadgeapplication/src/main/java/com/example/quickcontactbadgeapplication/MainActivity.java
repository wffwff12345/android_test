package com.example.quickcontactbadgeapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.QuickContactBadge;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        QuickContactBadge badge = findViewById(R.id.badge);
        badge.assignContactFromPhone("15209879830",false);
    }
}