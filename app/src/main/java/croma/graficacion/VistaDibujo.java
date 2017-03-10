package croma.graficacion;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;


class VistaDibujo extends View {
    private int opcdibujo;
    private Punto[] puntos;
    public VistaDibujo(Context context,int opcdibujo,Punto[] puntos) {
        super(context);
        this.opcdibujo=opcdibujo;
        this.puntos=puntos;

    }

    protected void onDraw(Canvas canvas) {
        canvas.drawRGB(255, 255, 255);
        int ancho = 100;
        Paint pincel1 = new Paint();
        pincel1.setColor(Color.BLACK);

        pincel1.setStrokeWidth(4);
        //canvas.drawLine(150, 150, ancho, 20, pincel1);
        if(opcdibujo==1)
            //lineaRecta(canvas,pincel1,puntos[0],puntos[1]);
        lineaRecta(canvas,pincel1,new Punto(100,100),new Punto(500,600));
        else if(opcdibujo==2){
            //codigo para linea  DDA
        }
        else if(opcdibujo==3){
            //codigo
        }
        else {
            canvas.drawText("Opcion no existe",getWidth()/2,getHeight()/2,pincel1);
        }

    }

    public void lineaRecta(Canvas pintar,Paint lapiz,Punto p0,Punto p1){
        int m=(p1.getY()/p1.getX())-(p0.getY()/p0.getX());
        int b=p0.getY()-m*p0.getX();
        int y=0;

        for (int x=p0.getX();x<p1.getX();x++){
            y=m*x+b;
            pintar.drawPoint(x,(int) Math.round(y),lapiz);
            Log.d("Puntos:","x:"+x+"y:"+y);

        }
    }
    public  void lineaDDa(Canvas pintar,Paint lapiz,int x0,int y0, int x1, int y1){
        int dx=x1-x0;
        int dy=y1-y0;
        int cont=0;
        if(Math.abs(dx)>Math.abs(dy)){
            cont=Math.abs(dx);
        }else{
            Math.abs(dy);
        }





    }

}
