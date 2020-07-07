package com.mp.ar9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ARMenu extends AppCompatActivity {

    CardView plantcellAR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar_menu);

        /*plantcellAR = findViewById(R.id.PlantCellMenuItem);

        plantcellAR.setOnClickListener((View v) -> {
            startActivity(new Intent(ARMenu.this, PlantCellAR.class));
        });*/
    }
}
