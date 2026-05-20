package ConfigurarPersonajes;

import Enums.PosEstados;

public class Enemigo extends BasePersonaje{
    protected String efectoRival;

    public Enemigo(String nombre, int ps, int ataque, int precision, PosEstados estado, String apodo, int idHabilidad){
        super(nombre, ps, ataque, precision, estado, apodo, idHabilidad);
    }



    @Override
    public String toString() {
        return "Se creo el enemigo";
    }
}
