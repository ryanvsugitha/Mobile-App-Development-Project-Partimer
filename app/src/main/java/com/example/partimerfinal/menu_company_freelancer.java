package com.example.partimerfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class menu_company_freelancer extends AppCompatActivity {

    private ImageView chats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_company_freelancer);

        chats = findViewById(R.id.chats);

        chats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menu_company_freelancer.this, chat_company.class);
                startActivity(intent);
            }
        });
    }
}