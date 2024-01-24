import java.util.Scanner;
public class PilotDigits {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        boolean menu = true;
        DigiControl objeto = new DigiControl("","","");
        DigiIBAN objeto2 = new DigiIBAN("","","");
        while(menu) {
            System.out.println("\033[1m\t  Menú de Opciones\033[0m");
            System.out.println("\033[1m\t  ================\033[0m");
            System.out.println("1) Generar digitos de control");
            System.out.println("2) Verificar digitos de control");
            System.out.println("3) Generar digitos del IBAN");
            System.out.println("4) Verificar digitos del IBAN");
            System.out.println("5) Salir");
            System.out.print("Opción: ");
            int opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    objeto.IngresarDigitosControl();
                    break;
                case 2:
                    objeto.VerificacionControDigitos();
                    break;
                case 3:
                    objeto2.IngresarDigitosIban();
                    break;
                case 4:
                    objeto2.VerificacionIBAN();
                    break;
                case 5:
                    menu = false;
                    break;
            }
        }
    }
}