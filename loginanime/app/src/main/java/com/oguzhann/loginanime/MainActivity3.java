package com.oguzhann.loginanime;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    TextView txtf1name , txtf1learn;
    ImageView If1draw;
    private  String sf1name,sf1aciklama;
    private Bitmap sf1resim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        txtf1name  = findViewById(R.id.F1teamname);
        txtf1learn = findViewById(R.id.F1learn);
        If1draw = findViewById(R.id.F1draw);

        sf1name=Homefrag.takimlar.getTakim();
        sf1aciklama=Homefrag.takimlar.getTakiminaciklamasi();
        sf1resim=Homefrag.takimlar.getResim();
        if(!TextUtils.isEmpty(sf1name)&& !TextUtils.isEmpty(sf1aciklama)){
            txtf1name.setText(sf1name);
            txtf1learn.setText(sf1aciklama);
            If1draw.setImageBitmap(sf1resim);
        }

    }
}