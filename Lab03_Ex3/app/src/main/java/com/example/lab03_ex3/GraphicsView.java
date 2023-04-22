package com.example.lab03_ex3.;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

public class GraphicView extends View {
    Bitmap[] frames = new Bitmap [16]; //16 frames
    int i=0;
    public GraphicView(Context context){
        super(context);

        frames [0] = BitmapFactory.decodeResource (getResources () ,R.drawable.);
        frames [1] = BitmapFactory.decodeResource (getResources () , R.drawable.);
        frames [2] = BitmapFactory.decodeResource (getResources () , R.drawable.);
        frames [3] = BitmapFactory. decodeResource (getResources () , R.drawable.);
        frames [4] = BitmapFactory.decodeResource (getResources () , R.drawable.);
        frames [5] = BitmapFactory.decodeResource (getResources () ,R.drawable.);
        frames [6] = BitmapFactory.decodeResource (getResources () , R.drawable.);
        frames [7] = BitmapFactory.decodeResource (getResources () , R.drawable.);
        frames [8] = BitmapFactory. decodeResource (getResources () , R.drawable.);
        frames [9] = BitmapFactory.decodeResource (getResources () , R.drawable.);
        frames [10] = BitmapFactory.decodeResource (getResources () , R.drawable.);
        frames [11] = BitmapFactory.decodeResource (getResources () , R.drawable.);
        frames [12] = BitmapFactory.decodeResource (getResources () , R.drawable.);
        frames [13] = BitmapFactory.decodeResource (getResources () , R.drawable.);
        frames [14] = BitmapFactory.decodeResource (getResources () , R.drawable.);
        frames [15] = BitmapFactory.decodeResource (getResources () , R.drawable.);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (i < 16){
            canvas.drawBitmap(frames[i], 40, 40, new Paint());
        }
        else {
            i =0;
        }
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        i++;
        return true;
    }
}
