package Mecanicas;

import ConfigurarPersonajes.BasePersonaje;
import ConfigurarPersonajes.Enemigo;
import ConfigurarPersonajes.Personaje;

import java.util.Random;

public class SistemaCombate {
    private Energia ener;
    private Habilidades hab;
    private Entornos ento;

    private Random random = new Random();

    public SistemaCombate(Energia ener, Habilidades hab, Entornos ento){
        this.ener = ener;
        this.hab = hab;
        this.ento = ento;
    }

    //----- Metodos de PS -----
    public void restarPs(BasePersonaje atacante, BasePersonaje objetivo){
        objetivo.setPs(objetivo.getPs() - calcularDanio(atacante.getAtaque()));
        objetivo.controlPS();
        System.out.println("¡Atacaste! PS del enemigo: "+ objetivo.getPs());}

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
                ataqueJugadorEnergia(personaje, enemigo);
                break;}
    }

    public void ataqueJugadorEnergia(Personaje personaje, Enemigo enemigo){
        int danioAdicional = 0;
        if(ener.verificarEnergia()){
            danioAdicional = ener.aumentaDanio();
            enemigo.setPs(enemigo.getPs() - (personaje.getAtaque() + danioAdicional));
            enemigo.controlPS();
            System.out.print("\n¡Ataque Cargado!");
            System.out.println("PS del enemigo: "+ enemigo.getPs()+"\nataque de jugador: "+(personaje.getAtaque()+danioAdicional));
        } else {
            restarPs(personaje, enemigo);}}

    public void confirmarAtaqueJugador(Personaje personaje, Enemigo enemigo, String accion){
        tipoAtaque(personaje, enemigo, accion);}

    public void confirmarAtaqueEnemigo(Personaje personaje, Enemigo enemigo){
        if(enemigo.getPs() != 0){
            precisionFinal(enemigo, personaje);}}

    //----- Metodos Extras -----
    public void verificarGanador(Personaje personaje, Enemigo enemigo){
        if(enemigo.getPs() == 0){
            System.out.println("\n¡HAS DERROTADO AL ENEMIGO!");}
        if(personaje.getPs() == 0){
            System.out.println("\nTe han derrotado...\nSuerta la proxima");}
    }

    public void opcionesJugador(Personaje personaje, Enemigo enemigo, String accion){
        switch (accion){
            case "1":
                confirmarAtaqueJugador(personaje, enemigo, accion);
                break;
            case "2":
                ener.manejoEnergia();
                break;
            case "3":
                confirmarAtaqueJugador(personaje, enemigo, accion);
                break;
            case "4":
                int enerHab = ener.getEnergia();
                hab.superDanio(personaje, enemigo, ener, enerHab);
                break;
            default:
                System.out.println("Accion no reconocida...\nSe contara como Reservar");
                ener.manejoEnergia();
                break;
        }
    }
}
