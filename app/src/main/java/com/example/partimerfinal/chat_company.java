package com.example.partimerfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class chat_company extends AppCompatActivity {

    private LinearLayout chat_ben, chat_alice, chat_michael;
    private ImageView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_company);

        list = findViewById(R.id.list);
        chat_ben = findViewById(R.id.chats_ben);
        chat_alice = findViewById(R.id.chats_alice);
        chat_michael = findViewById(R.id.chats_michael);

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(chat_company.this, menu_company.class);
                startActivity(intent);
            }
        });

        chat_ben.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        chat_alice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        chat_michael.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}