package com.example.partimerfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class menu_worker_parttime extends AppCompatActivity {

    private ImageView chats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_worker_parttime);

        chats = findViewById(R.id.chats);

        chats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menu_worker_parttime.this, chat_worker.class);
                startActivity(intent);
            }
        });
    }
}