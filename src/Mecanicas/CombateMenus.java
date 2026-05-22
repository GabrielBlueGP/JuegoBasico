package Mecanicas;

import Enums.EntornosTipo;
import ConfigurarPersonajes.Enemigo;
import ConfigurarPersonajes.Personaje;
import Mecanicas.ModosDeCombate.ModosDJuego;

import java.util.Scanner;

public class CombateMenus {
    private Energia ener;
    private Entornos ento;
    private Suelos sue;
    private Estados est;
    private SistemaCombate sist;
    private HabilidadesActivas hab;
    private TiposEnemigos tipEne;
    private ModosDJuego modComb;

    public CombateMenus(){
        this.ener = new Energia();
        this.ento = new Entornos(EntornosTipo.Normal);
        this.sue = new Suelos();
        this.est = new Estados();
        this.hab = new HabilidadesActivas(ener, est, sue, ento);
        this.sist = new SistemaCombate(ener, hab, ento, sue, est);
        this.tipEne = new TiposEnemigos(ener, hab, ento, sue, est, sist);
        this.modComb = new ModosDJuego(sist, tipEne);
    }

    public void menuModos(Personaje personaje, Enemigo enemigo, Scanner control) {
        modComb.setTurnos(1);
        boolean activo = true;
        while (activo){
            System.out.println("\nSeleccione el modo de combate:");
            System.out.println("\t(1) Modo practica");
            System.out.println("\t(2) Contra un enemigo comun");
            System.out.println("\t(3) Al limite");
            System.out.println("\t(X) Salir");
            System.out.print("Opcion: ");
            String opcion = control.nextLine().toUpperCase();
            switch (opcion){
                case "1":
                    System.out.println("\nModo practica seleccionado\n");
                    combateEnemigoAguantador(personaje, enemigo, control);
                    break;
                case "2" :
                    System.out.println("\nContra un enemigo comun seleccionado\n");
                    combateEnemigoComun(personaje, enemigo, control);
                    break;
                case "3":
                    System.out.println("\nAl limite seleccionado\n");
                    combateContraReloj(personaje, enemigo, control);
                    break;
                case "X":
                    System.out.println("\nVolviendo a inicio...\n");
                    activo = false;
                    break;
                default:
                    System.out.println("Opcion no reconocida, reingrese su opcion");
                    break;
            }
        }
    }

    public void combateEnemigoAguantador(Personaje personaje, Enemigo enemigo, Scanner control){
        System.out.println("############################################################################");
        System.out.println("############################################################################");
        System.out.println("############################################################################");
        System.out.println("\n¡¡¡COMENZO LA PRACTICA!!!\n");
        while(personaje.getPs() > 0 && enemigo.getPs() > 0){
            if(!modComb.practica(personaje, enemigo, control)){
                break;
            }
        }
        modComb.setTurnos(0);
        personaje.setPs(personaje.getPsMaximo());
        enemigo.setPs(enemigo.getPsMaximo());
        System.out.println("############################################################################");
        System.out.println("############################################################################");
        System.out.println("############################################################################");
    }

    public void combateEnemigoComun(Personaje personaje, Enemigo enemigo, Scanner control){
        System.out.println("############################################################################");
        System.out.println("############################################################################");
        System.out.println("############################################################################");
        System.out.println("\n¡¡¡COMENZO EL COMBATE!!!\n");
        while(personaje.getPs() > 0 && enemigo.getPs() > 0){
            if(!modComb.contraUnComun(personaje, enemigo, control)){
                break;
            }
        }
        modComb.setTurnos(0);
        personaje.setPs(personaje.getPsMaximo());
        enemigo.setPs(enemigo.getPsMaximo());
        System.out.println("############################################################################");
        System.out.println("############################################################################");
        System.out.println("############################################################################");

    }

    public void combateContraReloj(Personaje personaje, Enemigo enemigo, Scanner control){
        System.out.println("############################################################################");
        System.out.println("\n¡¡¡COMENZO EL COMBATE CONTRA EL TIEMPO!!!\n");
        while(modComb.getTurnos() <= modComb.getLimiteTurnos() && (personaje.getPs() > 0 && enemigo.getPs() > 0)){
            modComb.contraReloj(personaje, enemigo, control);
        }
        modComb.finContraReloj(personaje, enemigo);
        personaje.setPs(personaje.getPsMaximo());
        enemigo.setPs(enemigo.getPsMaximo());
        System.out.println("############################################################################");
    }
}


