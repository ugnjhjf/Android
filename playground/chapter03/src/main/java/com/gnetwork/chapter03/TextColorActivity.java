package com.gnetwork.chapter03;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TextColorActivity extends AppCompatActivity {
    @Override
    // onCreate() 方法是 Activity 的生命周期方法，当 Activity 创建时会调用这个方法
    //创建 Activity 实例 -> 寻找需要显示的元素 -> 设置元素的属性 -> 显示元素
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_view);
        TextView tv_code_system = findViewById(R.id.tv_code_system);
        tv_code_system.setTextColor(Color.WHITE);
        tv_code_system.setBackgroundColor(Color.BLACK);

        TextView tv_code_background = findViewById(R.id.tv_code_background);
        tv_code_background.setBackgroundColor(Color.GRAY);

    }
}
