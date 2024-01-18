import java.util.Scanner;

public class DigiControl {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese los 4 digitos del banco: ");
        String BancoDigitos = leer.next();
        System.out.println("Ingrese los 4 digitos de la sucursal: ");
        String SucursalDigitos = leer.next();
        System.out.println("Ingrese los 10 digitos de la cuenta: ");
        String CuentaDigitos = leer.next();
    }
}
