package com.example.chronometer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity implements Chronometer.OnChronometerTickListener {
    private Chronometer chronometer;

    private Button start;
    private Button stop;
    private Button reset;
    private Button format;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        chronometer = findViewById(R.id.chronometer);
        chronometer.setOnChronometerTickListener(this);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        reset = findViewById(R.id.reset);
        format = findViewById(R.id.format);
    }

    public void start(View view) {
        chronometer.start();
    }

    public void stop(View view) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.stop();
    }

    public void reset(View view) {
        chronometer.setBase(SystemClock.elapsedRealtime());
    }

    public void format(View view) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
    }

    @Override
    public void onChronometerTick(Chronometer chr) {
        long time = SystemClock.elapsedRealtime() - chr.getBase();
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        chronometer.setText(sdf.format(date));
    }
}