package com.gnetwork.calculator2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_result;
    //第一个操作数
    private String firstNum = "";
    private String operator = "";
    //第二个操作数
    private String secondNum = "";
    //结果
    private String result = "";
    //显示内容
    private String showText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         tv_result = findViewById(R.id.tv_result);
        findViewById(R.id.btn_cancel).setOnClickListener(this);
        findViewById(R.id.btn_clear).setOnClickListener(this);
        findViewById(R.id.btn_divide).setOnClickListener(this);
        findViewById(R.id.btn_multiply).setOnClickListener(this);
        findViewById(R.id.btn_seven).setOnClickListener(this);
        findViewById(R.id.btn_eight).setOnClickListener(this);
        findViewById(R.id.btn_nine).setOnClickListener(this);
        findViewById(R.id.btn_subtract).setOnClickListener(this);
        findViewById(R.id.btn_four).setOnClickListener(this);
        findViewById(R.id.btn_five).setOnClickListener(this);
        findViewById(R.id.btn_six).setOnClickListener(this);
        findViewById(R.id.btn_plus).setOnClickListener(this);
        findViewById(R.id.btn_one).setOnClickListener(this);
        findViewById(R.id.btn_two).setOnClickListener(this);
        findViewById(R.id.btn_three).setOnClickListener(this);
        findViewById(R.id.btn_equals).setOnClickListener(this);
        findViewById(R.id.btn_zero).setOnClickListener(this);
        findViewById(R.id.btn_dot).setOnClickListener(this);
        findViewById(R.id.ib_sqrt).setOnClickListener(this);
        findViewById(R.id.btn_reciprocal).setOnClickListener(this);
        }

    @Override
    public void onClick(View v) {
        String inputText;
        //如果是开根号
        if (v.getId() == R.id.ib_sqrt){
            inputText = "√";
        }else {
            inputText = ((TextView)v).getText().toString();

        }
        switch (v.getId())
        {
            case R.id.btn_clear:
                firstNum = "";
                operator = "";
                secondNum = "";
                result = "";
                showText = "";
                break;
            case R.id.btn_cancel:
                break;


            case R.id.btn_plus:
            case R.id.btn_subtract:
            case R.id.btn_multiply:
            case R.id.btn_divide:
                operator = inputText;
                refreshText(showText + operator);
                break;

            case R.id.btn_equals:
                break;
            case R.id.ib_sqrt:
                break;
            case R.id.btn_reciprocal:
                break;

            default:
                if (operator.equals("")) {
                    firstNum += inputText;
                }else{
                    secondNum += inputText;
                }
                if (showText.equals("0") && !inputText.equals(".")){
                    showText = "";
                }else {
                    refreshText(showText + inputText);
                }
                break;
        }
    };
    private void refreshText(String text){
        showText = text;
        tv_result.setText(showText);
    }
}