package Personajes;

public class Personaje extends BasePersonaje {
    private String nombre;
    private Roles rol;

    public Personaje(String nombre, int ps, int ataque, int precision, Roles rol) {
        super(ps, ataque, precision);
        this.nombre = nombre;
        this.precision = precision;
        this.rol = rol;
        switch (rol) {
            case Atacante:
                this.ps += 500;
                this.ataque += 100;
                break;
            case Apoyo:
                this.ps += 1000;
                this.ataque += 25;
                break;
            case Sabotaje:
                this.ps += 750;
                this.ataque += 50;
                break;
            default:
                throw new IllegalArgumentException("Rol no valido");}
    }
    public Roles getRol() {
        return rol;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public String toString() {
        return "Personaje nuevo: "+nombre;
    }
}
