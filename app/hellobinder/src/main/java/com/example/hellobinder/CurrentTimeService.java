package com.example.hellobinder;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.text.format.Time;


public class CurrentTimeService extends Service {
    private final IBinder binder= new LocalBinder();

    public class LocalBinder extends Binder{
         CurrentTimeService getService(){
            return CurrentTimeService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public String getCurrentTime(){
        Time time = new Time();
        time.setToNow();
        String currentTime = time.format("%Y-%m-%d %H:%M:%S");
        return currentTime;
    }
}
