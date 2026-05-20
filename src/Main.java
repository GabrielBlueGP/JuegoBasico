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
        Personaje pers1 = new Personaje("Tojita",300, 100, 100, PosEstados.Normal, Roles.Atacante, "El colorista desquiciado", 1);
        Personaje pers2 = new Personaje("Wonejo", 500, 20, 100, PosEstados.Normal, Roles.Apoyo, "El conejo dragon", 2);
        Personaje pers3 = new Personaje("Hervacio", 200, 50, 100, PosEstados.Normal, Roles.Sabotaje, "El artesano misterioso", 3);
        Personaje pers4 = new Personaje("Anthony", 400, 70, 100, PosEstados.Normal, Roles.Atacante, "El carnero abismal", 4);

        Enemigo enemigo = new Enemigo("Ogro", 2000, 50, 50, PosEstados.Normal, "Enemigo común", 1);

        gestor.agregar(pers1);
        gestor.agregar(pers2);
        gestor.agregar(pers3);
        gestor.agregar(pers4);

        System.out.println("\nBienvenido a: Gana o muere :3\n\nOpciones:\n\n(Precione la tecla marcada en ( ) + Enter)");
        while(juegoActivo){
            System.out.print("\n(A) Acerca del juego\n(B) Reglas de juego\n(C) Jugar\n(D) Mostrar personajes\n(X) Salir del juego\n\nIngrese su opcion: ");
            menuOpciones = menu.nextLine().toUpperCase();
            switch (menuOpciones){
                case "A":
                    TextosUsados.descripcion();
                    break;
                case "B":
                    TextosUsados.reglas(menu);
                    break;
                case "C":
                    combate.menuModos(pers1, enemigo, menu);
                    break;
                case "D":
                    gestor.mostrarPersonajesStats();
                    break;
                case "X":
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