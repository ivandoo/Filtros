package com.example.upam.proyectofiltros;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

public class Main5Activity extends AppCompatActivity {

    private ImageView imagen;
    private Filtros filtros;
    private int rojo = 0;
    private int verde = 0;
    private int azul = 0;
    private SeekBar ContBrillo1;
    private SeekBar ContBrillo2;
    private SeekBar ContBrillo3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        ContBrillo1 = (SeekBar) findViewById(R.id.sb1);
        ContBrillo2 = (SeekBar) findViewById(R.id.sb2);
        ContBrillo3 = (SeekBar) findViewById(R.id.sb3);
        imagen = (ImageView) findViewById(R.id.imageView5);
        final BitmapDrawable bitmapDrawable = (BitmapDrawable) imagen.getDrawable();
        filtros = new Filtros();


        ContBrillo1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rojo = progress;
                Bitmap bmp = filtros.CanalRGB(bitmapDrawable.getBitmap(), rojo ,verde,azul);
                imagen.setImageBitmap(bmp);
                Log.d(" ", "Valor Brillo es ==> " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        ContBrillo2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int b, boolean fromUser) {
                verde = b;
                Bitmap bmp = filtros.CanalRGB(bitmapDrawable.getBitmap(), rojo,verde,azul);
                imagen.setImageBitmap(bmp);
                Log.d(" ", "Valor Brillo es ==> " + b);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        ContBrillo3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int c, boolean fromUser) {
                azul = c;
                Bitmap bmp = filtros.CanalRGB(bitmapDrawable.getBitmap(), rojo,verde,azul);
                imagen.setImageBitmap(bmp);
                Log.d(" ", "Valor Brillo es ==> " + c);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }



    public void Siguiente(View v)
    {
        Intent i = new Intent(this,Main4Activity.class);
        startActivity(i);
    }

    public void Anterior(View v)
    {
        Intent i = new Intent(this, Main4Activity.class);
        startActivity(i);
    }

}
