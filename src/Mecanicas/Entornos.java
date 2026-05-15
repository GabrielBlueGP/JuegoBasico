package Mecanicas;

import ConfigurarPersonajes.Enemigo;
import ConfigurarPersonajes.Personaje;
import Enums.EntornosTipo;

import java.util.Random;

public class Entornos {
    private EntornosTipo entor;
    private Random random = new Random();

    public Entornos(EntornosTipo entor){
        this.entor = EntornosTipo.Normal;
    }

    public EntornosTipo getEntor() {
        return entor;}

    public void setEntor(EntornosTipo entor) {
        this.entor = entor;}

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

    public void accionEntornos(EntornosTipo entorno){
        switch (entorno){
            case Normal:
                System.out.println("El campo de batalla se encuentra normal");
                break;
            case Temblor:
                System.out.println("El campo de batalla esta temblando...\nLos ataques pueden llegar a fallar mas seguido");
                break;
            case Agresivo:
                System.out.println("El campo de batalla esta sumergido en una niebla agresiva...\nLos ataques de todos haran un 10% mas daño");
                entorno = EntornosTipo.Agresivo;
                break;
            case Sanador:
                System.out.println("El campo de batalla esta sumergido en un aura sanadora...\nLos ataques que acierten recuperan un 10% de los PS");
                break;
        }
    }

}
