package ConfigurarPersonajes;

import Enums.PosEstados;

public class Enemigo extends BasePersonaje{
    protected String efectoRival;

    public Enemigo(int ps, int ataque, int precision, PosEstados estado, String apodo){
        super(ps, ataque, precision, estado, apodo);
    }



    @Override
    public String toString() {
        return "Se creo el enemigo";
    }
}
