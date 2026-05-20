package Mecanicas;

import ConfigurarPersonajes.BasePersonaje;
import Enums.PosEstados;
import Enums.SuelosPosibles;

public class Suelos {

    public void sueloToxico(BasePersonaje afectado){
        afectado.setEstado(PosEstados.Envenenado);
        System.out.println("El suelo toxico a envenenado a "+afectado.getNombre());

    }

    public void sueloPuas(BasePersonaje afectado){
        if(afectado.getSuelo() == SuelosPosibles.Puas) {
            int danioPuas = (afectado.getPs() * 5) / 100;
            afectado.aplicarDanio(danioPuas);
            System.out.println(afectado.getNombre()+" sufre "+danioPuas+" de puas");
        }
    }

    public void sueloResiliente(BasePersonaje afectado){
        if(afectado.getEstado() != PosEstados.Normal){
            afectado.setEstado(PosEstados.Normal);
            afectado.setContadorEstados(0);
        }
    }

    public void iniciarContador(BasePersonaje afectado){
        switch (afectado.getSuelo()){
            case Toxico:
                afectado.setContadorSuelos(2);
                break;
            case Puas:
                afectado.setContadorSuelos(6);
                break;
            case Resiliente:
                afectado.setContadorSuelos(4);
                break;
        }
    }

    public void controlSuelo(BasePersonaje afectado){
        if(afectado.getSuelo() == SuelosPosibles.Normal){
            return;
        }
        switch (afectado.getSuelo()){
            case Toxico:
                sueloToxico(afectado);
                break;
            case Puas:
                sueloPuas(afectado);
                break;
            case Resiliente:
                sueloResiliente(afectado);
                break;
        }
        reductorContador(afectado);
    }

    public void reductorContador(BasePersonaje afectado){
        if(afectado.getContadorSuelos() > 1){
            afectado.setContadorSuelos(afectado.getContadorSuelos() - 1);
            System.out.println("El suelo se mantendra por "+afectado.getContadorSuelos());
        } else {
            afectado.setContadorSuelos(0);
            afectado.setSuelo(SuelosPosibles.Normal);
            System.out.println("El suelo se ha restaurado a la normalidad");
        }
    }

    public void cambioSuelo(BasePersonaje afectado, SuelosPosibles nuevoSuelo){
        afectado.setSuelo(nuevoSuelo);
        iniciarContador(afectado);
    }
}
