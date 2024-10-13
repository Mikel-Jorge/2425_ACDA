package dam.acda.ut2.db.service;

import java.util.List;

public interface GenericService<T, K> {

    // Método para insertar un nuevo registro (CREATE)
    int insertar(T entity);

    // Método para obtener todos los registros (READ)
    List<T> obtenerTodos();

    // Método para obtener un registro por ID (READ)
    T obtenerPorId(K id);

    // Método para actualizar un registro existente (UPDATE)
    int actualizar(T entity);

    // Método para eliminar un registro por ID (DELETE)
    int eliminar(K id);
}


