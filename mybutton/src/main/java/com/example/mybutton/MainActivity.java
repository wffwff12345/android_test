package com.example.mybutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "leo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);
        //点击事件
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: ");
            }
        });

        //长按事件
        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.e(TAG, "onLongClick: ");
                return false;
            }
        });

        //触摸事件
        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e(TAG, "onTouch: ");
                return false;
            }
        });
    }

    public void test(View view) throws IOException {
        new Thread(() -> {
            //图片 URL
            try {
                Log.e(TAG, "test: ");
                URL url = new URL("http://223.112.179.124:10205/" + "common/images?file=" + "ozXvuBlnTuEy8TpiJR9UkrC0XkOHlleKgujqJvYwNfpGgMhu3SNfXmspoY/8hKba");
                Bitmap bitmap = BitmapFactory.decodeStream(url.openStream());
                Log.e(TAG, "test: " + bitmap);
            } catch (IOException e) {
            }
        }).start();
    }
}