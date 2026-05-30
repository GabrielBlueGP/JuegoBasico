package ConfigurarPersonajes;

import Enums.PosEstados;
import Enums.RolPer;

public class Personaje extends BasePersonaje {
    private RolPer rol;
    private String apodo;

    public Personaje(){}

    public Personaje(String nombre, String apodo, int precision, PosEstados estado, RolPer rol, int idHabilidad) {
        super(nombre, precision, estado, idHabilidad);
        this.precision = precision;
        this.rol = rol;
        this.apodo = apodo;
        switch (rol) {
            case Atacante:
                this.ps = 3000;
                this.ataque = 800;
                break;
            case Apoyo:
                this.ps = 5500;
                this.ataque = 400;
                break;
            case Sabotaje:
                this.ps = 3400;
                this.ataque = 600;
                break;
            default:
                throw new IllegalArgumentException("Rol no valido");
        }
    setearMaximo(this.ps);
    }

    public void setearMaximo(int maximo){
        setPsMaximo(maximo);
    }

    public RolPer getRol() {
        return rol;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }
}
