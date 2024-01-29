package PROG2T.PEP2T_2_JMMM;

import java.util.Scanner;

public class DigiControl {
    // Constantes para la generación de dígitos de control
    private final int[] ValoresConstantes = {1,2,4,8,5,10,9,7,3,6};

    // Atributos para los dígitos de banco, sucursal y cuenta
    public String BancoDigitos;
    public String SucursalDigitos;
    public String CuentaDigitos;

    // Constructor de DigiControl
    public DigiControl(String BDC, String SDC, String CDC) {
        BancoDigitos = BDC;
        SucursalDigitos = SDC;
        CuentaDigitos = CDC;
    }

    // Método para ingresar los dígitos de control y generar la salida
    public void IngresarDigitosControl() {
        // Ingresamos los dígitos
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese los 4 digitos del banco: ");
        String BancoDigitos = leer.next();
        System.out.print("Ingrese los 4 digitos de la sucursal: ");
        String SucursalDigitos = leer.next();
        System.out.print("Ingrese los 10 digitos de la cuenta: ");
        String CuentaDigitos = leer.next();

        // Generamos los dígitos de control
        String DC1 = GenerarControlDigitos("00" + BancoDigitos + SucursalDigitos);
        String DC2 = GenerarControlDigitos(CuentaDigitos);

        // Sacamos el resultado por pantalla
        System.out.println("2098 0008 DC1DC2 1207383832 --> " + BancoDigitos + " " + SucursalDigitos + " " + DC1 + DC2 + " " + CuentaDigitos);
    }

    // Método para generar dígitos de control
    private String GenerarControlDigitos(String input) {
        int acumulado = 0;
        char[] Digitos = input.toCharArray();

        // Cálculo del acumulado
        for (int i = 0; i < Digitos.length; i++) {
            int Numeros = Integer.parseInt(String.valueOf(Digitos[i]));
            acumulado += Numeros * ValoresConstantes[i];
        }

        // Cálculo de dividir(resto) y restar
        int resto = acumulado % 11;
        int resultado = 11 - resto;

        // Devolución del dígito de control (menor 1ue 9, 10 y 11)
        if (resultado <= 9) {
            return Integer.toString(resultado);
        } else if (resultado == 10) {
            return "1";
        } else if (resultado == 11) {
            return "0";
        }
        return input;
    }

    // Método para verificar los dígitos de control ingresados
    public void VerificacionControDigitos() {
        // Ingresamos los digitos para la verificación
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese los 4 digitos del banco: ");
        String BancoDigitos = leer.next();
        System.out.print("Ingrese los 4 digitos de la sucursal: ");
        String SucursalDigitos = leer.next();
        System.out.print("Ingrese los 2 digitos de control: ");
        String ControlDigitos = leer.next();
        System.out.print("Ingrese los 10 digitos de la cuenta: ");
        String CuentaDigitos = leer.next();

        // Validamos de los dígitos de control
        ValidarDigitosControl(BancoDigitos, SucursalDigitos, ControlDigitos, CuentaDigitos);
    }

    // Método para validar los dígitos de control
    public void ValidarDigitosControl(String BancoDigitos, String SucursalDigitos, String ControlDigitos, String CuentaDigitos) {
        // Generamos dígitos de control
        String DC1 = GenerarControlDigitos("00" + BancoDigitos + SucursalDigitos);
        String DC2 = GenerarControlDigitos(CuentaDigitos);

        // Concatenamos los dígitos de control
        String DigitosCalculados = DC1 + DC2;

        // Verificación y resultados
        if (ControlDigitos.equals(DigitosCalculados)) {
            System.out.println("Número de cuenta a validar: " + BancoDigitos + " " + SucursalDigitos + " " + ControlDigitos + " " + CuentaDigitos);
            System.out.println("Dígitos calculados: " + DigitosCalculados + " Verificación: Correcta");
        } else {
            System.out.println("Número de cuenta a validar: " + BancoDigitos + " " + SucursalDigitos + " " + ControlDigitos + " " + CuentaDigitos);
            System.out.println("Dígitos calculados: " + DigitosCalculados + " Verificación: Incorrecta");
        }
    }
}