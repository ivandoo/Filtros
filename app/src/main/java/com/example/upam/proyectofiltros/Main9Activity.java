package com.example.upam.proyectofiltros;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main9Activity extends AppCompatActivity {
    private ImageView imagenViiew;
    private Filtros filtros;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        imagenViiew=(ImageView) findViewById(R.id.imageView9);
        filtros=new Filtros();

        BitmapDrawable bitmapDrawable=(BitmapDrawable) imagenViiew.getDrawable();
        //Bitmap bmp=filtros.greyScale(bitmapDrawable.getBitmap());

        Bitmap bmp=filtros.espejo(bitmapDrawable.getBitmap());
        imagenViiew.setImageBitmap(bmp);
    }

    public void Siguiente(View v)
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void Anterior(View v)
    {
        Intent i = new Intent(this, Main8Activity.class);
        startActivity(i);
    }
}