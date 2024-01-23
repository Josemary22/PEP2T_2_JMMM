import java.util.Scanner;

public class DigiControl {
    private static final int[] ValoresConstantes = {1,2,4,8,5,10,9,7,3,6};
    public void IngresarDigitos() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese los 4 digitos del banco: ");
        String BancoDigitos = leer.next();
        System.out.println("Ingrese los 4 digitos de la sucursal: ");
        String SucursalDigitos = leer.next();
        System.out.println("Ingrese los 10 digitos de la cuenta: ");
        String CuentaDigitos = leer.next();

        String DC1 = GenerarControlDigitos("00" + BancoDigitos + SucursalDigitos);
        String DC2 = GenerarControlDigitos(CuentaDigitos);

        System.out.println("2098 0008 DC1DC2 1207383832 --> " + BancoDigitos + " " + SucursalDigitos + " " + DC1 + DC2 + " " + CuentaDigitos);
    }

    private static String GenerarControlDigitos(String input) {
        int acumulado = 0;
        char[] Digitos = input.toCharArray();
        for (int i = 0; i < Digitos.length; i++) {
            int Numeros = Character.getNumericValue(Digitos[i]);
            acumulado += Numeros * ValoresConstantes[i];
        }

        int resto = acumulado % 11;
        int resultado = 11 - resto;

        if (resultado <= 9) {
            return Integer.toString(resultado);
        } else if (resultado == 10) {
            return "1";
        } else {
            return "0";
        }
    }
}