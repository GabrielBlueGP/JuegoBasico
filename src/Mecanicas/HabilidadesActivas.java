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

    //(1)
    public void superDanio(BasePersonaje atacante, BasePersonaje objetivo){
        this.usoEnergia = 5;
        if(atacante.getEnergia() >= usoEnergia){
            ener.restarEnergia(atacante, usoEnergia);
            int danio = atacante.getAtaque() + 1000;
            objetivo.aplicarDanio(danio);
            System.out.println("¡¡¡Super daño!!!\nDaño inflijido a "+objetivo.getNombre()+": "+danio);
        } else {
            habNoDisponible(atacante);
        }
    }

    //(2)
    public void superCura(BasePersonaje afectado) {
        this.usoEnergia = 5;
        if(afectado.getEnergia() >= usoEnergia){
            ener.restarEnergia(afectado, usoEnergia);
            int cura = (afectado.getPsMaximo() * 40) / 100;
            afectado.recibirCura(cura);
            System.out.println("¡¡¡Super cura!!!\nCura generada por " + afectado.getNombre() + ": " + cura);
        } else {
            habNoDisponible(afectado);
        }
    }

    //(3)
    public void relajacion(BasePersonaje afectado){
        this.usoEnergia = 6;
        if(afectado.getEnergia() >= usoEnergia){
            ener.restarEnergia(afectado, usoEnergia);
            int cura = (afectado.getPsMaximo() * 70) / 100;
            afectado.recibirCura(cura);
            est.cambioEstados(afectado, PosEstados.Dormido);
            System.out.println("¡¡¡Relajacion!!!\n"+afectado.getNombre()+" genera una cura de: " + cura);
            System.out.println("Pero en el proceso se ha quedado Dormido");
        } else {
            habNoDisponible(afectado);
        }
    }

    //(4)
    public void voluntador(BasePersonaje atacante, BasePersonaje objetivo){
        this.usoEnergia = 3;
        if(atacante.getEnergia() >= usoEnergia) {
            ener.restarEnergia(atacante, usoEnergia);
            System.out.println("¡¡¡Voluntador!!!\nreunes toda tu concentracion y de un movimiento...");
            est.cambioEstados(objetivo, PosEstados.Entumecido);
            System.out.println("¡" + objetivo.getNombre() + " a quedado entumecido!");
        } else {
            habNoDisponible(atacante);
        }
    }

    //(5)
    public void superEmpujon(BasePersonaje atacante, BasePersonaje objetivo){
        this.usoEnergia = 4;
        if(atacante.getEnergia() >= usoEnergia) {
            ener.restarEnergia(atacante, usoEnergia);
            int danio = (atacante.getAtaque() * 50) / 100;
            objetivo.aplicarDanio(danio);
            est.cambioEstados(objetivo, PosEstados.Entumecido);
            System.out.println("¡¡¡Super empujon!!!");
            System.out.println("Con serenidad y habilidad, aciertas un golpe entumecedor");
            System.out.println(objetivo.getNombre() + " recibe " + danio);
        } else {
            habNoDisponible(atacante);
        }
    }

    //(6)
    public void escupitajoToxico(BasePersonaje usuario ,BasePersonaje objetivo){
        this.usoEnergia = 5;
        if(usuario.getEnergia() >= usoEnergia) {
            ener.restarEnergia(usuario , usoEnergia);
            sue.cambioSuelo(objetivo, SuelosPosibles.Toxico);
            System.out.println("¡¡¡Escupitajo toxico!!!");
            System.out.println("Con fuerza, escupe algo de veneno al suelo de " + objetivo.getNombre());
        } else {
            habNoDisponible(usuario);
        }
    }

    //(7)
    public void aromaNatural(BasePersonaje afectado){
        this.usoEnergia = 6;
        if(afectado.getEnergia() >= usoEnergia) {
            ener.restarEnergia(afectado ,usoEnergia);
            int cura = (afectado.getPsMaximo() * 20) / 100;
            afectado.recibirCura(cura);
            sue.cambioSuelo(afectado, SuelosPosibles.Resiliente);
            System.out.println("¡¡¡Aroma natural!!!");
            System.out.println("Con calma se empieza a generar un fresco aroma...");
            System.out.println("Cura generada por " + afectado.getNombre() + ": " + cura);
            System.out.println("El suelo se vuelve resiliente por el aroma...");
        } else {
            habNoDisponible(afectado);
        }
    }

    public void habNoDisponible(BasePersonaje usuario){
        System.out.println("Energia insuficiente...");
        System.out.println("En su lugar, se concentrara para reservar...");
        ener.manejoEnergia(usuario);
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
                relajacion(usuario);
                break;
            case 4:
                voluntador(usuario, objetivo);
                break;
            case 5:
                superEmpujon(usuario, objetivo);
                break;
            case 6:
                escupitajoToxico(usuario, objetivo);
                break;
            case 7:
                aromaNatural(usuario);
                break;
            }
    }
}
