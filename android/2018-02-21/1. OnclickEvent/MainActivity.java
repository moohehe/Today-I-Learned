package com.example.scitmaster.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity{

    LinearLayout linear;
    Button btn1, btn2, btn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linear = findViewById(R.id.linear);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);



    }

    public void btnOnClick(View view) {
        switch(view.getId()) {
            case R.id.btn1 :
                linear.setOrientation(LinearLayout.VERTICAL);
                break;
            case R.id.btn2 :
                linear.setOrientation(LinearLayout.HORIZONTAL);
                break;
            case R.id.btn3 :
                btn1.setBackgroundColor(Color.argb(Integer.parseInt(String.valueOf(Math.random()*100)),255,11,22));
                btn2.setBackgroundColor(Color.argb(90,255,11,22));
                btn3.setBackgroundColor(Color.argb(90,255,11,22));
                break;
        }
    }
}
