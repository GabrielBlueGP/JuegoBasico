package Mecanicas;

import Enums.EntornosTipo;
import ConfigurarPersonajes.Enemigo;
import ConfigurarPersonajes.Personaje;
import Mecanicas.ModosDeCombate.ModosDJuego;

import java.util.Scanner;

public class CombateMenus {
    private Energia ener;
    private Habilidades hab;
    private SistemaCombate sist;
    private Entornos ento;
    private ModosDJuego modComb;

    public CombateMenus(){
        this.ener = new Energia();
        this.hab = new Habilidades();
        this.ento = new Entornos(EntornosTipo.Normal);
        this.sist = new SistemaCombate(ener, hab, ento);
        this.modComb = new ModosDJuego(sist);
    }

    public void menuModos(Personaje personaje, Enemigo enemigo, Scanner control) {
        modComb.setTurnos(1);
        boolean activo = true;
        while (activo){
            System.out.println("\nSeleccione el modo de combate:");
            System.out.print("\n\t(1) 1vs1\n\t(2) Contra-reloj\n\t(3) Salir\n\nOpcion: ");
            String opcion = control.nextLine();
            switch (opcion){
                case "1" :
                    System.out.println("\nModo 1vs1 seleccionado\n");
                    combateUnoVSUno(personaje, enemigo, control);
                    break;
                case "2":
                    System.out.println("\nModo Contra-reloj seleccionado\n");
                    combateContraReloj(personaje, enemigo, control);
                    break;
                case "3":
                    System.out.println("\nVolviendo a inicio...\n");
                    activo = false;
                    break;
                default:
                    System.out.println("Opcion no reconocida, reingrese su opcion");
                    break;
            }
        }
    }


    public void combateUnoVSUno(Personaje personaje, Enemigo enemigo, Scanner control){
        System.out.println("############################################################################");
        System.out.println("\n¡¡¡COMENZO EL COMBATE!!!\n");
        while(personaje.getPs() > 0 && enemigo.getPs() > 0){
             modComb.unoVSUno(personaje, enemigo, control);
        }
        modComb.setTurnos(0);
        personaje.setPs(personaje.getPsMaximo());
        enemigo.setPs(enemigo.getPsMaximo());
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


