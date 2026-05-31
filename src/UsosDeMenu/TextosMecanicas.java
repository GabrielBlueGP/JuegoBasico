package UsosDeMenu;

public class TextosMecanicas {

    public static void energiaText(){
        System.out.println("\n----------------------------------------------------------------------------");
        System.out.println("-Se acumula dependiendo de la acción");
        System.out.println("-Puede ser usada por los ataques cargados del jugador o las habilidades");
        System.out.println("-Los ataques cargados usan energía apartir de 3 puntos, tras usarse vuelve a 0");
        System.out.println("-El limite de energia acumulable es de 20");
        System.out.println("----------------------------------------------------------------------------");
    }

    public static void estadosText(){
        System.out.println("\n----------------------------------------------------------------------------");
        System.out.println("-Definen la condición física del jugador y el enemigo");
        System.out.println("-Puede ser cambiada por habilidades u otros efectos presentes durante un combate");
        System.out.println("-Hay 4 tipos:");
        System.out.println("\t-Normal: Es el estado base, no causa ningun efecto");
        System.out.println("\t-Entumecido: El afectado no puede hacer nada durante muchos turnos");
        System.out.println("\t-Envenenado: Quita una pequeña parte de los PS del afectado hasta que cambie de estado");
        System.out.println("\t-Sensible: El afectado recibe el doble de daño durante cierta cantidad de turnos");
        System.out.println("\t-Dormido: El afectado no puede hacer nada durante pocos turnos");
        System.out.println("----------------------------------------------------------------------------");
    }

    public static void entornosText(){
        System.out.println("\n----------------------------------------------------------------------------");
        System.out.println("-Es el campo donde ocurren los combates");
        System.out.println("-Afecta a todos los presentes");
        System.out.println("-Existen 4 tipos:");
        System.out.println("\t-Normal: Es un entorno sin efecto");
        System.out.println("\t-Temblor: Hace que el campo de batalla tiemble afectando la precision de los ataques");
        System.out.println("\t-Agresivo: Provoca una niebla en el campo que aumenta los ataques en un 15%");
        System.out.println("\t-Sanador: Envuelve el campo en un aura que tras cualquier acción se recupere un 10% de PS");
        System.out.println("----------------------------------------------------------------------------");
    }

    public static void suelosText(){
        System.out.println("\n----------------------------------------------------------------------------");
        System.out.println("-Es el área ocupada por los personajes");
        System.out.println("-Afecta solo al personaje que corresponda dicho suelo");
        System.out.println("-Existen 4 tipos:");
        System.out.println("\t-Normal: No causa ningun efecto");
        System.out.println("\t-Puas: Causa una pequeña cantidad de daño tras realizar cualquier accion");
        System.out.println("\t-Toxico: Provoca envenenamiento");
        System.out.println("\t-Resiliente: Retorna el estado a normal e impide que se cambie a otros estados mientras este activo");
        System.out.println("----------------------------------------------------------------------------");
    }

    public static void habilidadesText(){
        System.out.println("\n----------------------------------------------------------------------------");
        System.out.println("-Son efectos que se pueden usar durante los combates");
        System.out.println("-Solo pueden usarse con cierta cantidad de energia, tras su uso restan dicha cantidad");
        System.out.println("-Afectan a quien lo usa, el rival, estados, suelos y entornos");
        System.out.println("-Las habilidades existentes son: ");
        System.out.println("\t1 -Super daño: Realiza un fuerte ataque contra el rival");
        System.out.println("\t2 -Super cura: Cura un equivalente del 40% de los PS maximos del usuario");
        System.out.println("\n3 -Relajacion: El usuario se queda dormido y se cura un equivalente del 70% de los PS maximos");
        System.out.println("\t4 -Voluntador: Hace que el rival se quede entumecido");
        System.out.println("\t5 -Super empujon: Hace la mitad de daño de un ataque normal y entumece al rival");
        System.out.println("\t6 -Escupitajo Toxico: Escupe al suelo del rival volviendolo tóxico");
        System.out.println("\t7 -Aroma natural: Cura un equivalente del 20% de los PS maximos del usuario y cambia el suelo a resiliente");
        System.out.println("\t8 -Sanguijuela: Ataca con mas fuerza y se cura una cantidad de PS equivalente a la mitad del daño hecho");
        System.out.println("\t9 -Rasguño venenoso: Ataca haciendo la mitad de su daño y deja envenenado al rival");
        System.out.println("\t10-Super patada: Lanza una patada que provoca que el entorno tiemble");
        System.out.println("\t11-Grito furioso: Suelta un grito que desgasta la salud del usuario a cambio de tornar el entorno agresivo");
        System.out.println("\t12-Canto energico: El usuario se pone a cantar provocando que el entorno sea sanador");
        System.out.println("\t13-Juego sucio: La risa del usuario provoca que el rival se vuelva sensible con un suelo lleno de puas");
        System.out.println("----------------------------------------------------------------------------");
    }
}
