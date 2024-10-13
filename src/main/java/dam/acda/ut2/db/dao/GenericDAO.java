package dam.acda.ut2.db.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T, K> {

    // Método para insertar un nuevo registro (CREATE)
    void insertar(T entity) throws SQLException;

    // Método para obtener todos los registros (READ)
    List<T> obtenerTodos() throws SQLException;

    // Método para obtener un registro por ID (READ)
    T obtenerPorId(K id) throws SQLException;

    // Método para actualizar un registro existente (UPDATE)
    void actualizar(T entity) throws SQLException;

    // Método para eliminar un registro por ID (DELETE)
    void eliminar(K id) throws SQLException;
}
