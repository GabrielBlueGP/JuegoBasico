package UsosDeMenu;

import java.util.Scanner;

public class TextosUsados {

    public static void menuMain(){
        System.out.println("(A) Acerca del juego");
        System.out.println("(B) Reglas de juego");
        System.out.println("(C) Modos de juego");
        System.out.println("(D) Mostrar personajes");
        System.out.println("(E) Mostrar enemigos");
        System.out.println("(X) Salir del programa");
        System.out.println("(Precione la tecla marcada en ( ) + Enter)\n");
        System.out.print("Ingrese su opcion: ");
    }

    public static void descripcion(){
        System.out.println("\n----------------------------------------------------------------------------");
        System.out.println("\nUn juego centrado en combates con uso de diversos elementos y habilidades");
        System.out.println("\n----------------------------------------------------------------------------");
    }

    public static void reglas(Scanner control){
        boolean menuActivo = true;
        String opcion;
        while (menuActivo) {
            System.out.println("\n----------------------------------------------------------------------------");
            System.out.println("Reglas y jugabilidad");
            System.out.println("¿Cual apartado desea ver?");
            System.out.println("(1) Personaje del jugador");
            System.out.println("(2) Acerca de los enemigos");
            System.out.println("(3) Modos de juego");
            System.out.println("(4) Energia");
            System.out.println("(5) Estados");
            System.out.println("(6) Entornos");
            System.out.println("(7) Suelos");
            System.out.println("(8) Habilidades Activas");
            System.out.println("(X) Volver a incio");
            System.out.print("Opcion: ");
            opcion = control.nextLine().toUpperCase();
            switch (opcion){
                case "1":
                    reglasJugador();
                    break;
                case "2":
                    reglasEnemigo();
                    break;
                case "3":
                    reglasModos();
                    break;
                case "4":
                    TextosMecanicas.energiaText();
                    break;
                case "5":
                    TextosMecanicas.estadosText();
                    break;
                case "6":
                    TextosMecanicas.entornosText();
                    break;
                case "7":
                    TextosMecanicas.suelosText();
                    break;
                case "8":
                    TextosMecanicas.habilidadesText();
                    break;
                case "X":
                    System.out.println("Volviendo al menu principal...");
                    menuActivo = false;
                    break;
                default:
                    System.out.println("Opcion no reconocida, reingrese su opcion");
                    break;
            }
        }
        System.out.println("----------------------------------------------------------------------------");
    }

    public static void salirDelPrograma(){
        System.out.println("Gracias por jugar\nSaliendo del programa...");
    }

    public static void opcionNoReconocida(){
        System.out.println("\n----------------------------------------------------------------------------");
        System.out.println("\nLa tecla ingresada no se encuentra entre las opciones\nporfavor, precione una tecla valida + Enter\n");
        System.out.println("----------------------------------------------------------------------------\n");
    }

    public static void reglasJugador(){
        System.out.println("\n----------------------------------------------------------------------------");
        System.out.println("Caracteristicas del personaje jugable:");
        System.out.println("\n-Posee un nombre, apodo, atributos, rol y estadisticas");
        System.out.println("-El rol define el tipo habilidades que tendra");
        System.out.println("-Cada rol brinda un plus especifico a las estadisticas");
        System.out.println("-Puede atacar");
        System.out.println("-Los ataques normales pueden llegar a fallar en base a la precision");
        System.out.println("-Puede reservar energia");
        System.out.println("-Puede hacer un ataque cargado");
        System.out.println("-Puede usar habilidades");
        System.out.println("----------------------------------------------------------------------------");
    }

    public static void reglasEnemigo(){
        System.out.println("\n----------------------------------------------------------------------------");
        System.out.println("Caracteristicas del enemigo:");
        System.out.println("\n-Posee un nombre, apodo, atributos, rol y estadisticas");
        System.out.println("-existen 4 tipos definidos por su especie:");
        System.out.println("\t-Aguantador: no ataca, tiene bastantes PS");
        System.out.println("\t-Comun: puede atacar, tiene una cantidad de PS regular");
        System.out.println("\t-Fortalecido: puede atacar, tiene una cantidad de PS alta, Pueden usar habilidades");
        System.out.println("\t-Jefe: version mucho mas fuerte y desafiante de un Fortalecido");
        System.out.println("\t-");
        System.out.println("-Los ataques normales pueden llegar a fallar en base a la precision");
        System.out.println("-Puede reservar energia");
        System.out.println("----------------------------------------------------------------------------");
    }

    public static void reglasModos(){
        System.out.println("\n----------------------------------------------------------------------------");
        System.out.println("-Contra un enemigo: Un jugador se enfrenta a un enemigo comun");
        System.out.println("-Contra lo perseverante y estatico: Un jugador se enfrenta a un enemigo aguantador");
        System.out.println("-Al limite: Contra un enemigo pero el combate termina si llega al limite de turnos");
        System.out.println("-En guardia: Un jugador se enfrenta a un enemigo fortalecido");
        System.out.println("-Peligro inminente: Un jugador se enfrenta a un Jefe");
        System.out.println("-Dependiendo del modo, en algunos puedes seleccionar el personaje o el jugador");
        System.out.println("----------------------------------------------------------------------------");
    }
}
