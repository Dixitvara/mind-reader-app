package com.example.mindreader;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //image view
        ImageView imageView = findViewById(R.id.displayAns);
        ImageView globe = findViewById(R.id.imageView2);
        Button btn = findViewById(R.id.tryAgain);
        TextView clickMe = findViewById(R.id.clickMe);
        Animation fade = AnimationUtils.loadAnimation(this, R.anim.fade);
        Animation fadeout = AnimationUtils.loadAnimation(this, R.anim.fadeout);
        MediaPlayer imposterSound = MediaPlayer.create(this, R.raw.imposter);

        Bundle bundle = getIntent().getExtras();

        globe.setOnClickListener(v -> {
            if (bundle != null) {
                int imageAns = bundle.getInt("answer");
                imageView.setImageResource(imageAns);
            }
            btn.setVisibility(View.VISIBLE);
            btn.setAnimation(fade);
            imageView.setAnimation(fade);
            clickMe.setAnimation(fadeout);
            clickMe.setVisibility(View.INVISIBLE);
            imposterSound.start();
            imposterSound.setOnCompletionListener(mediaPlayer -> imposterSound.reset());
        });
        Intent homeActivity = new Intent(MainActivity4.this, MainActivity.class);
        btn.setOnClickListener(view -> startActivity(homeActivity));
    }
}