package croma.graficacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
public class Circulo extends AppCompatActivity {
  int corx, cory;
 Lienzo fondo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);
        RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.layout1);
        Lienzo fondo = new Lienzo(this);
        layout1.addView(fondo);
    }

    class Lienzo extends View {

        public Lienzo(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawRGB(0, 255, 0);
            int ancho = canvas.getWidth();
            int alto = canvas.getHeight();
            Paint pincel1 = new Paint();
            pincel1.setARGB(255,255, 0, 0);
            pincel1.setStyle(Paint.Style.STROKE);
            for (int f = 0; f < 10; f++) {
                canvas.drawCircle(ancho / 2, alto / 2, f * 40, pincel1);
            }
        }
    }
}
