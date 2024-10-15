package dam.acda.ut2;

import dam.acda.ut2.db.dao.VideojuegoDAO;
import dam.acda.ut2.db.model.Videojuego;
import dam.acda.ut2.db.service.VideojuegoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UT2_CRUD {

    private static final Logger logger = LogManager.getLogger(UT2_CRUD.class.getName());

    public void start() {
        System.out.println("--------------------");
        System.out.println("--  UT2.4 - CRUD  --");
        System.out.println("--------------------");

        VideojuegoService videojuegoService = new VideojuegoService(new VideojuegoDAO());

        int resultado = videojuegoService.insertar(new Videojuego(
                0,
                "Hollow Knight",
                "Nintendo Switch",
                2020,
                19.95,
                true));
        if (resultado == 0)
            System.out.println("Juego insertado correctamente");
        else System.out.println("Error al insertar el videojuego");
    }
}
