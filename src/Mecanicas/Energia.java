package Mecanicas;

import java.util.Scanner;

public class Energia {
    private int energia;

    public Energia(){
        this.energia = 0;
    }

    public void manejoEnergia(){
        if(this.energia < 6){
            this.energia += 1;
            System.out.println("No se realizo ningún ataque...\nEnergia reservada: "+ energia);}
        else{
            System.out.println("No se puede acumular mas energia\nEnergia reservada: "+ energia);
        }
    }

    public Boolean verificarEnergia(){
        if(getEnergia() >= 3){
            return true;
        }
        return false;
    }

    public int aumentaDanio(String usar){
        if(usar.equals("Si") || usar.equals("si")){
            int danioAdicional = 50 * this.energia;
            this.energia = 0;
            System.out.println("\n!ENERGIA USADA¡\n¡ATAQUE CARGADO!");
            return danioAdicional;
        } else if(usar.equals("No") || usar.equals("no")){
            System.out.println("\nNo se utilizo la energia");}
        return 0;
    }

    public int getEnergia() {return energia;}
}
