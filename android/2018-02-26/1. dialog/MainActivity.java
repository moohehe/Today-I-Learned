package com.example.scitmaster.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

    }
    public void btnOnClick(View view) {
        AlertDialog.Builder bid = new AlertDialog.Builder(this);
        /*bid.setTitle("알립니다.")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("대화상자를 열었습니다.")
                .show();*/
        bid.setPositiveButton("닫기", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                textView.setText("다이얼로그 테스트");
            }
        }).setNegativeButton("열기",null)
                .setNeutralButton("보기",null)
                .setCancelable(false)
                .show();
    }
}
