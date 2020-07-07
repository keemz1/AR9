package com.mp.ar9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView AR;
    CardView Suggestions;
    CardView Notes;
    CardView Info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AR = findViewById(R.id.ARSceneMenu);
        Suggestions = findViewById(R.id.SuggestionsMenuItem);
        Notes = findViewById(R.id.NotesMenuItem);
        Info = findViewById(R.id.InfoMenuItem);

        AR.setOnClickListener((View v) -> {
                startActivity(new Intent(MainActivity.this, ARMainActivity.class));
        });
        Suggestions.setOnClickListener((View v) ->{
            startActivity(new Intent(MainActivity.this, Suggestions.class));
        });
        Notes.setOnClickListener((View v) ->{
            startActivity(new Intent(MainActivity.this, Notes.class));
        });
        Info.setOnClickListener((View v) -> {
            startActivity(new Intent(MainActivity.this, InfoActivity.class));
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(MainActivity.this, HomeScreenActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },3000);
    }
}
