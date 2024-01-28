import java.util.Scanner;
import java.math.BigInteger;

public class DigiIBAN {
    public String BancoDigitos;
    public String SucursalDigitos;
    public String ControlDigitos;
    public String CuentaDigitos;
    public String IBANDigitos;
    public String Final;

    public DigiIBAN(String BDI, String SDI, String CODI, String CUDI, String F, String IBD) {
        BancoDigitos = BDI;
        SucursalDigitos = SDI;
        ControlDigitos = CODI;
        CuentaDigitos = CUDI;
        Final = F;
        IBANDigitos = IBD;
    }

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

    public void GenerarIBAN(){
        String Numeros = BancoDigitos + SucursalDigitos + ControlDigitos + CuentaDigitos;

        String SecuenciaCompleta = Numeros + "1428" + "00";

        BigInteger SecuenciaNumerica = new BigInteger(SecuenciaCompleta);

        BigInteger Dividir97 = SecuenciaNumerica.remainder(new BigInteger("97"));

        BigInteger Resto98 = new BigInteger("98").subtract(Dividir97);

        String Valor = String.valueOf(Resto98);

        Integer Resultado = Integer.parseInt(Valor);

        if (Resultado <= 9) {
            Final = "ES0"+ Resultado;
        } else {
            Final = "ES"+ Resultado;
        }

        System.out.println("El resultado es: " + Final + " " +  BancoDigitos + " " + SucursalDigitos + " " + ControlDigitos + " " + CuentaDigitos);
    }

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

        if (Final.equals(IBANDigitos)) {
            System.out.println("Número de cuenta a validar: " + Final + " " +  BancoDigitos + " " + SucursalDigitos + " " + ControlDigitos + " " + CuentaDigitos);
            System.out.println("Dígitos calculados: " + Final + " Verificación: Correcta");
        } else {
            System.out.println("Número de cuenta a validar: " + Final + " " +  BancoDigitos + " " + SucursalDigitos + " " + ControlDigitos + " " + CuentaDigitos);
            System.out.println("Dígitos calculados: " + Final + " Verificación: Incorrecta");
        }
    }
}