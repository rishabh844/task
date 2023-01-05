package com.example.demoUi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BestMarkitActivity extends AppCompatActivity {
    Button btn_Started;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_markit);

        btn_Started=findViewById(R.id.btn_started);

        btn_Started.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BestMarkitActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}