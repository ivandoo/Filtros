package com.example.upam.proyectofiltros;

import android.graphics.Bitmap;
import android.graphics.Color;

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
        int azula=azulg;
        int verdea=verdeg;
        int cont;
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


                a= Color.alpha(pixel);
                r=Color.red(pixel);
                g=Color.green(pixel);
                b=Color.blue(pixel);
                r=(int)((r+roja));
                g=(int)((g+verdea));
                b=(int)((b+azula));

                for ( r=0; r<.2; r++)
                {
                    r=1;

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






}


