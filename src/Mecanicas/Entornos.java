package Mecanicas;

public class Entornos {
    private EntornosPosibles campoBatalla;

    public Entornos(EntornosPosibles campoBatalla){
        this.campoBatalla = campoBatalla;
    }

    public EntornosPosibles getCampoBatalla() {
        return campoBatalla;}

    public void setCampoBatalla(EntornosPosibles campoBatalla) {
        this.campoBatalla = campoBatalla;}
}
