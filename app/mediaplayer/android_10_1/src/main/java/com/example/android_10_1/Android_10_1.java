package com.example.android_10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Android_10_1 extends AppCompatActivity {
    private MediaPlayer mp1;
    private boolean isPause = true;
//    private MediaPlayer mp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android101);

        Button button01 = findViewById(R.id.button01);
        Button button02 = findViewById(R.id.button02);
        Button button03 = findViewById(R.id.button03);

        mp1 = MediaPlayer.create(this, R.raw.rubia);
        mp1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer m) {
                play();
            }
        });

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //开始播放
                if(isPause){
                    button01.setEnabled(false);
                    button02.setEnabled(true);
                    button03.setEnabled(true);
                    isPause = false;
                    play();
                    Toast.makeText(Android_10_1.this, "开始播放:" + R.raw.rubia, Toast.LENGTH_SHORT).show();
                }
            }
        });

        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPause == true){
                    button01.setEnabled(false);
                    button02.setEnabled(true);
                    button03.setEnabled(true);
                    isPause = false;
                    mp1.start();
                    Toast.makeText(Android_10_1.this, "继续播放:" + R.raw.rubia, Toast.LENGTH_SHORT).show();
                } else{
                    mp1.pause();
                    isPause = true;
                    Toast.makeText(Android_10_1.this, "暂停播放", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp1.stop();
                isPause = true;
                button01.setEnabled(true);
                button02.setEnabled(false);
                button03.setEnabled(false);
                Toast.makeText(Android_10_1.this, "停止播放", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        if(mp1.isPlaying()){
            mp1.stop();
        }
        mp1.release();
        super.onDestroy();
    }

    public void play(){
        try{
            if(mp1 != null){
                mp1.reset();
            }
            mp1 = MediaPlayer.create(this, R.raw.rubia);
            mp1.start();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}