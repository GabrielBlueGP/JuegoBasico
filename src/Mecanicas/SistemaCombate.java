package Mecanicas;

import ConfigurarPersonajes.BasePersonaje;
import ConfigurarPersonajes.Enemigo;
import ConfigurarPersonajes.Personaje;
import Enums.EntornosTipo;

import java.util.Random;

public class SistemaCombate {
    private Energia ener;
    private Habilidades hab;
    private Entornos ento;
    private Estados est;

    private Random random = new Random();

    public SistemaCombate(Energia ener, Habilidades hab, Entornos ento, Estados est){
        this.ener = ener;
        this.hab = hab;
        this.ento = ento;
        this.est = est;
    }

    //----- Metodos de PS -----
    public void restarPs(BasePersonaje atacante, BasePersonaje objetivo){
        int ataque = calcularDanio(atacante.getAtaque());
        ataque = est.estSencible(objetivo, ataque);
        objetivo.aplicarDanio(objetivo, ataque);
        System.out.println("¡"+atacante.getNombre()+" acerto su ataque contra "+ objetivo.getNombre()+"!");
        System.out.println("Daño: "+ataque);

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
        if(ener.verificarEnergia()){
            int cargado = ener.aumentaDanio();
            int ataGuardado = atacante.getAtaque() + cargado;
            ataGuardado = calcularDanio(ataGuardado);
            objetivo.aplicarDanio(objetivo, ataGuardado);
            System.out.println("¡"+atacante.getNombre()+" acerto su ataque contra "+ objetivo.getNombre()+"!");
            System.out.println("Daño: "+ataGuardado);
            System.out.println("\n¡Ataque Cargado Acertado!");
            System.out.println("PS de "+objetivo.getNombre()+": "+objetivo.getPs());
            System.out.println("ataque recibido: "+ ataGuardado);
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
    public Entornos getEnto() {
        return ento;}

    public Estados getEst(){
        return est;
    }

    public void verificarGanador(Personaje personaje, Enemigo enemigo){
        if(enemigo.getPs() == 0){
            System.out.println("\n¡HAS DERROTADO AL ENEMIGO!");}
        if(personaje.getPs() == 0){
            System.out.println("\nTe han derrotado...\nSuerta la proxima");}
    }

    public void probar1(){
        getEnto().cambioEntorno(EntornosTipo.Agresivo);
    }

    public void probar2(BasePersonaje afectado){
        getEst().setear(afectado);
    }

    public void opcionesJugador(Personaje personaje, Enemigo enemigo, String accion){
        switch (accion) {
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
                probar1();
                //probar2(enemigo);
                System.out.println("Estado afectado: "+enemigo.getEstado());
                break;
            default:
                System.out.println("Accion no reconocida...\nSe contara como Reservar");
                ener.manejoEnergia();
                break;
        }
        ento.accionSanador(personaje);
    }
}
