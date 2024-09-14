package com.example.myactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void startService(View view) {
        startService(new Intent(this, Myservice.class));
    }

    public void stopService(View view) {
        stopService(new Intent(this, Myservice.class));
    }

    public void bindService(View view)
    {
        bindService(new Intent(this, Myservice.class), connection, Context.BIND_AUTO_CREATE);
    }

    public void unbindService(View view) {
        unbindService(connection);
    }

    private final ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}