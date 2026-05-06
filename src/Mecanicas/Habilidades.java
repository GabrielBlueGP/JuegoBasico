package Mecanicas;

import EnumsUsados.Roles;
import Personajes.Personaje;

public class Habilidades {
    private Roles rol;
    private Energia energia;
    private int danioHabilidad;

    public Habilidades(){}

    public int entornoAgresivo(){
        int danioAgresivo = 1;
        return danioAgresivo;
    }

    public int superdanio(Personaje personaje, Energia energia){
        int ataqueHabilidad = personaje.getAtaque() + 500;
        energia.setEnergia(0);
        return ataqueHabilidad;
    }
}
