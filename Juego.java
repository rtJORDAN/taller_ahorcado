import java.util.ArrayList;

public class Juego {

    public static boolean jugar(ArrayList<String[]> palabras, String categoria) {

        String nombre = ConsoleInput.leerTexto("\nIngrese su nombre: ");

        if (nombre.trim().isEmpty()) {
            nombre = "Jugador";
        }

        boolean modoDios = nombre.trim().equalsIgnoreCase("XACARANA");

        String[] seleccion = seleccionarPalabraAleatoria(palabras, categoria);

        if (seleccion == null) {
            System.out.println("No hay palabras disponibles en esta categoría.");
            return false;
        }

        String palabra = seleccion[1].trim().toUpperCase();
        String pista = seleccion[2].trim();

        int errores = 0;
        boolean pistaUsada = false;
        String letrasUsadas = "";

        char[] estado = new char[palabra.length()];

        for (int i = 0; i < estado.length; i++) {
            estado[i] = '_';
        }

        if (modoDios) {
            mostrarModoDios();

            if (palabra.length() > 0) {
                validarLetra(palabra.charAt(0), palabra, estado);
            }
        }

        while (errores < 6 && !estaCompleta(estado)) {

            limpiarPantalla();

            System.out.println("╔════════════════════════════════════╗");
            System.out.println("║             AHORCADO               ║");
            System.out.println("╠════════════════════════════════════╣");
            System.out.println("║ Jugador: " + nombre);
            System.out.println("║ Categoría: " + categoria);

            if (modoDios) {
                System.out.println("║ Modo: DIOS ACTIVADO");
}
            System.out.println("╚════════════════════════════════════╝");

            mostrarAhorcado(errores);
            mostrarPalabra(estado);

            System.out.println("\nLetras usadas: " + letrasUsadas);

            if (pistaUsada) {
                System.out.println("Pista: " + pista);
            } else {
                System.out.println("Para pedir pista escribe: -");
            }

            System.out.println("Puedes ingresar una letra o la palabra completa.");

            String entrada = ConsoleInput.leerTexto("Ingrese letra o palabra: ");
            entrada = entrada.trim().toUpperCase();

            if (entrada.equals("-")) {
                if (!pistaUsada) {
                    System.out.println("\nPISTA: " + pista);
                    pistaUsada = true;
                    errores++;
                } else {
                    System.out.println("\nYa usaste la pista.");
                }
                continue;
            }

            if (entrada.length() == 0) {
                System.out.println("No puedes dejar el campo vacío.");
                continue;
            }

            if (!soloLetras(entrada)) {
                System.out.println("Entrada inválida.");
                System.out.println("- Solo puedes ingresar letras.");
                System.out.println("- Para pedir pista usa únicamente el símbolo '-'.");
                System.out.println("- No uses números ni caracteres especiales.");
                continue;
            }

            if (entrada.length() > 1) {
                if (entrada.equals(palabra)) {
                    for (int i = 0; i < palabra.length(); i++) {
                        estado[i] = palabra.charAt(i);
                    }
                    System.out.println("¡Correcto! Adivinaste la palabra completa.");
                } else {
                    System.out.println("Palabra incorrecta.");
                    errores++;
                }
                continue;
            }

            char letra = entrada.charAt(0);

            if (letrasUsadas.indexOf(letra) != -1) {
                System.out.println("Ya usaste esa letra. Intenta con otra.");
                continue;
            }

            letrasUsadas = letrasUsadas + letra + " ";

            boolean acierto = validarLetra(letra, palabra, estado);

            if (acierto) {
                System.out.println("¡Correcto!");
            } else {
                System.out.println("Incorrecto.");
                errores++;
            }
        }

        limpiarPantalla();
        mostrarAhorcado(errores);

        if (estaCompleta(estado)) {
            System.out.println("\n╔════════════════════════════╗");
            System.out.println("║          ¡GANASTE!         ║");
            System.out.println("╚════════════════════════════╝");
            System.out.println("Jugador: " + nombre);
            System.out.println("Categoría: " + categoria);
            System.out.println("La palabra era: " + palabra);
            return true;
        } else {
            System.out.println("\n╔════════════════════════════╗");
            System.out.println("║          PERDISTE          ║");
            System.out.println("╚════════════════════════════╝");
            System.out.println("Jugador: " + nombre);
            System.out.println("Categoría: " + categoria);
            System.out.println("La palabra era: " + palabra);
            return false;
        }
    }

    public static String[] seleccionarPalabraAleatoria(ArrayList<String[]> palabras, String categoria) {
        ArrayList<String[]> filtradas = new ArrayList<>();

        for (String[] fila : palabras) {
            if (fila[0].trim().equalsIgnoreCase(categoria)) {
                filtradas.add(fila);
            }
        }

        if (filtradas.size() == 0) {
            return null;
        }

        int posicion = (int)(Math.random() * filtradas.size());
        return filtradas.get(posicion);
    }

    public static boolean validarLetra(char letra, String palabra, char[] estado) {
        boolean encontrada = false;

        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                estado[i] = letra;
                encontrada = true;
            }
        }

        return encontrada;
    }

    public static void mostrarPalabra(char[] estado) {
        System.out.print("\nPalabra: ");

        for (int i = 0; i < estado.length; i++) {
            System.out.print(estado[i] + " ");
        }

        System.out.println();
    }

    public static boolean estaCompleta(char[] estado) {
        for (int i = 0; i < estado.length; i++) {
            if (estado[i] == '_') {
                return false;
            }
        }

        return true;
    }

    public static boolean soloLetras(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            if (!Character.isLetter(texto.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static void mostrarModoDios() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║        MODO DIOS ACTIVADO            ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  Código secreto: XACARANA            ║");
        System.out.println("║  Se reveló la primera letra          ║");
        System.out.println("╚══════════════════════════════════════╝");
    }

    public static void mostrarAhorcado(int errores) {
        String cabeza = (errores >= 1) ? "O" : " ";
        String cuerpo = (errores >= 2) ? "|" : " ";
        String brazoIzq = (errores >= 3) ? "/" : " ";
        String brazoDer = (errores >= 4) ? "\\" : " ";
        String piernaIzq = (errores >= 5) ? "/" : " ";
        String piernaDer = (errores >= 6) ? "\\" : " ";

        System.out.println("\n╔════════════════════╗");
        System.out.println("║      AHORCADO      ║");
        System.out.println("╠════════════════════╣");
        System.out.println("║ Errores: " + errores + "/6        ║");
        System.out.println("╠════════════════════╣");
        System.out.println("║        ┌─────┐     ║");
        System.out.println("║        │     │     ║");
        System.out.println("║        " + cabeza + "     │     ║");
        System.out.println("║       " + brazoIzq + cuerpo + brazoDer + "    │     ║");
        System.out.println("║       " + piernaIzq + " " + piernaDer + "    │     ║");
        System.out.println("║              │     ║");
        System.out.println("║     ═══════════    ║");
        System.out.println("╚════════════════════╝");
    }

    public static void limpiarPantalla() {
    System.out.println("\n\n");
        }
    }