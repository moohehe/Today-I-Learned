package com.example.scitmaster.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by SCITMASTER on 2018-02-20.
 */
public class MakeRect extends View {
    private ArrayList<Float> x;
    private ArrayList<Float> y;

    public MakeRect(Context context)
    {
        super(context);
        x = new ArrayList<>();
        y = new ArrayList<>();
    }
    public void make(float x, float y){
        this.x.add(x);
        this.y.add(y);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.argb(30,22,11,22));
        for (int i = 0; i < x.size(); i++) {
            Paint paint = new Paint();
            int a = (int) (Math.random() * 100);
            int r = (int) (Math.random() * 255);
            int g = (int) (Math.random() * 255);
            int b = (int) (Math.random() * 255);
            paint.setColor(Color.argb(a, r, g, b));

            canvas.drawRect((x.get(i) - 15), (y.get(i) - 15), (x.get(i) + 15), (y.get(i) + 15), paint);
        }
    }
}
