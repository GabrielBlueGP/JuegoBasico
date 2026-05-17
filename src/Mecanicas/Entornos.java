package Mecanicas;

import ConfigurarPersonajes.BasePersonaje;
import Enums.EntornosTipo;

import java.util.Random;

public class Entornos {
    private EntornosTipo entor;
    private int contadorEntorno;
    private Random random = new Random();

    public Entornos(EntornosTipo entor){
        this.entor = EntornosTipo.Normal;
    }

    public void controlEntorno(){
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
                this.contadorEntorno = 8;
                break;
            case Agresivo:
                this.contadorEntorno = 6;
                break;
            case Sanador:
                this.contadorEntorno = 4;
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

    public void cambioEntorno(EntornosTipo NuevoEntor){
        this.entor = NuevoEntor;
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
            afectado.verificarCura(curita);
        }
    }

    public void mostrarEntornos(){
        switch (entor){
            case Normal:
                System.out.println("El campo de batalla se encuentra normal");
                break;
            case Temblor:
                System.out.println("El campo de batalla esta temblando...\nLos ataques pueden llegar a fallar mas seguido");
                break;
            case Agresivo:
                System.out.println("El campo de batalla esta sumergido en una niebla agresiva...\nLos ataques de todos haran un 15% mas daño");
                break;
            case Sanador:
                System.out.println("El campo de batalla esta sumergido en un aura sanadora...\nLos ataques que acierten recuperan un 5% de los PS");
                break;
        }
    }

}
