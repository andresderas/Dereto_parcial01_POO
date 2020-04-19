package com.AODC.x00362718;

public class Documento {
    private String nombre;
    private String numero;

    //Constructor
    public Documento(String nombre, String numero) {
        this.nombre = nombre;
        this.numero = numero;
    }
    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getNumero() {
        return numero;
    }
}
