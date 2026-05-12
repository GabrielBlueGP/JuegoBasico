package Mecanicas.ModosDeCombate;

import ConfigurarPersonajes.Enemigo;
import ConfigurarPersonajes.Personaje;
import Enums.PosEstados;
import Mecanicas.Energia;
import Mecanicas.Habilidades;
import Mecanicas.SistemaCombate;

import java.util.Scanner;

public class ModosDeCombate {
    private int turnos;
    private final int limiteTurnos = 20;

    public void unoVSUno(Personaje personaje, Enemigo enemigo, Energia energia, SistemaCombate sist, Habilidades hab, Scanner control){
        System.out.println("\nTurno "+getTurnos()+"\n");
        System.out.print("¿Que vas a hacer?\n(1) Atacar\n(2) Reservar\n(3) Ataque Cargado\n(4) Habilidad\nSu accion: ");
        String accion = control.nextLine();
        if(personaje.getEstado() == PosEstados.Entumecido){
            System.out.println("El jugador se encuentra Entumecido, No puede realizar ninguna accion");
        } else {
            opcionesJugador(personaje, enemigo, energia, sist, hab, accion);
        }
        setTurnos(turnos + 1);
        turnoEnemigo(enemigo, personaje, sist);
        setTurnos(turnos + 1);
        verificarGanador(personaje, enemigo);
    }

    public void contraReloj(Personaje personaje, Enemigo enemigo, Energia energia, SistemaCombate sist, Habilidades hab, Scanner control){
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
            opcionesJugador(personaje, enemigo, energia, sist, hab, accion);
        }
        setTurnos(turnos + 1);
        turnoEnemigo(enemigo, personaje, sist);
        setTurnos(turnos + 1);
    }

    public void opcionesJugador(Personaje personaje, Enemigo enemigo, Energia energia, SistemaCombate sist, Habilidades hab, String accion){
        switch (accion){
            case "1":
                sist.confirmarAtaqueJugador(personaje, enemigo, accion, energia);
                break;
            case "2":
                energia.manejoEnergia();
                break;
            case "3":
                sist.confirmarAtaqueJugador(personaje, enemigo, accion, energia);
                break;
            case "4":
                int enerHab = energia.getEnergia();
                int habAtaque = hab.superDanio(personaje, enemigo, energia, enerHab);
                break;
            default:
                System.out.println("Accion no reconocida...\nSe contara como Reservar");
                energia.manejoEnergia();
                break;
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

    public void turnoEnemigo(Enemigo enemigo, Personaje personaje, SistemaCombate sist){
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
