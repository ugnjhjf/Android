package com.gnetwork.chapter03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class ButtonClickActivity extends AppCompatActivity {
    private TextView tv_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_click);
        TextView tv_result = findViewById(R.id.tv_result);
        Button btn_click_single = findViewById(R.id.btn_click_single);
        btn_click_single.setOnClickListener(new MyOnClickListener(tv_result));
    }
    static class MyOnClickListener implements View.OnClickListener {
        private final TextView tv_result;

        public MyOnClickListener(TextView tv_result) {
            this.tv_result = tv_result;
        }
        @Override
        public void onClick(View v) {
            String desc = String.format("Button clicked at %d", System.currentTimeMillis(), ((Button) v));
            tv_result.setText(desc);
        }
    }
}