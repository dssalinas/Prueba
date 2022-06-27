package Clases;

public class Espectador {

    //Variables
    String nombre = "";
    int edad = 0;
    int dinero = 0;

    //Constructor
    public Espectador() {
    }

    //Constructor para registrar espectadores
    public Espectador(String nombre, int edad, int dinero) {
        setNombre(nombre);
        setDinero(dinero);
        setEdad(edad);
    }

    //Gets y Sets
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDinero() {
        return dinero;
    }

    public int getEdad() {
        return edad;
    }

}
