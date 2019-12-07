package com.example.lesson2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;


public class MainActivity extends Activity implements View.OnClickListener {

    public double separate(String plusesMinuses){
        Stack<String> signs=new Stack<>();
        Stack<String> nums=new Stack<>();
        String go="";

        for (int i=0;i<plusesMinuses.length();i++){
            if ("+".equals(plusesMinuses.charAt(i)+"") || "-".equals(plusesMinuses.charAt(i)+"")){
                signs.push(plusesMinuses.charAt(i)+"");
                nums.push(go);
                go="";
            }
            else{
                go+=plusesMinuses.charAt(i)+"";
            }
        }
        nums.push(go);
        double result=0;
        while (!signs.empty()){
            String sign=signs.pop();
            if (sign.equals("+")){
                result+=someResult( nums.pop());

            }
            else{
                result-=someResult( nums.pop());
            }
        }
        if (!nums.empty()){
            result+=someResult( nums.pop());
        }
        return result;
    }


    public double someResult(String expression){
        Stack<String> signs=new Stack<>();
        Stack<String> nums=new Stack<>();
        String go="";

        for (int i=0;i<expression.length();i++) {
            if ("x".equals(expression.charAt(i) + "") || "/".equals(expression.charAt(i) + "")) {
                signs.push(expression.charAt(i) + "");
                nums.push(go);
                go="";
            } else {
                go += expression.charAt(i) + "";
            }
        }
        nums.push(go);
        double result=1.0;
        while (!signs.empty()){
            String sign=signs.pop();
            if (sign.equals("x")){
                result*=Double.parseDouble( nums.pop());

            }
            else{
                result/=Double.parseDouble( nums.pop());
            }
        }
        if (!nums.empty()){
            result*=Double.parseDouble( nums.pop());
        }
        return result;


    }



    String goResult="";
    int realResult=0;

    TextView result;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;
    Button button_plus;
    Button button_minus;
    Button button_multiple;
    Button button_div;
    Button button_result;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // найдем View-элементы
        result = (TextView) findViewById(R.id.result);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button0 = (Button) findViewById(R.id.button0);
        button_minus = (Button) findViewById(R.id.button_minus);
        button_plus = (Button) findViewById(R.id.button_plus);
        button_result = (Button) findViewById(R.id.button_result);
        button_div = (Button) findViewById(R.id.button_div);
        button_multiple = (Button) findViewById(R.id.button_multiple);


        // присваиваем обработчик кнопкам
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        button_plus.setOnClickListener(this);
        button_minus.setOnClickListener(this);
        button_multiple.setOnClickListener(this);
        button_div.setOnClickListener(this);
        button_result.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // по id определеяем кнопку, вызвавшую этот обработчик
        switch (v.getId()) {
            case R.id.button1:
                goResult+="1";
                result.setText(goResult);
                break;
            case R.id.button2:
                goResult+="2";
                result.setText(goResult);
                break;
            case R.id.button3:
                goResult+="3";
                result.setText(goResult);
                break;
            case R.id.button4:
                goResult+="4";
                result.setText(goResult);
                break;
            case R.id.button5:
                goResult+="5";
                result.setText(goResult);
                break;
            case R.id.button6:
                goResult+="6";
                result.setText(goResult);
                break;
            case R.id.button7:
                goResult+="7";
                result.setText(goResult);
                break;
            case R.id.button8:
                goResult+="8";
                result.setText(goResult);
                break;
            case R.id.button9:
                goResult+="9";
                result.setText(goResult);
                break;
            case R.id.button0:
                goResult+="0";
                result.setText(goResult);
                break;
            case R.id.button_plus:
                goResult+="+";
                result.setText(goResult);
                break;
            case R.id.button_minus:
                goResult+="-";
                result.setText(goResult);
                break;
            case R.id.button_div:
                goResult+="/";
                result.setText(goResult);
                break;
            case R.id.button_multiple:
                goResult+="x";
                result.setText(goResult);
                break;
            case R.id.button_result:
                double res=separate(goResult);
                result.setText(""+res);
                goResult="";
                break;

        }
    }

}