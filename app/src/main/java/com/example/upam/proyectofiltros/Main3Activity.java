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

public class Main3Activity extends AppCompatActivity {

    private ImageView imagen;
    private Filtros filtros;
    private int brillo = 0;
    private SeekBar ContBrillo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ContBrillo = (SeekBar)findViewById(R.id.sb1);
        imagen = (ImageView)findViewById(R.id.imageView3);
        final BitmapDrawable bitmapDrawable=(BitmapDrawable) imagen.getDrawable();
        filtros = new Filtros();

        ContBrillo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                brillo = progress;
                Bitmap bmp=filtros.Tono_Billo(bitmapDrawable.getBitmap(), brillo);
                imagen.setImageBitmap(bmp);
                Log.d(" ","Valor Brillo es ==> " + progress);
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
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}
