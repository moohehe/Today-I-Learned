package com.example.scitmaster.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

/**
 * Created by SCITMASTER on 2018-02-20.
 */

public class PaintView extends View{
    Typeface font1;
    Bitmap bit;
    public PaintView(Context context){
        super(context);
        font1 = Typeface.createFromAsset(context.getAssets(),"droidrobot.otf");
        bit = BitmapFactory.decodeResource(getResources(), R.drawable.computer1);
    }
    //onDraw함수


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.LTGRAY);
        Paint paint = new Paint();
        // 그리기
        paint.setColor(Color.BLUE);
        // 원 그리기
        canvas.drawCircle(100,100,50,paint);

        paint.setColor(0x550000ff);
        canvas.drawRect(200,200,400,400,paint);

        paint.setColor(Color.RED);
        paint.setTextSize(50);
        paint.setTypeface(font1);
        canvas.drawText("Text",100,100,paint);

        paint.setColor(Color.GREEN);
        paint.setStrokeCap(Paint.Cap.ROUND); // 선의 끝 모양
        paint.setStrokeWidth(10);
        canvas.drawLine(100,400, 450, 600, paint);

        canvas.drawBitmap(bit, 500, 500, paint);

    }
}
