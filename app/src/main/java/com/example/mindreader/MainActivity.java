package com.example.mindreader;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.startBtn);
        builder = new AlertDialog.Builder(this);

        button.setOnClickListener(view -> goToNextActivity());
    }

    public void onBackPressed() {
        builder.setTitle("Exit app?");
        builder.setMessage("Do you really want to close the app?").
                setCancelable(false).
                setPositiveButton("Yes",(dialogInterface, i) -> finishAffinity()).
                setNegativeButton("Cancel",(dialogInterface, i) -> dialogInterface.cancel());
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void goToNextActivity() {
        startActivity(new Intent(this, page2.class));
    }
}