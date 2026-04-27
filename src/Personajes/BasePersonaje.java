package Personajes;

public abstract class BasePersonaje{
    protected int ps;
    protected int ataque;

    public BasePersonaje(int ps, int ataque){
        this.ps = ps;
        this.ataque = ataque;
    }

    public int getPs() {
        return ps;
    }

    public int getAtaque() {
        return ataque;
    }
}
