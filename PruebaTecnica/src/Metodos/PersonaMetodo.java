package Metodos;
import static Clases.Persona.listaNombre;

import java.util.Random;

import static Clases.Persona.listaApellido;

import Clases.Persona;

public class PersonaMetodo {
    Persona persona = new Persona();
    public String generarNombre() {
        

        // Variable para generar el número aleatorio del nombre de la persona en el
        // vector nombre[]
        int numeroAleatorio;

        // Ciclo para generar nombres

        // Variable para generar el número aleatorio del nombre de la persona en el
        // vector nombre[]
        numeroAleatorio = numeroAleatorio(7);

        // Variable que guardara el nombre y apellido
        persona.setNombre(listaNombre[numeroAleatorio]);

        return persona.getNombre();

    }

    public String generarApellido() {
        // Variable para generar el número aleatorio del nombre de la persona en el
        // vector apellido[]
        int numeroAleatorioApellido;
        // Variable para generar el número aleatorio del nombre de la persona en el
        // vector apellido[]
        numeroAleatorioApellido = numeroAleatorio(7);
        persona.setApellido(listaApellido[numeroAleatorioApellido]);
        return persona.getApellido();

    }

    protected int numeroAleatorio(int cantidad) {
        // Variable que ayuda a generar números aleatorios
        Random aleatorio = new Random();
        int numeroAleatorio = aleatorio.nextInt(cantidad);
        return numeroAleatorio;
    }
}
