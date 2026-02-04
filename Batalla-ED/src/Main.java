import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int vidaJugador = 100;
        int vidaEnemigo = 100;

        System.out.println("Bienvenido a la batalla!");

        while (vidaJugador > 0 && vidaEnemigo > 0) {

            System.out.println("-- MENÚ --");
            System.out.println("1) Atacar");
            System.out.println("2) Defenderse");
            System.out.println("3) Estadísticas");
            System.out.print("Elige opción: ");

            int menu = scanner.nextInt();

            switch (menu) {

                case 1: // Ataque
                    int dano = ataque(random);
                    vidaEnemigo = vidaEnemigo - dano;
                    System.out.println("Daño al enemigo: " + dano);
                    vidaJugador = enemigo(random, vidaJugador, 0);
                    break;

                case 2: // Defensa
                    int defensa = defensa(random);
                    break;

                case 3: // Estadisticas
                    est(vidaJugador, vidaEnemigo);
                    continue;

            }

        }
        if (vidaJugador <= 0) {
            System.out.println("Has perdido");
            System.exit(0);
        } else {
            System.out.println("Has ganado");
            System.exit(0);
        }
    }
    public static int ataque(Random random) { // Ataque jugador
        int ProbAtaque = random.nextInt(100);

        if (ProbAtaque < 25) {
            System.out.println("Fallaste el ataque");
            return 0;
        }

        return random.nextInt(15) + 5;
    }
    public static int defensa(Random random) { // Defensa jugador
        int probFallo = random.nextInt(100);

        if (probFallo < 25) {
            System.out.println("Has fallado la defensa");
            return 0;
        }

        int defensa = random.nextInt(10) + 5;
        System.out.println("Bloqueas " + defensa);
        return defensa;
    }

    // Enemigo
    public static int enemigo(Random random, int vidaJugador, int defensaJugador) {

        int accion = random.nextInt(100);

        if (accion < 20) {
            int cura = random.nextInt(10) + 5;
            System.out.println("El enemigo se cura " + cura);
        } else {
            int dano = random.nextInt(15) + 1;
            dano = dano - defensaJugador;
            vidaJugador = vidaJugador - dano;
            System.out.println("El enemigo te hace " + dano + " de daño");
        }
        return vidaJugador;
    }
    public static void est(int vidaJugador, int vidaEnemigo) { // Estadisticas
        System.out.println("-- ESTADÍSTICAS --");
        System.out.println("Vida Jugador: " + vidaJugador);
        System.out.println("Vida Enemigo: " + vidaEnemigo);
    }
}
