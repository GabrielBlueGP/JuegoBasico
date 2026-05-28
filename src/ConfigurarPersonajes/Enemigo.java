package ConfigurarPersonajes;

import Enums.RolEne;
import Enums.PosEstados;

public class Enemigo extends BasePersonaje{
    protected String efectoRival;
    protected RolEne rol;
    protected int idHabSecundaria;
    protected int idHabTerciaria;
    private boolean primerApuro;
    private boolean provocado;
    private int cantProvocado;

    public Enemigo(String nombre, int precision, PosEstados estado, int idHabilidad, RolEne rol){
        super(nombre, precision, estado, idHabilidad);
        this.rol = rol;
        switch (rol){
            case RolEne.Aguantador:
                this.ps += 6000;
                this.ataque += 0;
                break;
            case RolEne.Comun:
                this.ps += 2500;
                this.ataque += 100;
                break;
            case RolEne.Fortalecido:
                this.ps += 5000;
                this.ataque += 200;
                break;
            case RolEne.Jefe:
                this.ps += 10000;
                this.ataque += 500;
                break;
            default:
                throw new IllegalArgumentException("Rol no valido");
        }
        setearMaximo(this.ps);
    }

    public Enemigo(String nombre, int precision, PosEstados estado, int idHabilidad, int idHabSecundaria, RolEne rol){
        super(nombre, precision, estado, idHabilidad);
        this.rol = rol;
        this.idHabSecundaria = idHabSecundaria;
        this.provocado = true;
        this.cantProvocado = 0;
        this.primerApuro = true;
        switch (rol){
            case RolEne.Aguantador:
                this.ps += 6000;
                this.ataque += 0;
                break;
            case RolEne.Comun:
                this.ps += 2500;
                this.ataque += 100;
                break;
            case RolEne.Fortalecido:
                this.ps += 5000;
                this.ataque += 300;
                break;
            case RolEne.Jefe:
                this.ps += 10000;
                this.ataque += 500;
                break;
            default:
                throw new IllegalArgumentException("Rol no valido");
        }
        setearMaximo(this.ps);
    }

    public Enemigo(String nombre, int precision, PosEstados estado, int idHabilidad, int idHabSecundaria, int idHabTerciaria, RolEne rol){
        super(nombre, precision, estado, idHabilidad);
        this.rol = rol;
        this.idHabSecundaria = idHabSecundaria;
        this.idHabTerciaria = idHabTerciaria;
        switch (rol){
            case RolEne.Aguantador:
                this.ps += 6000;
                this.ataque += 0;
                break;
            case RolEne.Comun:
                this.ps += 2500;
                this.ataque += 175;
                break;
            case RolEne.Fortalecido:
                this.ps += 5000;
                this.ataque += 200;
                break;
            case RolEne.Jefe:
                this.ps += 10000;
                this.ataque += 300;
                break;
            default:
                throw new IllegalArgumentException("Rol no valido");
        }
        setearMaximo(this.ps);
    }

    public void setearMaximo(int maximo){
        setPsMaximo(maximo);
    }

    public RolEne getRol() {
        return rol;
    }

    public int getIdHabSecundaria() {
        return idHabSecundaria;
    }

    public void setIdHabSecundaria(int idHabSecundaria) {
        this.idHabSecundaria = idHabSecundaria;
    }

    public int getIdHabTerciaria() {
        return idHabTerciaria;
    }

    public void setIdHabTerciaria(int idHabTerciaria) {
        this.idHabTerciaria = idHabTerciaria;
    }

    public boolean getPrimerApuro() {return primerApuro;}

    public void setPrimerApuro(boolean primerApuro) {
        this.primerApuro = primerApuro;
    }

    public boolean getProvocado() {return provocado;}

    public void setProvocado(boolean provocado) {
        this.provocado = provocado;
    }

    public int getCantProvocado() {return cantProvocado;}

    public void setCantProvocado(int cantProvocado) {this.cantProvocado = cantProvocado;}

    @Override
    public String toString() {
        return "Se creo el enemigo";
    }
}
