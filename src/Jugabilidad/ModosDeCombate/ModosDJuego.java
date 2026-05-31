package Jugabilidad.ModosDeCombate;

import ConfigurarPersonajes.BasePersonaje;
import ConfigurarPersonajes.Enemigo;
import ConfigurarPersonajes.Personaje;
import Enums.EntornosTipo;
import Jugabilidad.SistemaCombate;
import Jugabilidad.TiposEnemigos;

import java.util.Scanner;

public class ModosDJuego {
    private int turnos;
    private final int limiteTurnos = 20;

    private SistemaCombate sist;
    private TiposEnemigos tipoEnemigo;

    public ModosDJuego(SistemaCombate sist, TiposEnemigos tipoEnemigo){
        this.sist = sist;
        this.tipoEnemigo = tipoEnemigo;
    }

    public boolean practica(Personaje personaje, Enemigo enemigo, Scanner control){
        return secuencia1vs1(personaje, enemigo, control);
    }

    public boolean contraUnComun(Personaje personaje, Enemigo enemigo, Scanner control){
        return secuencia1vs1(personaje,enemigo, control);
    }

    public boolean contraFortalecido(Personaje personaje, Enemigo enemigo, Scanner control){
        return secuencia1vs1(personaje, enemigo, control);
    }

    public boolean contraJefe(Personaje personaje, Enemigo enemigo, Scanner control){
        return secuencia1vs1(personaje, enemigo, control);
    }

    public boolean alLimite(Personaje personaje, Enemigo enemigo, Scanner control){
        return secuenciaLimite(personaje, enemigo, control);
    }

    // ------ metodos de juegos en general ------
    public void verificarGanador(Personaje personaje, Enemigo enemigo){
        if(personaje.getPs() == 0  && enemigo.getPs() == 0){
            System.out.println("\n¡Ambos han caido derrotados!");
        } else if (enemigo.getPs() == 0){
            System.out.println("\n¡HAS DERROTADO AL ENEMIGO!");
        } else if (personaje.getPs() == 0) {
            System.out.println("\nTe han derrotado...\nSuerta la proxima");
        }
    }

    public void verificarAlLimite(Personaje personaje, Enemigo enemigo){
        if((personaje.getPs() > 0  && enemigo.getPs() > 0) || turnos == 0){
            System.out.println("\n¡Fin del combate!");
            System.out.println("Nadie ha ganado");
        } else if(enemigo.getPs() == 0){
            System.out.println("\n¡HAS DERROTADO AL ENEMIGO ANTES DE TIEMPO!");
        } else if (personaje.getPs() == 0) {
            System.out.println("\n¡TE HAN DERROTADO ANTES DE TIEMPO!");
        }
    }

    public void mostrarTurnos(Personaje personaje, Enemigo enemigo){
        System.out.println("================");
        System.out.println("Turno " + getTurnos());
        System.out.println("=============");
        System.out.println("Entorno: "+ sist.getEnto().getEntor());
        if(sist.getEnto().getEntor() != EntornosTipo.Normal){
            System.out.println("=============");
            System.out.println("Duracion de turnos: "+sist.getEnto().getContadorEntorno());
        }
        mostrarEstadisticas(personaje, enemigo);
    }

    private void turnosAlLimite(Personaje personaje, Enemigo enemigo){
        if(turnos <= 15) {
            System.out.println("================");
            System.out.println("Turno " + getTurnos());
            System.out.println("=============");
        } else {
            System.out.println("==========================");
            System.out.println("¡EL COMBATE ESTA POR ACABAR!");
            System.out.println("¡Turno " + getTurnos() +"!");
            System.out.println("==========================");
        }
        System.out.println("Entorno: "+ sist.getEnto().getEntor());
        if(sist.getEnto().getEntor() != EntornosTipo.Normal){
            System.out.println("=============");
            System.out.println("Duracion de turnos: "+sist.getEnto().getContadorEntorno());
        }
        mostrarEstadisticas(personaje, enemigo);
    }

    public void mostrarEstadisticas(Personaje personaje, Enemigo enemigo){
        System.out.println("================");
        System.out.println(personaje.getNombre()+" - PS: "+personaje.getPs()+"/"+personaje.getPsMaximo());
        System.out.println("Energia: "+personaje.getEnergia());
        System.out.println("Estado: "+personaje.getEstado());
        System.out.println("Suelo: "+personaje.getSuelo());
        System.out.println("-----------------");
        System.out.println(enemigo.getNombre()+" - PS: "+enemigo.getPs()+"/"+enemigo.getPsMaximo());
        System.out.println("Energia: "+enemigo.getEnergia());
        System.out.println("Estado: "+enemigo.getEstado());
        System.out.println("Suelo: "+enemigo.getSuelo());
        System.out.println("================");
    }

    public void mostrarOpciones(){
        System.out.println("¡¡¡ ---------- Acciones --------- !!!");
        System.out.println("(1) Atacar");
        System.out.println("(2) Reservar");
        System.out.println("(3) Ataque Cargado");
        System.out.println("(4) Habilidad");
        System.out.println("(X) Salir del combate");
        System.out.print("Opcion: ");
    }

    // ------ metodos de contra reloj ------

    // ------ metodos de turnos ------
    public boolean turnoJugador(Personaje personaje, Enemigo enemigo, Scanner control){
        if(sist.getEst().estadoEntumecido(personaje)){
            System.out.println(personaje.getNombre()+" se encuentra entumecido, no pueda hacer nada...");
        } else if(sist.getEst().estadoDormido(personaje)){
            System.out.println(personaje.getNombre()+" se encuentra dormido, no pueda hacer nada...");
        } else {
            mostrarOpciones();
            String accion = control.nextLine();
            if(accion.equalsIgnoreCase("X")){
                System.out.println("------------------------------------------------");
                System.out.println("Combate cancelado, volviendo al menu...");
                System.out.println("------------------------------------------------");
                return false;
            }
            sist.opcionesJugador(personaje, enemigo, accion);
            sist.getSue().sueloPuas(personaje);
        }
        return true;
    }

    public void turnoEnemigo(Enemigo enemigo, Personaje personaje) {
        System.out.println("\n==================");
        System.out.println("Turno " + getTurnos());
        System.out.println("==================");
        System.out.println("-------Turno de enemigo-------");
        if (sist.getEst().estadoEntumecido(enemigo)){
            System.out.println(enemigo.getNombre()+" se encuentra entumecido, no puede hacer nada...");
        } else if(sist.getEst().estadoDormido(enemigo)){
            System.out.println(enemigo.getNombre()+" se encuentra dormido, no pueda hacer nada");
        } else {
            tipoEnemigo.selecEnemigo(enemigo, personaje);
        }
    }

    public void sumarTurnos(){
        setTurnos(turnos + 1);
    }

    public void finalizarTurnos(BasePersonaje perTurno){
        sist.getEst().controlEstado(perTurno);
        if(sist.getEnto().getEntor() != EntornosTipo.Normal){
            sist.getEnto().controlEntorno();
        }
        sist.getSue().controlSuelo(perTurno);
    }

    public boolean secuenciaLimite(Personaje personaje, Enemigo enemigo, Scanner control){
        turnosAlLimite(personaje, enemigo);
        mostrarOpciones();
        if(!turnoJugador(personaje, enemigo, control)){
            return false;
        }
        sumarTurnos();
        finalizarTurnos(personaje);
        if(enemigo.getPs() > 0) {
            turnoEnemigo(enemigo, personaje);
            sumarTurnos();
            finalizarTurnos(enemigo);
        }
        verificarAlLimite(personaje, enemigo);
        return true;
    }

    public boolean secuencia1vs1(Personaje personaje, Enemigo enemigo, Scanner control){
        mostrarTurnos(personaje, enemigo);
        if(!turnoJugador(personaje, enemigo, control)){
            return false;
        }
        sumarTurnos();
        finalizarTurnos(personaje);
        if(enemigo.getPs() > 0) {
            turnoEnemigo(enemigo, personaje);
            sumarTurnos();
            finalizarTurnos(enemigo);
        }
        verificarGanador(personaje, enemigo);
        return true;
    }

    public int getTurnos() {return turnos;}

    public void setTurnos(int turnos) {
        this.turnos = turnos;}

    public int getLimiteTurnos(){return limiteTurnos;}
}
