package croma.graficacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText et1,et2,et3,et4;
    private RadioButton r1,r2,r3,r4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);


        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        et4=(EditText)findViewById(R.id.et4);
        r1=(RadioButton)findViewById(R.id.r1);
        r2=(RadioButton)findViewById(R.id.r2);
        r3=(RadioButton)findViewById(R.id.r3);
        r4=(RadioButton)findViewById(R.id.r5);

    }

    public void boton(View view) {
        // Inflate the menu; this adds items to the action bar if it is present.

        String valor1=et1.getText().toString();
        String valor2=et2.getText().toString();
        String valor3=et3.getText().toString();
        String valor4=et4.getText().toString();

        if (r1.isChecked()==true) {

            Intent i=new Intent(getBaseContext(),CrearGraficador.class);
            i.putExtra("dibujo",1);
            startActivity(i);
        } else
        if (r2.isChecked()==true) {
            Intent i=new Intent(getBaseContext(),CrearGraficador.class);
            i.putExtra("dibujo",2);
            i.putExtra("x0",1);
            startActivity(i);
        }if (r3.isChecked()==true) {

            Intent i=new Intent(getBaseContext(),CrearGraficador.class);
            i.putExtra("dibujo",3);
            i.putExtra("x0",1);

            startActivity(i);
        } else
        if (r4.isChecked()==true) {

            Intent i=new Intent(getBaseContext(),CrearGraficador.class);
            i.putExtra("dibujo",4);
            i.putExtra("x0",1);

            startActivity(i);
        }
    }


}
