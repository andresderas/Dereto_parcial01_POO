package com.AODC.x00362718;

public final class CalculadoraImpuestos {
    //Atributos
    private static double totalRenta = 0;
    private static double totalISSS = 0;
    private static double totalAFP = 0;
    //Constructor privado
    private CalculadoraImpuestos() {}

    //Metodos estaticos
    public static String mostrarTotales(){
        return "\nTotal Renta: $" + totalRenta + "\nTotal ISSS: $" + totalISSS + "\nTotal AFP: $" + totalAFP;
    }

    public static double calcularPago(Empleado e){
        double renta = 0, afp, isss, restante, pago;

        if(e instanceof ServicioProfesional){
            renta = e.salario*0.1;
            totalRenta = totalRenta + renta;
            pago = e.salario - renta;
        }else{
            afp = e.salario*0.0625;
            totalAFP = totalAFP + afp;
            isss = e.salario*0.03;
            totalISSS = totalISSS + isss;
            restante = e.salario - afp - isss;

            if(e.salario>= 0.01 && e.salario<= 472.00){
                renta = 0;
            }else if(e.salario>= 472.01 && e.salario<= 895.24){
                renta = 0.1*(restante - 472) + 17.67;
                totalRenta = totalRenta + renta;
            }else if(e.salario>= 895.25 && e.salario<= 2038.10){
                renta = 0.2*(restante - 895.24) + 60;
                totalRenta = totalRenta + renta;
            }else if(e.salario>= 2038.11){
                renta = 0.3*(restante - 2038.10) + 288.57;
                totalRenta = totalRenta + renta;
            }
            pago = restante - renta;
        }
        return pago;
    }

}
