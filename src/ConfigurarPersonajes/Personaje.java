package ConfigurarPersonajes;

import Enums.PosEstados;
import Enums.RolJugador;

public class Personaje extends BasePersonaje {
    private RolJugador rol;
    private String apodo;

    public Personaje(String nombre, String apodo, int precision, PosEstados estado, RolJugador rol, int idHabilidad) {
        super(nombre, precision, estado, idHabilidad);
        this.precision = precision;
        this.rol = rol;
        this.apodo = apodo;
        switch (rol) {
            case Atacante:
                this.ps += 800;
                this.ataque += 200;
                break;
            case Apoyo:
                this.ps += 1200;
                this.ataque += 50;
                break;
            case Sabotaje:
                this.ps += 1000;
                this.ataque += 100;
                break;
            default:
                throw new IllegalArgumentException("Rol no valido");
        }
    setearMaximo(this.ps);
    }

    public void setearMaximo(int maximo){
        setPsMaximo(maximo);
    }

    public RolJugador getRol() {
        return rol;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }
}
