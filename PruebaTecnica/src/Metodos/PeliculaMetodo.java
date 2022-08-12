package Metodos;

import Clases.Pelicula;

public class PeliculaMetodo {
    Pelicula pelicula = new Pelicula();
     // Consultar datos de la pelicula
     public String ConsultarPelicula() {
        String mostrarPelicula = "Nombre de la pelicula:" + pelicula.getTitulo() + "\n Duracion: " + pelicula.getDuracion()
                + "\n Edad minima de " + pelicula.getEdadMinima() + "\n Producida por:" + pelicula.getDirector();
        return mostrarPelicula;

    }
}
