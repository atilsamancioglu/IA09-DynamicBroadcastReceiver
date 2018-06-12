package com.atilsamancioglu.dynamicbroadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    BroadcastingClass broadcastingClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        broadcastingClass = new BroadcastingClass();
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_LOW);

        registerReceiver(broadcastingClass,intentFilter);

    }

    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver(broadcastingClass);
    }
}
