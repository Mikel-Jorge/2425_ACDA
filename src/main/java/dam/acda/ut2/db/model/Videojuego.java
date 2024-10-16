package dam.acda.ut2.db.model;

public class Videojuego {
    private int videojuegoID;
    private String titulo;
    private String plataforma;
    private int anioLanzamiento;
    private double precio;
    private boolean disponible;
    private Historia historia;

    // Constructor completo
    public Videojuego(int videojuegoID, String titulo, String plataforma, int anioLanzamiento, double precio, boolean disponible, Historia historia) {
        this.videojuegoID = videojuegoID;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.anioLanzamiento = anioLanzamiento;
        this.precio = precio;
        this.disponible = disponible;
        this.historia = historia;
    }

    // getters and setters
    public int getVideojuegoID() {
        return videojuegoID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Historia getHistoria() {
        return historia;
    }

    public void setHistoria(Historia historia) {
        this.historia = historia;
    }
}
