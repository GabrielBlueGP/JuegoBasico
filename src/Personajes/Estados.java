package Personajes;

public class Estados {
    private String estBase;
    private String estAdicional;

    public Estados(String estCuerpo, String estAdicional){
        this.estBase = estCuerpo;
        this.estAdicional = estAdicional;}

    public String getEstAdicional() {return estAdicional;}
    public String getEstBase() {return estBase;}

    public String toString() {
        return "\nEstado base: "+ estBase+"\nEstado Adicional: "+estAdicional;}
}
