package Mecanicas;

import ConfigurarPersonajes.Personaje;

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
}
