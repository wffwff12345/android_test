package com.example.plainapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.Timer;
import java.util.TimerTask;

public class PlainView extends View {
    public float currentX;
    public float currentY;
    private Paint paint = new Paint();
    private Bitmap plane;
    private Bitmap plane1;
    private int index;

    public PlainView(Context context) {
        super(context);
        plane = BitmapFactory.decodeResource(context.getResources(), R.drawable.plane);
        plane1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.plane1);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                index++;
                PlainView.this.invalidate();
            }
        }, 0l, 100l);
        setFocusable(true);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(index % 2 == 0 ? plane : plane1, currentX, currentY, paint);
    }
}
