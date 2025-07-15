package com.example.alarmclock.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AlarmClockView extends View {
    private Paint circlePaint;
    private Paint keduPaint;

    public AlarmClockView(Context context) {
        super(context);
        init();
    }

    public AlarmClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AlarmClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public AlarmClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        circlePaint = new Paint();
        circlePaint.setColor(Color.parseColor("#000000"));
        circlePaint.setStrokeWidth(5);
        circlePaint.setStyle(Paint.Style.STROKE);

        keduPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        keduPaint.setColor(Color.parseColor("#000000"));
        keduPaint.setStrokeWidth(3);
        keduPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2f, getHeight() / 2f, getWidth() / 4f, circlePaint);
        for (int i = 0; i < 24; i++) {
            if (i==0 || i==6 || i== 12 || i==18) {
                keduPaint.setStrokeWidth(3);
                keduPaint.setTextSize(30);
                canvas.drawLine(getWidth() / 2f, getHeight() / 2f - getHeight() / 4f,getWidth() / 2f, getHeight() / 2f - getHeight() / 4f + 50, keduPaint);
                String text = String.valueOf(i);
                canvas.drawText(text, getWidth() / 2f - keduPaint.measureText(text) / 2f, getHeight() / 2f - getHeight() / 4f + 80, keduPaint);
            } else {
                keduPaint.setStrokeWidth(1);
                keduPaint.setTextSize(15);
                canvas.drawLine(getWidth() / 2f, getHeight() / 2f - getHeight() / 4f,getWidth() / 2f, getHeight() / 2f - getHeight() / 4f + 25, keduPaint);
                String text = String.valueOf(i);
                canvas.drawText(text, getWidth() / 2f - keduPaint.measureText(text) / 2f, getHeight() / 2f - getHeight() / 4f + 60, keduPaint);
            }
            canvas.rotate(15, getWidth()/2, getHeight()/2);
        }
    }
}
