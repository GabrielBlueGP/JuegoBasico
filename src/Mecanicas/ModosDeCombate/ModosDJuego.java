package Mecanicas.ModosDeCombate;

import ConfigurarPersonajes.Enemigo;
import ConfigurarPersonajes.Personaje;
import Enums.PosEstados;
import Mecanicas.Energia;
import Mecanicas.Habilidades;
import Mecanicas.SistemaCombate;

import java.util.Scanner;

public class ModosDJuego {
    private int turnos;
    private final int limiteTurnos = 20;

    private SistemaCombate sist;

    public ModosDJuego(SistemaCombate sist){
        this.sist = sist;
    }

    public void unoVSUno(Personaje personaje, Enemigo enemigo, Scanner control){
        System.out.println("\nTurno "+getTurnos()+"\n");
        System.out.print("¿Que vas a hacer?\n(1) Atacar\n(2) Reservar\n(3) Ataque Cargado\n(4) Habilidad\nSu accion: ");
        String accion = control.nextLine();
        if(personaje.getEstado() == PosEstados.Entumecido){
            System.out.println("El jugador se encuentra Entumecido, No puede realizar ninguna accion");
        } else {
            sist.opcionesJugador(personaje, enemigo, accion);
        }
        if (enemigo.getPs() > 0){
            turnoEnemigo(enemigo, personaje);
            setTurnos(turnos + 1);
        } else {
            sist.verificarGanador(personaje, enemigo);
        }
    }

    public void contraReloj(Personaje personaje, Enemigo enemigo, Scanner control){
        if(turnos <= 15) {
            System.out.println("\n=============");
            System.out.println("\tTurno " + getTurnos());
            System.out.println("=============\n");
        } else {
            System.out.println("\n==========================");
            System.out.println("\t¡EL COMBATE ESTA POR ACABAR!");
            System.out.println("\t\t¡Turno " + getTurnos() +"!");
            System.out.println("==========================\n");
        }
        System.out.print("¿Que vas a hacer?\n(1) Atacar\n(2) Reservar\n(3) Ataque Cargado\n(4) Habilidad\nSu accion: ");
        String accion = control.nextLine();
        if(personaje.getEstado() == PosEstados.Entumecido){
            System.out.println("El jugador se encuentra Entumecido, No puede realizar ninguna accion");
        } else {
            sist.opcionesJugador(personaje, enemigo, accion);
        }
        setTurnos(turnos + 1);
        if (enemigo.getPs() > 0){
            turnoEnemigo(enemigo, personaje);
            setTurnos(turnos + 1);
        } else {
            verificarGanador(personaje, enemigo);
        }

    }

    public void verificarGanador(Personaje personaje, Enemigo enemigo){
        if(enemigo.getPs() == 0){
            System.out.println("\n¡HAS DERROTADO AL ENEMIGO!");}
        if(personaje.getPs() == 0){
            System.out.println("\nTe han derrotado...\nSuerta la proxima");}
    }

    public void finContraReloj(Personaje personaje, Enemigo enemigo){
        if(getTurnos() == getLimiteTurnos() || (personaje.getPs() > 0 && enemigo.getPs() > 0)){
            System.out.println("\n¡¡¡SE ACABO EL TIEMPO!!!\n\nResultados:");
            System.out.println("\tPS del jugador: "+personaje.getPs());
            System.out.println("\tPS del jugador: "+enemigo.getPs());
        } else {
            verificarGanador(personaje, enemigo);
        }
    }

    public void turnoEnemigo(Enemigo enemigo, Personaje personaje){
        System.out.println("\n==================");
        System.out.println("Turno "+getTurnos());
        System.out.println("==================\n");
        System.out.println("Turno del enemigo...\n");
        if(enemigo.getEstado() == PosEstados.Entumecido){
            System.out.println("El enemigo se encuentra Entumecido, No puede atacar");
        } else {
            sist.confirmarAtaqueEnemigo(personaje, enemigo);
        }
    }

    public int getTurnos() {return turnos;}

    public void setTurnos(int turnos) {
        this.turnos = turnos;}

    public int getLimiteTurnos(){return limiteTurnos;}
}
