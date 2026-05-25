package ConfigurarPersonajes;

import Enums.RolEnemigos;
import Enums.PosEstados;
import Enums.RolJugador;

public class Enemigo extends BasePersonaje{
    protected String efectoRival;
    protected RolEnemigos rol;

    public Enemigo(String nombre, int precision, PosEstados estado, int idHabilidad, RolEnemigos rol){
        super(nombre, precision, estado, idHabilidad);
        this.rol = rol;
        switch (rol){
            case RolEnemigos.Aguantador:
                this.ps += 6000;
                this.ataque += 0;
                break;
            case RolEnemigos.Comun:
                this.ps += 2500;
                this.ataque += 100;
                break;
            case RolEnemigos.Fortalecido:
                this.ps += 5000;
                this.ataque += 300;
                break;
            case RolEnemigos.Jefe:
                this.ps += 10000;
                this.ataque += 500;
                break;
            default:
                throw new IllegalArgumentException("Rol no valido");
        }
        setearMaximo(this.ps);
    }

    public void setearMaximo(int maximo){
        setPsMaximo(maximo);
    }

    public RolEnemigos getRol() {
        return rol;
    }

    @Override
    public String toString() {
        return "Se creo el enemigo";
    }
}
