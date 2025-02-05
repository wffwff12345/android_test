package com.example.batteryapplication;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class BatteryActivity extends AppCompatActivity {
    private BatteryView horizontalBattery, verticalBattery;
    private int power;
    private LinearLayout root;
    private Handler handler = new Handler() {
        @SuppressLint("HandlerLeak")
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    horizontalBattery.setPower(power += 5);
                    if (power == 100) {
                        power = 0;
                    }
                    break;
                default:
                    break;
            }
        }
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);
        horizontalBattery = findViewById(R.id.horizontalBattery);
        verticalBattery = findViewById(R.id.verticalBattery);
        verticalBattery.setColor(Color.BLACK);
        verticalBattery.setPower(85);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        }, 0, 100);
        root = findViewById(R.id.main);
        DrawView drawView = new DrawView(this);
        drawView.setMinimumHeight(500);
        drawView.setMinimumWidth(300);
        root.addView(drawView);
        //joystickView = findViewById(R.id.joystick_view);

        // 添加监听器以获取操作杆数据
        /*joystickView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float x = event.getX();
                float y = event.getY();
                // 根据 x 和 y 的位置计算方向和力度
                // 可以在这里添加逻辑来控制游戏或设备
                return true;
            }
        });*/
    }
}