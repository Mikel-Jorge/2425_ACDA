package dam.acda.ut2.db.conection;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBD {

    // Obtén una instancia del logger
    private static final Logger logger = LogManager.getLogger(ConexionBD.class.getName());

    // La única instancia de la clase
    private static ConexionBD instancia;

    // El objeto Connection
    private Connection conexion;

    // Datos de conexión
    private final String PUERTO = "3308";
    private final String ESQUEMA = "acda_ut2";
    private final String SGBD = "mysql";
    private final String url = "jdbc:" + SGBD + "://localhost:" + PUERTO
            + "/" + ESQUEMA + "?allowMultiQueries=true";
    private final String usuario = "root";
    private final String contrasena = "root";

    // Constructor privado para evitar que se creen nuevas instancias
    private ConexionBD() {
        try {
            // Intentamos establecer la conexión
            conexion = DriverManager.getConnection(url, usuario, contrasena);
            logger.info("Conexión establecida con la base de datos '{}'", ESQUEMA);
        } catch (SQLException e) {
            logger.error("Error al conectar a la base de datos: ", e.fillInStackTrace());
        }
    }

    // Método para obtener la única instancia de la clase (Singleton)
    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    // Método para obtener la conexión
    public Connection getConexion() {
        return conexion;
    }
}

