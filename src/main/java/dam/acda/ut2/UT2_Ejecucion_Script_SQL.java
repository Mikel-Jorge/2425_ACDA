package dam.acda.ut2;

import dam.acda.ut2.db.conection.ConexionBD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class UT2_Ejecucion_Script_SQL {
    public void start() {
        System.out.println("--------------------------------------");
        System.out.println("--  UT2.4.1 - Ejecución Script SQL  --");
        System.out.println("--------------------------------------");

        String fichero = "src/main/resources/SQL/videojuegos.sql";
        try {
            String contenidoFicheroSQL = leerFicheroSQL(fichero);

            ConexionBD conexionBD = ConexionBD.getInstancia();
            if (conexionBD.getConexion() != null) {
                // Ejecutar todas las consultas en un único executeUpdate()
                try (Statement stmt = conexionBD.getConexion().createStatement()) {
                    stmt.executeUpdate(contenidoFicheroSQL);
                    System.out.println("Script ejecutado correctamente");
                }
            } else {
                System.out.println("Error al conectar con la base de datos");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.fillInStackTrace());
        } catch (SQLException e) {
            System.out.println("Error al ejecutar el fichero: " + e.fillInStackTrace());
        }
    }

    private String leerFicheroSQL(String sqlFilePath) throws IOException {
        // Leer el archivo SQL y construir el script en un StringBuilder
        StringBuilder script = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(sqlFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Añadir cada línea al script con el separador
                //      de línea del sistema (independiente de Windows o Linux)
                script.append(line).append(System.lineSeparator());
            }
        }

        return script.toString();
    }
}
