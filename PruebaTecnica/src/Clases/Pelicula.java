package Clases;

public class Pelicula {

    // Variables
    String titulo = "";
    String duracion = "";
    int edadMinima = 0;
    String director = "";

    // Gets y sets
    public String getTitulo() {
        return titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public String getDirector() {
        return director;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // Constructor
    public Pelicula() {
        setTitulo("Doctor stranger");
        setDuracion("2:30:00");
        setEdadMinima(12);
        setDirector("Sam Raimi");

    }

   

}
