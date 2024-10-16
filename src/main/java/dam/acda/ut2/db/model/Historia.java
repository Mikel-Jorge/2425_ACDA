package dam.acda.ut2.db.model;

public class Historia {
    private int historiaID;
    private String titulo;
    private String descripcion;

    public Historia(int historiaID, String titulo, String descripcion) {
        this.historiaID = historiaID;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public int getHistoriaID() {
        return historiaID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
