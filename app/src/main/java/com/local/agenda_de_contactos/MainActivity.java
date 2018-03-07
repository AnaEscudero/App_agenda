package com.local.agenda_de_contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Creamos un ArrayList para nuestra agenda

    ArrayList<Contacto> agenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agenda = new ArrayList<Contacto>();

    }

    // Abre la actividad AgregarActivity para
    public void abrirParaInsertarEnDB(View v){
        Intent intent = new Intent(this, AgregarActivity.class);

        startActivity(intent);
    }




    public void anadir(View v) {
        Intent intent = new Intent(this, AgregarActivity.class);
        intent.putExtra("agenda", agenda);
        this.startActivityForResult(intent, 1);

        for (Contacto c : agenda) {
            if (c != null) {
                Log.d("TAG", c.getNombre());
            } else {
                Log.d("TAG", "agenda vacía o valores nulos");
            }
        }
    }

    public void buscar(View v) {
        Intent intent = new Intent(this, BuscarActivity.class);
        intent.putExtra("agenda", agenda);
        this.startActivity(intent);
    }

    public void ver(View v) {
        Intent intent = new Intent(this, VerActivity.class);
        intent.putExtra("agenda", agenda);
        this.startActivity(intent);
    }

    @Override
    public void onActivityResult(int cod, int result, Intent data) {
        super.onActivityResult(cod, result, data);

        switch (result) {
            case RESULT_OK:
                agenda = (ArrayList<Contacto>) data.getSerializableExtra("miagenda");
                break;
            case RESULT_CANCELED:
                return;

        }
    }


}
