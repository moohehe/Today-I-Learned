package com.example.scitmaster.files;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText edit, filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = findViewById(R.id.edit);
        filename = findViewById(R.id.filename);


    }

    public void btnOnClick(View view) {

        String str = edit.getText().toString();
        String strName = filename.getText().toString();

        switch(view.getId())
        {
            case R.id.btnsave:

                // check path

                if (str.length() == 0 || strName.length() == 0){
                    Toast.makeText(getApplicationContext()
                    , "내용과 파일명을 입력해주세요."
                    ,Toast.LENGTH_SHORT).show();
                    return;
                }

                // save file
                try {
                    // 임의의 path 설정이 불가능하기 때문에 android method 사용
                    // openFileOutput(String filename, int mode)
                    // filename은 filename
                    // mode는 권한 설정
                    // ex) 사용중인 나만 쓸 수 있게 한다거나,
                    FileOutputStream fos = openFileOutput(strName, Context.MODE_PRIVATE);
                    fos.write(str.getBytes());
                    fos.close();
                    Toast.makeText(getApplicationContext(),
                            "save Complete"
                    , Toast.LENGTH_SHORT).show();
                    edit.setText("");
                    filename.setText("");

                }catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),
                            "save failed", Toast.LENGTH_SHORT).show();
                }


                break;
            case R.id.btnopen:
                if (strName.length() == 0) {
                    Toast.makeText(getApplicationContext(),
                            "파일명을 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {

                    FileInputStream fis = openFileInput(strName);
                    byte[] data = new byte[fis.available()];
                    while (fis.read(data) != -1);

                    fis.close();
                    edit.setText(new String(data));


                }catch(Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"file open failed",
                            Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btnlist:
                final String[] list = fileList();
                if (list.length == 0) {
                    Toast.makeText(getApplicationContext(), "파일이 없습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                AlertDialog.Builder bid = new AlertDialog.Builder(this);
                bid.setTitle("File List");
                bid.setItems(list, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),
                                i +" : " + list[i].toString(), Toast.LENGTH_SHORT).show();

                    }
                });
                bid.setNegativeButton("취소",null);
                bid.show();
                break;
        }
    }
}
