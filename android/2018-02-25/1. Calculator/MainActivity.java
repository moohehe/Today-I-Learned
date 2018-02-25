package com.example.scitmaster.calculator_report;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ArrayList<Button> number_list = new ArrayList<Button>();
    ArrayList<Button> op_list = new ArrayList<Button>();
    TextView view_result, view_number;
    char lastOp = '0'; // 마지막 연산자
    double result = 0; // 결과값
    String currentNumber = "0"; //현재입력된 수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view_result = findViewById(R.id.fomula);
        view_number = findViewById(R.id.number);
        for (int i = 0 ; i < 10 ; i++)
        {
            String str = "btn"+i;
            String str2 = "op"+i;
            int id = getResources().getIdentifier(str, "id",getPackageName());
            int id2 = getResources().getIdentifier(str2, "id",getPackageName());
            Button b1 = findViewById(id);
            Button b2 = findViewById(id2);
            b1.setOnClickListener(this);
            b2.setOnClickListener(this);
            number_list.add(b1);
            op_list.add(b2);

        }


        // view initialization
        view_result.setText("");
        view_number.setText("");

        // logcat 설정
        Log.i("a","lastOp: "+lastOp);
        Log.i("a","currentNumber: "+currentNumber);
        Log.i("a","result: "+result);

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(MainActivity.this, ((Button) view).getText(), Toast.LENGTH_SHORT).show();
        //CE와 BS 추가할것
        String op = (String) ((Button) view).getText();
        System.out.println("Pressed Button = "+op);
        if (op.equals("BS")){
            if (currentNumber.length() == 1)
                currentNumber = "0";
            else {
                currentNumber = currentNumber.substring(0,currentNumber.length()-1);
            }
        }
        else if (op.equals("CE")){
            currentNumber = "0";
            //fomula = "";
            result = 0.0;
            lastOp = '0';
        }
        else {
            char c = ((Button) view).getText().charAt(0);
            Toast.makeText(getApplicationContext(), String.valueOf(c), Toast.LENGTH_SHORT).show();
            // 계산기
            calc(c);
        }
        // 현재 숫자 표기
        view_number.setText(currentNumber);
        // 계산 결과값 표기
        view_result.setText(String.valueOf(result));



    }


    /**
     * Calculate
     * @param c (operations or numbers)
     */
    public void calc(char c)
    {
        switch (c) {
            case 'C':
                currentNumber = "0";
                break;
            case '0':
                if (!currentNumber.equals("0"))
                    currentNumber += "0";
                break;
            case '.':
                if (!currentNumber.contains("."))
                    currentNumber += ".";
                break;
            case '±':
                if (currentNumber.contains("-"))
                    currentNumber = currentNumber.replace("-","");
                else
                    currentNumber = "-" + currentNumber;

                break;
            default:
                if (currentNumber.equals("0"))
                    currentNumber = String.valueOf(c);
                else
                    currentNumber += String.valueOf(c);
                break;
            case '+': // 더하기
                if (lastOp == '0') {
                    lastOp = '+';
                    if(result == 0.0) {
                        result = Double.parseDouble(currentNumber);
                        currentNumber ="0";
                    }
                } else {
                    //계산하기
                    calculators(lastOp);
                    lastOp = c;
                }
                break;
            case '-': // 빼기
                if (lastOp == '0') {
                    lastOp = '-';
                    if(result == 0.0) {
                        result = Double.parseDouble(currentNumber);
                        currentNumber ="0";
                    }
                } else {
                    //계산하기
                    calculators(lastOp);
                    lastOp = c;
                }
                break;
            case '*':
                if (lastOp == '0') {
                    lastOp = '*';
                    if(result == 0.0) {
                        result = Double.parseDouble(currentNumber);
                        currentNumber ="0";
                    }
                } else {
                    //계산하기
                    calculators(lastOp);
                    lastOp = c;
                }
                break;
            case '/':
                if (lastOp == '0') {
                    lastOp = '/';
                    if(result == 0.0) {
                        result = Double.parseDouble(currentNumber);
                        currentNumber ="0";
                    }
                } else {
                    //계산하기
                    calculators(lastOp);
                    lastOp = c;
                }

                break;
            case '=':
                // lastOp 가 없으면 계산을 하지 않는다.
                if (lastOp == '0')
                    break;
                // currentNumber가 0이면 계산하지 않는다.(변화가 없으므로)
                if (currentNumber.equals("0"))
                    break;
                // 둘다 아니면 lastOp를 가지고 계산을 한다.
                calc(lastOp);
                // lastOp 초기화는 하지 않는다.
                // 방금 한 계산을 operator를 기준으로 반복한다.
                break;
        }
    }
    //사칙연산
    public void calculators(char c) {
        // 계산할 것이 없으면 lastOp만 바꾸기
        if (currentNumber.equals("0")) {
            lastOp = c;
            return;
        }

        // 계산할 것(currentNumber에 값이 있는 경우)이 있으면 계산하자.
        switch (c)
        {
            case '+':
                result += Double.parseDouble(currentNumber);
                break;
            case '-':
                result -= Double.parseDouble(currentNumber);
                break;
            case '*':
                result *= Double.parseDouble(currentNumber);
                break;
            case '/':
                result /= Double.parseDouble(currentNumber);
                break;
        }
        //계산하고 난 뒤에 현재 수는 0으로
        currentNumber = "0";
    }
}
