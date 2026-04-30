import Mecanicas.Combate;
import Personajes.Enemigo;
import Personajes.GestionarPersonajes;
import Personajes.Personaje;
import Personajes.Roles;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GestionarPersonajes gestor = new GestionarPersonajes();
        Personaje pers1 = new Personaje("Tojita",300, 100, 100, Roles.Atacante);
        Personaje pers2 = new Personaje("Wonejo", 500, 20, 100, Roles.Apoyo);
        Personaje pers3 = new Personaje("Hervacio", 200, 50, 100, Roles.Sabotaje);
        Personaje pers4 = new Personaje("Anthony", 400, 70, 100, Roles.Atacante);

        Enemigo enemigo = new Enemigo(1000, 50, 100);

        gestor.agregar(pers1);
        gestor.agregar(pers2);
        gestor.agregar(pers3);
        gestor.agregar(pers4);

        Combate combate = new Combate("Combatir");
        combate.modoCombate(pers1, enemigo);

    }
}