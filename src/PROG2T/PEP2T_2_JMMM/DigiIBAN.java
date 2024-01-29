package PROG2T.PEP2T_2_JMMM;

import java.util.Scanner;
import java.math.BigInteger;

public class DigiIBAN {
    // Atributos para los dígitos de banco, sucursal, control, cuenta, iban y "final"
    private String BancoDigitos;
    private String SucursalDigitos;
    private String ControlDigitos;
    private String CuentaDigitos;
    private String IBANDigitos;
    private String Final;

    //Constructor de DigiIBAN
    public DigiIBAN(String BDI, String SDI, String CODI, String CUDI, String F, String IBD) {
        BancoDigitos = BDI;
        SucursalDigitos = SDI;
        ControlDigitos = CODI;
        CuentaDigitos = CUDI;
        Final = F;
        IBANDigitos = IBD;
    }

    // Método para ingresar los dígitos del IBAN
    public void IngresarDigitosIBAN() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese los 4 digitos del banco: ");
        BancoDigitos = leer.next();
        System.out.print("Ingrese los 4 digitos de la sucursal: ");
        SucursalDigitos = leer.next();
        System.out.print("Ingrese los 2 digitos de control: ");
        ControlDigitos = leer.next();
        System.out.print("Ingrese los 10 digitos de la cuenta: ");
        CuentaDigitos = leer.next();
    }

    // Método para generar el IBAN
    public void GenerarIBAN(){
        // Concatenamos los dígitos para formar la secuencia numérica
        String Numeros = BancoDigitos + SucursalDigitos + ControlDigitos + CuentaDigitos;

        // Agregamos números al final "1428"(ES) Y "00"
        String SecuenciaCompleta = Numeros + "1428" + "00";

        // Creamos un objeto BigInteger para manejar grandes números
        BigInteger SecuenciaNumerica = new BigInteger(SecuenciaCompleta);

        // Cálculamos el resto al dividir entre 97
        BigInteger Dividir97 = SecuenciaNumerica.remainder(new BigInteger("97"));

        // Resto 98 menos el resultado anterior
        BigInteger Resto98 = new BigInteger("98").subtract(Dividir97);

        // Convertimos el resultado a String e Integer
        String Valor = String.valueOf(Resto98);
        int Resultado = Integer.parseInt(Valor);

        // Formato final del IBAN
        if (Resultado <= 9) {
            Final = "ES0"+ Resultado;
        } else {
            Final = "ES"+ Resultado;
        }

        // Mostramos el resultado por pantalla
        System.out.println("El resultado es: " + Final + " " +  BancoDigitos + " " + SucursalDigitos + " " + ControlDigitos + " " + CuentaDigitos);
    }

    // Método para verificar el IBAN
    public void VerificacionIBAN() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese los 4 digitos del IBAN: ");
        IBANDigitos = leer.next();
        System.out.print("Ingrese los 4 digitos del banco: ");
        BancoDigitos = leer.next();
        System.out.print("Ingrese los 4 digitos de la sucursal: ");
        SucursalDigitos = leer.next();
        System.out.print("Ingrese los 2 digitos de control: ");
        ControlDigitos = leer.next();
        System.out.print("Ingrese los 10 digitos de la cuenta: ");
        CuentaDigitos = leer.next();

        // Verificación y resultados
        if (Final.equals(IBANDigitos)) {
            System.out.println("Número de cuenta a validar: " + Final + " " +  BancoDigitos + " " + SucursalDigitos + " " + ControlDigitos + " " + CuentaDigitos);
            System.out.println("Dígitos calculados: " + Final + " Verificación: Correcta");
        } else {
            System.out.println("Número de cuenta a validar: " + Final + " " +  BancoDigitos + " " + SucursalDigitos + " " + ControlDigitos + " " + CuentaDigitos);
            System.out.println("Dígitos calculados: " + Final + " Verificación: Incorrecta");
        }
    }
}