package PROG2T.PEP2T_2_JMMM;

import java.util.Scanner;
import java.util.InputMismatchException;

// Metodo para el menú
public class PilotDigits {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        boolean menu = true;

        // Creamos instancias de las clases DigiControl y DigiIBAN
        DigiControl objeto = new DigiControl("","","");
        DigiIBAN objeto2 = new DigiIBAN("","","", "", "", "");

        // Bucle del menú
        while(menu) {
            // Menú de opciones
            System.out.println("\t \t Menú de Opciones");
            System.out.println("\t \t ================");
            System.out.println("\t 1) Generar digitos de control");
            System.out.println("\t 2) Verificar digitos de control");
            System.out.println("\t 3) Generar digitos del IBAN");
            System.out.println("\t 4) Verificar digitos del IBAN");
            System.out.println("\t 5) Salir");
            System.out.print("\t \t Opción: ");
            try {
                // Lectura de la opción ingresada por el usuario
                int opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    // Llamamos al método de ingreso de dígitos de control
                    objeto.IngresarDigitosControl();
                    break;
                case 2:
                    // Llamamos al método de verificación de dígitos de control
                    objeto.VerificacionControDigitos();
                    break;
                case 3:
                    // Llamamos a los métodos de ingreso y generación de dígitos del IBAN
                    objeto2.IngresarDigitosIBAN();
                    objeto2.GenerarIBAN();
                    break;
                case 4:
                    // Llamamos al método de verificación de dígitos del IBAN
                    objeto2.VerificacionIBAN();
                    break;
                case 5:
                    // Salida del bucle y finalización del programa
                    menu = false;
                    break;
                default:
                    System.out.println("Opción incorrecta, ingrese un número del 1 al 5");
            }
        } catch (InputMismatchException e) {
                // Excepción en caso de escribir letras
                System.out.println("Opción incorrecta, ingrese una de las opciones");
                leer.next();
            }
        }
    }
}