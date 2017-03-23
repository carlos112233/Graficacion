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


    public VistaDibujo(Context context, int opcdibujo, Punto[] puntos) {
        super(context);
        this.opcdibujo = opcdibujo;
        this.puntos = puntos;

    }

    protected void onDraw(Canvas canvas) {
        canvas.drawRGB(255, 255, 255);
        int ancho = 100;
        Paint pincel1 = new Paint();
        pincel1.setColor(Color.BLACK);

        pincel1.setStrokeWidth(10);
        //canvas.drawLine(150, 150, ancho, 20, pincel1);
        if (opcdibujo == 1) {
            lineaDDa(canvas, pincel1, new Punto(200, 400), new Punto(100, 100));

            lineaRecta(canvas,pincel1,new Punto(300,300),new Punto(500,600));
            CircleMidPoint(canvas, pincel1,600 , 600, 100);
            elipce(canvas, pincel1,900 , 900, 100,100);
        }   else if (opcdibujo == 2) {

            lineaRecta(canvas,pincel1,new Punto(300,700),new Punto(200,600));
        } else if (opcdibujo == 3) {
            //codigo
        } else {
            canvas.drawText("Opcion no existe", getWidth() / 2, getHeight() / 2, pincel1);
        }

    }


    public void lineaRecta(Canvas pintar, Paint lapiz, Punto p0, Punto p1) {
        int m = (p1.getY() / p1.getX()) - (p0.getY() / p0.getX());
        int b = p0.getY() - m * p0.getX();
        int y = 0;

        for (int x = p0.getX(); x < p1.getX(); x++) {
            y = m * x + b;
            pintar.drawPoint(x, (int) Math.round(y), lapiz);
            Log.d("Puntos1", "x:" + x + " y:" + y);

        }
    }


    public void lineaDDa(Canvas pintar, Paint lapiz, Punto p0, Punto p1) {
        int dx = p1.getX()-p0.getX();
        int dy = p1.getY()-p0.getY();
        int cont =1;
        if (Math.abs(dx) > Math.abs(dy)) {

        } else {
            cont=Math.abs(dy);
            int xinc=dx/cont;
            int yinc=dy/cont;
            int x=p0.getX();
            int y=p0.getY();
            pintar.drawPoint((int) Math.round(x), (int) Math.round(y), lapiz);
            cont = Math.abs(dx);
            for(int k=0; k<=cont; k++){
              x=x+xinc;
              y=y+yinc;
                pintar.drawPoint((int) Math.round(x), (int) Math.round(y), lapiz);
                Log.d("Puntos", "x:" + x + " y:" + y);
            }

        }
    }

   public void CircleMidPoint(Canvas pintar, Paint lapiz, int xc, int yc, int r){
       Punto punto = new Punto(0,0);
       int x, y, p;
        x = 0;
        y = r;
        p = 1 - r;
       punto.puntos(pintar,lapiz,xc,yc,x,y);
  while (x < y){
            x = x + 1;
            if (p < 0)
                p = p + 2*x + 1;
            else {
                y = y - 1;
                p = p + 2*(x - y) + 1;
            }
      punto.puntos(pintar,lapiz,xc,yc,x,y);
        }}



    public void elipce(Canvas pintar, Paint lapiz, int xc,int yc, int Rx, int Ry){
        Punto punto = new Punto(0,0);
       int Rx2=Rx*Rx;
       int Ry2=Ry*Ry;
       int A=2*Rx2;
       int B=2*Ry2;
       int px=0;
       int x=0;
       int y=Ry;
       int py=A*y;
        punto.ovalos(pintar,lapiz,xc,yc,x,y);
        float p=Math.round(Ry2-(Rx2*Ry)+(0.25*Rx2));
        while (px < py){
            x = x + 1;
            px=px+B;
            if (p < 0)
                p = p + Ry2*+px;
            else {
               y=y-1;
               py=py-A;
               p=p+Ry2+px-py;

            }
            punto.puntos(pintar,lapiz,xc,yc,x,y);
         }
         p=Math.round(Ry2*(x+0.5)*(x+0.5)+Rx2*(y-1)*(y-1)-Rx2*Ry2);
        while (y>0){
            y=y-1;
            py=py-A;
            if(p>0){
                p=p+Rx2-py;

            }else{
                x=x+1;
                px=px+B;
                p+=Rx2-py+py;


            }
            punto.puntos(pintar,lapiz,xc,yc,x,y);
        }

    }

}
