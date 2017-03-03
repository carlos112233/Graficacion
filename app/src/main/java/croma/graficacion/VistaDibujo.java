package croma.graficacion;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;

/**
 * Created by upam on 01/03/17.
 */

public class VistaDibujo extends View {
    public VistaDibujo(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint= new Paint();
        Log.d("width","w="+getWidth());
        Log.d("height","h="+getHeight());
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);

        paint.setColor(Color.BLUE);
        canvas.drawLine(0,0,100,100,paint);
        canvas.drawRect(new Rect(180,20,220,80),paint);
    }
}
