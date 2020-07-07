package com.mp.ar9;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class GetARInfo extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_arinfo);


        imageView = findViewById(R.id.imageViewDiagram);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            int picture = bundle.getInt("picture");
            imageView.setImageResource(picture);
        }

    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}
