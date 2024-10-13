package dam.acda.ut2.db.service;

import dam.acda.ut2.db.dao.VideojuegoDAO;
import dam.acda.ut2.db.model.Videojuego;

public class VideojuegoService extends GenericServiceImpl<Videojuego, Integer> {

    public VideojuegoService(VideojuegoDAO videojuegoDAO) {
        super(videojuegoDAO);
    }
}



