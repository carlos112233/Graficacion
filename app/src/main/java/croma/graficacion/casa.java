package croma.graficacion;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
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
          super.onDraw(canvas);
            canvas.drawColor(Color.WHITE);

            Paint pincel1 = new Paint();
            pincel1.setColor(Color.YELLOW);

            pincel1.setStrokeWidth(10);

            Rect rectangulo= new Rect();
            Rect Rec= new Rect();
            Rect Rec2= new Rect();
            rectangulo.set(200,600,800,1050);
            Rec.set(250,700,400,850);
            Rec2.set(420,900,550,1055);
            Paint fondo= new Paint();
            Paint fondo1= new Paint();
            Paint fondo2= new Paint();
            fondo.setColor(Color.RED);
            canvas.drawRect(rectangulo,fondo);
            fondo.setColor(Color.BLUE);
            canvas.drawRect(Rec,fondo1);
            fondo2.setColor(Color.YELLOW);
            canvas.drawRect(Rec2,fondo2);

            drawTriangle(canvas,pincel1, 500, 300, 600);



        }
    }

    public void drawTriangle(Canvas canvas, Paint paint, int x, int y, int width) {
        int halfWidth = width / 2;

        Path path = new Path();
        path.moveTo(x, y - halfWidth); // Top
        path.lineTo(x - halfWidth, y + halfWidth); // Bottom left
        path.lineTo(x + halfWidth, y + halfWidth); // Bottom right
        path.lineTo(x, y - halfWidth); // Back to Top
        path.close();

        canvas.drawPath(path, paint);
    }


}
