import java.util.Scanner;

public class Juego {

    public static void jugar(String palabra, String pista) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = sc.nextLine();

        boolean modoEspecial = verificarEasterEgg(nombre);

        if (modoEspecial) {
            mostrarEasterEgg();
        }

        palabra = palabra.toLowerCase();

        char[] estado = new char[palabra.length()];

        for (int i = 0; i < estado.length; i++) {
            estado[i] = '_';
        }

        if (modoEspecial) {
            estado[0] = palabra.charAt(0);
            System.out.println("Bonus activado: se reveló la primera letra.");
        }

        int errores = 0;
        int maxErrores = 6;

        while (errores < maxErrores && !estaCompleta(estado)) {

            mostrarAhorcado(errores);
            mostrarPalabra(estado);

            System.out.println("Pista: " + pista);
            System.out.print("Ingrese una letra: ");

            String entrada = sc.nextLine().toLowerCase();

            if (entrada.length() != 1) {
                System.out.println("Debe ingresar solo una letra.");
                continue;
            }

            char letra = entrada.charAt(0);

            if (!Character.isLetter(letra)) {
                System.out.println("Debe ingresar una letra válida.");
                continue;
            }

            boolean acierto = validarLetra(letra, palabra, estado);

            if (acierto) {
                System.out.println("¡Correcto!");
            } else {
                System.out.println("Incorrecto.");
                errores++;
            }
        }

        if (estaCompleta(estado)) {
            System.out.println("\n¡Ganaste!");
            System.out.println("La palabra era: " + palabra);
        } else {
            mostrarAhorcado(errores);
            System.out.println("\nPerdiste.");
            System.out.println("La palabra era: " + palabra);
        }
    }

    public static boolean verificarEasterEgg(String nombre) {
        return nombre.equalsIgnoreCase("XACARANA");
    }

    public static void mostrarEasterEgg() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║        MODO XACARANA ACTIVADO        ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║     Has desbloqueado un bonus        ║");
        System.out.println("║     Se revelará la primera letra     ║");
        System.out.println("╚══════════════════════════════════════╝");
    }

    public static void mostrarAhorcado(int errores) {

        System.out.println("\n======= AHORCADO =======");
        System.out.println("Errores: " + errores + "/6");

        if (errores == 0) {
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("=========");
        } else if (errores == 1) {
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("  O   |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("=========");
        } else if (errores == 2) {
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("  O   |");
            System.out.println("  |   |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("=========");
        } else if (errores == 3) {
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("  O   |");
            System.out.println(" /|   |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("=========");
        } else if (errores == 4) {
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("  O   |");
            System.out.println(" /|\\  |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("=========");
        } else if (errores == 5) {
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("  O   |");
            System.out.println(" /|\\  |");
            System.out.println(" /    |");
            System.out.println("      |");
            System.out.println("=========");
        } else {
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("  O   |");
            System.out.println(" /|\\  |");
            System.out.println(" / \\  |");
            System.out.println("      |");
            System.out.println("=========");
        }
    }

    public static void mostrarPalabra(char[] estado) {
        System.out.print("\nPalabra: ");

        for (int i = 0; i < estado.length; i++) {
            System.out.print(estado[i] + " ");
        }

        System.out.println();
    }

    public static boolean validarLetra(char letra, String palabra, char[] estado) {

        boolean acierto = false;

        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                estado[i] = letra;
                acierto = true;
            }
        }

        return acierto;
    }

    public static boolean estaCompleta(char[] estado) {

        for (int i = 0; i < estado.length; i++) {
            if (estado[i] == '_') {
                return false;
            }
        }

        return true;
    }

    public static String seleccionarPalabraAleatoria(String[] palabras) {
        int posicion = (int)(Math.random() * palabras.length);
        return palabras[posicion];
    }
}