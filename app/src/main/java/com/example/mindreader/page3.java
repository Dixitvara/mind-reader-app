package com.example.mindreader;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mindreader.adapters.IconAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class page3 extends AppCompatActivity {

    RecyclerView recyclerView;
    Map<Integer, Integer> models;
    ArrayList<Integer> ansArray;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        recyclerView = findViewById(R.id.recyclerView);
        nextBtn = findViewById(R.id.nextBtn2);

        models = new HashMap<>();
        ansArray = new ArrayList<>(Arrays.asList(9,18,27,36,45,54,63,72,81,90,99));

        Random rand = new Random();

        for (int i = 0; i <= 99; i++) {
            if(!ansArray.contains(i))
                models.put(i,R.mipmap.i1 + rand.nextInt(50));
            if(ansArray.contains(i))
                models.put(i, models.get(0));
        }

        // setting adapter to recycler view
        IconAdapter adapter = new IconAdapter(models);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 6));
        recyclerView.setAdapter(adapter);

        // saving data and sending to next activity
        Intent intent = new Intent(this,MainActivity4.class);
        Bundle bundle = new Bundle();

        bundle.putInt("answer", models.get(0));
        intent.putExtras(bundle);

        // navigating to next activity
        nextBtn.setOnClickListener(view -> {
            startActivity(intent);
        });

    }
}