package Personajes;

public abstract class BasePersonaje{
    protected int ps;
    protected int ataque;
    protected int precision;

    public BasePersonaje(int ps, int ataque, int precision){
        this.ps = ps;
        this.ataque = ataque;
        this.precision = precision;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;}

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;}

    public int getPrecision() {return precision;}

    public void setPrecision(int precision) {
        this.precision = precision;}
}
