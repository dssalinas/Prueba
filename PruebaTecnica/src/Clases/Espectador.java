package Clases;

import java.util.ArrayList;

public class Espectador extends Persona {

    // Variables

    int dinero = 0;

    String nombreApellido;

    // Constructor
    public Espectador() {
    }

    // Constructor para registrar espectadores
    public Espectador(String nombre, String apellido, int edad, int dinero) {

        setDinero(dinero);
        setNombre(nombre);
        setEdad(edad);
        setApellido(apellido);
    }

    // Gets y Sets

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public int getDinero() {
        return dinero;
    }

    // Metodo para generar los 45 espectadores
    public ArrayList<Espectador> generarEspectador() {

        // Lista donde se guardaran los espectadores
        ArrayList<Espectador> listaEspectadores = new ArrayList<Espectador>();

        // Ciclo para generar nombres
        for (int i = 0; i < 45; i++) {
            // Variable para generar que cantidad tiene cada espectador al azar
            dinero = numeroAleatorio(50000);

            // Variable para generar la edad de los espectadores al azar
            edad = numeroAleatorio(50);

            // Variable que guardara el nombre y apellido
            setNombre(generarNombre());
            setApellido(generarApellido());

            // Va creando usuarios y guardandolos en la lista
            Espectador lista = new Espectador(getNombre(), getApellido(), edad, dinero);

            // Lista donde se guardan los espectadores
            listaEspectadores.add(lista);

        }
        return listaEspectadores;

    }

}
