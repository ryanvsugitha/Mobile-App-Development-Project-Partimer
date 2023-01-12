package com.example.partimerfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class register_menu extends AppCompatActivity {

    private Button btn_register_worker, btn_register_company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_menu);

        btn_register_worker = findViewById(R.id.btn_register_worker);
        btn_register_company = findViewById(R.id.btn_register_company);

        btn_register_worker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register_menu.this, register_menu_worker.class);
                startActivity(intent);
            }
        });

        btn_register_company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register_menu.this, register_menu_company.class);
                startActivity(intent);
            }
        });
    }
}