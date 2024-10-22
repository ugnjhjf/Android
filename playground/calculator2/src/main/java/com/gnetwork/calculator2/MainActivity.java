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
              clear();
              break;

            case R.id.btn_cancel:
                // 如果操作符为空，表示正在输入的是第一个操作数，清除 firstNum
                if (operator.isEmpty()) {
                    firstNum = "";
                } else {
                    // 否则清除第二个操作数
                    secondNum = "";
                }
                result = "";
                showText = showText.substring(0, showText.length() - 1);  // 从显示内容中去掉最后一位
                refreshText(showText);
                break;


            case R.id.btn_plus:
            case R.id.btn_subtract:
            case R.id.btn_multiply:
            case R.id.btn_divide:
                operator = inputText;
                refreshText(showText + operator);
                break;

            case R.id.btn_equals:
                double calculator_result = calculateFour();
                refreshOperate(String.valueOf(calculator_result));
                refreshText(showText + "=" + result);
                break;
            case R.id.ib_sqrt:
                double sqrt_result = Math.sqrt(Double.parseDouble(firstNum));
                refreshOperate(String.valueOf(sqrt_result));
                refreshText(showText + "√=" + result);
                break;
            case R.id.btn_reciprocal:
                if (firstNum.isEmpty() || Double.parseDouble(firstNum) == 0) {
                    refreshText("Cannot divide by zero");
                    clear(); // 重置计算器
                } else {
                    double reciprocal_result = 1.0 / Double.parseDouble(firstNum);
                    refreshOperate(String.valueOf(reciprocal_result));
                    refreshText("1/" + firstNum + "=" + reciprocal_result);
                }
                break;


            default:
                if (result.length() > 0 && operator.equals("")){
                    clear();
                }

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
    }

    private double calculateFour() {
        switch (operator){
            case "+":
                return Double.parseDouble(firstNum) + Double.parseDouble(secondNum);
            case "-":
                return Double.parseDouble(firstNum) - Double.parseDouble(secondNum);
            case "×":
                    return Double.parseDouble(firstNum) * Double.parseDouble(secondNum);
            case "/":
                    return Double.parseDouble(firstNum) / Double.parseDouble(secondNum);
            default:
                return Double.parseDouble(firstNum);
        }
    }

    ;
    private void clear(){
        refreshText("");
    }

    private void refreshOperate(String new_result){
        result = new_result;
        firstNum = result;
        secondNum = "";
        operator = "";
    }
    //刷新文本显示
    private void refreshText(String text){
        showText = text;
        tv_result.setText(showText);
    }
}