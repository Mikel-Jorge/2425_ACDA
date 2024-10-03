package dam.acda.ut1;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class A8_FicherosBinarios {
    public void start() {
        System.out.println("------------------------------");
        System.out.println("--  UT1 - A7 Ficheros JSON  --");
        System.out.println("------------------------------");

        // Crear una lista de álbums
        List<Album> albums = crearAlbums();

        // Guardar los albums en un fichero binario
        String nombreFichero = "src/main/resources/UT1/albums.dat";
        guardarAlbums(nombreFichero, albums);

        // Leer los álbums del fichero binario y mostrarlos por consola
        List<Album> albumsLeidos = leerAlbums(nombreFichero);
        if (albumsLeidos != null) {
            for (Album album : albumsLeidos) {
                System.out.println(album);
            }
        }
    }

    private List<Album> crearAlbums() {
        // Crear tres álbums con cinco canciones cada uno
        Album album1 = new Album("The Beatles", LocalDate.of(1969, 9, 26));
        album1.agregarCancion(new Cancion("Come Together", 4.20, 9.5));
        album1.agregarCancion(new Cancion("Something", 3.03, 8.1));
        album1.agregarCancion(new Cancion("Maxwell's Silver Hammer", 3.27, 8.5));
        album1.agregarCancion(new Cancion("Oh! Darling", 3.27, 8.6));
        album1.agregarCancion(new Cancion("Octopus's Garden", 2.51, 7.0));

        Album album2 = new Album("Pink Floyd", LocalDate.of(1973, 3, 1));
        album2.agregarCancion(new Cancion("Speak to Me", 1.30, 3.5));
        album2.agregarCancion(new Cancion("Breathe", 2.43, 5.0));
        album2.agregarCancion(new Cancion("Time", 6.53, 11.3));
        album2.agregarCancion(new Cancion("Money", 6.22, 10.7));
        album2.agregarCancion(new Cancion("Us and Them", 7.51, 12.0));

        Album album3 = new Album("Queen", LocalDate.of(1975, 11, 21));
        album3.agregarCancion(new Cancion("Bohemian Rhapsody", 5.55, 12.5));
        album3.agregarCancion(new Cancion("Love of My Life", 3.39, 7.8));
        album3.agregarCancion(new Cancion("You're My Best Friend", 2.50, 7.0));
        album3.agregarCancion(new Cancion("God Save the Queen", 1.15, 3.2));
        album3.agregarCancion(new Cancion("I'm In Love With My Car", 3.05, 7.4));

        // Crear una lista de álbumes
        List<Album> albums = new ArrayList<>();
        albums.add(album1);
        albums.add(album2);
        albums.add(album3);
        return albums;
    }

    // Método para guardar álbums en un fichero binario
    public static void guardarAlbums(String nombreFichero, List<Album> albums) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreFichero))) {
            oos.writeObject(albums);
            System.out.println("Álbums guardados en el fichero " + nombreFichero);
        } catch (IOException e) {
            System.err.println("Error al guardar los álbumes: " + e.getMessage());
        }
    }

    // Método para leer álbums desde un fichero binario
    @SuppressWarnings("unchecked")
    public static List<Album> leerAlbums(String nombreFichero) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreFichero))) {
            System.out.println("\nLectura de fichero binario:");
            return (List<Album>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer los álbumes: " + e.getMessage());
        }
        return null;
    }
}

// Clase Canción
class Cancion implements Serializable {
    private String titulo;
    private double duracion; // en minutos
    private double tamano;   // en MB

    // Constructor
    public Cancion(String titulo, double duracion, double tamano) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.tamano = tamano;
    }

    // Método para imprimir la información de la canción
    public String toString() {
        return "Canción: " + titulo + ", Duración: " + duracion + " min, Tamaño: " + tamano + " MB";
    }
}

// Clase Álbum
class Album implements Serializable {
    private String nombreGrupo;
    private LocalDate fechaPublicacion;
    private List<Cancion> canciones;

    // Constructor
    public Album(String nombreGrupo, LocalDate fechaPublicacion) {
        this.nombreGrupo = nombreGrupo;
        this.fechaPublicacion = fechaPublicacion;
        this.canciones = new ArrayList<>();
    }

    // Método para agregar una canción al álbum
    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    // Método para imprimir la información del álbum
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Grupo: ").append(nombreGrupo)
                .append(", Fecha de publicación: ").append(fechaPublicacion)
                .append("\nCanciones:\n");

        for (Cancion cancion : canciones) {
            sb.append("\t- ").append(cancion.toString()).append("\n");
        }

        return sb.toString();
    }
}