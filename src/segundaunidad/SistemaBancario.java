package segundaunidad;

import java.util.Scanner;

public class SistemaBancario {

    Scanner lectura = new Scanner(System.in);

    int contador = 0;
    int[] cuenta = new int[10];
    String[] nombre = new String[10];
    int[] dpi = new int[10];
    float[] monto = new float[10];
    int[] telefono = new int[10];
    String[] tipo = new String[10];

//    ENUNCIADO: Realizar la estructura de una aplicación de consola para el manejo
//    adecuado de diferentes procesos para un sistema bancario, deberá utlizar
//    conceptos de vectores y diferentes funciones para que la aplicación
//    sea de beneficio para el usuario.
    //FUNCIONALIDADES DE NUESTRA APLICACIÓN:
    //podrá guardar un máximo de 10 clientes en la BD.
    //Se solicitarán los siguintes datos: NO. DE CUENTA, NOMBRE COMPLETO, DPI,
    //                                    MONTO INICIAL, TELEFONO, TIPO_CUENTA.
    //EL CLIENTE PODRÁ SER CAPAZ DE REALIZAR LAS SIGUIENTES FUNCIONES:
    //          - depositar. (no. de cuenta.)
    //          - Retirar    (no.de cuenta, DPI)
    //          - PRESTAMOS (sí y sólo sí el usuario es cliente del banco)
    //          - MODIFICAR DATOS DEL CLIENTE (para ello se le solicita no.cuenta)
    //          - ELIMINAR CLIENTE....
    //          - MOSTRAR TODOS LOS USUARIOS.
    public void MENU() {
        int elegir;

        do {
            System.out.println(" ___     _     _  _   ___   _   _   ___     _     _    \n"
                    + " | _ )   /_\\   | \\| | | _ \\ | | | | | _ \\   /_\\   | |   \n"
                    + " | _ \\  / _ \\  | .` | |   / | |_| | |   /  / _ \\  | |__ \n"
                    + " |___/ /_/ \\_\\ |_|\\_| |_|_\\  \\___/  |_|_\\ /_/ \\_\\ |____|\n"
                    + "                                                        ");
            System.out.println("----------------MENU PRINCIPAL DEL SISTEMA-------------------");
            System.out.println("_____________________________________________________________");
            System.out.println("1. AGREGAR NUEVO CLIENTE AL SISTEMA.");
            System.out.println("2. REALIZAR DEPÓSITO");
            System.out.println("3. REALIZAR RETIRO");
            System.out.println("5. MODIFICAR DATOS");
            System.out.println("6. ELIMINAR CLIENTE");
            System.out.println("7. MOSTRAR TODOS LOS USUARIOS");
            System.out.println("8. SALIR DEL SISTEMA.");
            System.out.println("_____________________________________________________________");
            elegir = lectura.nextInt();

            //INICIAMOS NUESTRO SWITCH:
            switch (elegir) {
                case 1:
                    guardar();
                    break;
                case 2:
                    depositar();
                    break;
                case 3:
                    retirar();
                    break;
                case 5:
                    modificar();
                    break;
                case 6:
                    eliminar();
                    break;
                case 7:
                    mostrar();
                    break;
                case 8:
                    //salimos del sistema
                    break;

            }

        } while (elegir != 8);

    }

    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public void guardar() {
//     int[] cuenta = new int[10];
//    String[] nombre = new String[10];
//    int[] dpi = new int[10];
//    double[] monto = new double[10];
//    int[] telefono = new int[10];
//    String tipo = new String[10];

        if (contador > 9) {
            System.out.println("YA NO EXISTEN ESPACIOS DISPONIBLES PARA NUEVOS DATOS");
        } else {
            System.out.println("INGRESE LOS DATOS QUE SE SOLICITAN A CONTINUACION:");
            System.out.println("___________________________________________________");
            System.out.println("NO. DE CUENTA:");
            cuenta[contador] = lectura.nextInt();
            System.out.println("NOMBRE COMPLETO:");
            nombre[contador] = lectura.next();
            System.out.println("INGRESE DPI");
            dpi[contador] = lectura.nextInt();
            System.out.println("INGRESE MONTO INICIAL");
            monto[contador] = lectura.nextInt();
            System.out.println("INGRESE TELEFONO:");
            telefono[contador] = lectura.nextInt();
            System.out.println("seleccione  el tipo de cuenta...");
            System.out.println("1. monetaria");
            System.out.println("2. ahorro");
            int type = lectura.nextInt();
            switch (type) {
                case 1:
                    tipo[contador] = "monetaria";
                    break;
                case 2:
                    tipo[contador] = "ahorro";
                    break;
            }

            System.out.println("___________________________________________________");
            System.out.println("DATOS GUARDADOS CORRECTAMENTE.....");
            System.out.println("___________________________________________________");

            contador++;
            int espacios = 10 - contador;
            System.out.println("ESPACIOS DISPONIBLES: " + espacios + " de " + "10");

        }

    }

    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public void depositar() {
        int cuentaDep;
        System.out.println("____________________________________________________");
        System.out.println("INGRESE EL NO. DE CUENTA: ");
        cuentaDep = lectura.nextInt();

        for (int i = 0; i < 10; i++) {
            if (cuenta[i] == cuentaDep) {
                System.out.println("EL USUARIO ESTÁ REGISTRADO CON EL NOMBRE: " + nombre[i]);
                System.out.println("Desea todavía realizar el deposito?");
                System.out.println("1. SI.");
                System.out.println("2. NO");
                int dec = lectura.nextInt();
                switch (dec) {
                    case 1:
                        System.out.println("INGRESE EL MONTO A DEPOSITAR");
                        float montoDep = lectura.nextFloat();
                        float total = monto[i] + montoDep;
                        monto[i] = total;
                        System.out.println("DEPOSITO REALIZADO CORRECTAMENTE..!!!");
                        break;
                    case 2:
                        System.out.println("vuelva pronto....");
                        break;
                }
            }

        }

    }

    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public void retirar() {

        int cuentaR;
        int dpiR;
        System.out.println("____________________________________________________");
        System.out.println("INGRESE EL NO. DE CUENTA: ");
        cuentaR = lectura.nextInt();
        System.out.println("INGRESE SU DPI:");
        dpiR = lectura.nextInt();

        for (int i = 0; i < 10; i++) {
            if (cuenta[i] == cuentaR && dpi[i] == dpiR) {
                System.out.println("EL USUARIO ESTÁ REGISTRADO CON EL NOMBRE: " + nombre[i]);

                System.out.println("INGRESE EL MONTO A RETIRAR");
                float montoR = lectura.nextFloat();

                if (montoR <= monto[i]) {
                    float total = monto[i] - montoR;
                    monto[i] = total;
                    System.out.println("RETIRO REALIZADO CORRECTAMENTE..!!!");
                } else {
                    System.out.println("LA CUENTA NO TIENE LOS FONDOS SUFICIENTES... LO SENTIMOS :(");
                }

            }

        }

    }

    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public void prestamo() {

    }

    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public void modificar() {
        
        System.out.println("INGRESE LA CUENTA QUE DESEA MODIFICAR: ");
        int cuentaE = lectura.nextInt();

        for (int i = 0; i < 10; i++) {
            if (cuenta[i] == cuentaE) {
                System.out.println("EL USUARIO ESTÁ REGISTRADO CON EL NOMBRE: " + nombre[i]);

                System.out.println("Qué desea modificar del cliente?");
                System.out.println("1. NOMBRE.");
                System.out.println("2. DPI");
                System.out.println("3. TELEFONO");
                int dec = lectura.nextInt();
                switch (dec) {
                    case 1:
                        System.out.println("INGRESE EL NUEVO NOMBRE: ");
                        nombre[i] = lectura.next();
                        System.out.println("DATOS MODIFICADOS CORRECTAMENTE");                   
                        break;
                    case 2:
                       System.out.println("INGRESE EL NUEVO DPI: ");
                       dpi[i] = lectura.nextInt();
                       System.out.println("DATOS MODIFICADOS CORRECTAMENTE"); 
                        break;
                    case 3:
                        System.out.println("INGRESE EL NUEVO TELEFONO: ");
                        telefono[i] = lectura.nextInt();
                        System.out.println("DATOS MODIFICADOS CORRECTAMENTE"); 
                        break;
                }

            }

        }
            
    }

//    int contador = 0;
//    int[] cuenta = new int[10];
//    String[] nombre = new String[10];
//    int[] dpi = new int[10];
//    float[] monto = new float[10];
//    int[] telefono = new int[10];
//    String[] tipo = new String[10];
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public void eliminar() {

        System.out.println("INGRESE LA CUENTA QUE DESEA ELIMINAR: ");
        int cuentaE = lectura.nextInt();

        for (int i = 0; i < 10; i++) {
            if (cuenta[i] == cuentaE) {
                System.out.println("EL USUARIO ESTÁ REGISTRADO CON EL NOMBRE: " + nombre[i]);

                System.out.println("Desea todavía eliminar al cliente?");
                System.out.println("1. SI.");
                System.out.println("2. NO");
                int dec = lectura.nextInt();
                switch (dec) {
                    case 1:
                        cuenta[i] = 0;
                        nombre[i] = "";
                        dpi[i] = 0;
                        monto[i] = 0;
                        telefono[i] = 0;
                        tipo[i] = "";
                        System.out.println("DATOS ELIMINADOS CORRECTAMENTE");
                        break;
                    case 2:
                        System.out.println("vuelva pronto....");
                        break;
                }

            }

        }

    }
    
    //USUARIO1: BLA BLA BLA BLA...
    //USUARIO2:                ...
    //USUARIO3: BLA BLA BLA BLA...
    //USUARIO4: BLA BLA BLA BLA...
    //USUARIO5: BLA BLA BLA BLA...




    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public void mostrar() {
        for (int i = 0; i < 10; i++) {

            if (cuenta[i] != 0) {
                System.out.println("INFORMACIÓN DEL CLIENTE NO." + (i + 1));
                System.out.println("NO. CUENTA: " + cuenta[i] + "__" + " NOMBRE: " + nombre[i] + "__" + " DPI: " + dpi[i] + "__" + "MONTO: " + monto[i] + "__" + "TELEFONO: " + telefono[i] + "__" + "TIPO: " + tipo[i]);
                System.out.println("____________________________________________________________________");
            } else {
                
            }

        }
    }

    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
}
