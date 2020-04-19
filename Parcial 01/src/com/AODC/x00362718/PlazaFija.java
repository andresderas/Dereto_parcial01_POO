package com.AODC.x00362718;

public class PlazaFija extends Empleado{
    //Atributo
    private int extension;
    //Constructor
    public PlazaFija(String nombre, String puesto, double salario, int extension) {
        super(nombre, puesto, salario);
        this.extension = extension;
    }
    //Getter
    public int getExtension() {
        return extension;
    }
    //Setter
    public void setExtension(int extension) {
        this.extension = extension;
    }
}
