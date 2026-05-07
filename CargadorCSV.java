import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CargadorCSV {

    public static ArrayList<String[]> cargarPalabras() {

        ArrayList<String[]> lista = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("palabras.csv"));
            String linea = br.readLine();

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length >= 3) {
                    datos[0] = datos[0].trim();
                    datos[1] = datos[1].trim();
                    datos[2] = datos[2].trim();

                    lista.add(datos);
                }
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error al leer palabras.csv. Verifica que el archivo exista.");
        }

        return lista;
    }
}