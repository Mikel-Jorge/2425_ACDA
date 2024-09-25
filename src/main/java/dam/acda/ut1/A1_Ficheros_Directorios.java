package dam.acda.ut1;

import java.io.File;

public class A1_Ficheros_Directorios {

    public void start(String[] args) {
        // Verificamos si se ha pasado un argumento
        if (args.length == 0) {
            System.out.println("Por favor, proporciona una ruta de archivo o directorio.");
            return;
        }

        // Obtenemos el parámetro (la ruta del fichero o directorio)
        String path = args[0];
        File file = new File(path);

        // Comprobamos si el fichero o directorio existe
        if (!file.exists()) {
            System.out.println("El archivo o directorio no existe.");
            return;
        }

        // Comprobamos si es un fichero
        if (file.isFile()) {
            System.out.println("Es un fichero.");
            mostrarInformacionArchivo(file);
        }
        // Comprobamos si es un directorio
        else if (file.isDirectory()) {
            System.out.println("Es un directorio.");
            mostrarInformacionDirectorio(file);
        }
    }

    // Método para mostrar información de un archivo (fichero)
    private void mostrarInformacionArchivo(File file) {
        System.out.println("Tamaño del fichero: " + file.length() + "B");
        System.out.println("Permisos:");
        System.out.println("  Lectura: " + (file.canRead() ? "Sí" : "No"));
        System.out.println("  Escritura: " + (file.canWrite() ? "Sí" : "No"));
        System.out.println("  Ejecución: " + (file.canExecute() ? "Sí" : "No"));
    }

    // Método para mostrar información de un directorio
    private long mostrarInformacionDirectorio(File dir) {
        long tamanoTotal = 0;
        System.out.println("Contenido del directorio '" + dir.getName() + "'");

        // Obtenemos el listado de ficheros y directorios
        File[] files = dir.listFiles();

        if (files != null && files.length > 0) {
            for (File f : files) {
                if (f.isFile()) {
                    tamanoTotal += f.length();
                    System.out.println("\tFichero: " + f.getName() + " (Tamaño: " + f.length() + " bytes)");
                } else if (f.isDirectory()) {
                    System.out.println("\tDirectorio: " + f.getName());
                    tamanoTotal += mostrarInformacionDirectorio(f); // Llamada recursiva para subdirectorios
                }
            }
        } else {
            System.out.println("  El directorio '" + dir.getName() + "' está vacío.");
        }

        // Mostrar el tamaño del directorio
        System.out.println("Tamaño total del directorio '" + dir.getName() + "': " + tamanoTotal + "B");
        return tamanoTotal;
    }
}
