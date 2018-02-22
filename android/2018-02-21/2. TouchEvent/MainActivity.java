package com.example.scitmaster.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
        edit = findViewById(R.id.edit);

        text.setOnTouchListener(new TouchHandler());
        edit.setOnKeyListener(new KeyHandler());
    }

    class TouchHandler implements View.OnTouchListener {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            String msg = "[터치이벤트]\n";
            msg += "x=" + motionEvent.getX() + "\n";
            msg += "y=" + motionEvent.getY() + "\n";
            msg += "time=" + motionEvent.getEventTime() + "\n";
            msg += "action=" + motionEvent.getAction() + "\n";
            msg += motionEvent.toString() + "\n";

            text.setText(msg);
            // return false이면 최초의 터치만 실행하고 그 뒤의 동작을 무시됨.
            return true;
        }
    }
    class KeyHandler implements View.OnKeyListener {
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            String msg = "i=" + i + "\n";
            msg += keyEvent.toString();
            text.setText(msg);

            return false;
        }
    }
}
