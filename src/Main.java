import Mecanicas.Combate;
import Personajes.Enemigo;
import Personajes.GestionarPersonajes;
import Personajes.Personaje;
import Personajes.Roles;
import UsosDeMenu.TextosMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);
        Boolean juegoActivo = true;
        String menuOpciones;
        Combate combate = new Combate("Combatir");
        GestionarPersonajes gestor = new GestionarPersonajes();
        Personaje pers1 = new Personaje("Tojita",300, 100, 100, Roles.Atacante);
        Personaje pers2 = new Personaje("Wonejo", 500, 20, 100, Roles.Apoyo);
        Personaje pers3 = new Personaje("Hervacio", 200, 50, 100, Roles.Sabotaje);
        Personaje pers4 = new Personaje("Anthony", 400, 70, 100, Roles.Atacante);

        Enemigo enemigo = new Enemigo(1000, 50, 50);

        gestor.agregar(pers1);
        gestor.agregar(pers2);
        gestor.agregar(pers3);
        gestor.agregar(pers4);

        System.out.println("\nBienvenido a: Gana o muere :3\n\nOpciones:\n\n(Precione la tecla marcada en ( ) + Enter)");
        while(juegoActivo){
            System.out.print("\n(A) Acerca del juego\n(B) Reglas de juego\n(C) Jugar\n(D) Salir del juego\n\nIngrese su opcion: ");
            menuOpciones = menu.nextLine();
            switch (menuOpciones){
                case "A":
                    TextosMenu.descripcion();
                    break;
                case "B":
                    TextosMenu.reglas();
                    break;
                case "C":
                    combate.modoCombate(pers1, enemigo, menu);
                    break;
                case "D":
                    TextosMenu.salirDelPrograma();
                    juegoActivo = false;
                    break;
                default:
                    TextosMenu.opcionNoReconocida();
                    break;
            }
        }
    }
}