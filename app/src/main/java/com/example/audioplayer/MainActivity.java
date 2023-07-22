package com.example.audioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btnf;
    Button btnp;
    Button btnb;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnp = findViewById(R.id.play1);
        btnb = findViewById(R.id.playback);
        btnf = findViewById(R.id.playforword);

MediaPlayer mp3 =new MediaPlayer();
//mp3.setAudioAttributes(AudioManager.STREAM_MUSIC);
mp3.setAuxEffectSendLevel(AudioManager.STREAM_ALARM);

        String apath = "android.resource://" + getPackageName() + "/" + R.raw.song_3;
        Uri audiouri = Uri.parse(apath);

        try {
            mp3.setDataSource(this, audiouri);
            mp3.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        btnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3.start();
            }
        });











    }
}