package Mecanicas;

import ConfigurarPersonajes.Enemigo;
import ConfigurarPersonajes.Personaje;

public class TiposEnemigos {
    private Energia ener;
    private HabilidadesActivas hab;
    private Entornos ento;
    private Suelos sue;
    private Estados est;
    private SistemaCombate sist;

    public TiposEnemigos(Energia ener, HabilidadesActivas hab, Entornos ento, Suelos sue, Estados est, SistemaCombate sist) {
        this.ener = ener;
        this.hab = hab;
        this.ento = ento;
        this.sue = sue;
        this.est = est;
        this.sist = sist;
    }

    public void selecEnemigo(Enemigo enemigo, Personaje personaje){
        switch (enemigo.getRol()){
            case Aguantador:
                enemigoAguantador(enemigo, personaje);
                break;
            case Comun:
                enemigoComun(enemigo, personaje);
                break;
            case Fortalecido:
                enemigoFortalecido(enemigo, personaje);
                break;
            case Jefe:
                break;
        }
    }

    public void enemigoAguantador(Enemigo enemigo, Personaje personaje) {
        int salud = (enemigo.getPsMaximo() * 20) / 100;
        if(enemigo.getPs() >= salud && enemigo.getEnergia() >= 5){
            hab.ejecutarHabilidades(enemigo, personaje);
        } else {
            System.out.println("El enemigo no parece interesado en pelear");
            System.out.println("Parece realizar un reserva");
            ener.manejoEnergia(enemigo);
        }
    }

    public void enemigoComun(Enemigo enemigo, Personaje personaje){
        sist.confirmarAtaqueEnemigo(personaje, enemigo);
    }

    public void enemigoFortalecido(Enemigo enemigo, Personaje personaje){
        int salud = (enemigo.getPsMaximo() * 40) / 100;
        int curaApuro = (enemigo.getPsMaximo() * 30) / 100;
        int auxHabilidad;
        if(enemigo.getPs() <= salud && enemigo.getPrimerApuro()){
            enemigo.recibirCura(curaApuro);
            enemigo.setPrimerApuro(false);
            System.out.println("El enemigo a aplicado una curacion en apuros de: "+curaApuro);
            sist.confirmarAtaqueEnemigo(personaje, enemigo);
            ener.manejoEnergia(enemigo);
            enemigo.setCantProvocado(enemigo.getCantProvocado() + 1);
        } else if(enemigo.getEnergia() >= 10 && enemigo.getCantProvocado() >= 6) {
            System.out.println("!El enemigo se siente provocado¡");
            auxHabilidad = enemigo.getIdHabilidad();
            enemigo.setIdHabilidad(enemigo.getIdHabSecundaria());
            hab.ejecutarHabilidades(enemigo, personaje);
            enemigo.setIdHabilidad(auxHabilidad);
            enemigo.setCantProvocado(0);
        } else if (enemigo.getEnergia() >= 10){
            hab.ejecutarHabilidades(enemigo, personaje);
        } else {
            sist.confirmarAtaqueEnemigo(personaje, enemigo);
            ener.manejoEnergia(enemigo);
            enemigo.setCantProvocado(enemigo.getCantProvocado() + 1);
        }
    }

    public void enemigoJefe(){}



}
