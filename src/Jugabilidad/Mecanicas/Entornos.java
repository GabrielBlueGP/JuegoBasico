package Jugabilidad.Mecanicas;

import ConfigurarPersonajes.BasePersonaje;
import Enums.EntornosTipo;

import java.util.Random;

public class Entornos {
    private EntornosTipo entor;
    private int contadorEntorno;
    private boolean entAplicado;
    private Random random = new Random();

    public Entornos(EntornosTipo entor){
        this.entor = EntornosTipo.Normal;
    }

    public void controlEntorno(){

        if(entAplicado) {
            entAplicado = false;
            return;
        }
        if(contadorEntorno > 1){
            contadorEntorno--;
            System.out.println("Le quedan: "+contadorEntorno);
        } else {
            contadorEntorno = 0;
            resetEntorno();
            System.out.println("El entorno ha vuelto a la normalidad");
        }
    }

    public void iniciarContador(){
        switch (entor){
            case Temblor:
                this.contadorEntorno = 12;
                break;
            case Agresivo:
                this.contadorEntorno = 10;
                break;
            case Sanador:
                this.contadorEntorno = 8;
                break;
        }
    }

    public int getContadorEntorno(){
        return contadorEntorno;
    }

    public EntornosTipo getEntor() {
        return entor;}

    public void setEntor(EntornosTipo entor) {
        this.entor = entor;}

    public void resetEntorno(){
        this.entor = EntornosTipo.Normal;
    }

    public void cambioEntorno(EntornosTipo nuevoEntor){
        this.entor = nuevoEntor;
        entAplicado = true;
        iniciarContador();
        mostrarEntornos();
    }

    public int accionAgresivo(int ataque){
        if(entor == EntornosTipo.Agresivo){
            ataque += (ataque * 15) / 100;
        }
        return ataque;
    }

    public int accionTemblor(){
        int modi = 0;
        if(entor == EntornosTipo.Temblor){
            modi = random.nextInt(20)+1;
        }
        return modi;
    }

    public void accionSanador(BasePersonaje afectado){
        if(entor == EntornosTipo.Sanador){
            int curita = (afectado.getPsMaximo() * 5) / 100;
            afectado.recibirCura(curita);
        }
    }

    public void mostrarEntornos(){
        switch (entor){
            case Normal:
                System.out.println("\nEl campo de batalla se encuentra normal");
                break;
            case Temblor:
                System.out.println("\nEl campo de batalla esta temblando...\nLos ataques pueden llegar a fallar mas seguido");
                break;
            case Agresivo:
                System.out.println("\nEl campo de batalla esta sumergido en una niebla agresiva...\nLos ataques de todos haran un 15% mas daño");
                break;
            case Sanador:
                System.out.println("\nEl campo de batalla esta sumergido en un aura sanadora...\nLos ataques que acierten recuperan un 5% de los PS");
                break;
        }
    }

}
