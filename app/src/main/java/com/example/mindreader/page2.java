package com.example.mindreader;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        Button nextBtn = findViewById(R.id.nextBtn);
        Intent nextActivity = new Intent(page2.this, page3.class);
        nextBtn.setOnClickListener(view -> startActivity(nextActivity));
    }
}