package Mecanicas;

import ConfigurarPersonajes.Personaje;
import Enums.PosEstados;

public class Estados {

    public Estados(){}

    public void personajeEstados(Personaje personaje){
        switch (personaje.getEstado()){
            case Normal:
                break;
            case Entumecido:
                break;
            case Envenenado:
                break;
            case Sencible:
                break;
        }

    }

    public boolean estadoEntumecido(Personaje personaje){
        if(personaje.getEstado() == PosEstados.Entumecido){
            return true;}
        return false;
    }
}
