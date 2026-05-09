package ConfigurarPersonajes;

import java.util.ArrayList;

public class GestionarPersonajes {
    private ArrayList<Personaje> personajes;

    public GestionarPersonajes(){
        this.personajes = new ArrayList<>();
    }

    public void agregar(Personaje per){
        personajes.add(per);
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public void mostrarPersonajesRol(){
        int lugar;
        System.out.println("\n==============================================================================");
        for(int ver = 0; ver < getPersonajes().size(); ver++){
            lugar = ver + 1;
            System.out.println(lugar+" - "+getPersonajes().get(ver).getNombre()+" "+getPersonajes().get(ver).getRol());
            System.out.println("----------------------------------------------------------------------------\n");
        }
        System.out.println("==============================================================================\n");
    }

    public void mostrarPersonajesStats(){
        int lugar;
        System.out.println("\n==============================================================================");
        for(int ver = 0; ver < getPersonajes().size(); ver++){
            lugar = ver + 1;
            System.out.println("----------------------------------------------------------------------------");
            System.out.println(lugar+" - "+getPersonajes().get(ver).getNombre()+" - "+ getPersonajes().get(ver).getApodo());
            System.out.println("    PS: "+getPersonajes().get(ver).getPs());
            System.out.println("    Ataque: "+getPersonajes().get(ver).getAtaque());
            System.out.println("----------------------------------------------------------------------------\n");
        }
        System.out.println("==============================================================================\n");
    }
}
