package Metodos;

import static Clases.SubCampeon.listaSubCampeones;
import static Clases.Campeonato.campeonatos;

public class SubCampeonMetodo extends CampeonatoMetodo {

    @Override
    public void rellenar() {
        for (int i = 1; i < 24; i++) {
            listaSubCampeones.put(Integer.parseInt(campeonatos[i][0]), campeonatos[i][2].toUpperCase());    
        }
    }
}
