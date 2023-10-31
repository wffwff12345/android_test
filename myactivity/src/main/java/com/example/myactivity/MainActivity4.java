package com.example.myactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity4 extends AppCompatActivity {

    private static final String TAG = "MainActivity4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        UpdateIpSelectCity updateIpSelectCity = new UpdateIpSelectCity();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ActionUtils.FLAG_MESSAGE);
        registerReceiver(updateIpSelectCity, intentFilter);
    }

    public void send(View view) {
        Log.e(TAG, "send: test ");
        Intent intent = new Intent();
        intent.setAction(ActionUtils.MESSAGE);
        intent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
        sendBroadcast(intent);
    }
}