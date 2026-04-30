package Personajes;

public class Enemigo extends BasePersonaje{
    protected String efectoRival;

    public Enemigo(int ps, int ataque, int precision){
        super(ps, ataque, precision);
    }



    @Override
    public String toString() {
        return "Se creo el enemigo";
    }
}
