import Personajes.Atacante;
import Personajes.Enemigo;
import Personajes.Personaje;
import Mecanicas.Combate;

import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        Atacante atacante = new Atacante(100, 5, "Ninguno");
        Personaje personaje = new Personaje("Tojita", atacante);
        System.out.println(personaje+"\nPS: "+atacante.getPs()+"\nAtaque: "+atacante.getAtaque()+"\n");

        Enemigo enemigo = new Enemigo();
        enemigo.setPs(1500);
        enemigo.setAtaque(20);
        System.out.println(enemigo+"\nPS: "+enemigo.getPs());

        Combate combate = new Combate("Normal");

        combate.IniciarCombate(personaje, enemigo);
    }
}