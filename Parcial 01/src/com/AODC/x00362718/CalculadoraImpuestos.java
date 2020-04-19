package com.AODC.x00362718;

public final class CalculadoraImpuestos {
    //Atributos
    private static double totalRenta = 0;
    private static double totalISSS = 0;
    private static double totalAFP = 0;
    //Constructor privado
    private CalculadoraImpuestos() {}
    //Metodos estaticos

    public static void mostrarTotales(){
        System.out.println("Total Renta: $" + totalRenta);
        System.out.println("Total ISSS: $" + totalISSS);
        System.out.println("Total AFP: $" + totalAFP);
    }

    public double calcularPago(Empleado e){
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

            if(restante>= 0.01 && restante<= 472.00){
                renta = 0;
            }else if(restante>= 472.01 && restante<= 895.24){
                renta = 0.1*(restante - 472) + 17.67;
                totalRenta = totalRenta + renta;
            }else if(restante>= 895.25 && restante<= 2038.10){
                renta = 0.2*(restante - 895.24) + 60;
                totalRenta = totalRenta + renta;
            }else if(restante>= 2038.11){
                renta = 0.3*(restante - 2038.10) + 288.57;
                totalRenta = totalRenta + renta;
            }
            pago = restante - renta;
        }
    }

}
