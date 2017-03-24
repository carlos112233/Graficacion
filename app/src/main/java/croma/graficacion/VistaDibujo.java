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
        if (opcdibujo == 1)
            lineaRecta(canvas, pincel1, new Punto(300,700),new Punto(200,600));


           else if (opcdibujo == 2) {

            lineaDDa(canvas,pincel1,new Punto(300,700),new Punto(200,600));
        } else if (opcdibujo == 3) {
            Elipse(canvas,pincel1,800,800,200,60);
        } else if(opcdibujo==4){
            CircleMidPoint(canvas,pincel1,800,800,200);
        }else if(opcdibujo==5){
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



    public void Elipse(Canvas g,Paint lapiz , int xc, int yc, int rx, int ry){
        Punto punto = new Punto(0,0);
        int x, y, p, px, py;
        int rx2, ry2, tworx2, twory2;
        ry2 = ry*ry;
        rx2 = rx*rx;
        twory2 = 2 * ry2;
        tworx2 = 2 * rx2;
/* región 1 */
        x = 0;
        y = ry;
        punto.ovalos(g,lapiz,xc,yc,x,y);
        p = (int)Math.round(ry2 - rx2*ry + 0.25*rx2);
        px = 0;
        py = tworx2*y;
        while (px < py) { /* se cicla hasta trazar la región 1 */
            x = x + 1;
            px = px + twory2;
            if (p < 0)
                p = p + ry2 + px;
            else {
                y = y - 1;
                py = py - tworx2;
                p = p + ry2 + px - py;
            }
            punto.ovalos(g,lapiz,xc,yc,x,y);
        }
/* región 2 */
        p = (int)Math.round(ry2*(x+0.5)*(x+0.5) + rx2*(y-1)*(y-1) - rx2*ry2);
        px = 0;
        py = tworx2*y;
        while (y > 0) { /* se cicla hasta trazar la región 2 */
            y = y - 1;
            py = py - tworx2;
            if (p > 0)
                p = p + rx2 - py;
            else {
                x = x + 1;
                px = px + twory2;
                p = p + rx2 + py + px;
            }
            punto.ovalos(g,lapiz,xc,yc,x,y);
        }
    }

}
