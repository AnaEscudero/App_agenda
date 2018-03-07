package com.local.agenda_de_contactos;

import java.io.Serializable;

// Implementamos el uso de la interfaz Seriable para enviar los datos en forma de bytes
public class Contacto implements Serializable  {

        private String nombre;
        private String email;
        private String edad;

    public Contacto(String nombre, String email, String edad) {
        super();
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}
