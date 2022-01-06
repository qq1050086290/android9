package com.example.notification_build;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Notification_build extends AppCompatActivity {

    private int NOTIFY_ID = 001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_build);

        Button button01 = findViewById(R.id.button01);
        Button button02 = findViewById(R.id.button02);

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager NoManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                Notification.Builder notification = new Notification.Builder(Notification_build.this);
                notification.setSmallIcon(R.mipmap.title);
                notification.setContentTitle("重要通知");
                notification.setContentText("明天上班");
                NoManager.notify(NOTIFY_ID, notification.build());
            }
        });

    }
}