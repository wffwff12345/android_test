package com.example.plainapplication;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private int speed = 10;
    private PlainView plainView;
    private DisplayMetrics displayMetrics = new DisplayMetrics();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        plainView = new PlainView(this);
        setContentView(plainView);
        plainView.setBackgroundColor(getResources().getColor(R.color.teal_200));
        WindowManager windowManager = getWindowManager();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        plainView.currentX = displayMetrics.widthPixels / 2;
        plainView.currentY = displayMetrics.heightPixels / 2;
        plainView.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getX() < displayMetrics.widthPixels / 8) {
            plainView.currentX -= speed;
        }
        if (event.getX() > displayMetrics.widthPixels * 7 / 8) {
            plainView.currentX += speed;
        }
        if (event.getY() < displayMetrics.heightPixels / 8) {
            plainView.currentY -= speed;
        }
        if (event.getY() > displayMetrics.heightPixels * 7 / 8) {
            plainView.currentY += speed;
        }
        return true;
    }
}