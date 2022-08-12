package Metodos;

import java.util.ArrayList;

import Clases.Espectador;


public class EspectadorMetodo extends PersonaMetodo{
     // Metodo para generar los 45 espectadores
     public ArrayList<Espectador> generarEspectador() {
    Espectador espectador = new Espectador();
        // Lista donde se guardaran los espectadores
        ArrayList<Espectador> listaEspectadores = new ArrayList<Espectador>();

        // Ciclo para generar nombres
        for (int i = 0; i < 45; i++) {
            // Variable para generar que cantidad tiene cada espectador al azar
            espectador.setDinero(numeroAleatorio(50000));

            // Variable para generar la edad de los espectadores al azar
            espectador.setEdad(numeroAleatorio(50));

            // Variable que guardara el nombre y apellido
            espectador.setNombre(generarNombre());
            espectador.setApellido(generarApellido());

            // Va creando usuarios y guardandolos en la lista
            Espectador lista = new Espectador(espectador.getNombre(), espectador.getApellido(), espectador.getEdad(), espectador.getDinero());

            // Lista donde se guardan los espectadores
            listaEspectadores.add(lista);

        }
        return listaEspectadores;

    }

}
