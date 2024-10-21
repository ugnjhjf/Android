package com.gnetwork.chapter03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class ButtonEnableActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_enable);
        Button btn_enable = findViewById(R.id.btn_enable);
        Button btn_disable = findViewById(R.id.btn_disable);
        Button btn_test = findViewById(R.id.btn_test);

        TextView tv_result = findViewById(R.id.tv_result);

        btn_enable.setOnClickListener(this);
        btn_disable.setOnClickListener(this);
        btn_test.setOnClickListener(this);

        }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_enable:
                Button btn_test = findViewById(R.id.btn_test);
                btn_test.setEnabled(true);
                break;
            case R.id.btn_disable:
                Button btn_test1 = findViewById(R.id.btn_test);
                btn_test1.setEnabled(false);
                break;
            case R.id.btn_test:
                TextView tv_result = findViewById(R.id.tv_result);
                tv_result.setText("按钮被点击了");
                break;
        }
    };
}
