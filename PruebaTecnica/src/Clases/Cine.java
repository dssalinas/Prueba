package Clases;



public class Cine{


    // Posición de las salas
    public static final String[] datosParaSala = { "A", "B", "C", "D", "F", "G", "H", "I", "J" };

    // Variable de precio de entrada, sirve para la validación donde no pueden
    // entrar menores de edad
    int precioEntrada = 13000;

    // Matriz para realizar el registro de la sala de cine con los espectadores
    public static final String[][] sala = new String[8][9];

    // Sets
    public void setPrecioEntrada(int precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    // Gets
    public int getPrecioEntrada() {
        return precioEntrada;
    }

    // Constructor
    public Cine() {
        
    }


    // Metodo para mostrar el precio de la entrada
    public String precioEntrada() {
        return "La entrada tiene un precio de: $" + precioEntrada + "\n";

    }

    // Metodo para rellenar las salas
    
}
