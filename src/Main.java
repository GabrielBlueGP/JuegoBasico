import Enums.PosEstados;
import Enums.RolEnemigos;
import Mecanicas.CombateMenus;
import ConfigurarPersonajes.Enemigo;
import ConfigurarPersonajes.GestionarPersonajes;
import ConfigurarPersonajes.Personaje;
import Enums.RolJugador;
import UsosDeMenu.TextosUsados;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);
        Boolean juegoActivo = true;
        String menuOpciones;
        CombateMenus combate = new CombateMenus();
        GestionarPersonajes gestor = new GestionarPersonajes();
        Personaje pers1 = new Personaje("Tojita", "El colorista desquiciad", 100, PosEstados.Normal, RolJugador.Atacante, 1);
        Personaje pers2 = new Personaje("Wonejo", "El conejo dragon", 100, PosEstados.Normal, RolJugador.Apoyo, 2);
        Personaje pers3 = new Personaje("Hervacio", "El artesano misterioso", 50, PosEstados.Normal, RolJugador.Sabotaje, 4);
        Personaje pers4 = new Personaje("Anthony", "El carnero abismal", 75, PosEstados.Normal, RolJugador.Sabotaje, 3);

        Enemigo enemigo = new Enemigo("Gordiflon", 50, PosEstados.Normal, 1, RolEnemigos.Aguantador);

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