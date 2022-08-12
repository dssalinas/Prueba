package Metodos;

import Interfaz.InterfazMetodos;
import Clases.Espectador;
import Clases.Pelicula;
import Clases.Cine;

import java.util.Random;

import static Clases.Cine.datosParaSala;
import static Clases.Cine.sala;


public class CineMetodo implements InterfazMetodos{
    Pelicula pelicula = new Pelicula();
    Cine cine = new Cine();

    public void rellenar() {

        // Número de la posición de la sala
        int numero = 0;

        // Ciclo para rellenar la matriz
        for (int i = 0; i < 8; i++) {

            numero++;

            for (int j = 0; j < 9; j++) {

                sala[i][j] = numero + datosParaSala[j];

            }

        }

    }

    // Metodo para registrar en la matriz el usuario
    public String ingresarSala(Espectador persona) {

        // accedes se encarga de devolver el dato si se registro o no cumplio alguna de
        // las validaciones
        // datoLista se encarga de guardar en que parte de la matriz quedo la ubicación
        // del espectador
        String acceder = "", datoLista = "";

        // terminar valida para terminar el ciclo
        // espacio valida que la matriz aun haya espacio
        boolean terminar = true, espacio = true;
        Random aleatorio = new Random();
        int fila = 0;
        int columna = 0;

        // Invoca el metodo hayEspacio para ver en la matriz si hay espacio
        espacio = hayEspacio();

        if (espacio) {

            // Validación de edad
            if (persona.getEdad() < pelicula.getEdadMinima()) {

                acceder = "No puede acceder a la sala de cine, no cuenta con la edad suficiente";

            } else if (persona.getDinero() < cine.getPrecioEntrada()) { // Validación para ver si cuenta con el dinero de la
                                                                   // entrada

                acceder = "No puede acceder a la sala de cine, no cuenta con el dinero suficiente";

            } else {

                while (terminar) {

                    // fila guardara la posición aleatoria de la fila
                    fila = aleatorio.nextInt(8);

                    // columna se encargara de la posición aleatoria de la columna
                    columna = aleatorio.nextInt(9);

                    // Validación si contiene x el espacio de la matriz se repetira el ciclo
                    // buscando otro puesto
                    if (sala[fila][columna].contains("x")) {

                        terminar = true;

                    } else {

                        // Si no hay x dentro de la matriz se llena con x diciendo que el espectador
                        // asignado ya va tomar ese lugar
                        datoLista = sala[fila][columna];

                        sala[fila][columna] = "x";

                        // Salir del ciclo
                        terminar = false;

                    }
                    // Ciclo para mostrar la sala como quedo luego de registrar el usuario
                    for (int i = 0; i < 8; i++) {

                        for (int j = 0; j < 9; j++) {

                            System.out.print("|" + sala[i][j] + "|");

                        }

                        System.out.print("\n");

                    }
                }

                acceder = "El puesto de la persona es:" + datoLista;
            }
        } else {
            // Si la validación de espacio dio false
            acceder = "No hay espacio";
        }
        return acceder;
    }

    // Validación para ver si hay espacio en la matriz
    public boolean hayEspacio() {

        // contador se encarga de validar si hay espacio en la matriz
        int contador = 0;

        // espacio se encarga de devolver un true si hay espacio y un false si no lo hay
        boolean espacio = true;

        // Ciclo para validación
        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 9; j++) {

                // Si el contenido dentro de la matriz es x entonces el contador sube
                if (sala[i][j].contains("x")) {
                    contador++;
                }
            }

        }

        // Si el contador es igual o mayor a 72 entonces el boolean quedara en false
        if (contador >= 72) {
            espacio = false;
        }
        return espacio;
    }
    public int precioEntrada(){
        return cine.getPrecioEntrada();
    }

}
