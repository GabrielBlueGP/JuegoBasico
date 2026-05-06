package UsosDeMenu;

public class TextosMenu {

    public static void descripcion(){
        System.out.println("\n----------------------------------------------------------------------------");
        System.out.println("\nUn juego sencillo de turnos en donde un personaje se enfrenta a un enemigo, gana el primero que deje sin PS al otro");
        System.out.println("\n----------------------------------------------------------------------------");
    }

    public static void reglas(){
        System.out.println("\n----------------------------------------------------------------------------");
        System.out.println("\n(Reglas sujetas a cambios)");
        System.out.println("\nAcciones del jugador:");
        System.out.println("\n-Puede atacar (con chances de fallar)\n-Puede no atacar en un turno\n-Puede curarse");

        System.out.println("\nAcciones del enemigo:");
        System.out.println("\n-Puede atacar (con chances de fallar)");

        System.out.println("\nEnergia:");
        System.out.println("\n-Se acumula para el jugador\n-Se gasta tras usar un ataque cargado apartir de los 3 de energia");
        System.out.println("\n-Tras el ataque cargado, se restablece a 0\n-El limite de energia acumulable es de 6");
        System.out.println("\n----------------------------------------------------------------------------");
    }

    public static void salirDelPrograma(){
        System.out.println("Gracias por jugar\nSaliendo del programa...");
    }

    public static void opcionNoReconocida(){
        System.out.println("\n----------------------------------------------------------------------------\n");
        System.out.println("\nLa tecla ingresada no se encuentra entre las opciones\nporfavor, precione una tecla valida + Enter\n");
        System.out.println("\n----------------------------------------------------------------------------");
    }
}
