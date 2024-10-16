package dam.acda.ut2.db.model;

public class Contiene {
    private Pedido pedido;
    private Videojuego videojuego;
    private int cantidad;

    public Contiene(Pedido pedido, Videojuego videojuego, int cantidad) {
        this.pedido = pedido;
        this.videojuego = videojuego;
        this.cantidad = cantidad;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Videojuego getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Videojuego videojuego) {
        this.videojuego = videojuego;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
