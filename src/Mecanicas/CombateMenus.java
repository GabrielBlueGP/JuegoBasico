package Mecanicas;

import ConfigurarPersonajes.*;
import Enums.EntornosTipo;
import Enums.PosEstados;
import Enums.SuelosPosibles;
import Mecanicas.ModosDeCombate.ModosDJuego;

import java.util.Scanner;

public class CombateMenus {
    private GestionPersonajes gestPer;
    private GestionEnemigos gestEne;
    private Energia ener;
    private Entornos ento;
    private Suelos sue;
    private Estados est;
    private SistemaCombate sist;
    private HabilidadesActivas hab;
    private TiposEnemigos tipEne;
    private ModosDJuego modComb;
    private Personaje jugadores;
    private Enemigo rivales;

    public CombateMenus(GestionPersonajes gestPer, GestionEnemigos gestEne){
        this.gestPer = gestPer;
        this.gestEne = gestEne;
        this.ener = new Energia();
        this.ento = new Entornos(EntornosTipo.Normal);
        this.sue = new Suelos();
        this.est = new Estados();
        this.hab = new HabilidadesActivas(ener, est, sue, ento);
        this.sist = new SistemaCombate(ener, hab, ento, sue, est);
        this.tipEne = new TiposEnemigos(ener, hab, ento, sue, est, sist);
        this.modComb = new ModosDJuego(sist, tipEne);
    }

    public void menuModos(Scanner control) {
        modComb.setTurnos(1);
        boolean activo = true;
        while (activo){
            System.out.println("\n----------------------------------");
            System.out.println("Seleccione el modo de combate:");
            System.out.println("\t(1) Modo practica");
            System.out.println("\t(2) Contra un enemigo comun");
            System.out.println("\t(3) Contra un enemigo fortalecido");
            System.out.println("\t(4) Al limite");
            System.out.println("\t(X) Salir");
            System.out.print("\nOpcion: ");
            String opcion = control.nextLine().toUpperCase();
            switch (opcion){
                case "1":
                    System.out.println("\nModo practica seleccionado");
                    menuSelectorPer(gestPer, control);
                    rivales = gestEne.selectorEnemigos(1);
                    combateEnemigoAguantador(jugadores, rivales, control);
                    break;
                case "2" :
                    System.out.println("\nContra un enemigo comun seleccionado");
                    menuSelectorPer(gestPer, control);
                    rivales = gestEne.selectorEnemigos(2);
                    combateEnemigoComun(jugadores, rivales, control);
                    break;
                case "3":
                    System.out.println("\nContra un enemigo fortalecido seleccionado");
                    menuSelectorPer(gestPer, control);
                    rivales = gestEne.selectorEnemigos(3);
                    combateEnemigoFortalecido(jugadores, rivales, control);
                    break;
                case "4":
                    System.out.println("\nAl limite seleccionado");
                    menuSelectorPer(gestPer, control);
                    rivales = gestEne.selectorEnemigos(5);
                    combateAlLimite(jugadores, rivales, control);
                    break;
                case "X":
                    System.out.println("\nVolviendo a inicio...");
                    activo = false;
                    break;
                default:
                    System.out.println("\nOpcion no reconocida, reingrese su opcion");
                    break;
            }
            System.out.println("----------------------------------\n");
        }
    }

    public void combateEnemigoAguantador(Personaje personaje, Enemigo enemigo, Scanner control){
        barraDecorativa();
        System.out.println("\n¡¡¡COMENZO LA PRACTICA!!!\n");
        while(personaje.getPs() > 0 && enemigo.getPs() > 0){
            if(!modComb.practica(personaje, enemigo, control)){
                break;
            }
        }
        finCombates(personaje, enemigo);
    }

    public void combateEnemigoComun(Personaje personaje, Enemigo enemigo, Scanner control){
        barraDecorativa();
        System.out.println("\n¡¡¡COMENZO EL COMBATE!!!\n");
        while(personaje.getPs() > 0 && enemigo.getPs() > 0){
            if(!modComb.contraUnComun(personaje, enemigo, control)){
                break;
            }
        }
        finCombates(personaje, enemigo);
    }

    public void combateEnemigoFortalecido(Personaje personaje, Enemigo enemigo, Scanner control){
        barraDecorativa();
        System.out.println("\n¡¡¡COMENZO UN COMBATE SERIO!!!\n");
        while(personaje.getPs() > 0 && enemigo.getPs() > 0){
            if(!modComb.contraFortalecido(personaje, enemigo, control)){
                break;
            }
        }
        finCombates(personaje, enemigo);
    }

    public void combateAlLimite(Personaje personaje, Enemigo enemigo, Scanner control){
        barraDecorativa();
        System.out.println("\n¡¡¡AL LIMITE!!!\n");
        while(modComb.getTurnos() <= modComb.getLimiteTurnos() && (personaje.getPs() > 0 && enemigo.getPs() > 0)){
            if(!modComb.alLimite(personaje, enemigo, control)){
                break;
            }
        }
        finCombates(personaje, enemigo);
    }

    public void finCombates(Personaje personaje, Enemigo enemigo){
        personaje.setPs(personaje.getPsMaximo());
        personaje.setEstado(PosEstados.Normal);
        personaje.setSuelo(SuelosPosibles.Normal);
        enemigo.setPs(enemigo.getPsMaximo());
        enemigo.setEstado(PosEstados.Normal);
        switch (enemigo.getRol()){
            case Fortalecido:
                enemigo.setPrimerApuro(true);
                enemigo.setProvocado(true);
                enemigo.setCantProvocado(0);
                break;
        }
        barraDecorativa();
    }

    public void barraDecorativa(){
        System.out.println("############################################################################");
        System.out.println("############################################################################");
        System.out.println("############################################################################");
    }

    public void menuSelectorPer(GestionPersonajes gestPer, Scanner control){
        boolean activo = true;
        while (activo){
            System.out.println("\n----------------------------------");
            System.out.println("Seleccione su personaje:");
            gestPer.mostrarPersonajesRol();
            System.out.print("\nOpcion: ");
            String opcion = control.nextLine().toUpperCase();
            int idUsado = Integer.parseInt(opcion);
            if(idUsado >= 1 && idUsado <= 4){
                jugadores = gestPer.selectorPersonaje(1);
                activo = false;
            } else {
                System.out.println("\nOpcion no reconocida, reingrese su opcion");
            }
            System.out.println("----------------------------------\n");
        }

    }
}


