package com.example.partimerfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class chat_worker extends AppCompatActivity {

    private LinearLayout chat_cafelicious;
    private ImageView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_worker);

        list = findViewById(R.id.list);
        chat_cafelicious = findViewById(R.id.chats_cafelicous);

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(chat_worker.this, menu_worker.class);
                startActivity(intent);
            }
        });

        chat_cafelicious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(chat_worker.this, chat_cafelicious.class);
                startActivity(intent);
            }
        });
    }
}