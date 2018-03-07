package com.local.agenda_de_contactos.Model;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.local.agenda_de_contactos.constants.Constantes;

public class DataBaseContacts extends SQLiteOpenHelper{



    // ALT + SHIFT + TECLAS FLECHAS = Seleccionar varial lineas (teclado)
    // ALT + BLOQ_MAYUSC = Seleccionar varias lineas (raton)


    // TODO: Constantes para crear y eliminar tabla contactos
    private static final String CREATE_TABLE_CONTACTOS =
            "CREATE TABLE " + Constantes.CONTACTOS_TABLA + " (" + Constantes.CAMPO_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + Constantes.CAMPO_NOMBRE + " TEXT NOT NULL, " +
            Constantes.CAMPO_EMAIL + " TEXT NOT NULL, " + Constantes.CAMPO_EDAD + " INTEGER NOT NULL)";

    private static final String DELETE_TABLE_CONTACTO = "DROP TABLE IF EXISTS " + Constantes.CONTACTOS_TABLA;


    // TODO: Constructor de nuestra clase para crear una referencia a nuestra base de datos

    public DataBaseContacts (Context context){
        super (context, Constantes.DATABASE_NAME,null, Constantes.DATABASE_VERSION);
    }

    // TODO: El método onCreate se llama al crear la base de datos

    @Override
    public void onCreate(SQLiteDatabase db) {
    // Invocamos al método createTables
        createTables(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // Eliminamos la tabla
        deleteTables(db);

        // y la volvemos a crear
        createTables(db);

    }

    // TODO: Usamos un metodo para crear nuestra tabla
    // Con el parametro db "SQLiteDatabase" ejecutamos una instruccion SQL para crear nuestra tabla
    private void createTables (SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_CONTACTOS);
    }


    // TODO: Usamos este metodo para eliminar nuestras tablas
    private void deleteTables (SQLiteDatabase db){
        db.execSQL(DELETE_TABLE_CONTACTO);

    }




}







