package com.example.soundpool01;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

public class SoundPool01 extends AppCompatActivity {
    private SoundPool sp01;
    private HashMap<Integer, Integer> soundMp = new HashMap<Integer, Integer>();

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        sp01.play(soundMp.get(5), 1, 1, 0, 0, 1);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_pool01);

        Button button01 = findViewById(R.id.button01);
        Button button02 = findViewById(R.id.button02);
        Button button03 = findViewById(R.id.button03);
        Button button04 = findViewById(R.id.button04);

        sp01 = new SoundPool(5, AudioManager.STREAM_SYSTEM, 1);
        soundMp.put(1, sp01.load(SoundPool01.this, R.raw.chimes, 1));
        soundMp.put(2, sp01.load(SoundPool01.this, R.raw.enter, 1));
        soundMp.put(3, sp01.load(SoundPool01.this, R.raw.notify, 1));
        soundMp.put(4, sp01.load(SoundPool01.this, R.raw.ringout, 1));
        soundMp.put(5, sp01.load(SoundPool01.this, R.raw.ding, 1));

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp01.play(soundMp.get(1), 1, 1, 0, 0, 1);
            }
        });

        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp01.play(soundMp.get(2), 1, 1, 0, 0, 1);
            }
        });

        button03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp01.play(soundMp.get(3), 1, 1, 0, 0, 1);
            }
        });

        button04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp01.play(soundMp.get(4), 1, 1, 0, 0, 1);
            }
        });



    }
}