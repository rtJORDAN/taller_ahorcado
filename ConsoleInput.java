import java.util.Scanner;

public class ConsoleInput {

    static Scanner sc = new Scanner(System.in);

    public static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int numero = Integer.parseInt(sc.nextLine());
                return numero;
            } catch (Exception e) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
            }
        }
    }

    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }
}