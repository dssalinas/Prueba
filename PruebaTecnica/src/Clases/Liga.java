package Clases;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedHashMap;

import java.util.Map;
import java.util.Map.Entry;

public class Liga {

    // campeonatos[][] matriz donde se guardara la información de los campeonatos
    private static String campeonatos[][] = {
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
    private static Map<Integer, String> listaCampeones = new LinkedHashMap<>();
    private static Map<Integer, String> listaSubCampeones = new LinkedHashMap<>();
    private static Map<Integer, String> listaSedes = new LinkedHashMap<>();

    // Construtor
    public Liga() {
        rellenar();
    }

    private static void rellenar() {
        for (int i = 1; i < 24; i++) {
            listaCampeones.put(Integer.parseInt(campeonatos[i][0]), campeonatos[i][1].toUpperCase());
            listaSubCampeones.put(Integer.parseInt(campeonatos[i][0]), campeonatos[i][2].toUpperCase());
            listaSedes.put(Integer.parseInt(campeonatos[i][0]), campeonatos[i][3].toUpperCase());
        }

    }

    // Metodo para ver las fechas donde gano el campeonato
    /**
     * @param pais
     */
    public void fechaGanadorCampeonato(String pais) {

        // Lista donde se guardaran las fechas que gano el equipo

        // Ciclo para registrar en la lista las fechas
        for (Entry<Integer, String> jugador : listaCampeones.entrySet()) {

            // Validación de paises según el dato enviado en los parametros

            boolean equals = jugador.equals(pais.toUpperCase());
            if (equals) {

                // Agrega en la lista
                System.out.println("|" + jugador.getKey() + "|");
            }
        }

    }

    // Metodo para saber quien fue el ganador desde un año especifico
    public void ganadorEspecificoFecha(int fecha) {

        // transformación de la fecha de texto a entero
        int validar = fecha;

        // Lista donde se guardaran los ganadores
        ArrayList<String> lista = new ArrayList<String>();

        // Ciclo para validación y guardar dato según sea mayor o igual a la fecha
        // puesta
        for (Entry<Integer, String> jugador : listaCampeones.entrySet()) {

            if (jugador.getKey() >= validar) {

                System.out.print("|" + jugador.getKey() + "|" + jugador.getValue() + "|\n");

            }
        }

    }

    // Metodo para ver el ganador especifico de la fecha
    public String ganadorEspecificoNombre(int fecha) {

        return listaCampeones.get(fecha);
    }

    // Metodo para saber quien es el ganador mas repetido desde cierta fecha
    /**
     * @param fecha
     */
    public void ganadorMasRepetido(int fecha) {

        Map<String, Integer> cantidadGanadora = new HashMap();
        String campeon = "";
        int mayor = 0;

        cantidadGanadora.put(listaCampeones.get(fecha), 0);
        for (Entry<Integer, String> jugador : listaCampeones.entrySet()) {

            if (jugador.getKey() >= fecha) {
                if (cantidadGanadora.containsKey(jugador.getValue())) {
                    mayor = cantidadGanadora.get(jugador.getValue()) + 1;
                    cantidadGanadora.put(jugador.getValue(), mayor);

                } else {
                    cantidadGanadora.put(jugador.getValue(), 0);

                }
            }
        }

        for (Entry<String, Integer> jugador : cantidadGanadora.entrySet()) {
            if (mayor >= jugador.getValue()) {
                campeon = jugador.getKey();
            }
        }

        System.out.println("El ganador mas repetido desde " + fecha + " es:" + campeon);
    }

    // Metodo para saber las sedes mas repetidas de la liga
    public void sedeRepetido() {
        Map<String, Integer> sedeRepeat = new HashMap<>();
        sedeRepeat.put("vacio", 0);
        int contador = 0;
        String repetido = "";
        for (Entry<Integer, String> sede : listaSedes.entrySet()) {
            if (sedeRepeat.containsKey(sede.getValue())) {
                contador = sedeRepeat.get(sede.getValue()) + 1;
                sedeRepeat.put(sede.getValue(), contador);
            } else {
                sedeRepeat.put(sede.getValue(), 0);
            }

        }
        for (Entry<String, Integer> sede : sedeRepeat.entrySet()) {
            if (contador >= sede.getValue()) {
                repetido = sede.getKey();
            }
        }
        System.out.print("La sede mas repetida es:" + repetido);

    }

}
