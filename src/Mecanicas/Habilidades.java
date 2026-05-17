package Mecanicas;

import ConfigurarPersonajes.Enemigo;
import ConfigurarPersonajes.Personaje;
import Enums.PosEstados;

public class Habilidades {
    private Integer id;

    public Habilidades(){}

    public void superDanio(Personaje personaje, Enemigo enemigo, Energia energia, int enerhab){
        int ataqueHabilidad = 500;
        energia.restarEnergia(enerhab);
        enemigo.setPs(personaje.getAtaque() + ataqueHabilidad);
    }

    public void curacion(Personaje personaje, Energia energia, int enerhab){
        int cura = (personaje.getPsMaximo() * 20) / 100;
        energia.restarEnergia(enerhab);

        System.out.println("¡Te curaste! Ps recuperados: "+cura+" PS de "+personaje.getNombre()+": "+ personaje.getPs());
    }

    public void golpeEntumecedor(Personaje personaje, Enemigo enemigo, Energia energia, int enerhab){
        enemigo.setEstado(PosEstados.Entumecido);
        System.out.println("¡El rival ha sido entumecido!");
    }


}
