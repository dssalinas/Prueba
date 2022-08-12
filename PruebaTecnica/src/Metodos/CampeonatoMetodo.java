package Metodos;

import Interfaz.InterfazMetodos;
import static Clases.Campeonato.listaSedes;
import static Clases.Campeonato.campeonatos;

public class CampeonatoMetodo implements InterfazMetodos{
   
    public void rellenar() {
        for (int i = 1; i < 24; i++) {
            
            listaSedes.put(Integer.parseInt(campeonatos[i][0]), campeonatos[i][3].toUpperCase());
        }
        
    }
}
