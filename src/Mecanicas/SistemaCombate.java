package Mecanicas;

import Personajes.Enemigo;
import Personajes.Personaje;

import java.util.Random;

public class SistemaCombate {
    private Random random = new Random();

    public SistemaCombate(){}

    public int controlPS(int ps){
        if(ps < 0){
            ps = 0;
            return ps;
        }
        return ps;
    }
    public int reseatPS(int maxPS){
        return maxPS;
    }

    public void tipoAtaque(Personaje personaje, Enemigo enemigo, String accion, Energia energia){
        int precision = random.nextInt(100)+ 1;
        switch (accion){
            case "1":
                precisionJugador(personaje, enemigo, precision);
                break;
            case "4":
                ataqueJugadorEnergia(personaje, enemigo, energia);
                break;
        }
    }

    public void restarPsEnemigo(Personaje personaje, Enemigo enemigo){
        enemigo.setPs(controlPS(enemigo.getPs() - (personaje.getAtaque())));
        System.out.println("¡Atacaste! PS del enemigo: "+ enemigo.getPs()+"\nataque de jugador: "+personaje.getAtaque());
    }

    public void restarPsJugador(Enemigo enemigo, Personaje personaje){
        personaje.setPs(controlPS(personaje.getPs() - enemigo.getAtaque()));
        System.out.println("¡EL ENEMIGO A ACERTADO SU ATAQUE¡ PS de "+personaje.getNombre()+": "+ personaje.getPs());
    }

    public void precisionJugador(Personaje personaje, Enemigo enemigo, int precision){
        System.out.println("Precision del usuario: "+personaje.getPrecision()+" Random: "+precision);
        if(precision >= 1 && precision <= personaje.getPrecision()){
            restarPsEnemigo(personaje, enemigo);
        } else {
            System.out.println("¡El ataque fallo!");}
    }

    public void ataqueJugadorEnergia(Personaje personaje, Enemigo enemigo, Energia energia){
        int danioAdicional = 0;
        if(energia.verificarEnergia()){
            danioAdicional = energia.aumentaDanio();
            enemigo.setPs(controlPS(enemigo.getPs() - (personaje.getAtaque() + danioAdicional)));
            System.out.print("\n¡Ataque Cargado!");
            System.out.println("PS del enemigo: "+ enemigo.getPs()+"\nataque de jugador: "+(personaje.getAtaque()+danioAdicional));
        } else {
            restarPsEnemigo(personaje, enemigo);}
    }

    public void precisionEnemigo(Personaje personaje, Enemigo enemigo){
        int precision = random.nextInt(100)+ 1;
        System.out.println("Precision del enemigo: "+enemigo.getPrecision()+" Random: "+precision);
        if(precision >= 1 && precision <= enemigo.getPrecision()){
            restarPsJugador(enemigo, personaje);
        } else {
            System.out.println("¡El enemigo fallo su ataque!");}
    }

    public void confirmarAtaqueJugador(Personaje personaje, Enemigo enemigo, String accion, Energia energia){
        tipoAtaque(personaje, enemigo, accion, energia);

    }

    public void confirmarAtaqueEnemigo(Personaje personaje, Enemigo enemigo){
        if(enemigo.getPs() != 0){
            precisionEnemigo(personaje, enemigo);
        }
    }
}
