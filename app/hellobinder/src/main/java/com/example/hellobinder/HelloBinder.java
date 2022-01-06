package com.example.hellobinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HelloBinder extends AppCompatActivity {
    CurrentTimeService cts;
    boolean bound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_binder);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button button01 = findViewById(R.id.button01);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HelloBinder. this,CurrentTimeService.class);
                bindService(intent, sc, BIND_AUTO_CREATE);
                if(bound){
                    Toast.makeText(HelloBinder.this, cts.getCurrentTime(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(!bound){
            bound = false;
            unbindService(sc);
        }
    }

    private ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            CurrentTimeService.LocalBinder binder = (CurrentTimeService.LocalBinder) iBinder;
            cts = binder.getService();
            bound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            bound = false;
        }
    };
}