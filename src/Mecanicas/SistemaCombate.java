package Mecanicas;

import ConfigurarPersonajes.BasePersonaje;
import ConfigurarPersonajes.Enemigo;
import ConfigurarPersonajes.Personaje;
import Enums.EntornosTipo;

import java.util.Random;

public class SistemaCombate {
    private Energia ener;
    private HabilidadesActivas hab;
    private Entornos ento;
    private Suelos sue;
    private Estados est;

    private Random random = new Random();

    public SistemaCombate(Energia ener, HabilidadesActivas hab, Entornos ento, Suelos sue, Estados est){
        this.ener = ener;
        this.hab = hab;
        this.ento = ento;
        this.sue = sue;
        this.est = est;
    }

    //----- Metodos de PS -----
    public void restarPs(BasePersonaje atacante, BasePersonaje objetivo){
        int ataque = calcularDanio(atacante.getAtaque());
        ataque = est.estSencible(objetivo, ataque);
        objetivo.aplicarDanio(ataque);
        System.out.println("¡"+atacante.getNombre()+" acerto su ataque contra "+ objetivo.getNombre()+"!");
        System.out.println("Daño causado: "+ataque);

    }

    //----- Metodos de precision -----
    public int calcularPrecision(){
        return (random.nextInt(100)+1) + ento.accionTemblor();
    }

    public void precisionFinal(BasePersonaje atacante, BasePersonaje objetivo){
        int precision = calcularPrecision();
        if(precision >= 1 && precision <= atacante.getPrecision()){
            restarPs(atacante, objetivo);
        } else {
            System.out.println("¡El ataque fallo!");}}

    //----- Metodos de Ataques -----
    public int calcularDanio(int ataque){
        return ento.accionAgresivo(ataque);
    }

    public void tipoAtaque(Personaje personaje, Enemigo enemigo, String accion){
        switch (accion){
            case "1":
                precisionFinal(personaje, enemigo);
                break;
            case "3":
                ataqueCargado(personaje, enemigo);
                break;}
    }

    public void ataqueCargado(BasePersonaje atacante, BasePersonaje objetivo){
        if(ener.verificarEnergia(atacante)){
            int cargado = ener.aumentaDanio(atacante);
            int ataGuardado = atacante.getAtaque() + cargado;
            ataGuardado = calcularDanio(ataGuardado);
            objetivo.aplicarDanio(ataGuardado);
            System.out.println("-----------------------------");
            System.out.println("¡¡¡Ataque Cargado!!!");
            System.out.println("¡"+atacante.getNombre()+" acerto su ataque contra "+ objetivo.getNombre()+"!");
            System.out.println("Daño hecho: "+ ataGuardado);
            System.out.println("-----------------------------");
        } else {
            restarPs(atacante, objetivo);
        }
    }

    public void confirmarAtaqueJugador(Personaje personaje, Enemigo enemigo, String accion){
        tipoAtaque(personaje, enemigo, accion);}

    public void confirmarAtaqueEnemigo(Personaje personaje, Enemigo enemigo){
        if(enemigo.getPs() != 0) {
            precisionFinal(enemigo, personaje);
            ento.accionSanador(enemigo);
        }
    }

    //----- Metodos Extras -----
    public Entornos getEnto() {return ento;}

    public Estados getEst(){return est;}

    public Suelos getSue(){return sue;}

    public void opcionesJugador(Personaje personaje, Enemigo enemigo, String accion){
        switch (accion) {
            case "1":
                confirmarAtaqueJugador(personaje, enemigo, accion);
                break;
            case "2":
                ener.manejoEnergia(personaje);
                break;
            case "3":
                confirmarAtaqueJugador(personaje, enemigo, accion);
                break;
            case "4":
                hab.ejecutarHabilidades(personaje, enemigo);
                break;
            case "X":
                break;
            default:
                System.out.println("------------------------------------------------");
                System.out.println("Accion no reconocida...Se contara como Reservar");
                System.out.println("------------------------------------------------");
                ener.manejoEnergia(personaje);
                break;
        }
        ento.accionSanador(personaje);
    }
}
