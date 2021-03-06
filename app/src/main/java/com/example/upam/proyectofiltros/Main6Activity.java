package com.example.upam.proyectofiltros;

/**
 * Created by upam on 08/03/17.
 */

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main6Activity extends AppCompatActivity {
    private ImageView imagenVieww;
    private Filtros filtros;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        imagenVieww=(ImageView) findViewById(R.id.imageView6);
        filtros=new Filtros();

        BitmapDrawable bitmapDrawable=(BitmapDrawable) imagenVieww.getDrawable();
        //Bitmap bmp=filtros.greyScale(bitmapDrawable.getBitmap());

        Bitmap bmp=filtros.rotar(bitmapDrawable.getBitmap());
        imagenVieww.setImageBitmap(bmp);
    }

    public void Siguiente(View v)
    {
        Intent i = new Intent(this, Main7Activity.class);
        startActivity(i);
    }

    public void Anterior(View v)
    {
        Intent i = new Intent(this, Main5Activity.class);
        startActivity(i);
    }
}