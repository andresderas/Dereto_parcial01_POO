package com.AODC.x00362718;

import java.util.ArrayList;

abstract class Empleado {
    //Atributos
    protected String nombre;
    protected String puesto;
    protected ArrayList<Documento> documentos;
    protected double salario;
    //Constructor
    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        documentos = new ArrayList<>();
        this.salario = salario;
    }
    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }

    public double getSalario() {
        return salario;
    }
    //Setters
    public void setSalario(double salario) {
        this.salario = salario;
    }
    //Metodos
    public void addDocumento(){

    }
    public void removeDocumento(String){

    }
}
