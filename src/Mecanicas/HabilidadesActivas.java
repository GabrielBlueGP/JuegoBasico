package Mecanicas;

import ConfigurarPersonajes.BasePersonaje;
import Enums.PosEstados;
import Enums.SuelosPosibles;

public class HabilidadesActivas {
    private Energia ener;
    private Estados est;
    private Suelos sue;
    private Entornos ento;

    private int usoEnergia;

    public HabilidadesActivas(Energia ener, Estados est, Suelos sue, Entornos ento){
        this.ener = ener;
        this.est = est;
        this.sue = sue;
        this.ento = ento;
    }

    public void superDanio(BasePersonaje atacante, BasePersonaje objetivo){
        this.usoEnergia = 5;
        if(ener.getEnergia() >= usoEnergia){
            ener.restarEnergia(usoEnergia);
            int danio = atacante.getAtaque() + 500;
            objetivo.aplicarDanio(danio);
            System.out.println("¡¡¡Super daño!!!\nDaño inflijido a "+objetivo.getNombre()+": "+danio);
        } else {
            habNoDisponible();
        }
    }

    public void superCura(BasePersonaje afectado) {
        this.usoEnergia = 5;
        if(ener.getEnergia() >= usoEnergia){
            ener.restarEnergia(usoEnergia);
            int cura = (afectado.getPsMaximo() * 50) / 100;
            afectado.recibirCura(cura);
            System.out.println("¡¡¡Super cura!!!\nCura generada por " + afectado.getNombre() + ": " + cura);
        } else {
            habNoDisponible();
        }
    }

    public void voluntador(BasePersonaje objetivo){
        this.usoEnergia = 3;
        if(ener.getEnergia() >= usoEnergia) {
            ener.restarEnergia(usoEnergia);
            System.out.println("¡¡¡Voluntador!!!\nreunes toda tu concentracion y de un movimiento...");
            est.cambioEstados(objetivo, PosEstados.Entumecido);
            System.out.println("¡" + objetivo.getNombre() + " a quedado entumecido!");
        } else {
            habNoDisponible();
        }
    }

    public void superEmpujon(BasePersonaje atacante, BasePersonaje objetivo){
        this.usoEnergia = 4;
        if(ener.getEnergia() >= usoEnergia) {
            ener.restarEnergia(usoEnergia);
            int danio = (atacante.getAtaque() * 50) / 100;
            objetivo.aplicarDanio(danio);
            est.cambioEstados(objetivo, PosEstados.Entumecido);
            System.out.println("¡¡¡Super empujon!!!");
            System.out.println("Con serenidad y habilidad, aciertas un golpe entumecedor");
            System.out.println(objetivo.getNombre() + " recibe " + danio);
        } else {
            habNoDisponible();
        }
    }

    public void escupitajoToxico(BasePersonaje objetivo){
        this.usoEnergia = 5;
        if(ener.getEnergia() >= usoEnergia) {
            ener.restarEnergia(usoEnergia);
            sue.cambioSuelo(objetivo, SuelosPosibles.Toxico);
            System.out.println("¡¡¡Escupitajo toxico!!!");
            System.out.println("Con fuerza, escupe algo de veneno al suelo de " + objetivo.getNombre());
        } else {
            habNoDisponible();
        }
    }

    public void aromaNatural(BasePersonaje afectado){
        this.usoEnergia = 6;
        if(ener.getEnergia() >= usoEnergia) {
            ener.restarEnergia(usoEnergia);
            int cura = (afectado.getPsMaximo() * 20) / 100;
            afectado.recibirCura(cura);
            sue.cambioSuelo(afectado, SuelosPosibles.Resiliente);
            System.out.println("¡¡¡Aroma natural!!!");
            System.out.println("Con calma se empieza a generar un fresco aroma...");
            System.out.println("Cura generada por " + afectado.getNombre() + ": " + cura);
            System.out.println("El suelo se vuelve resiliente por el aroma...");
        } else {
            habNoDisponible();
        }
    }

    public void habNoDisponible(){
        System.out.println("Energia insuficiente...");
        System.out.println("En su lugar, se concentrara para reservar...");
        ener.manejoEnergia();
    }

    public void ejecutarHabilidades(BasePersonaje usuario, BasePersonaje objetivo){
        System.out.println("Se esta ejecutando una habilidad");
        switch (usuario.getIdHabilidad()) {
            case 1:
                superDanio(usuario, objetivo);
                break;
            case 2:
                superCura(usuario);
                break;
            case 3:
                voluntador(objetivo);
                break;
            case 4:
                superEmpujon(usuario, objetivo);
                break;
            case 5:
                escupitajoToxico(objetivo);
                break;
            case 6:
                aromaNatural(usuario);
                break;
            }
    }
}
