package Personajes;

public class Enemigo {
    private int ps;
    private int ataque;
    private String efecto_1;
    private String efecto_2;

    public Enemigo(){}

    public int getPs() {return ps;}
    public void setPs(int ps) {this.ps = ps;}

    public int getAtaque() {return ataque;}
    public void setAtaque(int ataque) {this.ataque = ataque;}

    public String getEfecto_1() {return efecto_1;}
    public void setEfecto_1(String efecto_1) {this.efecto_1 = efecto_1;}

    public String getEfecto_2() {return efecto_2;}
    public void setEfecto_2(String efecto_2) {this.efecto_2 = efecto_2;}

    public int recibirDanio(int danio, int danioExtra){
        return this.ps = this.ps - (danio + danioExtra);}

    public String toString() {
        return "Un fuerte enemigo";}
}
