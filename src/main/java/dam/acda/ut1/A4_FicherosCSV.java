package dam.acda.ut1;

import java.io.*;
import java.util.Scanner;

public class A4_FicherosCSV {

    int sumaEdades = 0;
    int totalCampos = 0;

    public void start() {
        System.out.println("-----------------------------");
        System.out.println("--  UT1 - A4 Ficheros CSV  --");
        System.out.println("-----------------------------");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del fichero CSV (con ruta): ");
        String rutaFichero = scanner.nextLine();

        File fichero = new File(rutaFichero);

        // Comprobar si el fichero existe y no es un directorio
        if (!fichero.exists() || fichero.isDirectory()) {
            System.out.println("El fichero no existe o es un directorio.");
            return;
        }

        try {
            sumarEdades(fichero);
            escribirResultado(fichero);
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
            return;
        }
    }

    private void escribirResultado(File fichero) {
        String rutaResultado = fichero.getParent() + File.separator + "resultado.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaResultado))) {
            // Escribir la cabecera
            bw.write("Campos;Edades");
            bw.newLine();

            // Escribir los resultados
            bw.write(totalCampos + ";"+ sumaEdades);
            System.out.println("Resultados escritos en " + rutaResultado);
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero de resultados: " + e.getMessage());
        }
    }

    private void sumarEdades(File fichero) throws IOException {
        String linea;
        int campoEdad = -1;
        boolean primeraLinea = true;
        BufferedReader br = new BufferedReader(new FileReader(fichero));

        // Leer cada línea del fichero CSV
        while ((linea = br.readLine()) != null) {
            // Dividir la línea en campos usando la coma como delimitador
            String[] campos = linea.split("[;,]");

            // Busco la posición del campo Edad únicamente en la primera línea
            if (primeraLinea) {
                totalCampos = campos.length;
                for (int i = 0; i < campos.length; i++) {
                    // Guardar la posición del campo Edad
                    //     Si no existe mantendrá el -1 para evitar errores en caso de que no exita
                    if (campos[i].equalsIgnoreCase("Edad")) {
                        campoEdad = i;
                    }
                }
                primeraLinea = false;
            }
            else {
                sumaEdades += Integer.parseInt(campos[campoEdad].trim());
            }
        }
    }
}
