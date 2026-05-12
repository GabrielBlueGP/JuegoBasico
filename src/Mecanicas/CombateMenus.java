package Mecanicas;

import Enums.EntornosPosibles;
import ConfigurarPersonajes.Enemigo;
import ConfigurarPersonajes.Personaje;
import Mecanicas.ModosDeCombate.ModosDeCombate;

import java.util.Scanner;

public class CombateMenus {
    private int turnos;

    private SistemaCombate sist = new SistemaCombate();
    private String modoCombate;
    private Energia energia = new Energia();
    private Habilidades hab = new Habilidades();
    private EntornosPosibles entorno = EntornosPosibles.Normal;
    private ModosDeCombate modComb = new ModosDeCombate();

    public CombateMenus(String modoCombate){
        this.modoCombate = modoCombate;
    }

    public void modoCombate(Personaje personaje, Enemigo enemigo, Scanner control) {
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
        turnos = 1;
        int perMaxPs = personaje.getPs();
        int eneMaxPs = enemigo.getPs();
        System.out.println("############################################################################");
        System.out.println("\n¡¡¡COMENZO EL COMBATE!!!\n");
        while(personaje.getPs() > 0 && enemigo.getPs() > 0){
             modComb.unoVSUno(personaje, enemigo, energia, sist, hab, control);
        }
        modComb.setTurnos(0);
        personaje.setPs(sist.reseatPS(perMaxPs));
        enemigo.setPs(sist.reseatPS(eneMaxPs));
        System.out.println("############################################################################");

    }

    public void combateContraReloj(Personaje personaje, Enemigo enemigo, Scanner control){
        int perMaxPs = personaje.getPs();
        int eneMaxPs = enemigo.getPs();
        System.out.println("############################################################################");
        System.out.println("\n¡¡¡COMENZO EL COMBATE CONTRA EL TIEMPO!!!\n");
        while(modComb.getTurnos() <= modComb.getLimiteTurnos() && (personaje.getPs() > 0 && enemigo.getPs() > 0)){
            modComb.contraReloj(personaje, enemigo, energia, sist, hab,  control);
        }
        modComb.finContraReloj(personaje, enemigo);
        personaje.setPs(sist.reseatPS(perMaxPs));
        enemigo.setPs(sist.reseatPS(eneMaxPs));
        System.out.println("############################################################################");
    }
}


