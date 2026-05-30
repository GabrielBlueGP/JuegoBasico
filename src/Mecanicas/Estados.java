package Mecanicas;

import ConfigurarPersonajes.BasePersonaje;
import Enums.PosEstados;

public class Estados {

    public Estados(){}

    public void  iniciarContador(BasePersonaje afectado){
        switch (afectado.getEstado()){
            case Sensible:
                afectado.setContadorEstados(3);
                break;
            case Entumecido:
                afectado.setContadorEstados(8);
                break;
            case Dormido:
                afectado.setContadorEstados(3);
                break;
        }
    }

    public void cambioEstados(BasePersonaje afectado, PosEstados nuevoEstados){
        afectado.setEstado(nuevoEstados);
        iniciarContador(afectado);
    }

    public void controlEstado(BasePersonaje afectado){
        switch (afectado.getEstado()){
            case Envenenado:
                estEnvenenado(afectado);
                break;
            case Sensible:
            case Entumecido:
            case Dormido:
                if(afectado.getContadorEstados() > 1){
                    afectado.setContadorEstados(afectado.getContadorEstados() - 1);
                    System.out.println("El estado durara: "+afectado.getContadorEstados());
                } else {
                    afectado.setContadorEstados(0);
                    afectado.setEstado(PosEstados.Normal);
                    System.out.println("Su estado ha vuelto a la normalidad");
                }
                break;
        }
    }

    public int estSencible(BasePersonaje afectado, int ataque){
        if(afectado.getEstado() == PosEstados.Sensible){
            ataque = ataque * 2;
        }
        return ataque;
    }

    public void estEnvenenado(BasePersonaje afectado){
        if(afectado.getEstado() == PosEstados.Envenenado){
            int veneno = (afectado.getPs() * 5) / 100;
            afectado.aplicarDanio(veneno);
            System.out.println(afectado.getNombre()+" sufre "+veneno+" de daño por veneno");
        }
    }

    public boolean estadoEntumecido(BasePersonaje afectado){
        if(afectado.getEstado() == PosEstados.Entumecido){
            return true;
        }
        return false;
    }

    public boolean estadoDormido(BasePersonaje afectado){
        if(afectado.getEstado() == PosEstados.Dormido){
            return true;
        }
        return false;
    }
}
