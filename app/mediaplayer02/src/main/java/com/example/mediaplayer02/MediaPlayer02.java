package com.example.mediaplayer02;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

import java.io.File;
import java.io.IOException;

public class MediaPlayer02 extends AppCompatActivity {
    private MediaPlayer mp;
    private File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player02);

        file = new File("/sd/a.wav");
        mp = new MediaPlayer();
        try {
            mp.setDataSource(file.getAbsolutePath());
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}