package Mecanicas;

import Enums.EntornosPosibles;
import ConfigurarPersonajes.Enemigo;
import ConfigurarPersonajes.Personaje;

import java.util.Scanner;

public class Combate {
    private SistemaCombate sist = new SistemaCombate();
    private String modoCombate;
    private Energia energia = new Energia();
    private Habilidades hab = new Habilidades();
    private EntornosPosibles entorno = EntornosPosibles.Normal;

    public Combate(String modoCombate){
        this.modoCombate = modoCombate;
    }

    public void modoCombate(Personaje personaje, Enemigo enemigo, Scanner control) {
        System.out.print("¿Iniciar combate?\n-Si\n-No\nDecida: ");
        String opcion = control.nextLine();
        if(opcion.equals("No") || opcion.equals("no")){
            System.out.println("No se realizo ningun combate");
        } else {
            if(opcion.equals("Si") || opcion.equals("si")){
                combateUnoVSUno(personaje, enemigo, control);
            }
        }
        System.out.println("\nSaliendo del modo combate...\n");
    }


    public void combateUnoVSUno(Personaje personaje, Enemigo enemigo, Scanner control){
        int perMaxPs = personaje.getPs();
        int eneMaxPs = enemigo.getPs();
        System.out.println("\n¡¡¡COMENZO EL COMBATE!!!\n");
        while(personaje.getPs() > 0 && enemigo.getPs() > 0){
            System.out.print("¿Que vas a hacer?\n(1) Atacar\n(2) Reservar\n(3) Curarse\n(4) Ataque Cargado\n(5) Habilidad\nSu accion: ");
            String accion = control.nextLine();
            switch (accion){
                case "1":
                    sist.confirmarAtaqueJugador(personaje, enemigo, accion, energia);
                    break;
                case "2":
                    energia.manejoEnergia();
                    break;
                case "3":
                    int curar = 100;
                    int curacion = verificarCura(personaje.getPs(), perMaxPs, curar);
                    personaje.setPs(personaje.getPs() + curacion);
                    System.out.println("¡Te curaste! Ps recuperados: "+curacion+" PS de "+personaje.getNombre()+": "+ personaje.getPs());
                    break;
                case "4":
                    sist.confirmarAtaqueJugador(personaje, enemigo, accion, energia);
                    break;
                case "5":
                    int enerHab = energia.getEnergia();
                    int habAtaque = hab.superDanio(personaje, enemigo, energia, enerHab);
                    break;
                default:
                    System.out.println("Accion no reconocida...\nSe contara como Reservar");
                    energia.manejoEnergia();
                    break;}
            sist.confirmarAtaqueEnemigo(personaje, enemigo);
            if(enemigo.getPs() == 0){
                System.out.println("\n¡HAS DERROTADO AL ENEMIGO!");}
            if(personaje.getPs() == 0){
                System.out.println("\nTe han derrotado...\nSuerta la proxima");}
        }
        personaje.setPs(sist.reseatPS(perMaxPs));
        enemigo.setPs(sist.reseatPS(eneMaxPs));

    }

    public int verificarCura(int ps, int psMax, int cura) {
        if ((ps + cura) <= psMax) {
            return cura;}
        cura = psMax - ps;
        return cura;
    }
}


