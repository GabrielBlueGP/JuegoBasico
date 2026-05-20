package UsosDeMenu;

import java.util.Scanner;

public class TextosUsados {

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
                    reglasEnergia();
                    break;
                case "5":
                    reglasEstados();
                    break;
                case "6":
                    reglasEntornos();
                    break;
                case "7":
                    reglasSuelos();
                    break;
                case "8":
                    reglasHabilidades();
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
        System.out.println("\n----------------------------------------------------------------------------\n");
        System.out.println("\nLa tecla ingresada no se encuentra entre las opciones\nporfavor, precione una tecla valida + Enter\n");
        System.out.println("\n----------------------------------------------------------------------------");
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
        System.out.println("-existen 4 tipos definidos por sus apodos:");
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
        System.out.println("-Al limite: Un jugador contra un enemigo comun pero el combate termina si llega al limite de turnos");
        System.out.println("-En guardia: Un jugador se enfrenta a un enemigo fortalecido");
        System.out.println("-Peligro inminente: Un jugador se enfrenta a un Jefe");
        System.out.println("----------------------------------------------------------------------------");
    }

    public static void reglasEnergia(){
        System.out.println("\n----------------------------------------------------------------------------");
        System.out.println("-Se acumula dependiendo de la accion");
        System.out.println("-Puede ser usada por los ataques cargados del jugador o las habilidades");
        System.out.println("-Los ataque cargados usan energia apartir de 3 puntos, tras usarse vuelve a 0");
        System.out.println("-El limite de energia acumulable es de 20");
        System.out.println("----------------------------------------------------------------------------");
    }

    public static void reglasEstados(){
        System.out.println("\n----------------------------------------------------------------------------");
        System.out.println("-Definen la condicion fisica del jugador y el enemigo");
        System.out.println("-Puede ser cambiada por habilidades u otros efectos presenten durante un combate");
        System.out.println("-Hay 4 tipos:");
        System.out.println("\t-Normal: Es el estado base, no causa ningun efecto");
        System.out.println("\t-Entumecido: El afectado no puede realizar ninguna accion durante cierta cantidad de turnos");
        System.out.println("\t-Envenenado: Quita una pequeña parte de los PS del afectado hasta que cambie de estado");
        System.out.println("\t-Sencible: El afectado recibe el doble de daño durante cierta cantidad de turnos");
        System.out.println("----------------------------------------------------------------------------");
    }

    public static void reglasEntornos(){
        System.out.println("\n----------------------------------------------------------------------------");
        System.out.println("-Es el campo donde ocurren los combates");
        System.out.println("-Afecta a todos los presentes");
        System.out.println("-Existen 4 tipos:");
        System.out.println("\t-Normal: Es un entorno sin efecto");
        System.out.println("\t-Temblor: Hace que el campo de batalla tiemble afectando la precision de los ataques");
        System.out.println("\t-Agresivo: Provoca una niebla en el campo que aumenta los ataques en un 15%");
        System.out.println("\t-Sanador: Envuelve el campo en un aura que tras cualquier accion se recupere un 10% de PS");
        System.out.println("----------------------------------------------------------------------------");
    }

    public static void reglasSuelos(){
        System.out.println("\n----------------------------------------------------------------------------");
        System.out.println("-Es el area ocupada por los personajes");
        System.out.println("-Afecta solo al personaje que corresponda dicho suelo");
        System.out.println("-Existen 4 tipos:");
        System.out.println("\t-Normal: No causa ningun efecto");
        System.out.println("\t-Puas: Causa una pequeña cantidad de daño tras realizar cualquier accion");
        System.out.println("\t-Toxico: Provoca que se cambia a un estado envenenado");
        System.out.println("\t-Resiliente: Retorna el estado a normal e impide que se cambie a otros estados mientras este activo");
        System.out.println("----------------------------------------------------------------------------");
    }

    public static void reglasHabilidades(){
        System.out.println("\n----------------------------------------------------------------------------");
        System.out.println("-Son efectos que se pueden usar durante los combates");
        System.out.println("-Solo pueden usarse con cierta cantidad de energia, tras su uson restan dicha cantidad");
        System.out.println("-Afectan a quien lo usa, el rival, estados, suelos y entornos");
        System.out.println("-Las habilidades existentes son: ");
        System.out.println("\t-Superdaño: Realiza un fuerte ataque contra el rival");
        System.out.println("\t-Supercura: Cura un equivalente del 50% de los PS maximos del usuario");
        System.out.println("\t-Voluntador: Hace que el rival entre en el estado entumecido");
        System.out.println("\t-Superempujon: Hace la mitad de daño de un ataque normal y entumece al rival");
        System.out.println("----------------------------------------------------------------------------");
    }

}
