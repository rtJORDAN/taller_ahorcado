import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CargadorCSV {

    public static void cargarPalabras() {

        String archivo = "palabras.csv";
        String linea;

        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));

            br.readLine();

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                String categoria = datos[0];
                String palabra = datos[1];
                String pista = datos[2];

                System.out.println("Categoría: " + categoria);
                System.out.println("Palabra: " + palabra);
                System.out.println("Pista: " + pista);
                System.out.println("----------------------");
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo palabras.csv");
        }
    }
}