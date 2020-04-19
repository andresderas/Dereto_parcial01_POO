package com.AODC.x00362718;

import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private ArrayList<Empleado> planilla;

    //Constructor
    public Empresa(String nombre) {
        this.nombre = nombre;
        planilla = new ArrayList<Empleado>();
    }
    //Getters
    public String getNombre() {
        return nombre;
    }

    public ArrayList<Empleado> getPlanilla() {
        return planilla;
    }
    //Metodos
    public void addEmpleado(Empleado empleado){
        planilla.add(empleado);
    }

    public void quitEmpleado(String nom){
        planilla.removeIf(obj -> obj.nombre.equalsIgnoreCase(nom));
    }
    private String verEmpleados(){
        String mess = "";

        for(Empleado m : planilla){
            mess += m.toString() + "\n";
        }
        return mess;
    }
    //To string
    @Override
    public String toString() {
        return "\nEmpresa{" +
                "Planilla:\n" + verEmpleados() +
                '}';
    }
}
