package com.example.videoview01;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class VideoView01 extends AppCompatActivity {
    private VideoView videoView01;
    private File file01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view01);

        videoView01 = findViewById(R.id.videoView01);
        file01 = new File("/storage/emulated/0/Movies/yuansheng01.mp4");
        MediaController mc = new MediaController(this);
        if(file01.exists()){
            videoView01.setVideoPath(file01.getPath());
            videoView01.setMediaController(mc);
            videoView01.requestFocus();
            try {
                videoView01.start();
            }catch (Exception e){
                e.printStackTrace();
            }
            videoView01.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    Toast.makeText(VideoView01.this, "视频播放完毕!", Toast.LENGTH_SHORT).show();
                }
            });
        } else{
            Toast.makeText(VideoView01.this, "视频文件不存在", Toast.LENGTH_SHORT).show();
        }

    }
}