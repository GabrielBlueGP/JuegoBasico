import ConfigurarPersonajes.GestionEnemigos;
import Enums.PosEstados;
import Enums.RolEne;
import Mecanicas.CombateMenus;
import ConfigurarPersonajes.Enemigo;
import ConfigurarPersonajes.GestionPersonajes;
import ConfigurarPersonajes.Personaje;
import Enums.RolPer;
import UsosDeMenu.TextosUsados;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);
        Boolean juegoActivo = true;
        String menuOpciones;
        GestionPersonajes gestorPer = new GestionPersonajes();
        Personaje pers1 = new Personaje("Brayan", "El espadachin", 100, PosEstados.Normal, RolPer.Atacante, 1);
        Personaje pers2 = new Personaje("Chris", "El curandero", 90, PosEstados.Normal, RolPer.Apoyo, 2);
        Personaje pers3 = new Personaje("Fabi", "El dormilon", 90, PosEstados.Normal, RolPer.Apoyo, 3);
        Personaje pers4 = new Personaje("Luana", "La viajera", 80, PosEstados.Normal, RolPer.Sabotaje, 4);
        Personaje pers5 = new Personaje("Valen", "El luchador", 80, PosEstados.Normal, RolPer.Sabotaje, 5);
        Personaje pers6 = new Personaje("Matias", "El brujo", 80, PosEstados.Normal, RolPer.Atacante, 6);
        Personaje pers7 = new Personaje("Luna", "La cuidadora", 80, PosEstados.Normal, RolPer.Apoyo, 7);
        Personaje pers8 = new Personaje("Paola", "La intercambiante", 80, PosEstados.Normal, RolPer.Sabotaje, 8);
        Personaje pers9 = new Personaje("Bogdan", "El salvaje", 80, PosEstados.Normal, RolPer.Atacante, 9);
        Personaje pers10 = new Personaje("Xavier", "El deportista", 80, PosEstados.Normal, RolPer.Sabotaje, 10);
        Personaje pers11 = new Personaje("Lauty", "El musico", 80, PosEstados.Normal, RolPer.Atacante, 11);
        Personaje pers12 = new Personaje("Toji", "El cantante", 80, PosEstados.Normal, RolPer.Apoyo, 12);
        Personaje pers13 = new Personaje("Hervo", "El peligroso", 80, PosEstados.Normal, RolPer.Sabotaje, 13);


        GestionEnemigos gestorEne = new GestionEnemigos();
        Enemigo enem1 = new Enemigo("Gordiflon", 0, PosEstados.Normal, 3, RolEne.Aguantador);
        Enemigo enem2 = new Enemigo("Ogro", 80, PosEstados.Normal, 1, RolEne.Comun);
        Enemigo enem3 = new Enemigo("Armadura maldita", 90, PosEstados.Normal, 1, 5, RolEne.Fortalecido );
        Enemigo enem4 = new Enemigo("Rey insecto", 100, PosEstados.Normal, 1, 6, 13, RolEne.Jefe);
        Enemigo enem5 = new Enemigo("Ogrin", 50, PosEstados.Normal, 1, RolEne.Comun);


        gestorPer.agregarPer(pers1);
        gestorPer.agregarPer(pers2);
        gestorPer.agregarPer(pers3);
        gestorPer.agregarPer(pers4);
        gestorPer.agregarPer(pers5);
        gestorPer.agregarPer(pers6);
        gestorPer.agregarPer(pers7);
        gestorPer.agregarPer(pers8);
        gestorPer.agregarPer(pers9);
        gestorPer.agregarPer(pers10);
        gestorPer.agregarPer(pers11);
        gestorPer.agregarPer(pers12);
        gestorPer.agregarPer(pers13);


        gestorEne.agregarEne(enem1);
        gestorEne.agregarEne(enem2);
        gestorEne.agregarEne(enem3);
        gestorEne.agregarEne(enem4);
        gestorEne.agregarEne(enem5);

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