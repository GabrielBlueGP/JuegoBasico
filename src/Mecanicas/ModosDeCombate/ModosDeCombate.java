package Mecanicas.ModosDeCombate;

import ConfigurarPersonajes.Enemigo;
import ConfigurarPersonajes.Personaje;
import Enums.PosEstados;
import Mecanicas.Energia;
import Mecanicas.Habilidades;
import Mecanicas.SistemaCombate;

import java.util.Scanner;

public class ModosDeCombate {

    public void menuUnoVSUno(Personaje personaje, Enemigo enemigo, Energia energia, SistemaCombate sist, Habilidades hab, int turnos, Scanner control){
        System.out.println("\nTurno "+turnos+"\n");
        System.out.print("¿Que vas a hacer?\n(1) Atacar\n(2) Reservar\n(3) Ataque Cargado\n(4) Habilidad\nSu accion: ");
        String accion = control.nextLine();
        if(personaje.getEstado() == PosEstados.Entumecido){
            System.out.println("El jugador se encuentra Entumecido, No puede realizar ninguna accion");
        } else {
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
                    break;}
        }
        turnos++;
        System.out.println("Turno "+turnos+"\nEl enemigo acciona");
        if(enemigo.getEstado() == PosEstados.Entumecido){
            System.out.println("El enemigo se encuentra Entumecido, No puede atacar");
        } else {
            sist.confirmarAtaqueEnemigo(personaje, enemigo);
        }
        verificarGanador(personaje, enemigo);
    }

    public void modoContraReloj(Personaje personaje, Enemigo enemigo, Energia energia, SistemaCombate sist, Habilidades hab, int turnos, Scanner control){
        if(turnos <= 15) {
            System.out.println("\n=============");
            System.out.println("\tTurno " + turnos);
            System.out.println("=============\n");
        } else {
            System.out.println("\n==========================");
            System.out.println("\t¡EL COMBATE ESTA POR ACABAR!");
            System.out.println("\t\t¡Turno " + turnos +"!");
            System.out.println("==========================\n");
        }
        System.out.print("¿Que vas a hacer?\n(1) Atacar\n(2) Reservar\n(3) Ataque Cargado\n(4) Habilidad\nSu accion: ");
        String accion = control.nextLine();
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
                break;}
        turnos++;
        System.out.println("Turno "+turnos+"\nEl enemigo acciona");
        sist.confirmarAtaqueEnemigo(personaje, enemigo);
    }

    public void verificarGanador(Personaje personaje, Enemigo enemigo){
        if(enemigo.getPs() == 0){
            System.out.println("\n¡HAS DERROTADO AL ENEMIGO!");}
        if(personaje.getPs() == 0){
            System.out.println("\nTe han derrotado...\nSuerta la proxima");}
    }
}
