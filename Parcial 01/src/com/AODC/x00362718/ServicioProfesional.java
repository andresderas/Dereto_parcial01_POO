package com.AODC.x00362718;

public class ServicioProfesional extends Empleado{
    private int mesesContrato;
    //Constructor
    public ServicioProfesional(String nombre, String puesto, double salario, int mesesContrato) {
        super(nombre, puesto, salario);
        this.mesesContrato = mesesContrato;
    }
    //Getter
    public int getMesesContrato() {
        return mesesContrato;
    }
    //Setter
    public void setMesesContrato(int mesesContrato) {
        this.mesesContrato = mesesContrato;
    }
}
