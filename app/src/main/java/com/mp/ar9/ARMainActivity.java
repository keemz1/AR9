package com.mp.ar9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ARMainActivity extends AppCompatActivity {

    CardView plantcellAR;
    CardView animallcellAR;
    CardView heartAR;
    CardView nervecellAR;
    CardView earAR;
    CardView eyeAR;
    CardView brainAR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armain);

        plantcellAR = findViewById(R.id.PlantCellMenuItem);
        animallcellAR = findViewById(R.id.AnimalCellMenuItem);
        heartAR = findViewById(R.id.HeartMenuItem);
        eyeAR = findViewById(R.id.EyeMenuItem);
        earAR = findViewById(R.id.EarMenuItem);
        brainAR = findViewById(R.id.BrainMenuItem);
        nervecellAR = findViewById(R.id.NerveCellMenuItem);

        plantcellAR.setOnClickListener((View v) -> {
            startActivity(new Intent(ARMainActivity.this, PlantCellAR.class));
        });
        animallcellAR.setOnClickListener((View v) -> {
            startActivity(new Intent(ARMainActivity.this, HumanCellAR.class));
        });
        brainAR.setOnClickListener((View v) -> {
            startActivity(new Intent(ARMainActivity.this, BrainAR.class));
        });
        earAR.setOnClickListener((View v) -> {
            startActivity(new Intent(ARMainActivity.this, EarAR.class));
        });
        eyeAR.setOnClickListener((View v) -> {
            startActivity(new Intent(ARMainActivity.this, EyeAR.class));
        });
        heartAR.setOnClickListener((View v) -> {
            startActivity(new Intent(ARMainActivity.this, HeartAR.class));
        });
        nervecellAR.setOnClickListener((View v) -> {
            startActivity(new Intent(ARMainActivity.this, NerveCell.class));
        });
    }
}
