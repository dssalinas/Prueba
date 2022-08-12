package Metodos;

import static Clases.Campeon.listaCampeones;
import static Clases.Campeonato.campeonatos;

public class CampeonMetodo extends CampeonatoMetodo{
    
    @Override
    public void rellenar() {
        // TODO Auto-generated method stub
        super.rellenar();
        for (int i = 1; i < 24; i++) {
            listaCampeones.put(Integer.parseInt(campeonatos[i][0]), campeonatos[i][1].toUpperCase());
            
        }
    }
}
