package ConfigurarPersonajes;

import Enums.PosEstados;
import Enums.SuelosPosibles;

public abstract class BasePersonaje{
    protected String nombre;
    protected int ps;
    protected int psMaximo;
    protected int ataque;
    protected int precision;
    protected String apodo;
    protected PosEstados estado;
    protected SuelosPosibles suelo;
    protected int idHabilidad;
    protected int contadorEstados;
    protected int contadorSuelos;

    public BasePersonaje(String nombre, int ps, int ataque, int precision, PosEstados estado, String apodo){
        this.nombre = nombre;
        this.ps = ps;
        this.psMaximo = ps;
        this.ataque = ataque;
        this.precision = precision;
        this.estado = estado;
        this.suelo = SuelosPosibles.Normal;
        this.apodo = apodo;
    }

    // ---- Textos ----
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;}

    public String getApodo() {return apodo;}

    public void setApodo(String apodo) {
        this.apodo = apodo;}

    // ---- Ps ----
    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;}

    public int getPsMaximo() {return psMaximo;}

    public void setPsMaximo(int psMaximo) {
        this.psMaximo = psMaximo;}

    // ---- mecanias ----
    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;}

    public int getPrecision() {return precision;}

    public void setPrecision(int precision) {
        this.precision = precision;}

    public int getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(int idHabilidad) {
        this.idHabilidad = idHabilidad;
    }

    public void aplicarDanio(int danio){
        this.ps -= danio;
        controlPS();
    }

    public PosEstados getEstado() {return estado;}

    public void setEstado(PosEstados estado) {
        this.estado = estado;
    }

    public SuelosPosibles getSuelo(){return suelo;}

    public void setSuelo(SuelosPosibles suelo){this.suelo = suelo;}

    public int getContadorEstados(){return contadorEstados;}

    public void setContadorEstados(int contadorEstados){
       this.contadorEstados = contadorEstados;
    }

    public int getContadorSuelos() {return contadorSuelos;}

    public void setContadorSuelos(int contadorSuelos) { this.contadorSuelos = contadorSuelos;}

    public void controlPS(){
        if(getPs() < 0){
            setPs(0);
        }
    }

    public void recibirCura(int cura) {
        if ((this.ps + cura) <= this.psMaximo) {
            this.ps += cura;
        } else {
            this.ps = this.psMaximo;}
    }

    public String toString() {
        return "Personaje nuevo: "+nombre;
    }
}
