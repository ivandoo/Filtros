package com.example.upam.proyectofiltros;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

public class Main4Activity extends AppCompatActivity {
    private ImageView imageView;
    private Filtros filtros;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        imageView=(ImageView) findViewById(R.id.imageView4);
        filtros=new Filtros();

        BitmapDrawable bitmapDrawable=(BitmapDrawable) imageView.getDrawable();
        //Bitmap bmp=filtros.greyScale(bitmapDrawable.getBitmap());

        Bitmap bmp=filtros.Contraste(bitmapDrawable.getBitmap());
        imageView.setImageBitmap(bmp);
    }

    public void Siguiente(View v)
    {
        Intent i = new Intent(this, Main5Activity.class);
        startActivity(i);
    }

    public void Anterior(View v)
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
