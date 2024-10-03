package dam.acda.ut1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class A2_Ficheros_Caracteres {

    public void start() {
        System.out.println("--------------------------------------");
        System.out.println("-  UT1 - A2 Ficheros por caracteres  -");
        System.out.println("--------------------------------------");

        Scanner scanner = new Scanner(System.in);

        // Pedimos al usuario que introduzca el nombre del fichero
        System.out.print("Introduce el nombre del fichero (puede incluir la ruta): ");
        String nombreFichero = scanner.nextLine();

        // Creamos un objeto File con el nombre del fichero proporcionado
        File file = new File(nombreFichero);

        // Comprobamos si el fichero existe
        if (!file.exists()) {
            System.out.println("El fichero no existe.");
            return;
        }

        // Comprobamos si es un directorio
        if (file.isDirectory()) {
            System.out.println("La ruta corresponde a un directorio, no a un fichero.");
            return;
        }

        // Si es un fichero, contamos las vocales
        try {
            contarVocalesEnFichero(file);
        } catch (IOException e) {
            System.out.println("No se ha podido leer el fichero.");
            e.printStackTrace();
        }
    }

    // Método para contar las vocales en el fichero
    private static void contarVocalesEnFichero(File file) throws IOException {
        FileReader fr = new FileReader(file);
        StringBuilder sb = new StringBuilder();
        int contadorVocales = 0;

        // Vamos leyendo el fichero si no hemos terminado
        while (fr.ready()) {
            // Leemos caracter a caracter
            char c = (char) fr.read();
            if (esVocal(c))
                contadorVocales++;
        }

        fr.close();
        System.out.println("El número total de vocales en el fichero es: " + contadorVocales);
    }

    // Método para comprobar si un carácter es una vocal
    private static boolean esVocal(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
