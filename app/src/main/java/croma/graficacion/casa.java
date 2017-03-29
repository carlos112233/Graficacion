package croma.graficacion;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;

public class casa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casa);
        RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.layout1);
        Lienzo fondo = new Lienzo(this);
        layout1.addView(fondo);
    }



    class Lienzo extends View {

        public Lienzo(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawRGB(255,255,255);
            int ancho=canvas.getWidth();
            Paint pincel1=new Paint();

            pincel1.setStrokeWidth(100);
            canvas.drawRect(200, 400, 500, 400,pincel1);



        }
    }

}
