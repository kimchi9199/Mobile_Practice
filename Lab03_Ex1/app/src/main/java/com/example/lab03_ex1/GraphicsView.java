package com.example.lab03_ex1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class GraphicsView extends View {

    public GraphicsView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Rect r = new Rect(60, 60, 500, 200);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.RED);
        canvas.drawRect(r, paint);
        invalidate();
    }
}
