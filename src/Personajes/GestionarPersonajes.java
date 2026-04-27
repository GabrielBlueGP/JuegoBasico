package Personajes;

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
    public void mostrarPersonajes(){
        int lugar;
        for(int ver = 0; ver < getPersonajes().size(); ver++){
            lugar = ver + 1;
            System.out.println(lugar+" - "+getPersonajes().get(ver).getNombre()+" "+getPersonajes().get(ver).getRol());
        }
    }
}
