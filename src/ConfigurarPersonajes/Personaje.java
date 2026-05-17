package ConfigurarPersonajes;

import Enums.PosEstados;
import Enums.Roles;

public class Personaje extends BasePersonaje {
    private Roles rol;

    public Personaje(String nombre, int ps, int ataque, int precision, PosEstados estado, Roles rol, String apodo) {
        super(nombre, ps, ataque, precision, estado, apodo);
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
                throw new IllegalArgumentException("Rol no valido");
        }
    setearMaximo(this.ps);
    }

    public void setearMaximo(int maximo){
        setPsMaximo(maximo);
    }

    public Roles getRol() {
        return rol;
    }
}
