package com.example.myactivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class CustomReceiver extends BroadcastReceiver {
    private static final String TAG = CustomReceiver.class.getSimpleName();
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "onReceive: 接受静态广播信息" );
    }
}
