package com.example.scitmaster.menu3;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
    }

    public void btnOnClick(View view) {
        // Popup 메뉴 객체를 만들고 xml로 만든 구조를 자바 팝업 메뉴 객체에 전개
        // Popupmenu 선택시 동작할 이벤트 처리
        //PopupMenu라는 객체를 만듬.
        PopupMenu popup = new PopupMenu(getApplicationContext(), view);
        // 메뉴 인플레이터 라는 객체를 만든다. 아까만든 PopupMenu 객체에서 가지고 온다.
        MenuInflater inflater = popup.getMenuInflater();
        // Menu라는 객체를 가지고 온다. 처음 만든 PopupMenu 쪽에서 생성한다.
        Menu menu = popup.getMenu();
        //inflater를 생성한다. parameter는 xml파일과 menu 객체
        inflater.inflate(R.menu.popupmenu, menu);
        // popup Menu에 이벤트리스너 등록하기
        popup.setOnMenuItemClickListener(new MenuListener());
        popup.show();
    }

    public void btnOnClick2(View view) {
        //PopupMenu라는 객체를 만듬.
        PopupMenu popup = new PopupMenu(getApplicationContext(), view);
        // 메뉴 인플레이터 라는 객체를 만든다. 아까만든 PopupMenu 객체에서 가지고 온다.
        MenuInflater inflater = popup.getMenuInflater();
        // Menu라는 객체를 가지고 온다. 처음 만든 PopupMenu 쪽에서 생성한다.
        Menu menu = popup.getMenu();
        //inflater를 생성한다. parameter는 xml파일과 menu 객체
        inflater.inflate(R.menu.popupmenu, menu);
        // popup Menu에 이벤트리스너 등록하기
        popup.setOnMenuItemClickListener(new MenuListener());
        popup.show();
    }


    class MenuListener implements PopupMenu.OnMenuItemClickListener {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            int id = menuItem.getItemId();
            switch (id)
            {
                case R.id.popup_red:
                    btn.setBackgroundColor(Color.RED);
                    break;
                case R.id.popup_green:
                    btn.setBackgroundColor(Color.GREEN);
                    break;
                case R.id.popup_blue:
                    btn.setBackgroundColor(Color.BLUE);
                    break;
                case R.id.popup_black:
                    btn.setBackgroundColor(Color.BLACK);
                    break;
                case R.id.popup_yellow:
                    btn.setBackgroundColor(Color.YELLOW);
                    break;
                case R.id.popup_white:
                    btn.setBackgroundColor(Color.WHITE);
                    break;

            }
            return false;
        }
    }

}
