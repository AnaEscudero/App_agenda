package com.local.agenda_de_contactos;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class VerActivity extends Activity {
    ArrayList<Contacto> miagenda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_ver);
        Intent intent=this.getIntent();
        //recupera la agenda
        miagenda=(ArrayList<Contacto>)intent.getSerializableExtra("agenda");
        String datos="";
        TextView tvListado=(TextView)this.findViewById(R.id.textViewResultado1);
        //recorre la agenda y forma una cadena con cada contacto de la misma
        for(Contacto c:miagenda){
            datos+="Nombre: "+c.getNombre()+" Email: "+c.getEmail()+" Edad: "+c.getEdad()+"\n";
        }
        //vuelca los datos en el TextView
        tvListado.setText(datos);
    }

    public void salir(View v){
        this.finish();
    }
}