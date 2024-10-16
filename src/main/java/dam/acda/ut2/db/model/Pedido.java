package dam.acda.ut2.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int pedidoID;
    private Cliente cliente;
    private Date fecha;
    private List<Contiene> contiene = new ArrayList<>();

    public Pedido(int pedidoID,Cliente cliente,Date fecha, List<Contiene> contiene) {
        this.pedidoID = pedidoID;
        this.cliente = cliente;
        this.fecha = fecha;
        this.contiene = contiene;
    }

    public int getPedidoID() {
        return pedidoID;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Contiene> getContiene() {
        return contiene;
    }

    public void setContiene(List<Contiene> contiene) {
        this.contiene = contiene;
    }
}
