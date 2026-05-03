package Mecanicas;

import Personajes.Roles;
import Personajes.Personaje;
import Mecanicas.Energia;

public class Habilidades {
    private Roles rol;
    private Energia energia;
    public Habilidades(){}

    public int superdanio(Personaje personaje, Energia energia){
        int ataqueHabilidad = personaje.getAtaque() + 500;
        energia.setEnergia(0);
        return ataqueHabilidad;
    }
}
