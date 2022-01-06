package com.example.helloservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.format.Time;
import android.util.Log;


public class CurrentTimeByService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Time time = new Time();
        time.setToNow();
        String currentTime = time.format("%Y-%m-%d %H:%M:%S");
        Log.i("CurrentTimeByService", currentTime);
        return START_STICKY;
    }
}
