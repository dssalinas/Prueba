package Clases;

import java.util.ArrayList;
import java.util.Arrays;

public class Liga {

    // campeonatos[][] matriz donde se guardara la información de los campeonatos
    String campeonatos[][] = {
            { "Año", "Campeón", "Subcampeón", "Sede" },
            { "1930", "Uruguay", "Argentina", "Uruguay" },
            { "1934", "Italia", "Checoslovaquia", "Italia" },
            { "1938", "Italia", "Hungría", "Francia" },
            { "1942", "No celebrado", "No celebrado", "No celebrado" },
            { "1946", "No celebrado", "No celebrado", "No celebrado" },
            { "1950", "Uruguay", "Brasil", "Brasil" },
            { "1954", "Alemania", "Hungría", "Suiza" },
            { "1958", "Brasil", "Suecia", "Suecia" },
            { "1962", "Brasil", "Checoslovaquia", "Chile" },
            { "1966", "Inglaterra", "Alemania", "Inglaterra" },
            { "1970", "Brasil", "Italia", "México" },
            { "1974", "Alemania", "Holanda", "Alemania" },
            { "1978", "Argentina", "Holanda", "Argentina" },
            { "1982", "Italia", "Alemania", "España" },
            { "1986", "Argentina", "Alemania", "México" },
            { "1990", "Alemania", "Argentina", "Italia" },
            { "1994", "Brasil", "Italia", "Estados Unidos" },
            { "1998", "Francia", "Brasil", "Francia" },
            { "2002", "Brasil", "Alemania", "Corea-Japón" },
            { "2006", "Italia", "Francia", "Alemania" },
            { "2010", "España", "Holanda", "Sudáfrica" },
            { "2014", "Alemania", "Argentina", "Brasil" },
            { "2018", "Francia", "Croacia", "Rusia" }

    };

    // Construtor
    public Liga() {
    }

    // Metodo para ver las fechas donde gano el campeonato
    public void fechaGanadorCampeonato(String pais) {

        // Lista donde se guardaran las fechas que gano el equipo
        ArrayList<String> listaCampeones = new ArrayList<String>();

        // Ciclo para registrar en la lista las fechas
        for (int i = 0; i < 24; i++) {

            // Validación de paises según el dato enviado en los parametros
            if (campeonatos[i][1].toUpperCase().equals(pais.toUpperCase())) {

                // Agrega en la lista
                listaCampeones.add(campeonatos[i][0]);
            }
        }

        // Imprime en pantalla las fechas del ganador
        for (int i = 0; i < listaCampeones.size(); i++) {

            System.out.print("|" + listaCampeones.get(i) + "|");

        }

    }

    // Metodo para saber quien fue el ganador desde un año especifico
    public void ganadorEspecificoFecha(String fecha) {

        // transformación de la fecha de texto a entero
        int validar = Integer.parseInt(fecha);

        // Lista donde se guardaran los ganadores
        ArrayList<String> lista = new ArrayList<String>();

        // Ciclo para validación y guardar dato según sea mayor o igual a la fecha
        // puesta
        for (int i = 1; i < 24; i++) {

            int campeonesFecha = Integer.parseInt(campeonatos[i][0]);

            if (campeonesFecha >= validar) {

                lista.add("|" + campeonatos[i][0] + "|" + campeonatos[i][1] + "|\n");

            }
        }

        // Ciclo para imprimir los resultados
        for (int i = 0; i < 24; i++) {

            System.out.print(lista.get(i));

        }

    }

    // Metodo para ver el ganador especifico de la fecha
    public ArrayList<String> ganadorEspecificoNombre(String fecha) {

        // validar transforma fecha entero
        int validar = Integer.parseInt(fecha);

        // Lista para guardar los que coinciden con la fecha
        ArrayList<String> lista = new ArrayList<String>();

        // Ciclo de validación
        for (int i = 1; i < 24; i++) {

            // campeonesFecha guarda la fecha de la matriz transformada a entero
            int campeonesFecha = Integer.parseInt(campeonatos[i][0]);

            // Validación
            if (campeonesFecha >= validar) {

                lista.add(campeonatos[i][1]);

            }
        }
        return lista;
    }

    // Metodo para saber quien es el ganador mas repetido desde cierta fecha
    public void ganadorMasRepetido(String fecha) {

        // contar dice en que posición de la lista debe ir el registro
        int contar = 0;

        // Guarda los paises mas repetidos
        ArrayList<String> listaPaises = new ArrayList<String>();

        // recibe el ganador según la fecha agregada
        listaPaises = ganadorEspecificoNombre(fecha);

        // contador guarda el conteo de registros de lsitaPaises
        int contador = listaPaises.size();

        // lista para saber cuantas repeticiones hubo según el pais
        ArrayList<Integer> cuantasRepeticiones = new ArrayList<Integer>();

        // Ciclo validación para ver los paises mas repetidos
        for (int i = 0; i < contador; i++) {

            // Contador se reinicia para saber cuantas repeticiones hay
            contador = 0;

            for (int j = 1; j < contador; j++) {

                // Validación si los datos son iguales
                if (listaPaises.get(i).equals(listaPaises.get(j))) {

                    contador++;

                    // contar pone la posición de la lista para que no vayan nullos a la lista
                    // contador se encarda de decir cuantas veces se repitio
                    cuantasRepeticiones.add(contar, contador);

                }
            }

            contar++;

        }

        int posicion = 0;

        // Ciclo para ver cuales son los paises mas repetidos
        for (int i = 1; i < cuantasRepeticiones.size(); i++) {

            // validación para saber cual es la posición
            if (cuantasRepeticiones.get(i - 1) > cuantasRepeticiones.get(i)) {

                posicion = i - 1;

            }
        }

        System.out.print("El pais que mas veces gano segun desde la fecha escrita es:" + listaPaises.get(posicion));
    }

    // Metodo para saber las sedes mas repetidas de la liga
    public void sedeRepetido() {

        // lista guardara las sedes de campeonatos[][]
        String[] lista = listaSedes();

        // listaTemporal guardara las sedes con las veces que se repite
        String[][] listaTemporal = new String[lista.length][2];

        // Organiza el vector lista[]
        Arrays.sort(lista);

        // Guarda el primer dato para comparar
        String aux = lista[0];

        // contador guardara las veces que se repite una sede
        // posicion se usara para las posiciones del vector y no hayan null en la lista
        int contador = 0, posicion = 0;

        // Ciclo para acomodar y contar
        for (int i = 0; i < listaTemporal.length - 1; i++) {

            // Si el axiliar es diferente empieza nuevo conteo
            if (aux != lista[i]) {

                aux = lista[i];

                contador = 1;

                listaTemporal[i][0] = aux;

                listaTemporal[i][1] = contador + "";

                posicion = i;

            } else {

                // Si el auxiliar es igual que aumente el conte
                contador++;

                listaTemporal[posicion][1] = contador + "";

                listaTemporal[posicion][0] = aux;

            }
        }
        // max transforma el conteo en entero
        int max = Integer.parseInt(listaTemporal[0][1]);

        // repiteMas guarda el dato que mas se repite
        String repiteMas = "";

        // Ciclo para validar cual se repite
        for (int i = 0; i < lista.length; i++) {

            // Validación si en esa parte de la lista no hayan null
            if (listaTemporal[i][0] != null) {

                // Validación para comparar si el dato traido de la lista es mayor a max (No
                // celebrado no cuenta como registr0)
                if (Integer.parseInt(listaTemporal[i][1]) > max && listaTemporal[i][0] != "No celebrado") {

                    // Guarda el nombre del país
                    repiteMas = listaTemporal[i][0];

                    // Guarda el nuevo maximo para comparar
                    max = Integer.parseInt(listaTemporal[i][1]);

                    //Validación si es igual a maximo entonces se agrega
                } else if (Integer.parseInt(listaTemporal[i][1]) == max && listaTemporal[i][0] != "No celebrado") {

                    //Se concatena la respuesta que ya habia con el nuevo registro que mas se repite
                    repiteMas = repiteMas + "," + listaTemporal[i][0];
                }
            }

        }
        System.out.println("Los lugares mas repetidos son:" + repiteMas);

    }

    //Metodo para devolver solamente una lista de sedes
    public String[] listaSedes() {

        //lista donde se guardaran las 23 sedes
        String[] lista = new String[23];

        //Ciclo para empezar a guardar solo las sedes
        for (int i = 0; i < lista.length; i++) {

            //Guardar dato en lista en la posición i y se detiene cuando llegue al limite de lista (23) 
            lista[i] = campeonatos[i + 1][3];

        }
        
        return lista;
    }
}
