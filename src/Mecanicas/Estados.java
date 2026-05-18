package Mecanicas;

import ConfigurarPersonajes.BasePersonaje;
import ConfigurarPersonajes.Personaje;
import Enums.EntornosTipo;
import Enums.PosEstados;

public class Estados {

    public Estados(){}

    public void personajeEstados(BasePersonaje afectado){
        switch (afectado.getEstado()){
            case Normal:
                System.out.println("Estado normal");
                break;
            case Entumecido:
                System.out.println("Estado entumecido");
                break;
            case Envenenado:
                System.out.println("Estado envenenado");
                break;
            case Sencible:
                System.out.println("Estado sencible");
                break;
        }
    }

    public void  iniciarContador(BasePersonaje afectado){
        switch (afectado.getEstado()){
            case Sencible:
                afectado.setContadorEstados(3);
                break;
            case Entumecido:
                afectado.setContadorEstados(4);
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
            case Sencible:
            case Entumecido:
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

    public void setear(BasePersonaje afectado){
        afectado.setEstado(PosEstados.Envenenado);
    }

    public int estSencible(BasePersonaje afectado, int ataque){
        if(afectado.getEstado() == PosEstados.Sencible){
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

    public boolean estadoEntumecido(BasePersonaje afectadp){
        if(afectadp.getEstado() == PosEstados.Entumecido){
            return true;}
        return false;
    }
}
