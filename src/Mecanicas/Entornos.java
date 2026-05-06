package Mecanicas;

import EnumsUsados.EntornosPosibles;

public class Entornos {
    private EntornosPosibles campoBatalla;

    public Entornos(EntornosPosibles campoBatalla){
        this.campoBatalla = campoBatalla;
    }

    public EntornosPosibles getCampoBatalla() {
        return campoBatalla;}

    public void setCampoBatalla(EntornosPosibles campoBatalla) {
        this.campoBatalla = campoBatalla;}

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
