package ConfigurarPersonajes;

import java.util.ArrayList;

public class GestionPersonajes {
    private ArrayList<Integer> id;
    private ArrayList<Personaje> personajes;

    public GestionPersonajes(){
        this.id = new ArrayList<>();
        this.personajes = new ArrayList<>();
    }

    public void agregarPer(Personaje per){
        id.add(id.size() + 1);
        personajes.add(per);
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public ArrayList<Integer> getId() {
        return id;
    }

    public void mostrarPersonajesRol(){
        System.out.println("\n==============================================================================");
        for(int ver = 0; ver < getPersonajes().size(); ver++){
            System.out.println(id.get(ver)+" - "+getPersonajes().get(ver).getNombre()+" "+getPersonajes().get(ver).getRol());
            System.out.println("----------------------------------------------------------------------------\n");
        }
        System.out.println("==============================================================================\n");
    }

    public void mostrarPersonajesStats(){
        System.out.println("\n==============================================================================");
        for(int ver = 0; ver < getPersonajes().size(); ver++){
            System.out.println("----------------------------------------------------------------------------");
            System.out.println(id.get(ver)+" - "+getPersonajes().get(ver).getNombre()+" - "+ getPersonajes().get(ver));
            System.out.println("\tPS: "+getPersonajes().get(ver).getPs());
            System.out.println("\tAtaque: "+getPersonajes().get(ver).getAtaque());
            System.out.println("----------------------------------------------------------------------------\n");
        }
        System.out.println("==============================================================================\n");
    }
}
