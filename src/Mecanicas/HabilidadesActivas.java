package Mecanicas;

import ConfigurarPersonajes.BasePersonaje;
import ConfigurarPersonajes.Enemigo;
import ConfigurarPersonajes.Personaje;
import Enums.PosEstados;

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
        int danio = atacante.getAtaque() + 500;
        ener.restarEnergia(usoEnergia);
        objetivo.aplicarDanio(danio);
        System.out.println("¡¡¡SUPERDAÑO!!!\nDaño inflijido a "+objetivo.getNombre()+": "+danio);
    }

    public void superCura(BasePersonaje afectado){
        this.usoEnergia = 5;
        int cura = (afectado.getPsMaximo() * 50) / 100;
        ener.restarEnergia(usoEnergia);
        afectado.recibirCura(cura);
        System.out.println("¡¡¡SUPERCURA!!!\nCura generada por "+afectado.getNombre()+": "+cura);
    }

    public void voluntador(BasePersonaje objetivo){
        System.out.println("¡¡¡Voluntador!!!\nreunes toda tu concentracion y de un movimiento...");
        est.cambioEstados(objetivo, PosEstados.Entumecido);
        System.out.println("¡"+objetivo.getNombre()+" a quedado entumecido!");
    }

    public void superEmpujon(BasePersonaje atacante, BasePersonaje objetivo){
        int danio = (atacante.getAtaque() * 50) / 100;
        ener.restarEnergia(usoEnergia);
        objetivo.aplicarDanio(danio);
        est.cambioEstados(objetivo, PosEstados.Entumecido);
        System.out.println("¡Super empujon!");
        System.out.println("Con serenidad y habilidad, aciertas un golpe entumecedor");
        System.out.println(objetivo.getNombre()+" recibe "+danio);
    }

    public void ejecutarHabilidades(BasePersonaje usuario, BasePersonaje objetivo){
        if(ener.getEnergia() < usoEnergia) {
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
            }
        } else {
            System.out.println("Energia insuficiente...");
            System.out.println("En su lugar, se concentrara para reservar...");
            ener.manejoEnergia();
        }
    }
}
