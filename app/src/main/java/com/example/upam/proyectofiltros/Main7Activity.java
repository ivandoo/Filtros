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

public class Main7Activity extends AppCompatActivity {
    private ImageView imagenView7;
    private Filtros filtros;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        imagenView7=(ImageView) findViewById(R.id.imageView7);
        filtros=new Filtros();

        BitmapDrawable bitmapDrawable=(BitmapDrawable) imagenView7.getDrawable();
        //Bitmap bmp=filtros.greyScale(bitmapDrawable.getBitmap());

        Bitmap bmp=filtros.Bordes(bitmapDrawable.getBitmap());
        imagenView7.setImageBitmap(bmp);
    }

    public void Siguiente(View v)
    {
        Intent i = new Intent(this, Main8Activity.class);
        startActivity(i);
    }

    public void Anterior(View v)
    {
        Intent i = new Intent(this, Main6Activity.class);
        startActivity(i);
    }
}