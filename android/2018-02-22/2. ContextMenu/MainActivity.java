package com.example.scitmaster.menu2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText edit;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // View initializing
        btn = findViewById(R.id.btn);
        edit = findViewById(R.id.edit);
        img = findViewById(R.id.img);

        //regist contextMenu
        registerForContextMenu(btn);
        registerForContextMenu(edit);
        registerForContextMenu(img);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == btn) {
            menu.setHeaderTitle("Button Menu");
            menu.add(0,1,0,"RED");
            menu.add(0,2,0,"GREEN");
            menu.add(0,3,0,"BLUE");
        }
        if (v == edit) {
            menu.setHeaderTitle("EditText Menu");
            menu.add(0,4,0,"번역하기");
            menu.add(0,5,0,"필기인식");
        }
        if (v == img) {
            menu.setHeaderTitle("ImageView Menu");
            menu.add(0,100,0,"이미지 회전");
            menu.add(0,99,0,"크기변경");
            menu.setHeaderIcon(R.drawable.ic_launcher_foreground);
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //super.onContextItemSelected(item);
        switch(item.getItemId())
        {
            case 1:
                btn.setBackgroundColor(Color.RED);
                break;
            case 2:
                btn.setBackgroundColor(Color.GREEN);
                break;
            case 3:
                btn.setBackgroundColor(Color.BLUE);
                break;
        }


        return false;
    }
}
