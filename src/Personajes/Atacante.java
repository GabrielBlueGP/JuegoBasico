package Personajes;

public class Atacante {
    private int ps;
    private int ataque;
    private String efecto;

    public Atacante(int ps, int ataque, String efecto){
        this.ps = ps + 700;
        this.ataque = ataque + 50;
        this.efecto = efecto;}

    public int getPs() {return ps;}
    public void setPs(int ps) {this.ps = ps;}

    public int getAtaque() {return ataque;}
    public void setAtaque(int ataque) {this.ataque = ataque;}

    public String toString() {
        return "- Personajes.Atacante";}
}
