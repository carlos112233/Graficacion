package croma.graficacion;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by upam on 10/03/17.
 */

public class Punto {
    private int x=0;
    private  int y=0;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void puntos(Canvas pintar, Paint lapiz, int Xc, int Yc, int x , int y){
        pintar.drawPoint(Xc+x,Yc+y,lapiz);
        pintar.drawPoint(Xc-x,Yc+y,lapiz);
        pintar.drawPoint(Xc+x,Yc-y,lapiz);
        pintar.drawPoint(Xc-x,Yc-y,lapiz);

        pintar.drawPoint(Xc+y,Yc+x,lapiz);
        pintar.drawPoint(Xc-y,Yc+x,lapiz);
        pintar.drawPoint(Xc+y,Yc-x,lapiz);
        pintar.drawPoint(Xc-y,Yc-x,lapiz);


    }
    public void ovalos(Canvas pintar, Paint lapiz, int Xc, int Yc, int x , int y) {
        pintar.drawPoint(Xc + x, Yc + y, lapiz);
        pintar.drawPoint(Xc - x, Yc + y, lapiz);
        pintar.drawPoint(Xc + x, Yc - y, lapiz);
        pintar.drawPoint(Xc - x, Yc - y, lapiz);

    }

    @Override
    public String toString() {
        return "Punto{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
