import java.util.ArrayList;

public class Main {

    static ArrayList<String[]> palabras = CargadorCSV.cargarPalabras();
    static int victorias = 0;

    public static void main(String[] args) {

        int opcion = 0;

        while (opcion != 4) {
            mostrarMenu();
            opcion = ConsoleInput.leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    jugar();
                    break;

                case 2:
                    mostrarInstrucciones();
                    break;

                case 3:
                    mostrarRecords();
                    break;

                case 4:
                    System.out.println("\nGracias por jugar.");
                    break;

                default:
                    System.out.println("\nOpción inválida.");
                    System.out.println("Debes ingresar un número entre 1 y 4.");
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("\n╔════════════════════════════╗");
        System.out.println("║          AHORCADO          ║");
        System.out.println("╠════════════════════════════╣");
        System.out.println("║  1. Jugar                  ║");
        System.out.println("║  2. Ver instrucciones      ║");
        System.out.println("║  3. Tabla de récords       ║");
        System.out.println("║  4. Salir                  ║");
        System.out.println("╚════════════════════════════╝");
    }

    public static void jugar() {

        if (palabras.size() == 0) {
            System.out.println("No se cargaron palabras desde el CSV.");
            return;
        }

        String[] categorias = {
            "ANIMALES",
            "TECNOLOGIA",
            "PAISES",
            "COLOMBIA",
            "PROGRAMACION"
        };

        System.out.println("\n╔════════════════════════════╗");
        System.out.println("║        CATEGORÍAS          ║");
        System.out.println("╠════════════════════════════╣");

        for (int i = 0; i < categorias.length; i++) {
            System.out.println("║  " + (i + 1) + ". " + categorias[i]);
        }

        System.out.println("╚════════════════════════════╝");

        int opcion = ConsoleInput.leerEntero("Seleccione categoría: ");

        if (opcion < 1 || opcion > categorias.length) {
            System.out.println("Categoría inválida. Debes elegir entre 1 y " + categorias.length + ".");
            return;
        }

        String categoria = categorias[opcion - 1];

        boolean gano = Juego.jugar(palabras, categoria);

        if (gano) {
            victorias++;
        }
    }

    public static void mostrarInstrucciones() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║              INSTRUCCIONES             ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("- Escribe tu nombre antes de jugar.");
        System.out.println("- Si escribes XACARANA, activas el Modo Dios.");
        System.out.println("- Selecciona una categoría.");
        System.out.println("- Adivina la palabra letra por letra.");
        System.out.println("- También puedes escribir la palabra completa.");
        System.out.println("- Escribe '-' para pedir pista.");
        System.out.println("- Pedir pista cuesta 1 error.");
        System.out.println("- Pierdes al llegar a 6 errores.");
    }

    public static void mostrarRecords() {
        System.out.println("\n╔════════════════════════════╗");
        System.out.println("║          RÉCORDS           ║");
        System.out.println("╚════════════════════════════╝");
        System.out.println("Victorias en esta sesión: " + victorias);
    }
}