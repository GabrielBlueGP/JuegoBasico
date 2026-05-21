package Mecanicas.ModosDeCombate;

import ConfigurarPersonajes.BasePersonaje;
import ConfigurarPersonajes.Enemigo;
import ConfigurarPersonajes.Personaje;
import Enums.EntornosTipo;
import Enums.PosEstados;
import Mecanicas.SistemaCombate;
import Mecanicas.TiposEnemigos;

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

    public void practica(Personaje personaje, Enemigo enemigo, Scanner control){
        secuencia1vs1(personaje, enemigo, control);
    }

    public void contraUnComun(Personaje personaje, Enemigo enemigo, Scanner control){
        mostrarTurnos(personaje, enemigo);
        mostrarOpciones();
        turnoJugador(personaje, enemigo, control);
        sumarTurnos();
        finalizarTurnos(personaje);
        if(enemigo.getPs() > 0) {
            turnoEnemigo(enemigo, personaje);
            sumarTurnos();
            finalizarTurnos(enemigo);
        }
        verificarGanador(personaje, enemigo);
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
        System.out.print("Opcion: ");
    }

    // ------ metodos de contra reloj ------
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

    public void finContraReloj(Personaje personaje, Enemigo enemigo){
        if(getTurnos() == getLimiteTurnos() || (personaje.getPs() > 0 && enemigo.getPs() > 0)){
            System.out.println("\n¡¡¡SE ACABO EL TIEMPO!!!\n\nResultados:");
            System.out.println("\tPS del jugador: "+personaje.getPs());
            System.out.println("\tPS del jugador: "+enemigo.getPs());
        } else {
            verificarGanador(personaje, enemigo);
        }
    }

    // ------ metodos de turnos ------
    public void turnoJugador(Personaje personaje, Enemigo enemigo, Scanner control){
        String accion = control.nextLine();
        if(sist.getEst().estadoEntumecido(personaje)){
            System.out.println("El jugador se encuentra Entumecido, No puede realizar ninguna accion");
        } else {
            sist.opcionesJugador(personaje, enemigo, accion);
            sist.getSue().sueloPuas(personaje);
        }
    }

    public void turnoEnemigo(Enemigo enemigo, Personaje personaje) {
        System.out.println("\n==================");
        System.out.println("Turno " + getTurnos());
        System.out.println("==================");
        System.out.println("-------Turno de enemigo-------");
        if (sist.getEst().estadoEntumecido(enemigo)) {
            System.out.println("El enemigo se encuentra Entumecido\nNo puede atacar");
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

    public void secuencia1vs1(Personaje personaje, Enemigo enemigo, Scanner control){
        mostrarTurnos(personaje, enemigo);
        mostrarOpciones();
        turnoJugador(personaje, enemigo, control);
        sumarTurnos();
        finalizarTurnos(personaje);
        if(enemigo.getPs() > 0) {
            turnoEnemigo(enemigo, personaje);
            sumarTurnos();
            finalizarTurnos(enemigo);
        }
        verificarGanador(personaje, enemigo);
    }

    public int getTurnos() {return turnos;}

    public void setTurnos(int turnos) {
        this.turnos = turnos;}

    public int getLimiteTurnos(){return limiteTurnos;}
}
