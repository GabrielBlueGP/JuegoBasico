package Mecanicas;

import Personajes.Enemigo;
import Personajes.Personaje;
import Personajes.Atacante;

import java.util.Scanner;

public class Combate {
    private String modoCombate;

    public Combate(String modoCombate) {
        this.modoCombate = modoCombate;}

    public void IniciarCombate(Personaje personaje, Enemigo enemigo) {
        Scanner control = new Scanner(System.in);
        System.out.println("Desea combatir (si / no): ");
        String opcion = control.nextLine();
        if (opcion.equals("Si") || opcion.equals("si")) {
            while (personaje.getRol().getPs() > 0 && enemigo.getPs() > 0) {
                System.out.println("Que vas a hacer?\n1) atacar\n 2) nada\nsu accion: ");
                int accion = control.nextInt();
                if (accion == 1) {
                    enemigo.setPs(enemigo.getPs() - personaje.getRol().getAtaque());
                    System.out.println("\nATACASTE!\n");
                } else {
                    System.out.println("\nNo atacaste...\n");}
                if (enemigo.getPs() > 0) {
                    personaje.getRol().setPs(personaje.getRol().getPs() - enemigo.getAtaque());}
                }
            System.out.println("Salud: " + personaje.getRol().getPs());
            System.out.println("Salud rival: " + enemigo.getPs());
        } else if (opcion.equals("No") || opcion.equals("no")) {
            System.out.println("No se realizara ningun combate");}
    }
}


