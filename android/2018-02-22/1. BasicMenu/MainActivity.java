package com.example.scitmaster.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        //MenuItem item = menu.add(int groupId, int itemId, int order, CharSequence title);
        //groupId : 항목의 그룹을 지정할때 지정, 그룹 소속이 아닌 단일 메뉴의 소속의 메뉴를 구성할때는 0을 입력
        // itemId : 항목의 고유한 ID, 이 ID를 통해서 어떤 메뉴가 선택되었는지를 판단

        MenuItem item = menu.add(0,1,0,"짜장면");
        menu.add(0,2,0,"짬뽕");

        SubMenu etc = menu.addSubMenu("기타");
        etc.add(0,3,0,"우동");
        etc.add(0,4,0,"만두");


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        System.out.println("뽀 "+item.toString());
        System.out.println("itemId="+item.getItemId());
        System.out.println("groupId="+item.getGroupId());
        System.out.println("intent="+item.getIntent());
        System.out.println("menuInfo"+item.getMenuInfo());
        System.out.println("subMenu"+item.getSubMenu());
        System.out.println("title="+item.getTitle());
        System.out.println("order="+item.getOrder());
        String msg = "";
        switch(item.getItemId())
        {
            case 1:
                msg = "짜장";
                break;
            case 2:
                msg = "짬뽕";
                break;
            case 3:
                msg = "우동";
                break;
            case 4:
                msg = "만두";
                break;
        }
        Toast.makeText(MainActivity.this, msg+"은 맛있다.", Toast.LENGTH_SHORT).show();

        return false;
    }
}
