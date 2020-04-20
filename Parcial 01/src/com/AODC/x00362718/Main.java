package com.AODC.x00362718;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        DecimalFormat formato1 = new DecimalFormat("0.00");
        byte opc = 0;
        String empleado, puesto, tipo, empresa;
        double salario, pago;
        int extension, contrato;
        System.out.print("\nIngrese el nombre de la empresa: "); empresa = in.nextLine();
        Empresa nuevaEmpresa = new Empresa(empresa);
        do{
            try {
                System.out.println(mainMenu());
                System.out.print("Opcion: ");
                opc = in.nextByte();in.nextLine();
            }
            catch (InputMismatchException e){
                System.out.print("\nPROBLEMA CON EL SCANNER");
                return;
            }
            switch (opc){
                case 1:
                    try {
                        System.out.print("\n¿Que tipo de empleado desea contratar? (plaza fija o servicio profesional): ");
                        tipo = in.nextLine();
                        if (tipo.equalsIgnoreCase("plaza fija")) {
                            System.out.print("\nIngrese el nombre del empleado: ");
                            empleado = in.nextLine();
                            System.out.print("Ingrese el puesto del empleado: ");
                            puesto = in.nextLine();
                            System.out.print("Ingrese el salario del empleado: ");
                            salario = in.nextDouble();in.nextLine();
                            if(salario <= 0)
                                throw new InvalidSalaryAmountException("SALARIO INVALIDO\n");
                            System.out.print("Ingrese el numero de extension del empleado: ");
                            extension = in.nextInt(); in.nextLine();
                            PlazaFija nuevoEmpleado = new PlazaFija(empleado, puesto, salario, extension);
                            anadirDocumentos(nuevoEmpleado);
                            nuevaEmpresa.addEmpleado(nuevoEmpleado);
                        } else if (tipo.equalsIgnoreCase("servicio profesional")) {
                            System.out.print("\nIngrese el nombre del empleado: ");
                            empleado = in.nextLine();
                            System.out.print("Ingrese el puesto del empleado: ");
                            puesto = in.nextLine();
                            System.out.print("Ingrese el salario del empleado: ");
                            salario = in.nextDouble();in.nextLine();
                            if(salario <= 0)
                                throw new InvalidSalaryAmountException("SALARIO INVALIDO\n");
                            System.out.print("Ingrese los meses de contrato del empleado: ");
                            contrato = in.nextInt();in.nextLine();
                            ServicioProfesional nuevoEmpleado = new ServicioProfesional(empleado, puesto, salario, contrato);
                            anadirDocumentos(nuevoEmpleado);
                            nuevaEmpresa.addEmpleado(nuevoEmpleado);
                        } else
                            System.out.print("¡OPCION NO VALIDA!\n");
                    }
                    catch (InvalidSalaryAmountException ex){
                        System.out.print(ex.getMessage());
                    }
                    catch (InputMismatchException e){
                        System.out.print("\nPROBLEMA CON EL SCANNER");
                        return;
                    }
                    break;

                case 2:
                    try{
                        Empleado quitEmpleado = null;
                        System.out.print("\nIngrese el nombre del empleado que desea despedir: "); empleado = in.nextLine();

                        for (Empleado e: nuevaEmpresa.getPlanilla()) {
                            if(e.getNombre().equalsIgnoreCase(empleado))
                                quitEmpleado = e;
                        }

                        if(quitEmpleado == null)
                            throw new NotExistingEmployeeException("EMPLEADO NO ENCONTRADO\n");

                        nuevaEmpresa.quitEmpleado(empleado);
                    }catch (NotExistingEmployeeException ex){
                        System.out.print(ex.getMessage());
                    }
                    break;

                case 3:
                    try{
                        if(nuevaEmpresa.getPlanilla().isEmpty())
                            throw new NotExistingEmployeeException("\nNO HAY EMPLEADOS REGISTRADOS\n");

                        System.out.println(nuevaEmpresa.toString());

                    }catch(NotExistingEmployeeException ex){
                        System.out.print(ex.getMessage());
                    }
                    break;

                case 4:
                    try{
                        if (nuevaEmpresa.getPlanilla().isEmpty())
                            throw new NotExistingEmployeeException("\nNO HAY EMPLEADOS REGISTRADOS\n");

                        Empleado pagarEmpleado = null;
                        System.out.print("\nIngrese el nombre del empleado: "); empleado = in.nextLine();

                        for (Empleado e: nuevaEmpresa.getPlanilla()) {
                            if(e.getNombre().equalsIgnoreCase(empleado)) {
                                pagarEmpleado = e;
                                pago=CalculadoraImpuestos.calcularPago(e);
                                System.out.print("Pago con descuentos: $" + formato1.format(pago) + "\n");
                            }
                        }
                        if(pagarEmpleado == null)
                            throw new NotExistingEmployeeException("EMPLEADO NO ENCONTRADO\n");

                    }catch(NotExistingEmployeeException ex){
                        System.out.print(ex.getMessage());
                    }
                    break;

                case 5:
                    System.out.println(CalculadoraImpuestos.mostrarTotales());
                    break;

                case 0:
                    System.out.print("\nCERRANDO PROGRAMA...");
                    break;

                default:
                    System.out.print("\n¡OPCION INGRESADA NO VALIDA!\n");
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
