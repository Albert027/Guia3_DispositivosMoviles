package com.example.atriox.guia3_moviles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MensajeActivity extends AppCompatActivity {

    //declaracion de variables
    private EditText txtMensaje;
    private Button btnAgregar;

    public static int GUARDADO=47;//puede ser un numero cualquiera

    private AdaptadorMensaje adaptadorMensaje;
    private ArrayList<Mensaje> mensajesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        //inicializando variables
        txtMensaje   = (EditText) findViewById(R.id.txtEntrada);
        btnAgregar  = (Button  ) findViewById(R.id.btnEnviar);

        mensajesArrayList = new ArrayList<>();
        //Inicializando el adaptador
        adaptadorMensaje = new AdaptadorMensaje(MensajeActivity.this,  mensajesArrayList);
        //Inicializando el listView
        ListView listView = (ListView) findViewById(R.id.lstMensaje);
        //seteando el adaptador al listview
        listView.setAdapter(adaptadorMensaje);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //si alguno de los dos campos estan vacios
                if(txtMensaje.getText().toString().isEmpty()){
                    Toast.makeText(MensajeActivity.this,"Escriba el texto a enviar",Toast.LENGTH_SHORT).show();
                }else{//de lo contrario los campos estan llenos
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy h:mm a");
                    String fecha = sdf.format(new Date());
                    Mensaje m = new Mensaje(fecha,txtMensaje.getText().toString());
                    mensajesArrayList.add(m);
                    adaptadorMensaje.notifyDataSetChanged();
                    txtMensaje.setText("");
                }
            }
        });
    }
}