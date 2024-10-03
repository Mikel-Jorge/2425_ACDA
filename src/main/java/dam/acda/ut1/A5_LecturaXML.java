package dam.acda.ut1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Scanner;

public class A5_LecturaXML {

    public void start() {
        System.out.println("-----------------------------");
        System.out.println("--  UT1 - A5 Lectura XML  ---");
        System.out.println("-----------------------------");

        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario el nombre del fichero XML
        System.out.print("Introduce la ruta o nombre del archivo XML: ");
        String filePath = scanner.nextLine();

        // Comprobar si el archivo existe y no es un directorio
        File file = new File(filePath);
        if (!file.exists() || file.isDirectory()) {
            System.out.println("El archivo no existe o es un directorio.");
            return;
        }

        procesarXML(file);
    }

    private void procesarXML(File file) {
        // Procesar el archivo XML
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            // Para quitar saltos de línea innecesarios etc...
            doc.getDocumentElement().normalize();

            // Obtener todos los elementos de "videojuego"
            NodeList listaVideojuegos = doc.getElementsByTagName("videojuego");

            // Recorrer cada uno de los videojuegos
            for (int i = 0; i < listaVideojuegos.getLength(); i++) {
                Node nodoVideojuego = listaVideojuegos.item(i);

                if (nodoVideojuego.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoVideojuego = (Element) nodoVideojuego;

                    mostrarVideojuego(elementoVideojuego);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mostrarVideojuego(Element elementoVideojuego) {
        System.out.println("---------------------------------------------------------------");
        // Obtener y mostrar el nombre del videojuego
        String nombre = elementoVideojuego.getElementsByTagName("nombre").item(0).getTextContent();
        System.out.println("Videojuego: " + nombre);

        // Mostrar popularidad
        String popularidad = elementoVideojuego.getAttribute("popularidad");
        System.out.println("Popularidad: " + popularidad);

        // Mostrar el año de lanzamiento
        String anio = elementoVideojuego.getElementsByTagName("anio").item(0).getTextContent();
        System.out.println("Año: " + anio);

        // Mostrar los beneficios
        String beneficios = elementoVideojuego.getElementsByTagName("beneficios").item(0).getTextContent();
        System.out.println("Beneficios: " + beneficios);

        // Mostrar las plataformas
        NodeList plataformas = elementoVideojuego.getElementsByTagName("plataforma");
        System.out.println("Plataformas: ");
        for (int j = 0; j < plataformas.getLength(); j++) {
            System.out.println("\t" + plataformas.item(j).getTextContent() + " ");
        }
        System.out.println();

        // Mostrar los géneros
        NodeList generos = elementoVideojuego.getElementsByTagName("genero");
        System.out.print("Géneros: ");
        for (int j = 0; j < generos.getLength(); j++) {
            System.out.println("\t" + generos.item(j).getTextContent() + " ");
        }
    }
}
