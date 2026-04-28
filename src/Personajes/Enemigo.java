package Personajes;

public class Enemigo extends BasePersonaje{
    protected String efectoRival;

    public Enemigo(int ps, int ataque){
        super(ps, ataque);
    }



    @Override
    public String toString() {
        return "Se creo el enemigo";
    }
}
