package Mecanicas;

import ConfigurarPersonajes.Enemigo;
import ConfigurarPersonajes.Personaje;

public class Habilidades {

    private Energia energia;
    private int danioHabilidad;

    public Habilidades(){}

    public int entornoAgresivo(){
        int danioAgresivo = 1;
        return danioAgresivo;
    }

    public int superDanio(Personaje personaje, Enemigo enemigo, Energia energia, int enerhab){
        int ataqueHabilidad = 500;
        energia.restarEnergia(enerhab);
        enemigo.setPs(personaje.getAtaque());
        return ataqueHabilidad;
    }

    public void curacion(Personaje personaje, Energia energia, int enerhab, int psMax){
        int curaBase = 100;
        int cura = curaBase;
        energia.restarEnergia(enerhab);
        personaje.setPs(personaje.getPs() + cura);
        System.out.println("¡Te curaste! Ps recuperados: "+cura+" PS de "+personaje.getNombre()+": "+ personaje.getPs());
    }
}
