package com.example.upam.proyectofiltros;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main8Activity extends AppCompatActivity {
        private ImageView imagenView8;
        private Filtros filtros;
        private Bitmap bmp;
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main8);

            imagenView8=(ImageView) findViewById(R.id.imageView7);
            filtros=new Filtros();

            BitmapDrawable bitmapDrawable=(BitmapDrawable) imagenView8.getDrawable();
            //Bitmap bmp=filtros.greyScale(bitmapDrawable.getBitmap());
            if(bmp==null) {
                filtros.guardarImagen(bitmapDrawable.getBitmap());
                imagenView8.setImageBitmap(bmp);
            }else {
                filtros.guardarImagen(bitmapDrawable.getBitmap());
                imagenView8.setImageBitmap(bmp);
            }
        }

        public void Siguiente(View v)
        {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }

        public void Anterior(View v)
        {
            Intent i = new Intent(this, Main6Activity.class);
            startActivity(i);
        }
    }