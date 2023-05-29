package com.example.pre_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Activity_Recibo extends AppCompatActivity {


    private Button btnGenerar;
    private Button btnLimpiar;
    private Button btnRegresar;

    private TextView lblUsuario;

    private EditText txtNombre;
    private EditText txtNumeroRecibo;
    private EditText txtHorasTrabajadas;
    private EditText txtHorasExtras;

    private RadioButton rbAuxiliar;
    private RadioButton rbAlbañil;
    private RadioButton rbingObra;

    private EditText txtSubtotal;
    private EditText txtImpuesto;
    private EditText txtTotalPagar;

    private ReciboNomina reciboNomina = new ReciboNomina(0,"",0.0,0.0,0,0.0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibo);

        iniciarComponentes();
        String strUsuario;
        strUsuario = getResources().getString(R.string.nombre);
        lblUsuario.setText(strUsuario.toString());

        btnGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnGenerar();
            }
        });


        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLimpiar();
            }
        });



    }







    private void iniciarComponentes()
    {
        btnGenerar = findViewById(R.id.btnCalcular);
        btnLimpiar=findViewById(R.id.btnLimpiar);
        btnRegresar=findViewById(R.id.btnRegresar);

        lblUsuario= findViewById(R.id.lblUsuario);

        txtNombre= findViewById(R.id.txtNombre);
        txtNumeroRecibo= findViewById(R.id.txtNumero);
        txtHorasTrabajadas=findViewById(R.id.txtHoras);
        txtHorasExtras=findViewById(R.id.txtHorasExtras);

        rbAuxiliar=findViewById(R.id.rbAuxiliar);
        rbAlbañil=findViewById(R.id.rbAlbañil);
        rbingObra=findViewById(R.id.rbIngObra);

        txtSubtotal=findViewById(R.id.txtSubTotal);
        txtImpuesto=findViewById(R.id.txtImpuestos);
        txtTotalPagar=findViewById(R.id.txttotalPagar);
    }


    private void btnGenerar()
    {
        int puesto=0;
        reciboNomina.setHorasTrabajadas(Integer.parseInt(txtHorasTrabajadas.getText().toString()));
        reciboNomina.setHorasExtras(Double.parseDouble((txtHorasExtras.getText().toString())));
        if(rbAuxiliar.isChecked())
        {
            puesto=1;
        }
        else if(rbAlbañil.isChecked())
        {
            puesto=2;
        }
        else if(rbingObra.isChecked())
        {
            puesto=3;
        }
        reciboNomina.setPuesto(puesto);
        double subtotal=reciboNomina.calcularSubtotal();
        txtSubtotal.setText(String.valueOf(subtotal));


        double impuesto=reciboNomina.calcularImpuesto();
        txtImpuesto.setText(String.valueOf(impuesto));

        double total=reciboNomina.calcularTotalPagar();
        txtTotalPagar.setText(String.valueOf(total));




    }

    private void btnLimpiar()
    {
        txtNombre.setText("");
        txtNumeroRecibo.setText("");
        txtHorasExtras.setText("");
        txtHorasTrabajadas.setText("");
        txtSubtotal.setText("");
        txtImpuesto.setText("");
        txtTotalPagar.setText("");

    }

    private void btnRegresar()
    {

    }


}