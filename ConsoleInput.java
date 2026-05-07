import java.util.Scanner;

public class ConsoleInput {

    static Scanner sc = new Scanner(System.in);

    public static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String entrada = sc.nextLine();

                if (entrada.trim().isEmpty()) {
                    System.out.println("No puedes dejar el campo vacío.");
                    continue;
                }

                return Integer.parseInt(entrada);

            } catch (Exception e) {
                System.out.println("Entrada inválida. Debes ingresar solo números.");
            }
        }
    }

    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }
}