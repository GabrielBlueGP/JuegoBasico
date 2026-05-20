package Mecanicas;

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

    public void selecEnemigo(){}

    public void enemigoAguantador(){}
    public void enemigoComun(){}
    public void enemigoFortalecido(){}
    public void enemigoJefe(){}

}
