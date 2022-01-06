package com.example.hellointentservice;

import android.app.IntentService;
import android.content.Intent;
import android.text.format.Time;
import android.util.Log;


public class CurrentTimeService extends IntentService {
    public CurrentTimeService(){
        super("CurrentTimeService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Time time = new Time();
        time.setToNow();
        String currentTime = time.format("%Y-%m-%d %H:%M:%S");
        Log.i("CurrentTimeService", currentTime);
    }
}
