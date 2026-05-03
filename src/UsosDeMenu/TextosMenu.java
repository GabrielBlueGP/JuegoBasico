package UsosDeMenu;

public class TextosMenu {

    public static void descripcion(){
        System.out.println("\nSe trata de un juego sencillo de turnos en donde tu personaje se enfrenta a un enemigo\n");
    }

    public static void reglas(){
        System.out.println("\nAcciones del jugador:\n-Puede atacar\n-Puede no atacar en un turno\n-Puede curarse\n");
        System.out.println("\nAcciones del enemigo:\n-Puede atacar");
        System.out.println("\nEnergia:\n-Es usada por el jugador\n-Se acumula cuando el jugador no ataca\n-Se gasta apartir de tener acumulado 3 puntos\n-Se usa para hacer mas daño o mas cura\n-Tras usarse el valor se restablece a 0\n");
    }

    public static void salirDelPrograma(){
        System.out.println("Gracias por jugar\nSaliendo del programa...");
    }

    public static void opcionNoReconocida(){
        System.out.println("\nLa tecla ingresada no se encuentra entre las opciones\nporfavor, precione una tecla valida + Enter\n");
    }
}
