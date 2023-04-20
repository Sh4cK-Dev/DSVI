package com.example.applabs_3scedeo_csnchez_aurriola;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    List <String> operaciones = new ArrayList<>();

    EditText txtNum1;
    EditText txtNum2;
    TextView lblResultado;

    CheckBox checkbox1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InicializarControles();

        /*adaptador del spinner*/
        ArrayAdapter <String> spinnerlist = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,operaciones);
        spinner.setAdapter(spinnerlist);

    }

    private void InicializarControles() {
        spinner = findViewById(R.id.spn_opciones);

        txtNum1 = (EditText)findViewById(R.id.txtNum1);
        txtNum2 = (EditText)findViewById(R.id.txtNum2);

        lblResultado = (TextView)findViewById(R.id.lblRes);

        operaciones.add("Suma");
        operaciones.add("Resta");
        operaciones.add("Multiplicacion");
        operaciones.add("Division");
    }

    public void RealizarOperaciones(View view){

        Operaciones op = new Operaciones();
        checkbox1= findViewById(R.id.chk_1);

        try {
            int n1 = Integer.parseInt(txtNum1.getText().toString());
            int n2 = Integer.parseInt(txtNum2.getText().toString());
            int opcion_spinner = spinner.getSelectedItemPosition();

            double respuesta = 0;
            op.Operaciones(opcion_spinner,n1,n2);

            /*checkbox sentencia if*/

            if(checkbox1.isChecked()==true){
                switch(opcion_spinner){
                    case 0:
                        respuesta=op.Sumar();
                        break;

                    case 1:
                        respuesta=op.Restar();
                        break;

                    case 2:
                        respuesta=op.Multiplicar();
                        break;

                    case 3:
                        respuesta=op.Dividir();
                        break;

                    default:
                        break;
                }
            }
            else{
                Toast.makeText(this,"Llene los campos", Toast.LENGTH_SHORT).show();
            }


            lblResultado.setText(Double.toString(respuesta));

        }
        catch (Exception e){
            Toast.makeText(this,"Error en la suma de los datos" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        /*
        catch (NullPointerException e){
            Toast.makeText(this,"Error en la suma de los datos" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        catch (ArithmeticException ee){
            Toast.makeText(this,"No se puede dividir entre 0" + ee.getMessage(), Toast.LENGTH_SHORT).show();
        }
         */
    }



}
