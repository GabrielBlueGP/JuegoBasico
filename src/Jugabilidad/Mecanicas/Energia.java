package Jugabilidad.Mecanicas;

import ConfigurarPersonajes.BasePersonaje;

public class Energia {

    public Energia(){}

    public void manejoEnergia(BasePersonaje usuario){
        if(usuario.getEnergia() < 11){
            usuario.setEnergia(usuario.getEnergia() + 1);
            System.out.println("-----------------------------");
            System.out.println("Con calma, se ha reservado...");
            System.out.println("-----------------------------");
        } else {
            System.out.println("-----------------------------");
            System.out.println("Limite de energia alcanzado");
            System.out.println("-----------------------------");
        }
    }

    public Boolean verificarEnergia(BasePersonaje usuario){
        if(usuario.getEnergia() >= 3){
            return true;
        }
        return false;
    }

    public void reseteoEnergia(BasePersonaje usuario){
        usuario.setEnergia(0);
    }

    public void restarEnergia(BasePersonaje usuario, int resta){
        usuario.setEnergia(usuario.getEnergia() - resta);
    }

    public int aumentaDanio(BasePersonaje usuario){
        int danioAdicional = 50 * usuario.getEnergia();
        reseteoEnergia(usuario);
        return danioAdicional;
    }
}
