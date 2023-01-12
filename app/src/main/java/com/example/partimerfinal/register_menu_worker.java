package com.example.partimerfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.partimerfinal.helper.DatabaseHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class register_menu_worker extends AppCompatActivity {

    private DatabaseHelper database;
    private EditText etEmail, etName, etPassword, etConfirmPassword;
    private Button btnSubmit;
    private CheckBox cbAgreeTerms;

    Pattern letter = Pattern.compile("[a-zA-z]");
    Pattern digit = Pattern.compile("[0-9]");
    Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_menu_worker);

        database = new DatabaseHelper(this);

        etEmail = findViewById(R.id.et_email_worker);
        etName = findViewById(R.id.et_name_worker);
        etPassword = findViewById(R.id.et_password_worker);
        etConfirmPassword = findViewById(R.id.et_password_worker_confirm);
        btnSubmit = findViewById(R.id.btn_submit_worker);
        cbAgreeTerms = findViewById(R.id.cb_agreeTerms);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String name = etName.getText().toString();
                String password = etPassword.getText().toString();
                String confirm_password = etConfirmPassword.getText().toString();

                Matcher hasLetter = letter.matcher(password);
                Matcher hasDigit = digit.matcher(password);
                Matcher hasSpecial = special.matcher(password);

                if(email.isEmpty() || name.isEmpty() || password.isEmpty() || confirm_password.isEmpty()){
                    Toast.makeText(register_menu_worker.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else if(!password.equals(confirm_password)){
                    Toast.makeText(register_menu_worker.this, "Password does not match", Toast.LENGTH_SHORT).show();
                }
                else if(password.length() < 8){
                    Toast.makeText(register_menu_worker.this, "Password length must be 8 or more characters", Toast.LENGTH_SHORT).show();
                }
                else if(!hasLetter.find() || !hasDigit.find() || !hasSpecial.find()){
                    Toast.makeText(register_menu_worker.this, "Password must include lower, upper, number, and special character", Toast.LENGTH_SHORT).show();
                }
                else if(!cbAgreeTerms.isChecked()){
                    Toast.makeText(register_menu_worker.this, "You must agree the terms and privacy", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(database.exist_email_workers(email)){
                        Toast.makeText(register_menu_worker.this, "Email already used!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        database.add_worker(email, name, password);
                        Toast.makeText(register_menu_worker.this, "User registered", Toast.LENGTH_SHORT).show();
                        database.close();

                        Intent intent = new Intent(register_menu_worker.this, com.example.partimerfinal.MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}