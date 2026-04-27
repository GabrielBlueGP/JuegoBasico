package Personajes;

public class Personaje{
    private String nombre;
    private Atacante rol;

    public Personaje(String nombre, Atacante rol){
        this.nombre = nombre;
        this.rol = rol;}

    public Personaje(String nombre){
        this.nombre = nombre;}

    public String getNombre() {return nombre;}
    public Atacante getRol() {return rol;}

    public String toString() {
        return nombre+" "+rol;}
}
