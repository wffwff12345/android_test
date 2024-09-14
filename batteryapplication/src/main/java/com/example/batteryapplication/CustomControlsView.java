package com.example.batteryapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.ui.StyledPlayerView;

public class CustomControlsView extends LinearLayout {

    private PlayerView playerView;

    public CustomControlsView(Context context) {
        super(context);
        init(context);
    }

    public CustomControlsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomControlsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.custom_controls_layout, this, true);
        playerView = findViewById(R.id.player_view);
    }

    public void setPlayer(ExoPlayer player) {
        playerView.setPlayer(player);
    }
}