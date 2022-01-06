package com.example.protectedeye;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.format.Time;

import java.util.Timer;
import java.util.TimerTask;


public class TimeService extends Service {
    private Timer timer;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        timer = new Timer(true);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                String ns = Context.NOTIFICATION_SERVICE;
                NotificationManager manager = (NotificationManager)getSystemService(ns);
                Notification.Builder notification = new Notification.Builder(TimeService.this);
                CharSequence contentTitle = getText(R.string.title);
                CharSequence contentText = getText(R.string.text);
                notification.setContentTitle(contentTitle);
                notification.setContentText(contentText);
                notification.setSmallIcon(R.mipmap.warning);
                notification.setDefaults(Notification.DEFAULT_SOUND|Notification.DEFAULT_VIBRATE);
                Intent intent1 = new Intent(TimeService.this, ProtectedEye.class);
                manager.notify(0, notification.build());
                TimeService.this.stopSelf();
            }
        }, 6000);
    }
}
