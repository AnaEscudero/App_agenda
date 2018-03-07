package com.local.agenda_de_contactos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class BuscarActivity extends Activity {

    ArrayList<Contacto> miagenda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_buscar);
        Intent intent=this.getIntent();
        miagenda=(ArrayList<Contacto>)intent.getSerializableExtra("agenda");
    }
    public void buscar(View v){
        String email=((EditText)this.findViewById(R.id.editTextBuscarEmail)).getText().toString();
        //guardamos aqu� el contacto recuperado
        Contacto c=null;
        for(Contacto con:miagenda){
            //si coincide el email, nos quedamos con el contacto
            if(con.getEmail().equals(email)){
                c=con;
                break;
            }
        }


        mostrarDato(c);
    }
    public void salir(View v){

        this.finish();
    }

    private void mostrarDato(Contacto c){
        if(c==null){
            AlertDialog.Builder cuadro=new AlertDialog.Builder(this);
            cuadro.setMessage("No se ha encontrado el contacto, ¿Desea realizar otra búsqueda?");
            //en caso de que diga que no, salimos de la actividad
            cuadro.setNegativeButton(android.R.string.no,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Abandona la actividad
                            BuscarActivity.this.finish();
                        }
                    });
            //no se define ningún escuchador para el botón de afirmación
            cuadro.setPositiveButton(android.R.string.yes,null);
            cuadro.show();

        }
        else{
            String datos="Nombre: "+c.getNombre()+"\n Email:"+c.getEmail()+"\n Edad:"+c.getEdad();
            Toast.makeText(this,datos,Toast.LENGTH_LONG).show();

        }
    }

}