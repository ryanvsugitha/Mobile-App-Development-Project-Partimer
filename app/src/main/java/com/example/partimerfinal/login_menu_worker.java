package com.example.partimerfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.partimerfinal.helper.DatabaseHelper;

public class login_menu_worker extends AppCompatActivity {

    private TextView forgot;
    private DatabaseHelper dataBase;
    private EditText etEmail, etPassword;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_menu_worker);

        forgot = (TextView) this.findViewById(R.id.forgot_password);

        dataBase = new DatabaseHelper(this);

        etEmail = findViewById(R.id.et_email_worker_login);
        etPassword = findViewById(R.id.et_password_worker_login);
        btn_login = findViewById(R.id.btn_login_worker);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if(email.isEmpty() || password.isEmpty()){
                    Toast.makeText(login_menu_worker.this, "Please fill the fields!", Toast.LENGTH_SHORT).show();
                }
                else if(dataBase.auth_worker(email, password)){
                    Toast.makeText(login_menu_worker.this, "Welcome!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login_menu_worker.this, menu_worker.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(login_menu_worker.this, "Credentials invalid!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login_menu_worker.this, forgot_password.class);
                startActivity(intent);
            }
        });
    }
}