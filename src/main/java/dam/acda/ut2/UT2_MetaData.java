package dam.acda.ut2;

import dam.acda.ut2.db.conection.ConexionBD;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class UT2_MetaData {

    private static final Logger logger = LogManager.getLogger(UT2_MetaData.class.getName());

    public void start() {
        System.out.println("------------------------------");
        System.out.println("--  UT2 - Meda información  --");
        System.out.println("------------------------------");

        Connection conexion = ConexionBD.getInstancia().getConexion();
        try {
            // Obtenemos los metadatos de la BDR
            DatabaseMetaData dbMetaData = conexion.getMetaData();
            mostrarMetadatos(dbMetaData);
        } catch (SQLException e) {
            logger.error("Ha ocurrido un error al obtener los metadatos: ", e.fillInStackTrace());
        }
    }

    private void mostrarMetadatos(DatabaseMetaData dbMetaData) throws SQLException {
        // Con "catalog" a null devuelve todas las tablas de la BDR
        ResultSet tablas = dbMetaData.getTables(
                "acda_ut2",
                null,
                null,
                new String[] { "TABLE" });
        while (tablas.next()) {
            System.out.println("Tabla: " + tablas.getString("TABLE_NAME"));
        }

        // Con catalog = null muestra las columnas de la primera tabla cliente que encuentre
        ResultSet columnas = dbMetaData.getColumns(
                null,
                null,
                "Cliente",
                null);
        while (columnas.next()) {
            System.out.println("Columna: " + columnas.getString("COLUMN_NAME") +
                    ",\tTipo: " + columnas.getString("TYPE_NAME"));
        }

        // Con catalog = null muestra las PK de todas las tablas cliente que encuentre
        ResultSet pk = dbMetaData.getPrimaryKeys(null, null, "Cliente");
        while (pk.next()) {
            System.out.println("Clave Primaria: " + pk.getString("COLUMN_NAME"));
        }

        // Con catalog = null muestra las FK de todas las tablas cliente que encuentre
        ResultSet fk = dbMetaData.getImportedKeys(null, null, "Pedido");
        while (fk.next()) {
            System.out.println("Clave Foránea: " + fk.getString("FKCOLUMN_NAME") +
                    " -> Tabla Referenciada: " + fk.getString("PKTABLE_NAME"));
        }
    }
}
