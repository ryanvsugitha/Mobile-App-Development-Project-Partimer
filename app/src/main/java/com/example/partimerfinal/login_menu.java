package com.example.partimerfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login_menu extends AppCompatActivity {

    private Button btn_login_worker, btn_login_company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_menu);

        btn_login_worker = findViewById(R.id.btn_login_worker);
        btn_login_company = findViewById(R.id.btn_login_company);

        btn_login_worker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login_menu.this, login_menu_worker.class);
                startActivity(intent);
            }
        });

        btn_login_company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login_menu.this, login_menu_company.class);
                startActivity(intent);
            }
        });
    }
}