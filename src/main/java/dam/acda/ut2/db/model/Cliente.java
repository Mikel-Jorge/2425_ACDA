package dam.acda.ut2.db.model;

import java.util.Date;

public class Cliente {
    private int clienteID;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;

    public Cliente(int clienteID, String nombre, String apellidos, Date fechaNacimiento) {
        this.clienteID = clienteID;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getClienteID() {
        return clienteID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
