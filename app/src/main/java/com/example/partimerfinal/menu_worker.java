package com.example.partimerfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu_worker extends AppCompatActivity {

    private Button btn_parttime, btn_freelancer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_worker);

        btn_parttime = findViewById(R.id.parttime);
        btn_freelancer = findViewById(R.id.freelancer);

        btn_parttime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menu_worker.this, menu_worker_parttime.class);
                startActivity(intent);
            }
        });

        btn_freelancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menu_worker.this, menu_worker_freelancer.class);
                startActivity(intent);
            }
        });
    }
}