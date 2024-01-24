import java.util.Scanner;
import java.math.BigInteger;

public class DigiIBAN {
    public String BancoDigitos;
    public String SucursalDigitos;
    public String CuentaDigitos;

    public DigiIBAN(String BDI, String SDI, String CDI) {
        BancoDigitos = BDI;
        SucursalDigitos = SDI;
        CuentaDigitos = CDI;
    }

    public void IngresarDigitosIban() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese los 4 digitos del banco: ");
        String BancoDigitos = leer.next();
        System.out.print("Ingrese los 4 digitos de la sucursal: ");
        String SucursalDigitos = leer.next();
        System.out.print("Ingrese los 2 digitos de control: ");
        String ControlDigitos = leer.next();
        System.out.print("Ingrese los 10 digitos de la cuenta: ");
        String CuentaDigitos = leer.next();

    }
}