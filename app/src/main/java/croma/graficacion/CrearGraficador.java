package croma.graficacion;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by upam on 10/03/17.
 */

public class CrearGraficador extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i=getIntent();
        int opc=i.getIntExtra("dibujo",1);
        //objeto de tipo puntos
        Punto[] puntos=new Punto[10];
        // puntos[0].setX(i.getIntExtra("x0",0));
        setContentView(new VistaDibujo(getBaseContext(),opc,puntos));
    }
}
