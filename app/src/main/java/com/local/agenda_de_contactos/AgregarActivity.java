package com.local.agenda_de_contactos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.local.agenda_de_contactos.Model.UtilsContacts;
import com.local.agenda_de_contactos.Model.utils.Utilidades;

import java.util.ArrayList;

public class AgregarActivity extends Activity {

    // Mi agenda es nuestro array de tipo contacto
    ArrayList<Contacto> miagenda;

    // Creamos referencia para utilizar los métodos de la clase Utilidades
    Utilidades u = new Utilidades();


    // Creamos un objeto de tipo Resources para acceder a los String
    // Resources rs = getResources();


    EditText editTextName;
    EditText editTextEmail;
    EditText editTextEdad;
    Button btnGuardar;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_agregar);


        // ENCONTRAR NUESTROS OBJETOS EN LA VISTA (XML) Y PASARLOS A NUESTRAS VARIABLES DEL MISMO TIPO
        editTextName =((EditText)this.findViewById(R.id.editTextName));
        editTextEmail=((EditText)this.findViewById(R.id.editTextBuscarEmail));
        editTextEdad = (EditText)this.findViewById(R.id.editTextEdad);

        btnGuardar = this.findViewById(R.id.buttonGuardar);
        //Intent intent = this.getIntent();
        //miagenda = (ArrayList<Contacto>) intent.getSerializableExtra("agenda");

    }


    /* public void guardar(View v){

         String nombre=((EditText)this.findViewById(R.id.editTextName)).getText().toString();
         String email=((EditText)this.findViewById(R.id.editTextEmail)).getText().toString();
         int edad=Integer.parseInt(((EditText)this.findViewById(R.id.editTextEdad)).getText().toString());
         //creamos objeto contacto
         Contacto c=new Contacto(nombre, email, edad);
         //lo añadimos a la colección
         miagenda.add(c);

         //pasamos la colección como resultado a la actividad principal
         //para que se mantengan los contactos añadidos
         Intent intent=new Intent();
         intent.putExtra("miagenda", miagenda);
         this.setResult(0, intent);
         //cerramos la actividad
         this.finish();

 0    }*/
    public void guardar(View v) {
        //recogemos el objeto EditText, le aplicamos
        // el método getText() para recuperar su contenido
        //y, dado que lo devuelve como editable, le aplicamos
        // al valor devuelto por getText el método toString
        //para convertirlo a String
        String nombre = ((EditText) this.findViewById(R.id.editTextName)).getText().toString();
        String email = ((EditText) this.findViewById(R.id.editTextBuscarEmail)).getText().toString();
        // para poder evaluar la edad como vacio en el if, hemos puesto edad como String en lugar de entero
        // en contacto hay que cambiar edad a String también para que funcione
        String edad = ((EditText) this.findViewById(R.id.editTextEdad)).getText().toString();
        boolean auxnombre = false;
        boolean auxmail = false;
        boolean auxedad = false;
        Contacto c = new Contacto(nombre, email, edad);
        if (nombre.equals("")) {
            auxnombre = true;
        } else if (email.equals("")) {
            auxmail = true;
        } else if (edad.equals("")) {
            auxedad = true;

        }
        if ((auxedad == true) || (auxmail == true) || (auxnombre == true)) {

            Toast.makeText(this, "Debe rellenar todos los campos", Toast.LENGTH_LONG).show();

        } else {

            miagenda.add(c);
            Intent intent = new Intent();
            intent.putExtra("miagenda", miagenda);
            this.setResult(AgregarActivity.RESULT_OK, intent);
            this.finish();
        }


    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        setResult(AgregarActivity.RESULT_CANCELED);
        finish();

    }


    public void insertarContactosADB(View view) {

        //Compruebo valores en los campos para que no este vacíos. Textutils para comprobar si esta
        //vacio con is empty

        if (TextUtils.isEmpty(editTextName.getText()) ||
                TextUtils.isEmpty(editTextEmail.getText()) ||
                TextUtils.isEmpty(editTextEdad.getText())) {


            // Mostramos mensaje de error "Campos vacios"


            u.mostrarMensaje(this, R.string.campos_vacios);

        } else {

            // Variables para recoger valores
            String nombre = ((EditText) this.findViewById(R.id.editTextName)).getText().toString();
            String email = ((EditText) this.findViewById(R.id.editTextBuscarEmail)).getText().toString();
            String edad = ((EditText) this.findViewById(R.id.editTextEdad)).getText().toString();

            //creamos objeto contacto
            Contacto c = new Contacto(nombre, email, edad);

            //creamos un DBContactos y añadimos
            //el nuevo contacto

            UtilsContacts gestion = new UtilsContacts(this);
            gestion.insertarContacto(c);

            //cerramos la base de datos
            gestion.close();

            //finalizamos la actividad
            this.finish();


        }


    }
}




