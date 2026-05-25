import ConfigurarPersonajes.GestionEnemigos;
import Enums.PosEstados;
import Enums.RolEnemigos;
import Mecanicas.CombateMenus;
import ConfigurarPersonajes.Enemigo;
import ConfigurarPersonajes.GestionPersonajes;
import ConfigurarPersonajes.Personaje;
import Enums.RolJugador;
import UsosDeMenu.TextosUsados;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);
        Boolean juegoActivo = true;
        String menuOpciones;
        GestionPersonajes gestorPer = new GestionPersonajes();
        Personaje pers1 = new Personaje("Tojita", "El colorista desquiciad", 100, PosEstados.Normal, RolJugador.Atacante, 1);
        Personaje pers2 = new Personaje("Wonejo", "El conejo dragon", 100, PosEstados.Normal, RolJugador.Apoyo, 2);
        Personaje pers3 = new Personaje("Hervacio", "El artesano misterioso", 50, PosEstados.Normal, RolJugador.Sabotaje, 4);
        Personaje pers4 = new Personaje("Anthony", "El carnero abismal", 75, PosEstados.Normal, RolJugador.Sabotaje, 3);

        GestionEnemigos gestorEne = new GestionEnemigos();
        Enemigo enem1 = new Enemigo("Gordiflon", 50, PosEstados.Normal, 3, RolEnemigos.Aguantador);
        Enemigo enem2 = new Enemigo("Ogro", 80, PosEstados.Normal, 1, RolEnemigos.Comun);
        Enemigo enem3 = new Enemigo("Armadura maldita", 90, PosEstados.Normal, 5, RolEnemigos.Fortalecido );
        Enemigo enem4 = new Enemigo("Rey insecto", 100, PosEstados.Normal, 7, RolEnemigos.Jefe);


        gestorPer.agregarPer(pers1);
        gestorPer.agregarPer(pers2);
        gestorPer.agregarPer(pers3);
        gestorPer.agregarPer(pers4);

        gestorEne.agregarEne(enem1);
        gestorEne.agregarEne(enem2);
        gestorEne.agregarEne(enem3);
        gestorEne.agregarEne(enem4);

        CombateMenus combate = new CombateMenus(gestorPer, gestorEne);
        System.out.println("\n#######################################");
        System.out.println("\nBienenido a: Un lugar muy basico\n");
        System.out.println("#######################################\n");
        while(juegoActivo){
            TextosUsados.menuMain();
            menuOpciones = menu.nextLine().toUpperCase();
            switch (menuOpciones){
                case "A":
                    TextosUsados.descripcion();
                    break;
                case "B":
                    TextosUsados.reglas(menu);
                    break;
                case "C":
                    combate.menuModos(menu);
                    break;
                case "D":
                    gestorPer.mostrarPersonajesStats();
                    break;
                case "E":
                    gestorEne.mostrarEnemigosStats();
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