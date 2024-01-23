import java.util.Scanner;
public class PilotDigits {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        boolean menu = true;
        DigiControl objeto = new DigiControl();
        while(menu) {
            System.out.println("Menú de opciones");
            System.out.println("================");
            System.out.println("1) Generar digitos de control");
            System.out.println("2) Verificar digitos de control");
            System.out.println("3) Generar digitos del IBAN");
            System.out.println("4) Verificar digitos del IBAN");
            System.out.println("5) Salir");
            System.out.println("Opción: ");
            int opcion = leer.nextInt();
            // Estructura switch para manejar la opción seleccionada
            switch (opcion) {
                case 1:
                    objeto.IngresarDigitos();
                    break;
            }
        }
    }
}
