package Clases;

import java.util.Random;

public class Persona {
    // Lista de nombres para generar espectadores
    protected static String[] listaNombre = { "Veronica", "Carlos", "Michel", "Eduardo", "Walter", "Gabriela",
            "Jeferson" };

    // Lista de apellidos para generar espectadores
    protected static String[] listaApellido = { "Gonzales", "Avila", "Silva", "Herrera", "Ordoñes", "Gomez", "Lopez" };

    protected String nombre;
    protected String apellido;
    protected int edad;

    public Persona() {
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String generarNombre() {

        // Variable para generar el número aleatorio del nombre de la persona en el
        // vector nombre[]
        int numeroAleatorio;

        // Ciclo para generar nombres

        // Variable para generar el número aleatorio del nombre de la persona en el
        // vector nombre[]
        numeroAleatorio = numeroAleatorio(7);

        // Variable que guardara el nombre y apellido
        setNombre(listaNombre[numeroAleatorio]);

        return getNombre();

    }

    public String generarApellido() {
        // Variable para generar el número aleatorio del nombre de la persona en el
        // vector apellido[]
        int numeroAleatorioApellido;
        // Variable para generar el número aleatorio del nombre de la persona en el
        // vector apellido[]
        numeroAleatorioApellido = numeroAleatorio(7);
        setApellido(listaApellido[numeroAleatorioApellido]);
        return getApellido();

    }

    protected int numeroAleatorio(int cantidad) {
        // Variable que ayuda a generar números aleatorios
        Random aleatorio = new Random();
        int numeroAleatorio = aleatorio.nextInt(cantidad);
        return numeroAleatorio;
    }

}
