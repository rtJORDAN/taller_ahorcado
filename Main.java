public class Main {

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
                    System.out.println("\nGracias por jugar. Hasta luego.");
                    break;

                default:
                    System.out.println("\nOpción inválida. Debe elegir entre 1 y 4.");
                    break;
            }
        }
    }

    public static void mostrarMenu() {

        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║              AHORCADO                ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  1. Jugar                            ║");
        System.out.println("║  2. Ver instrucciones                ║");
        System.out.println("║  3. Tabla de récords                 ║");
        System.out.println("║  4. Salir                            ║");
        System.out.println("╚══════════════════════════════════════╝");
    }

    public static void jugar() {

        System.out.println("\nIniciando juego...");

        // Por ahora se prueba con una palabra fija
        Juego.jugar("elefante", "Mamífero grande con trompa");
    }

    public static void mostrarInstrucciones() {

        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║             INSTRUCCIONES            ║");
        System.out.println("╚══════════════════════════════════════╝");

        System.out.println("- Debes adivinar la palabra oculta.");
        System.out.println("- Ingresa una letra por turno.");
        System.out.println("- Si la letra está en la palabra, se mostrará.");
        System.out.println("- Si la letra no está, se suma un error.");
        System.out.println("- Pierdes al llegar a 6 errores.");
        System.out.println("- Ganas si completas la palabra.");
    }

    public static void mostrarRecords() {

        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║            TABLA DE RÉCORDS          ║");
        System.out.println("╚══════════════════════════════════════╝");

        System.out.println("Aún no hay récords registrados.");
    }
}