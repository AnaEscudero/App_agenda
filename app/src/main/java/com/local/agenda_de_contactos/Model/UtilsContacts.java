package com.local.agenda_de_contactos.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.local.agenda_de_contactos.Contacto;
import com.local.agenda_de_contactos.constants.Constantes;

/**
 * Created by user on 05/03/2018.
 */

public class UtilsContacts {

    // Atributos
    private SQLiteDatabase db = null;
    private DataBaseContacts dbhelper = null;

    //Contexto
    Context context;


    // TODO: Constructor de nuestra clase para instanciar la clase DAtabaseContactos y usar los
    // métodos para escribir nuestra base de datos
    public UtilsContacts(Context contexto) {
        this.context = contexto;

        //Crea una instancia del helper
        dbhelper = new DataBaseContacts(context);

        // Crea un objeto SQLiteDatabase para operar contra la base de datos
        db = dbhelper.getWritableDatabase();

    }

    // TODO: Cerramos la base de datos
    public void close() {
        dbhelper.close();
    }


    // TODO: Usamos un objeto de tipo ContentValues para guardar las "keys" de cada campo de nuestro
    // contacto e insertarlo en la tabla

    public long insertarContacto(Contacto c) {
        ContentValues initialValues = new ContentValues();
        initialValues.put("nombre", c.getNombre());
        initialValues.put("email", c.getEmail());
        initialValues.put("edad", c.getEdad());

        // Inserta el Contacto en la base de datos
        return db.insert(Constantes.CONTACTOS_TABLA, null, initialValues);

    }

    public Cursor recuperarContactos() {
        return db.query(Constantes.CONTACTOS_TABLA, new String[]{
                Constantes.CAMPO_ID, Constantes.CAMPO_NOMBRE,
                Constantes.CAMPO_EMAIL, Constantes.CAMPO_EDAD
        }, null, null, null, null, null);
    }

    public Contacto buscarPorEmail(String email) {
        Contacto con = null;
        Cursor c = db.query(Constantes.CONTACTOS_TABLA, new String[]{
                        Constantes.CAMPO_ID, Constantes.CAMPO_NOMBRE,
                        Constantes.CAMPO_EMAIL, Constantes.CAMPO_EDAD},
                Constantes.CAMPO_EMAIL + "email=?",
                new String[]{email}, null, null, null);

        if (c.moveToNext()) {
            con = new Contacto(c.getString(1), c.getString(2), c.getString(3));
        }
        return con;
    }

}



