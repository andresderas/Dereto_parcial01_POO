package com.AODC.x00362718;

import java.text.DecimalFormat;
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
    private String verDocumentos(){
        String mess = "";

        for(Documento m : documentos){
            mess += m.toString() ;
        }
        return mess;
    }
    //toString
    DecimalFormat formato1 = new DecimalFormat("0.00");
    @Override
    public String toString() {
        return "Empleado{" +
                "Nombre:'" + nombre + '\'' +
                ", Puesto:'" + puesto + '\'' +
                ", Documentos: " + verDocumentos() +
                ", Salario: $" + formato1.format(salario) +
                '}';
    }

    //Metodos
    public void addDocumento(Documento d){
        documentos.add(d);
    }
    public void removeDocumento(String nom){
        documentos.removeIf(obj -> obj.getNombre().equalsIgnoreCase(nom));
    }
}
