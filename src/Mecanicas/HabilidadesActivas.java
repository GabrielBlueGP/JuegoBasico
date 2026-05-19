package Mecanicas;

import ConfigurarPersonajes.BasePersonaje;
import ConfigurarPersonajes.Enemigo;
import ConfigurarPersonajes.Personaje;
import Enums.EntornosTipo;
import Enums.PosEstados;

public class HabilidadesActivas {
    private Energia ener;
    private Estados est;
    private Suelos sue;
    private Entornos ento;

    private Integer idHabilidad;

    public HabilidadesActivas(Energia ener, Estados est, Suelos sue, Entornos ento){
        this.ener = ener;
        this.est = est;
        this.sue = sue;
        this.ento = ento;
    }

    public void superDanio(BasePersonaje atacante, BasePersonaje objetivo, Energia energia, int enerhab){
        int ataqueHabilidad = 500;
        energia.restarEnergia(enerhab);


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
