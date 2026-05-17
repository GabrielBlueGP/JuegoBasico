package ConfigurarPersonajes;

import Enums.PosEstados;
import Enums.Roles;

public abstract class BasePersonaje{
    protected String nombre;
    protected int ps;
    protected int psMaximo;
    protected int ataque;
    protected int precision;
    protected String apodo;
    protected PosEstados estado;

    public BasePersonaje(String nombre, int ps, int ataque, int precision, PosEstados estado, String apodo){
        this.nombre = nombre;
        this.ps = ps;
        this.psMaximo = ps;
        this.ataque = ataque;
        this.precision = precision;
        this.estado = estado;
        this.apodo = apodo;
    }

    public String getNombre(){
        return nombre;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;}

    public int getPsMaximo() {return psMaximo;}

    public void setPsMaximo(int psMaximo) {
        this.psMaximo = psMaximo;}

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

    public void controlPS(){
        if(getPs() < 0){
            setPs(0);
        }
    }

    public void verificarCura(int cura) {
        if ((getPs() + cura) <= getPsMaximo()) {
            setPs(getPs() + cura);
        } else {setPs(getPsMaximo());}
    }

    public String toString() {
        return "Personaje nuevo: "+nombre;
    }
}
