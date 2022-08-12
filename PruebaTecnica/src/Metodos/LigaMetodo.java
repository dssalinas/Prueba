package Metodos;

import java.util.HashMap;
import java.util.Map;

import Clases.Campeon;
import Clases.SubCampeon;
import Interfaz.InterfazMetodos;
import static Clases.Campeon.listaCampeones;
import static Clases.Campeonato.listaSedes;

public class LigaMetodo implements InterfazMetodos {
    private static final String NO_CELEBRADO = "NO CELEBRADO";
    Campeon campeon= new Campeon();
    SubCampeon subCampeon = new SubCampeon();
    CampeonMetodo campeonMetodo = new CampeonMetodo();
    SubCampeonMetodo subCampeonMetodo = new SubCampeonMetodo();

    public void rellenar() {
        campeonMetodo.rellenar();
        subCampeonMetodo.rellenar();
    }

    // Metodo para ver las fechas donde gano el campeonato
    public void fechaGanadorCampeonato(String pais) {
        String datoValue = "";

        // Lista donde se guardaran las fechas que gano el equipo

        // Ciclo para registrar en la lista las fechas

        for (Map.Entry<Integer, String> jugador : listaCampeones.entrySet()) {

            datoValue = jugador.getValue();

            if (datoValue.equals(pais.toUpperCase())) {

                // Agrega en la lista
                System.out.println("|" + jugador.getKey() + "|");
            }
        }

    }

    // Metodo para saber quien fue el ganador desde un año especifico
    public void ganadorEspecificoFecha(int fecha) {

        // transformación de la fecha de texto a entero
        int validar = fecha;

  
   

        // Ciclo para validación y guardar dato según sea mayor o igual a la fecha
        // puesta
        for (Map.Entry<Integer, String> jugador : listaCampeones.entrySet()) {

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
        for (Map.Entry<Integer, String> jugador : listaCampeones.entrySet()) {
            if(!jugador.equals(NO_CELEBRADO)){
            if (jugador.getKey() >= fecha) {
                if (cantidadGanadora.containsKey(jugador.getValue())) {
                    mayor = cantidadGanadora.get(jugador.getValue()) + 1;
                    cantidadGanadora.replace(jugador.getValue(), cantidadGanadora.get(jugador.getValue()), mayor);

                } else {
                    cantidadGanadora.put("El equipo que mas veces ha ganado"+jugador.getValue(), 0);

                }
            }
        }
    }

        for (Map.Entry<String, Integer> jugador : cantidadGanadora.entrySet()) {
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
        for (Map.Entry<Integer, String> sede : listaSedes.entrySet()) {
            if (sedeRepeat.containsKey(sede.getValue())) {
                contador = sedeRepeat.get(sede.getValue()) + 1;
                sedeRepeat.put(sede.getValue(), contador);
            } else {
                sedeRepeat.put(sede.getValue(), 0);
            }

        }
        for (Map.Entry<String, Integer> sede : sedeRepeat.entrySet()) {
            if (contador >= sede.getValue()) {
                repetido = sede.getKey();
            }
        }
        System.out.print("La sede mas repetida es:" + repetido);

    }

    public void ganadorMasRepetido() {

        Map<String, Integer> cantidadGanadora = new HashMap();

        int mayor = 0;

        cantidadGanadora.put("vacio", 0);
        for (Map.Entry<Integer, String> jugador : listaCampeones.entrySet()) {

            if (cantidadGanadora.containsKey(jugador.getValue())) {

                mayor = cantidadGanadora.get(jugador.getValue()) + 1;
                cantidadGanadora.put(jugador.getValue(), mayor);
                cantidadGanadora.remove("vacio");

            }else{
                cantidadGanadora.put(jugador.getValue(), 1);
            }
        }

        System.out.println("Veces que los equipos han ganado campeonatos");
        for (Map.Entry<String, Integer> jugador : cantidadGanadora.entrySet()) {
            System.out.println(jugador.getKey() + ":" + jugador.getValue());
        }

    }
}
