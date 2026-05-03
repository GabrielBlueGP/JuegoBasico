package Mecanicas;

import Personajes.BasePersonaje;
import Personajes.Enemigo;
import Personajes.Personaje;

import java.util.Random;
import java.util.Scanner;

public class Combate {
    private String modoCombate;
    private Energia energia = new Energia();
    private Habilidades habiliadd = new Habilidades();
    private EntornosPosibles entorno;
    private int danioHabilidad;
    private Random random = new Random();

    public Combate(String modoCombate){
        this.modoCombate = modoCombate;
    }

    public void modoCombate(Personaje personaje, Enemigo enemigo, Scanner control) {
        int perMaxPs = personaje.getPs();
        int eneMaxPs = enemigo.getPs();
        entorno = EntornosPosibles.Normal;
        System.out.print("¿Iniciar combate?\n-Si\n-No\nDecida: ");
        String opcion = control.nextLine();
        if(opcion.equals("No") || opcion.equals("no")){
            System.out.println("No se realizo ningun combate");
        } else {
            if(opcion.equals("Si") || opcion.equals("si")){
                System.out.println("\n¡¡¡COMENZO EL COMBATE!!!\n");
                while(personaje.getPs() > 0 && enemigo.getPs() > 0){
                    int precisionEnemigo = random.nextInt(100)+ 1;
                    System.out.print("¿Que vas a hacer?\n(1) Atacar\n(2) Reservar\n(3) Curarse\n(4) Habilidad\nSu accion: ");
                    String accion = control.nextLine();
                    switch (accion){
                        case "1":
                            int danioAdicional = 0;
                            if(energia.verificarEnergia()){
                                System.out.print("\n¿Usar energia?\nSi)\nNo)\nDecidir: ");
                                String usar = control.nextLine();
                                danioAdicional = energia.aumentaDanio(usar);}
                            enemigo.setPs(controlPS(enemigo.getPs() - (personaje.getAtaque() + danioAdicional)));
                            System.out.println("¡Atacaste! PS del enemigo: "+ enemigo.getPs()+"\nataque de jugador: "+personaje.getAtaque());
                            break;
                        case "2":
                            energia.manejoEnergia();
                            break;

                        case "3":
                            int curar = 100;
                            int curacion = curarse(personaje.getPs(), perMaxPs, curar);
                            personaje.setPs(personaje.getPs() + curacion);
                            System.out.println("¡Te curaste! Ps recuperados: "+curacion+" PS de "+personaje.getNombre()+": "+ personaje.getPs());
                            break;
                        case "4":
                            int activarHabilidad = habiliadd.superdanio(personaje, energia);
                            break;
                        default:
                            System.out.println("Accion no reconocida...\nSe contara como Reservar");
                            energia.manejoEnergia();
                            break;
                    }
                    ataqueEnemigo(precisionEnemigo, personaje, enemigo);
                    System.out.println("");
                }
                if(enemigo.getPs() == 0){
                    personaje.setPs(reseatPS(perMaxPs));
                    enemigo.setPs(reseatPS(eneMaxPs));
                    System.out.println("¡HAS DERROTADO AL ENEMIGO!");
                } else {
                    if(personaje.getPs() == 0){
                        personaje.setPs(reseatPS(perMaxPs));
                        enemigo.setPs(reseatPS(eneMaxPs));
                        System.out.println("Te han derrotado...\nSuerta la proxima");
                    }
                }
            }
        }
        System.out.println("\nSaliendo del modo combate...\n");
    }

    public void precisionEnemigo(int precision, Personaje personaje, Enemigo enemigo){
        System.out.println("Precision del enemigo: "+enemigo.getPrecision()+" Random: "+precision);
        if(precision >= 1 && precision <= enemigo.getPrecision()){
            personaje.setPs(controlPS(personaje.getPs() - enemigo.getAtaque()));
            System.out.println("¡EL ENEMIGO A ACERTADO SU ATAQUE¡ PS de "+personaje.getNombre()+": "+ personaje.getPs());
        } else {
            System.out.println("¡El enemigo fallo su ataque!");}
    }

    public boolean ataqueEnemigo(int precision, Personaje personaje, Enemigo enemigo){
        if(enemigo.getPs() != 0){
            precisionEnemigo(precision, personaje, enemigo);
       }
        return false;
    }

    public int controlPS(int ps){
        if(ps < 0){
            ps = 0;
            return ps;
        }
        return ps;
    }

    public int curarse(int ps, int psMax, int cura) {
        if ((ps + cura) <= psMax) {
            return cura;}
        cura = psMax - ps;
        return cura;
    }

    public int reseatPS(int maxPS){
        return maxPS;
    }

    public int entornoAgresivo(){
        int danioAgresivo = 1;
        return danioAgresivo;
    }

    public void accionEntornos(EntornosPosibles entorno){
        switch (entorno){
            case Normal:
                System.out.println("El campo de batalla se encuentra normal");
                break;
            case Temblor:
                System.out.println("El campo de batalla esta temblando...\nLos ataques pueden llegar a fallar mas seguido");
                break;
            case Agresivo:
                System.out.println("El campo de batalla esta sumergido en una niebla agresiva...\nLos ataques de todos haran un 10% mas daño");
                entorno = EntornosPosibles.Agresivo;
                break;
            case Sanador:
                System.out.println("El campo de batalla esta sumergido en un aura sanadora...\nLos ataques que acierten recuperan un 10% de los PS");
                break;
        }
    }
}


