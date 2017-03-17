package com.example.upam.proyectofiltros;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.Random;

/**
 * Created by Upam on 03/02/17.
 */

public class Filtros
{
    public Bitmap greyScale(Bitmap bitmap){
        //crear una copia de bitmap para modificar la imagen origen
        // la imagen origen no puede ser modificada por lo tanto se crea una copia
        Bitmap bmp=Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),bitmap.getConfig());
        //se declaran las variables a utilizar para vaciar el pixel y los canales

        int pixel=0;
        int r=0;
        int g=0;
        int b=0;
        int a=0;
        //se declara la variable grey donde de descargara la sumatoria de los pixeles
        int grey=0;
        //se recorre la imagen de origen ancho por alto
        for (int x=0;x<bitmap.getWidth();x++){
            for(int y=0;y<bitmap.getHeight();y++){
                // se obtiene el pixel segun las coordenadas
                pixel=bitmap.getPixel(x,y);
                //se obtienen los canales del pixel por medio de corrimiento
                a=(pixel>>>24) & 0xff;
                r=(pixel>>16) & 0xff;
                g=(pixel>>8) & 0xff;
                b=pixel & 0xff;

                //se realiza la operacion por pixel
                grey=(r+g+b)/3;
                //se vuelve a codificar el pixel
                pixel=((a<<24)|(grey<<16)|(grey<<8)|grey);
                //se agrega el pixel en el bitmap destino
                bmp.setPixel(x,y, pixel);
            }
        }
        //retorna el bitmap final para ser renderizado por imageView
        return bmp;
    }


    public Bitmap Inverso(Bitmap bitmap){
        //crear una copia de bitmap para modificar la imagen origen
        // la imagen origen no puede ser modificada por lo tanto se crea una copia
        Bitmap bmp=Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),bitmap.getConfig());
        //se declaran las variables a utilizar para vaciar el pixel y los canales

        int pixel=0;
        int r=0;
        int g=0;
        int b=0;
        int a=0;
        //se declara la variable grey donde de descargara la sumatoria de los pixeles
        int grey=0;
        //se recorre la imagen de origen ancho por alto
        for (int x=0;x<bitmap.getWidth();x++){
            for(int y=0;y<bitmap.getHeight();y++){
                // se obtiene el pixel segun las coordenadas
                pixel=bitmap.getPixel(x,y);
                //se obtienen los canales del pixel por medio de corrimiento
                a=(pixel>>24) & 0xff;
                r=(pixel>>16) & 0xff;
                g=(pixel>>8) & 0xff;
                b=pixel & 0xff;


                r = 255-r;
                g= 255-g;
                b = 255-b;

                //se realiza la operacion por pixel
                grey=(r+g+b)/3;
                //se vuelve a codificar el pixel
                pixel=((a<<24)|(r<<16)|(g<<8)|b);
                //se agrega el pixel en el bitmap destino
                bmp.setPixel(x,y, pixel);
            }
        }
        //retorna el bitmap final para ser renderizado por imageView
        return bmp;
    }

    public Bitmap Tono_Billo(Bitmap bitmap, int brillo)
    {

        //crear una copia de bitmap para modificar la imagen origen
        // la imagen origen no puede ser modificada por lo tanto se crea una copia
        Bitmap bmp=Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),bitmap.getConfig());
        //se declaran las variables a utilizar para vaciar el pixel y los canales

        int pixel=0;
        int r, auxr=0;
        int g=0;
        int b=0;
        int a=0;
        //se declara la variable grey donde de descargara la sumatoria de los pixeles
        int grey=0;
        //se recorre la imagen de origen ancho por alto
        for (int x=0;x<bitmap.getWidth();x++){
            for(int y=0;y<bitmap.getHeight();y++){
                // se obtiene el pixel segun las coordenadas
                pixel=bitmap.getPixel(x,y);
                //se obtienen los canales del pixel por medio de corrimiento
                a=(pixel>>24) & 0xff;
                r=(pixel>>16) & 0xff;
                g=(pixel>>8) & 0xff;
                b=pixel & 0xff;

                r = r+brillo;

                if (r < 0)
                {
                    r = 0;
                }
                else if (r>255)
                {
                    r = 255;
                }

                g = g+brillo;

                if (g < 0)
                {
                    g = 0;
                }
                else if (g>255)
                {
                    g = 255;
                }

                b = b+brillo;
                if (b < 0)
                {
                    b = 0;
                }
                else if (b>255)
                {
                    b = 255;
                }


                //se vuelve a codificar el pixel
                pixel=((a<<24)|(r<<16)|(g<<8)|b);
                //se agrega el pixel en el bitmap destino
                bmp.setPixel(x,y, pixel);
            }
        }
        //retorna el bitmap final para ser renderizado por imageView
        return bmp;
    }



        public Bitmap Contraste(Bitmap bitmap) {
            //crear una copia de bitmap para modificar la imagen origen
            // la imagen origen no puede ser modificada por lo tanto se crea una copia
            Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
            //se declaran las variables a utilizar para vaciar el pixel y los canales

            double angulo=180;
            double contraste= Math.pow((100+angulo)/100,2);
            int pixel = 0;
            int r = 0;
            int g = 0;
            int b = 0;
            int a = 0;



            //se declara la variable grey donde de descargara la sumatoria de los pixeles
            int grey = 0;
            //se recorre la imagen de origen ancho por alto
            for (int x = 0; x < bitmap.getWidth(); x++) {
                for (int y = 0; y < bitmap.getHeight(); y++) {
                    // se obtiene el pixel segun las coordenadas
                    pixel = bitmap.getPixel(x, y);
                    //se obtienen los canales del pixel por medio de corrimiento
                    a = (pixel >>> 24) & 0xff;
                    r = (pixel >> 16) & 0xff;
                    g = (pixel >> 8) & 0xff;
                    b = pixel & 0xff;


                    a= Color.alpha(pixel);


                    r=Color.red(pixel);
                    g=Color.green(pixel);
                    b=Color.blue(pixel);
                    r=(int)((((r/255.0)-0.5)*contraste+0.5)*255.0);
                    g=(int)((((g/255.0)-0.5)*contraste+0.5)*255.0);
                    b=(int)((((b/255.0)-0.5)*contraste+0.5)*255.0);

                    if  (r > 255)
                    {
                        r = 255;
                    }
                    else if (r<0)
                    {
                        r = 0;
                    }
                    if  (g > 255)
                    {
                        g = 255;
                    }
                    else if (g<0)
                    {
                        g = 0;
                    }
                    if  (b> 255)
                    {
                        b = 255;
                    }
                    else if (b<0)
                    {
                        b = 0;
                    }
                    //se realiza la operacion por pixel
                    //grey = (r + g + b) / 3;
                    //se vuelve a codificar el pixel
                    //pixel = ((a << 24) | (grey << 16) | (grey << 8) | grey);
                    //se agrega el pixel en el bitmap destino
                    bmp.setPixel(x, y, Color.argb(a,r,b,g));
                }
            }
            //retorna el bitmap final para ser renderizado por imageView
            return bmp;
        }

    public Bitmap CanalRGB(Bitmap bitmap,int rojo,int verde,int azul) {
        //crear una copia de bitmap para modificar la imagen origen
        // la imagen origen no puede ser modificada por lo tanto se crea una copia
        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        //se declaran las variables a utilizar para vaciar el pixel y los canales

        double angulo=180;
        double contraste= Math.pow((100+angulo)/100,2);
        int pixel = 0;
        int r = 0;
        int g = 0;
        int b = 0;
        int a = 0;
        int roja=rojo;
        int azula=azul;
        int verdea=verde;




        //se declara la variable grey donde de descargara la sumatoria de los pixeles
        int grey = 0;
        //se recorre la imagen de origen ancho por alto
        for (int x = 0; x < bitmap.getWidth(); x++) {
            for (int y = 0; y < bitmap.getHeight(); y++) {
                // se obtiene el pixel segun las coordenadas
                pixel = bitmap.getPixel(x, y);
                //se obtienen los canales del pixel por medio de corrimiento
                a = (pixel >>> 24) & 0xff;
                r = (pixel >> 16) & 0xff;
                g = (pixel >> 8) & 0xff;
                b = pixel & 0xff;


                a= Color.alpha(pixel);
                r=(int)((((r/255.0)-0.5)*contraste+0.5)*255.0);
                g=(int)((((g/255.0)-0.5)*contraste+0.5)*255.0);
                b=(int)((((b/255.0)-0.5)*contraste+0.5)*255.0);


                r=Color.red(pixel);
                g=Color.green(pixel);
                b=Color.blue(pixel);
                r=(int)((r+roja));
                g=(int)((g+verdea));
                b=(int)((b+azula));

                if  (r > 255)
                {
                    r = 255;
                }
                else if (r<0)
                {
                    r = 0;
                }
                if  (g > 255)
                {
                    g = 255;
                }
                else if (g<0)
                {
                    g = 0;
                }
                if  (b> 255)
                {
                    b = 255;
                }
                else if (b<0)
                {
                    b = 0;
                }
                //se realiza la operacion por pixel
                //grey = (r + g + b) / 3;
                //se vuelve a codificar el pixel
                //pixel = ((a << 24) | (grey << 16) | (grey << 8) | grey);
                //se agrega el pixel en el bitmap destino
                bmp.setPixel(x, y, Color.argb(a,r,b,g));
            }
        }
        //retorna el bitmap final para ser renderizado por imageView
        return bmp;
    }

    public Bitmap Gamma(Bitmap bitmap,int rojog,int verdeg,int azulg) {
        //crear una copia de bitmap para modificar la imagen origen
        // la imagen origen no puede ser modificada por lo tanto se crea una copia
        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        //se declaran las variables a utilizar para vaciar el pixel y los canales


        int pixel = 0;
        int r = 0;
        int g = 0;
        int b = 0;
        int a = 0;
        int roja=rojog;
        int azul=azulg;
        int verde=verdeg;

        double angulo=180;
        double contraste= Math.pow(r/255,1);
        double contraste1= Math.pow(g/255,1);
        double contraste2= Math.pow(b/255,1);


        //se declara la variable grey donde de descargara la sumatoria de los pixeles
        int grey = 0;
        //se recorre la imagen de origen ancho por alto
        for (int x = 0; x < bitmap.getWidth(); x++) {
            for (int y = 0; y < bitmap.getHeight(); y++) {
                // se obtiene el pixel segun las coordenadas
                pixel = bitmap.getPixel(x, y);
                //se obtienen los canales del pixel por medio de corrimiento
                a = (pixel >>> 24) & 0xff;
                r = (pixel >> 16) & 0xff;
                g = (pixel >> 8) & 0xff;
                b = pixel & 0xff;

                int [] ArrR = new int[256];
                int [] ArrG = new int[256];
                int [] ArrB = new int[256];



                a= Color.alpha(pixel);
                r=Color.red(pixel);
                g=Color.green(pixel);
                b=Color.blue(pixel);
                r=(int)((r+roja));
                g=(int)((g+verde));
                b=(int)((b+azul));

                int i=0;
                for ( i=0; i<.2; i++)
                {
                    if(r<.2 || r>5)
                    {
                    r=1;
                }
                    else if (g<.2 || g>5){

                        g=1;

                    }
                    else if (b<.2 || b>5){

                        b=1;

                    }

                }

                //se realiza la operacion por pixel
                //grey = (r + g + b) / 3;
                //se vuelve a codificar el pixel
                //pixel = ((a << 24) | (grey << 16) | (grey << 8) | grey);
                //se agrega el pixel en el bitmap destino
                bmp.setPixel(x, y, Color.argb(a,r,b,g));
            }
        }
        //retorna el bitmap final para ser renderizado por imageView
        return bmp;
    }


    public static Bitmap rotar(Bitmap bitmap) {
        float angu=90;
        Matrix matrix = new Matrix();
        // setup rotation degree
        matrix.postRotate(angu);

        // return new bitmap rotated using matrix
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public Bitmap Bordes(Bitmap bitmap){
        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        int p1=0;
        int p2=0;
        int p3=0;
        int umbral=20;
        int a1=0;
        int r1=0;
        int b1=0;
        int g1=0;

        int a2=0;
        int r2=0;
        int b2=0;
        int g2=0;

        for(int x=0; x<bitmap.getWidth()-2; x++){
            for(int y=0; y<bitmap.getHeight()-2; y++){

                int pixel = bitmap.getPixel(x, y);
                p1 = bitmap.getPixel(x, y);
                p2 = bitmap.getPixel(x+1,y);
                p3 = bitmap.getPixel(x,y+1);

                int a = (p1 >>> 24) & 0xff;
                int r = (p1 >> 16) & 0xff;
                int g = (p1 >> 8) & 0xff;
                int b = p1 & 0xff;

                a1 = (p2 >>> 24) & 0xff;
                r1 = (p2 >> 16) & 0xff;
                g1 = (p2 >> 8) & 0xff;
                b1 = p2 & 0xff;

                a2 = (p3 >>> 24) & 0xff;
                r2 = (p3 >> 16) & 0xff;
                g2 = (p3 >> 8) & 0xff;
                b2 = p3 & 0xff;

                int d1= (int)Math.pow(r-r1,2.0)+(int)Math.pow(g-g1,2.0)+(int)Math.pow(b-b1,2.0);
                d1=(int)Math.sqrt(d1);
                int d2= (int)Math.pow(r-r2,2.0)+(int)Math.pow(g-g2,2.0)+(int)Math.pow(b-b2,2.0);
                d2=(int)Math.sqrt(d1);

                if((d1>=umbral)|| (d2>=umbral)){
                    d1=255;
                }else{
                    d1=0;
                }
                pixel = ((a << 24) | (d1 << 16) | (d1<< 8) | d1);
                bmp.setPixel(x, y,pixel);
            }

        }
        return bmp;
    }


    public void guardarImagen(Bitmap bitmap){

        File almacen= Environment.getExternalStorageDirectory();
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "Image-"+ n +".jpg";
        File file = new File (almacen.getAbsolutePath()+"/Pictures", fname);

        if (file.exists ()) file.delete ();
        try {
            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
            Log.i("TAG", "Imagen guardada"+file.getAbsolutePath());
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}




