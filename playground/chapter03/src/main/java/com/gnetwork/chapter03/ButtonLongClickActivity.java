package com.gnetwork.chapter03;

import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class ButtonLongClickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_button_long_click);
        TextView tv_result = findViewById(R.id.tv_result);
        Button btn_long_click = findViewById(R.id.btn_long_click);
        // v -> true is the lambda expression for returning true

        // 返回false则代表事件未被消费，会继续传递给下一个监听器（冒泡） （解决不了事务，通知大哥）
        // 返回true则代表事件已被消费，不会继续传递给下一个监听器  （小弟自己消费了）
        // 冒泡：子容器收到事件后回传给外面一层（父容器），称为冒泡
        btn_long_click.setOnLongClickListener(v -> {
                    String desc = String.format("您点击了按钮： %s", DateUtils.formatDateTime(this, System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME));
                    tv_result.setText(desc);
                    return true;
                }
        );
    }

}