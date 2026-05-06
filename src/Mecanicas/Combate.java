package Mecanicas;

import EnumsUsados.EntornosPosibles;
import Personajes.Enemigo;
import Personajes.Personaje;

import java.util.Random;
import java.util.Scanner;

public class Combate {
    private SistemaCombate sist = new SistemaCombate();
    private String modoCombate;
    private Energia energia = new Energia();
    private Habilidades hab = new Habilidades();
    private EntornosPosibles entorno;

    public Combate(String modoCombate){
        this.modoCombate = modoCombate;
    }

    public void modoCombate(Personaje personaje, Enemigo enemigo, Scanner control) {
        int perMaxPs = personaje.getPs();
        int eneMaxPs = enemigo.getPs();
        entorno = EntornosPosibles.Normal;
        System.out.print("¿Iniciar combate?\n-Si\n-No\nDecida: ");
        String opcion = control.nextLine();
        if(opcion.equals("No") || opcion.equals("no")){
            System.out.println("No se realizo ningun combate");
        } else {
            if(opcion.equals("Si") || opcion.equals("si")){
                System.out.println("\n¡¡¡COMENZO EL COMBATE!!!\n");
                while(personaje.getPs() > 0 && enemigo.getPs() > 0){
                    System.out.print("¿Que vas a hacer?\n(1) Atacar\n(2) Reservar\n(3) Curarse\n(4) Ataque Cargado\nSu accion: ");
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
                            int curacion = curarse(personaje.getPs(), perMaxPs, curar);
                            personaje.setPs(personaje.getPs() + curacion);
                            System.out.println("¡Te curaste! Ps recuperados: "+curacion+" PS de "+personaje.getNombre()+": "+ personaje.getPs());
                            break;
                        case "4":
                            sist.confirmarAtaqueJugador(personaje, enemigo, accion, energia);
                            break;
                        default:
                            System.out.println("Accion no reconocida...\nSe contara como Reservar");
                            energia.manejoEnergia();
                            break;
                    }
                    sist.confirmarAtaqueEnemigo(personaje, enemigo);
                    System.out.println("");
                }
                if(enemigo.getPs() == 0){
                    personaje.setPs(sist.reseatPS(perMaxPs));
                    enemigo.setPs(sist.reseatPS(eneMaxPs));
                    System.out.println("¡HAS DERROTADO AL ENEMIGO!");
                } else {
                    if(personaje.getPs() == 0){
                        personaje.setPs(sist.reseatPS(perMaxPs));
                        enemigo.setPs(sist.reseatPS(eneMaxPs));
                        System.out.println("Te han derrotado...\nSuerta la proxima");
                    }
                }
            }
        }
        System.out.println("\nSaliendo del modo combate...\n");
    }


    public int curarse(int ps, int psMax, int cura) {
        if ((ps + cura) <= psMax) {
            return cura;}
        cura = psMax - ps;
        return cura;
    }
}


