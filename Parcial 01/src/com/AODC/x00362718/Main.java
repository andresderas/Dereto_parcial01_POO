package com.AODC.x00362718;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        DecimalFormat formato1 = new DecimalFormat("0.00");
        byte opc=0;
        String empleado, puesto, tipo, empresa;
        double salario, pago;
        int extension, contrato, contador;
        System.out.print("\nIngrese el nombre de la empresa: "); empresa = in.nextLine();
        Empresa nuevaEmpresa = new Empresa(empresa);
        do{
            System.out.println(mainMenu());
            System.out.print("Opcion: "); opc = in.nextByte(); in.nextLine();
            switch (opc){
                case 1:
                    System.out.print("\n¿Que tipo de empleado desea contratar? (plaza fija o servicio profesional): "); tipo = in.nextLine();
                    if(tipo.equalsIgnoreCase("plaza fija")){
                        System.out.print("\nIngrese el nombre del empleado: "); empleado = in.nextLine();
                        System.out.print("Ingrese el puesto del empleado: "); puesto = in.nextLine();
                        System.out.print("Ingrese el salario del empleado: "); salario = in.nextDouble(); in.nextLine();
                        System.out.print("Ingrese el numero de extension del empleado: "); extension = in.nextInt(); in.nextLine();
                        PlazaFija nuevoEmpleado = new PlazaFija(empleado,puesto,salario,extension);
                        anadirDocumentos(nuevoEmpleado);
                        nuevaEmpresa.addEmpleado(nuevoEmpleado);
                    }
                    else if(tipo.equalsIgnoreCase("servicio profesional")){
                        System.out.print("\nIngrese el nombre del empleado: "); empleado = in.nextLine();
                        System.out.print("Ingrese el puesto del empleado: "); puesto = in.nextLine();
                        System.out.print("Ingrese el salario del empleado: "); salario = in.nextDouble(); in.nextLine();
                        System.out.print("Ingrese los meses de contrato del empleado: "); contrato = in.nextInt(); in.nextLine();
                        ServicioProfesional nuevoEmpleado = new ServicioProfesional(empleado,puesto,salario,contrato);
                        anadirDocumentos(nuevoEmpleado);
                        nuevaEmpresa.addEmpleado(nuevoEmpleado);
                    }
                    else
                        System.out.print("¡OPCION NO VALIDA!");
                    break;

                case 2:
                    System.out.print("\nIngrese el nombre del empleado que desea despedir: "); empleado = in.nextLine();
                    nuevaEmpresa.quitEmpleado(empleado);
                    break;

                case 3:
                    if(nuevaEmpresa.getPlanilla().isEmpty())
                        System.out.print("\nNO HAY EMPLEADOS REGISTRADOS");
                    else
                        nuevaEmpresa.toString();
                    break;

                case 4:
                    System.out.print("\nIngrese el nombre del empleado: "); empleado = in.nextLine();
                    contador = 0;

                    if (nuevaEmpresa.getPlanilla().isEmpty())
                        System.out.print("NO HAY EMPLEADOS REGISTRADOS\n");
                    else {
                        for (Empleado aux : nuevaEmpresa.getPlanilla()) {
                            if (aux.getNombre().equalsIgnoreCase(empleado)) {
                                pago=CalculadoraImpuestos.calcularPago(aux);
                                System.out.print("Pago con descuentos: $" + formato1.format(pago) + "\n");
                                contador++;
                            }
                        }
                        if (contador == 0)
                            System.out.print("EMPLEADO NO ENCONTRADO");
                    }
                    break;

                case 5:
                    CalculadoraImpuestos.mostrarTotales();
                    break;

                case 0:
                    System.out.print("\nCERRANDO PROGRAMA...");
                    break;

                default:
                    System.out.print("¡OPCION INGRESADA NO VALIDA!");
                    break;
            }

        }while(opc != 0);
    }
    //Menu
    static String mainMenu(){
        return "\n1. Agregar empleado\n2. Despedir empleado\n3. Ver lista de empleados\n4. Calcular sueldo\n5. Mostrar totales" +
                "\n0. Salir";
    }
    //Funcion que añade documentos en el caso de plaza fija
    public static void anadirDocumentos(PlazaFija p){
        String documento, numero;
        String agregarOtro = "si";
        System.out.print("Documentos empleado:\nIngrese nombre del documento: "); documento = in.nextLine();
        System.out.print("Ingrese el numero de " + documento + ": "); numero = in.nextLine();
        Documento nuevoDocumento = new Documento(documento,numero);
        p.addDocumento(nuevoDocumento);

        do{
            System.out.print("¿Desea agregar otro documento? (Si/No): "); agregarOtro = in.nextLine();
            if(agregarOtro.equalsIgnoreCase("si")) {
                System.out.print("Ingrese nombre del documento: "); documento = in.nextLine();
                System.out.print("Ingrese el numero de " + documento + ": "); numero = in.nextLine();
                nuevoDocumento = new Documento(documento, numero);
                p.addDocumento(nuevoDocumento);
            }
        }while(agregarOtro.equalsIgnoreCase("si"));
    }
    //Funcion que añade documentos en el caso servicio profesional
    public static void anadirDocumentos(ServicioProfesional p){
        String documento, numero;
        String agregarOtro = "si";
        System.out.print("Documentos empleado:\nIngrese nombre del documento: "); documento = in.nextLine();
        System.out.print("Ingrese el numero de " + documento + ": "); numero = in.nextLine();
        Documento nuevoDocumento = new Documento(documento,numero);
        p.addDocumento(nuevoDocumento);

        do{
            System.out.print("¿Desea agregar otro documento? (Si/No): "); agregarOtro = in.nextLine();
            if(agregarOtro.equalsIgnoreCase("si")) {
                System.out.print("Ingrese nombre del documento: "); documento = in.nextLine();
                System.out.print("Ingrese el numero de " + documento + ": "); numero = in.nextLine();
                nuevoDocumento = new Documento(documento, numero);
                p.addDocumento(nuevoDocumento);
            }
        }while(agregarOtro.equalsIgnoreCase("si"));
    }


}
