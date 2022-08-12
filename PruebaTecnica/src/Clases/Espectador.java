package Clases;





public class Espectador extends Persona  {

    // Variables

    private int dinero = 0;

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

   
}
