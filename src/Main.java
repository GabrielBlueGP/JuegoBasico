import Enums.PosEstados;
import Mecanicas.CombateMenus;
import ConfigurarPersonajes.Enemigo;
import ConfigurarPersonajes.GestionarPersonajes;
import ConfigurarPersonajes.Personaje;
import Enums.Roles;
import UsosDeMenu.TextosUsados;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);
        Boolean juegoActivo = true;
        String menuOpciones;
        CombateMenus combate = new CombateMenus();
        GestionarPersonajes gestor = new GestionarPersonajes();
        Personaje pers1 = new Personaje("Tojita",300, 100, 100, PosEstados.Envenenado, Roles.Atacante, "El colorista desquiciado");
        Personaje pers2 = new Personaje("Wonejo", 500, 20, 100, PosEstados.Normal, Roles.Apoyo, "El conejo dragon");
        Personaje pers3 = new Personaje("Hervacio", 200, 50, 100, PosEstados.Normal, Roles.Sabotaje, "El artesano misterioso");
        Personaje pers4 = new Personaje("Anthony", 400, 70, 100, PosEstados.Normal, Roles.Atacante, "El carnero abismal");

        Enemigo enemigo = new Enemigo("Ogro", 2000, 10, 50, PosEstados.Normal, "Enemigo común");

        gestor.agregar(pers1);
        gestor.agregar(pers2);
        gestor.agregar(pers3);
        gestor.agregar(pers4);

        System.out.println("\nBienvenido a: Gana o muere :3\n\nOpciones:\n\n(Precione la tecla marcada en ( ) + Enter)");
        while(juegoActivo){
            System.out.print("\n(A) Acerca del juego\n(B) Reglas de juego\n(C) Jugar\n(D) Mostrar personajes\n(E) Salir del juego\n\nIngrese su opcion: ");
            menuOpciones = menu.nextLine();
            switch (menuOpciones){
                case "A":
                    TextosUsados.descripcion();
                    break;
                case "B":
                    TextosUsados.reglas();
                    break;
                case "C":
                    combate.menuModos(pers1, enemigo, menu);
                    break;
                case "D":
                    gestor.mostrarPersonajesStats();
                    break;
                case "E":
                    TextosUsados.salirDelPrograma();
                    juegoActivo = false;
                    break;
                default:
                    TextosUsados.opcionNoReconocida();
                    break;
            }
        }
    }
}