package croma.graficacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button btnGraficar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
        btnGraficar=(Button) findViewById(R.id.btngraficar);
        btnGraficar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getBaseContext(),CrearGraficador.class);
                i.putExtra("dibujo",1);
                i.putExtra("x0",1);

                startActivity(i);

            }
        });
    }

    public void circulo(View v){
        Intent i=new Intent(this,CrearGraficador.class);
        startActivity(i);

    }

    public void  Casa1(View v){
        Intent inten= new Intent(this, Casa.class);
        startActivity(inten);
    }
}
