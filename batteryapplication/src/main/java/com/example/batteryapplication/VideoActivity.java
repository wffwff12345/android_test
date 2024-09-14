package com.example.batteryapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;


public class VideoActivity extends AppCompatActivity implements TextureView.SurfaceTextureListener, JoystickView.OnJoystickListener {

    private static final String TAG = "VideoActivity";
    private TextureView videoTextureView;
    private MediaPlayer mediaPlayer;
    private JoystickView joystickView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoTextureView = findViewById(R.id.video_texture_view);
        joystickView = findViewById(R.id.joystick_view);

        videoTextureView.setSurfaceTextureListener(this);
        joystickView.setOnJoystickListener(this);

        // 初始化MediaPlayer
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource("http://223.112.179.125:23081/hls/stream2.m3u8");
            mediaPlayer.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPositionChanged(float x, float y) {
        // 根据 x 和 y 的位置计算方向和力度
        // 可以在这里添加逻辑来控制游戏或设备
        System.out.println("Handle Position: (" + x + ", " + y + ")");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }

    @Override
    public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surface, int width, int height) {
        try {
            mediaPlayer.setSurface(new Surface(videoTextureView.getSurfaceTexture()));
            mediaPlayer.start();
        } catch (IllegalStateException e) {
            Log.i(TAG, "onSurfaceTextureAvailable: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surface) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surface) {

    }
}