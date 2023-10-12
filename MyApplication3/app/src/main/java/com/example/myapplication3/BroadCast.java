package com.example.myapplication3;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

public class BroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String value = intent.getStringExtra("key");
        if(value != null){
            Intent i = new Intent();
            i.setClassName("com.example.myapplication3", "com.example.myapplication3.MainActivity");
            i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(i);
        }
    }
}
