package dam.acda.ut1;

import java.io.*;
import java.util.Scanner;

public class A3_Ficheros_Completo {

    int contadorLineas = 0;
    int contadorPalabras = 0;

    public void start() {
        System.out.println("-----------------------------------");
        System.out.println("--  UT1 - A3 Ficheros Completos  --");
        System.out.println("-----------------------------------");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del fichero (con ruta): ");
        String rutaFichero = scanner.nextLine();

        File fichero = new File(rutaFichero);

        // Comprobar si el fichero existe y no es un directorio
        if (!fichero.exists() || fichero.isDirectory()) {
            System.out.println("El fichero no existe o es un directorio.");
            return;
        }

        try {
            // Contar líneas y palabras
            contarLineasPalabras(fichero);

            // Escribir resultados en resultado.txt
            escribirFichero(fichero);
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }

    private void escribirFichero(File fichero) {
        String rutaResultado = fichero.getParent() + File.separator + "resultado.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaResultado))) {
            bw.write("Número de líneas: " + contadorLineas + "\n");
            bw.write("Número de palabras: " + contadorPalabras + "\n");

            System.out.println("Resultados escritos en " + rutaResultado);
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero de resultados: " + e.getMessage());
        }
    }

    private void contarLineasPalabras(File fichero) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contadorLineas++;

                // Evitamos las líneas vacías
                if (!linea.isEmpty() && !linea.isBlank()) {
                    // Contar palabras, separando por espacios
                    String[] palabras = linea.trim().split("\\s+");
                    contadorPalabras += palabras.length;
                }
            }
        } catch (IOException e) {
            throw e;
        }
    }
}
