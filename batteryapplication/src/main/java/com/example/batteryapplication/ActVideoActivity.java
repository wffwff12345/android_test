package com.example.batteryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;

public class ActVideoActivity extends AppCompatActivity implements JoystickView.OnJoystickListener {

    private CustomControlsView customControlsView;
    private ExoPlayer exoPlayer;
    private JoystickView joystickView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_video2);

        customControlsView = findViewById(R.id.custom_controls);
        joystickView = findViewById(R.id.joystick_view);
        joystickView.setOnJoystickListener(this);

        // 初始化 ExoPlayer
        exoPlayer = new ExoPlayer.Builder(this).build();
        customControlsView.setPlayer(exoPlayer);

        // 设置播放源
        MediaItem mediaItem = MediaItem.fromUri("http://223.112.179.125:23081/hls/stream2.m3u8");
        exoPlayer.setMediaItem(mediaItem);
        exoPlayer.prepare();
        exoPlayer.play();

        // 添加播放器状态监听器
        exoPlayer.addListener(new Player.Listener() {
            @Override
            public void onIsPlayingChanged(boolean isPlaying) {
            }

            @Override
            public void onPlaybackStateChanged(int playbackState) {
                // 播放状态变化时的处理
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (exoPlayer != null) {
            exoPlayer.release();
        }
    }

    @Override
    public void onPositionChanged(float x, float y) {
        // 根据 x 和 y 的位置计算方向和力度
        // 可以在这里添加逻辑来控制游戏或设备
        System.out.println("Handle Position: (" + x + ", " + y + ")");
    }
}