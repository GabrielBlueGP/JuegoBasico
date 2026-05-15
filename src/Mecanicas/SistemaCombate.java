package Mecanicas;

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
    public int controlPS(int ps){
        if(ps < 0){
            ps = 0;
            return ps;}
        return ps;
    }

    public void restarPsEnemigo(Personaje personaje, Enemigo enemigo){
        enemigo.setPs(controlPS(enemigo.getPs() - calcularDanio(personaje.getAtaque())));
        System.out.println("¡Atacaste! PS del enemigo: "+ enemigo.getPs());}

    public void restarPsJugador(Enemigo enemigo, Personaje personaje){
        personaje.setPs(controlPS(personaje.getPs() - calcularDanio(enemigo.getAtaque())));
        System.out.println("¡EL ENEMIGO A ACERTADO SU ATAQUE¡ PS de "+personaje.getNombre()+": "+ personaje.getPs());}

    //----- Metodos de precision -----
    public int calcularPrecision(){
        return (random.nextInt(100)+1) + ento.accionTemblor();
    }

    public void precisionJugador(Personaje personaje, Enemigo enemigo, int precision){
        if(precision >= 1 && precision <= personaje.getPrecision()){
            restarPsEnemigo(personaje, enemigo);
        } else {
            System.out.println("¡El ataque fallo!");}}

    //----- Metodos de Ataques -----
    public int calcularDanio(int ataque){
        return ento.accionAgresivo(ataque);
    }

    public void tipoAtaque(Personaje personaje, Enemigo enemigo, String accion){
        int precision = calcularPrecision();
        switch (accion){
            case "1":
                precisionJugador(personaje, enemigo, precision);
                break;
            case "3":
                ataqueJugadorEnergia(personaje, enemigo);
                break;}
    }

    public void ataqueJugadorEnergia(Personaje personaje, Enemigo enemigo){
        int danioAdicional = 0;
        if(ener.verificarEnergia()){
            danioAdicional = ener.aumentaDanio();
            enemigo.setPs(controlPS(enemigo.getPs() - (personaje.getAtaque() + danioAdicional)));
            System.out.print("\n¡Ataque Cargado!");
            System.out.println("PS del enemigo: "+ enemigo.getPs()+"\nataque de jugador: "+(personaje.getAtaque()+danioAdicional));
        } else {
            restarPsEnemigo(personaje, enemigo);}}

    public void precisionEnemigo(Personaje personaje, Enemigo enemigo){
        int precision = calcularPrecision();
        if(precision >= 1 && precision <= enemigo.getPrecision()){
            restarPsJugador(enemigo, personaje);
        } else {
            System.out.println("¡El enemigo fallo su ataque!");}}

    public void confirmarAtaqueJugador(Personaje personaje, Enemigo enemigo, String accion){
        tipoAtaque(personaje, enemigo, accion);}

    public void confirmarAtaqueEnemigo(Personaje personaje, Enemigo enemigo){
        if(enemigo.getPs() != 0){
            precisionEnemigo(personaje, enemigo);}}

    //----- Metodos Extras -----
    public void verificarGanador(Personaje personaje, Enemigo enemigo){
        if(enemigo.getPs() == 0){
            System.out.println("\n¡HAS DERROTADO AL ENEMIGO!");}
        if(personaje.getPs() == 0){
            System.out.println("\nTe han derrotado...\nSuerta la proxima");}
    }

    public int verificarCura(int ps, int psMax, int cura) {
        if ((ps + cura) <= psMax) {
            return cura;}
        cura = psMax - ps;
        return cura;}

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
