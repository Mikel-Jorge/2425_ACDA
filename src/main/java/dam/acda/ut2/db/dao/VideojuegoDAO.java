package dam.acda.ut2.db.dao;

import dam.acda.ut2.db.conection.ConexionBD;
import dam.acda.ut2.db.model.Videojuego;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

public class VideojuegoDAO implements GenericDAO<Videojuego, Integer> {

    @Override
    public void insertar(Videojuego entity) throws SQLException {
        ConexionBD conexionBD = ConexionBD.getInstancia();

        String query = "INSERT INTO videojuegos (titulo, plataforma, anio_lanzamiento, precio, disponible) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conexionBD.getConexion().prepareStatement(query);
        pstmt.setString(1, entity.getTitulo());
        pstmt.setString(2, entity.getPlataforma());
        pstmt.setInt(3, entity.getAnioLanzamiento());
        pstmt.setDouble(4, entity.getPrecio());
        pstmt.setBoolean(5, entity.isDisponible());
        pstmt.execute();

        pstmt.close();
    }

    @Override
    public List<Videojuego> obtenerTodos() throws SQLException {

        String query = "SELECT * FROM videojuegos";
        PreparedStatement pstmt = ConexionBD.getInstancia().getConexion().prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();

        // Obtener los metadatos del ResultSet
        ResultSetMetaData metaData = rs.getMetaData();

        // Obtener el número de columnas en el resultado
        int columnCount = metaData.getColumnCount();
        System.out.println("Número de columnas: " + columnCount);

        // Obtener nombres y tipos de cada columna
        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            String columnType = metaData.getColumnTypeName(i);
            System.out.println("Columna " + i + ": " + columnName + " (Tipo: " + columnType + ")");
        }


        return List.of();
    }

    @Override
    public Videojuego obtenerPorId(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void actualizar(Videojuego entity) throws SQLException {

    }

    @Override
    public void eliminar(Integer id) throws SQLException {

    }
}


