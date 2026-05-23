package ConfigurarPersonajes;

import java.util.ArrayList;

public class GestionEnemigos {
    private ArrayList<Integer> id;
    private ArrayList<Enemigo> enemigos;

    public GestionEnemigos(){
        this.id = new ArrayList<>();
        this.enemigos = new ArrayList<>();
    }

    public void agregarEne(Enemigo ene){
        id.add(id.size() + 1);
        enemigos.add(ene);
    }

    public ArrayList<Enemigo> getEnemigos(){
        return enemigos;
    }

    public ArrayList<Integer> getId() {
        return id;
    }

    public void mostrarEnemigoRol(){
        System.out.println("\n==============================================================================");
        for(int ver = 0; ver < getEnemigos().size(); ver++){
            System.out.println(id.get(ver)+" - "+getEnemigos().get(ver).getNombre()+" "+getEnemigos().get(ver).getRol());
            System.out.println("----------------------------------------------------------------------------\n");
        }
        System.out.println("==============================================================================\n");
    }

    public void mostrarEnemigosStats(){
        System.out.println("\n==============================================================================");
        for(int ver = 0; ver < getEnemigos().size(); ver++){
            System.out.println("----------------------------------------------------------------------------");
            System.out.println(id.get(ver)+" - "+getEnemigos().get(ver).getNombre()+" - "+ getEnemigos().get(ver));
            System.out.println("\tPS: "+getEnemigos().get(ver).getPs());
            System.out.println("\tAtaque: "+getEnemigos().get(ver).getAtaque());
            System.out.println("----------------------------------------------------------------------------\n");
        }
        System.out.println("==============================================================================\n");
    }

}
