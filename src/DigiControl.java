import java.util.Scanner;

public class DigiControl {
    private static final int[] ValoresConstantes = {1,2,4,8,5,10,9,7,3,6};
    public void IngresarDigitosControl() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese los 4 digitos del banco: ");
        String BancoDigitos = leer.next();
        System.out.print("Ingrese los 4 digitos de la sucursal: ");
        String SucursalDigitos = leer.next();
        System.out.print("Ingrese los 10 digitos de la cuenta: ");
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
        } else if (resultado == 11) {
            return "0";
        }
        return input;
    }

    public void VerificacionControDigitos() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese los 4 digitos del banco: ");
        String BancoDigitos = leer.next();
        System.out.print("Ingrese los 4 digitos de la sucursal: ");
        String SucursalDigitos = leer.next();
        System.out.print("Ingrese los 2 digitos de control: ");
        String ControlDigitos = leer.next();
        System.out.print("Ingrese los 10 digitos de la cuenta: ");
        String CuentaDigitos = leer.next();

        ValidarDigitosControl(BancoDigitos, SucursalDigitos, ControlDigitos, CuentaDigitos);
    }

    public void ValidarDigitosControl(String BancoDigitos, String SucursalDigitos, String ControlDigitos, String CuentaDigitos) {
        String DC1 = GenerarControlDigitos("00" + BancoDigitos + SucursalDigitos);
        String DC2 = GenerarControlDigitos(CuentaDigitos);

        String DigitsCalculados = DC1 + DC2;

        if (ControlDigitos.equals(DigitsCalculados)) {
            System.out.println("Número de cuenta a validar: " + BancoDigitos + " " + SucursalDigitos + " " + ControlDigitos + " " + CuentaDigitos);
            System.out.println("Dígitos calculados: " + DigitsCalculados + " Verificación: Correcta");
        } else {
            System.out.println("Número de cuenta a validar: " + BancoDigitos + " " + SucursalDigitos + " " + ControlDigitos + " " + CuentaDigitos);
            System.out.println("Dígitos calculados: " + DigitsCalculados + " Verificación: Incorrecta");
        }
    }
}