package com.example.scitmaster.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /**
     * Activity
     * 안드로이드 응용 프로그램을 구성하는 4가지 컴포넌트 중 하나
     * Activity, Service, BR(BroadCast Receiver), CP(Content Provider)
     *
     * Activity 하나는 독립된 기능을 수행하며
     * Activity 끼리 중첩되지 않는 것이 View 와 다른 점이다.
     */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnOnClick (View view) {
        // new Intent(호출자, 대상자)
        // 호출자는 MainActivity 자신
        // 대상자는 SubActivity를 호출한다는 뜻
        Intent intent = new Intent(this, SubActivity.class);
        // Intent의 정보를 참조하여 현재 Activity를 부모로 하는
        // SubActivity를 호출한다.
        startActivity(intent);
    }

}
