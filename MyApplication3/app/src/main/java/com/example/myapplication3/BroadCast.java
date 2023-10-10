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
            Log.d("value",value);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                ((Activity) context).finishAndRemoveTask();
            } else {
                ((Activity) context).finish();
            }
        }
    }
}
