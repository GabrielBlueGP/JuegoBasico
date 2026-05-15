package UsosDeMenu;

public class TextosUsados {

    public static void descripcion(){
        System.out.println("\n----------------------------------------------------------------------------");
        System.out.println("\nUn juego centrado en combates con uso de diversos elementos y habilidades");
        System.out.println("\n----------------------------------------------------------------------------");
    }

    public static void reglas(){
        System.out.println("\n----------------------------------------------------------------------------");
        System.out.println("\nModos de juego:");
        System.out.println("\t-1vs1: Un jugador se enfrenta a un enemigo. Gana el que deje sin ps al otro primero");
        System.out.println("\t-Contrareloj: Variante del 1vs1 pero el combate se limita por cantidad de turnos");
        System.out.println("----------------------------------------------------------------------------");

        System.out.println("(Reglas sujetas a cambios)");
        System.out.println("\nAcciones del jugador:");
        System.out.println("\n-Puede atacar (con chances de fallar)\n-Puede no atacar en un turno\n-Puede curarse");
        System.out.println("----------------------------------------------------------------------------");

        System.out.println("Acciones del enemigo:");
        System.out.println("\n-Puede atacar (con chances de fallar)");
        System.out.println("----------------------------------------------------------------------------");

        System.out.println("Energia:");
        System.out.println("\n-Se acumula para el jugador\n-Se gasta tras usar un ataque cargado apartir de los 3 de energia");
        System.out.println("-Tras el ataque cargado, se restablece a 0\n-El limite de energia acumulable es de 6");
        System.out.println("----------------------------------------------------------------------------");

        System.out.println("Estados:");
        System.out.println("\n-Definen la condicion fisica del jugador y el enemigo\n-Puede ser cambiada por habilidades u efectos");
        System.out.println("\n-Hay 4 tipos:");
        System.out.println("\t-Normal\nEs el estado base y sin efecto");
        System.out.println("\t-Entumecido\nEl afectado no puede realizar ninguna accion durante cierta cantidad de turnos");
        System.out.println("\t-Envenenado\nQuita una parte de la salud del afectado y reduce las habilidades curativas en un 30%");
        System.out.println("\t-Sencible\nEl afectado recibe el doble de daño del siguiente tipo:");
        System.out.println("\t\t-Ataques normales\t\t\n-Ataques cargados\t\t\n-Habilidades ofensivas");
        System.out.println("\tEste cambio dura muy pocos turnos");
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
