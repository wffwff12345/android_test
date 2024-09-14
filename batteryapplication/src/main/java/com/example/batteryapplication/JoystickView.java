package com.example.batteryapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class JoystickView extends View {

    private Paint paint = new Paint();
    private int centerX, centerY;
    private float handleX, handleY;
    private int radius;
    private OnJoystickListener listener;

    public JoystickView(Context context) {
        this(context, null);
    }

    public JoystickView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public JoystickView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        radius = 200; // 假设半径为100像素
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        centerY = h / 2;
        handleX = centerX;
        handleY = centerY;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.GRAY);
        paint.setAlpha(128);
        canvas.drawCircle(centerX, centerY, radius, paint); // 绘制背景圆

        paint.setColor(Color.BLUE); // 改变颜色以区分手柄
        paint.setAlpha(128);
        canvas.drawCircle(handleX, handleY, radius / 3, paint); // 绘制手柄
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                double distance = Math.sqrt((x - centerX) * (x - centerX) + (y - centerY) * (y - centerY));
                if (distance > radius) {
                    handleX = (float) ((x - centerX) / distance * radius + centerX);
                    handleY = (float) ((y - centerY) / distance * radius + centerY);
                } else {
                    handleX = x;
                    handleY = y;
                }
                invalidate();
                if (listener != null) {
                    listener.onPositionChanged(handleX, handleY);
                }
                break;
            case MotionEvent.ACTION_UP:
                handleX = centerX;
                handleY = centerY;
                invalidate();
                if (listener != null) {
                    listener.onPositionChanged(handleX, handleY);
                }
                break;
        }
        return true;
    }

    public void setOnJoystickListener(OnJoystickListener listener) {
        this.listener = listener;
    }

    public interface OnJoystickListener {
        void onPositionChanged(float x, float y);
    }
}