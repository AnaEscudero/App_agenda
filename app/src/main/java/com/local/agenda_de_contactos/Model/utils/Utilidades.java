package com.local.agenda_de_contactos.Model.utils;

import android.content.Context;
import android.widget.Toast;


public class Utilidades {

    /** Muestra un toast con un mensaje para el usuario
     *
      * @param context (Representa el contexto donde se va a mostrar el mensaje)
     *
     * @param mensaje (Mensaje del usuario)
     */
    public void mostrarMensaje (Context context, int mensaje){

        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();

    }
}
