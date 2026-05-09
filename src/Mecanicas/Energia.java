package Mecanicas;

public class Energia {
    private int energia;

    public Energia(){
        this.energia = 0;
    }

    public void manejoEnergia(){
        if(this.energia < 6){
            this.energia += 1;
            System.out.println("Con calma, se ha reservado...\nReserva de energia: "+ energia);}
        else{
            System.out.println("Has llegado al limite para reservar...\nReserva de energia: "+ energia);
        }
    }

    public Boolean verificarEnergia(){
        if(getEnergia() >= 3){
            return true;
        }
        return false;
    }

    public void reseteoEnergia(){
        this.energia = 0;
    }

    public void restarEnergia(int energia){
        int resEnergia = 5;
        this.energia = energia - resEnergia;
    }

    public int aumentaDanio(){
        int danioAdicional = 50 * this.energia;
        reseteoEnergia();
        return danioAdicional;
    }

    public int getEnergia() {return energia;}

    public void setEnergia(int energia) {
        this.energia = energia;
    }
}
