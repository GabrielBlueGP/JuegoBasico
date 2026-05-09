package ConfigurarPersonajes;

import Enums.PosEstados;

public abstract class BasePersonaje{
    protected int ps;
    protected int ataque;
    protected int precision;
    protected String apodo;
    protected PosEstados estado;

    public BasePersonaje(int ps, int ataque, int precision, PosEstados estado, String apodo){
        this.ps = ps;
        this.ataque = ataque;
        this.precision = precision;
        this.estado = estado;
        this.apodo = apodo;
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

    public String getApodo() {return apodo;}

    public void setApodo(String apodo) {
        this.apodo = apodo;}

    public PosEstados getEstado() {return estado;}

    public void setEstado(PosEstados estado) {
        this.estado = estado;}
}
