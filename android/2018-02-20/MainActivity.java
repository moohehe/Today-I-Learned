package com.example.scitmaster.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView body;
    MakeRect makeRect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        makeRect = new MakeRect(this);

        setContentView(makeRect);
        Toast.makeText(this, "로드완료", Toast.LENGTH_SHORT).show();
        //body = findViewById(R.id.body);
        //body.setOnTouchListener(new View.OnTouchListener() {
        makeRect.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //Toast.makeText(MainActivity.this, "x="+motionEvent.getX()+" y=" + motionEvent.getY(),Toast.LENGTH_SHORT).show();
                //body.setText("x="+motionEvent.getX()+" y=" + motionEvent.getY());
                makeRect.make(motionEvent.getX(), motionEvent.getY());
                return true;
            }
        });

        //PaintView paintView = new PaintView(this);
        //setContentView(paintView);


    }

}

