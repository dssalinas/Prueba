import java.util.ArrayList;
import java.util.Scanner;

import Clases.Cine;
import Clases.Espectador;
import Clases.Liga;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Que actividad quiere validar (Escriba el número de la actividad):");
            int lector = sc.nextInt();

            switch (lector) {
                case 1:
                    // PrimeraActividad
                    primeraActividad();
                    break;
                case 2:
                    // Segunda actividad
                    segundaActividad();
                    break;
                case 3:
                terceraActividad();
            }



            // TerceraActividad

        } catch (Exception e) {

        }
    }

    // Primera actividad
    public static void primeraActividad() {
        // Lista para acomodar
        String array[] = {
                "12.4/11-24 (4)",
                "10.4/11-28 (6)",
                "7.00-19 (10)",
                "12.4/11-36 (12)",
                "7.00-18 (6)",
                "12.4/11-38 (6)",
                "12.4/11-38 (14)",
                "7.34-18 (10)",
                "19.9/14-24 (8)",
                "8.3-24 (6)",
                "8.3-24 (4)",
                "7.07-18 (80)",
                "520/85-42",
                "480/80-50",
                "480/80-46"
        };

        // limite se encarga de guardar el contador de registros que hay dentro de
        // array[]
        // faltante valida la cantidad de datos de un registro contra el otro
        int limite = array.length, faltante = 0;

        // Apoya el acomodamiento de los registros dentro de array[]
        String temporal = "";

        // Ciclo para acomodar los datos dentro de la lista
        for (int i = 0; i < limite; i++) {
            for (int j = 1; j < (limite - i); j++) {

                /*
                 * Guarda dentro de una lista de enteros los números dentro de la posición j - 1
                 * (si j es 1 entonces haria la consulta de la posición 0)
                 * lista array[] utilizando regresarNumero
                 */
                ArrayList<Integer> dato1 = regresarNumero(array[j - 1]);

                /*
                 * Guarda dentro de una lista de enteros los números dentro de la posición j de
                 * lista array[] utilizando regresarNumero
                 */
                ArrayList<Integer> dato2 = regresarNumero(array[j]);

                /*
                 * Cada lista tiene guardado de 1 registro en array[], x cantidad de numeros que
                 * tuviera se hace la
                 * comparación de cantidad de número
                 */
                if (dato1.size() > dato2.size()) {

                    // faltante recibe cuantos registros le falta a la lista de dato2
                    faltante = dato1.size() - dato2.size();

                    // El ciclo se encarga de rellenar la lista menor con lo faltante llenandolo con
                    // 0
                    for (int o = 0; o < faltante; o++) {
                        dato2.add(0);
                    }

                    // Si el dato1 no tiene una cantidad mayor de registro entonces se valida si
                    // dato2 tiene cantidad grande para rellenar
                } else if (dato2.size() > dato1.size()) {

                    // faltante recibe cuantos registros le falta a la lista de dato2
                    faltante = dato2.size() - dato1.size();

                    // El ciclo se encarga de rellenar la lista menor con lo faltante llenandolo con
                    // 0
                    for (int o = 0; o < faltante; o++) {
                        dato1.add(0);
                    }
                }

                // Ciclo para acomodar los registros dentro de la lista array[]
                for (int k = 0; k < dato1.size(); k++) {

                    // Si dato1 en la posición k (k es el valor del ciclo) es mayor a dato2 en la
                    // posición k,se acomoda la lista intentando que el menor quede antes del mayor
                    if (dato1.get(k) > dato2.get(k)) {

                        // temporal guarda el dato mayor (dato1)
                        temporal = array[j - 1];

                        // La posicion de dato mayor sobreescribe y guarda el dato menor
                        array[j - 1] = array[j];

                        // La posición de dato menor sobreescribe y guarda el dato menor
                        array[j] = temporal;

                        // detener el ciclo para que no siga validando los otros números que siguen de
                        // las listas de números
                        break;
                    } else if (dato1.get(k) < dato2.get(k)) {

                        // detener el ciclo para que no siga validando los otros números que siguen de
                        // la listas de números
                        break;
                    }

                }

            }
        }

        // Ciclo que se encarga de imprimir como quedo organizado el ciclo
        for (String elemento : array) {
            System.out.print(elemento + "\n");
        }

    }

    // Metodo para separar los números y convertirlos a enteros de registro que se
    // envie del vector array[] y regresar una lista de enteros según x cantidad de
    // números que tuviera el registro que envian
    public static ArrayList<Integer> regresarNumero(String dato) {

        // Texto donde se encuentran los números
        String sTexto = dato;

        // Texto que vamos a buscar
        String sTextoBuscado = "";

        // Lista donde se guardaran los números
        ArrayList<Integer> respuesta = new ArrayList<Integer>();

        // Las siguientes validaciones son para quitar caracteres del registro y solo
        // dejar números con un caracter facil de identificar y quitar

        // Validación de espacios
        if (sTexto.contains(" ")) {

            // Si cumple la condición se sobreescribe sTextoBuscado para buscar lo validado
            sTextoBuscado = " ";

            // remplaza en el registro donde haya algo parecido a sTextoBuscado y lo
            // remplaza
            sTexto = sTexto.replace(sTextoBuscado, "");
        }

        // validación para quitar el - del registro y remplazarlo
        if (sTexto.contains("-")) {
            sTextoBuscado = "-";
            sTexto = sTexto.replace(sTextoBuscado, " ");
        }
        // Validación de opcionales de la formula
        if (sTexto.contains("/")) {
            sTextoBuscado = "/";
            sTexto = sTexto.replace(sTextoBuscado, " ");

        }

        // Validación de opcionales de la formula
        if (sTexto.contains(".")) {
            sTextoBuscado = ".";
            sTexto = sTexto.replace(sTextoBuscado, " ");

        }

        // Validación de opcionales de la formula
        if (sTexto.contains("(")) {
            sTextoBuscado = "(";
            sTexto = sTexto.replace(sTextoBuscado, " ");
            sTextoBuscado = ")";
            sTexto = sTexto.replace(sTextoBuscado, " ");

        }

        // Se encargara de separar los números del caracter facil de identificar y
        // remplazar
        String[] guardarDatos = sTexto.split(" ");

        for (String elemento : guardarDatos) {

            // Se guarda en la lista de enteros lo que guardo guardarDatos transformando de
            // tipo texto a entero
            respuesta.add(Integer.parseInt(elemento));
        }

        return respuesta;

    }

    // Segunda actividad
    public static void segundaActividad() {
        // sc se encargara de leer lo que el usuario digite
        Scanner sc = new Scanner(System.in);

        // Guardara todo lo que el usuario digite
        int lectura = 0;

        // Muestra el número de la posición del espectador
        int contador = 0;

        // Guardara en una lista los espectadores
        ArrayList<Espectador> listaEspectadores = new ArrayList<>();

        // Se invoca la entidad Cine
        Cine cine = new Cine();

        System.out.print("Se entrega lista de la fila de 45 espectadores\n");

        // Se utiliza el metodo para generar los 45 espectadores
        listaEspectadores = cine.generarEspectador();

        try {
            do {

                contador = 0;

                // Ciclo para imprimir a los 45 espectadores
                for (int i = 0; i < listaEspectadores.size(); i++) {

                    contador++;

                    System.out.print(contador + ")Nombre:" + listaEspectadores.get(i).getNombre() + " Edad:"
                            + listaEspectadores.get(i).getEdad() + " Dinero:" + listaEspectadores.get(i).getDinero()
                            + "\n");
                }

                System.out.print("Recuerde que la entrada al cine vale $" + cine.getPrecioEntrada() + "\n");

                System.out.print("Seleccione el número de la persona que quiere ingresar a la sala de cine\n");

                // El usuario tiene que escribir cual de los 45 espectadores va a entrar
                lectura = sc.nextInt();

                // Validación para ver si escribio un dato entre 1 a 45
                if (lectura > 0 && lectura <= 45) {

                    // se encarga de dar la posición del usuario seleccionado
                    int posicion = 0;

                    posicion = lectura - 1;

                    // respuesta se encarga de recibir respuesta del metodo Cine.ingresarSala la
                    // respuesta
                    String respuesta = cine.ingresarSala(listaEspectadores.get(posicion));

                    System.out.print(respuesta);

                    // Quita de la lista el espectador que se acaba de colocar en la sala de cine
                    listaEspectadores.remove(posicion);

                } else {

                    System.out.print("El número no esta en la lista\n");

                }

                System.out.print("¿Desea ingresar otro espectador?\n 1)Si / 2)No\n");

                // La siguiente lectura es para ver si repite el ciclo y acomoda a otro
                // espectador
                lectura = sc.nextInt();

            } while (lectura == 1);
        } catch (Exception a) {

            // Se imprime si suelta alguna excepción
            System.out.println("Error, por favor ingrese alguno de los dos números que se muestran en pantalla");

        }

    }

    public static void terceraActividad() {

        Liga liga = new Liga();
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba el nombre del país que solicita saber cuantas veces a ganado");

        String lectura = sc.nextLine();

        liga.fechaGanadorCampeonato(lectura);

        System.out.println(
                "Escriba la fecha entre 1930 y 2018 para saber cuantas veces fue campeón un equipo ");

        lectura = sc.nextLine();

        liga.ganadorMasRepetido(lectura);

    }
}
