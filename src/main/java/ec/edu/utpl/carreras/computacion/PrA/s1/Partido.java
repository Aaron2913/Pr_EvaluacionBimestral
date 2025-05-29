package ec.edu.utpl.carreras.computacion.PrA.s1;


import java.util.Random;
import java.util.concurrent.Callable;

import java.util.*;
public class Partido implements Callable<Jugador> {
    private final Jugador jugador1;
    private final Jugador jugador2;

    public Partido(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    @Override
    public Jugador call() throws Exception {
        Random rand = new Random();
        int setsJugador1 = 0;
        int setsJugador2 = 0;

        List<String> resultados = new ArrayList<>();

        int set = 1;
        while (setsJugador1 < 2 && setsJugador2 < 2) {
            // Simula duración del set entre 1.5 a 2 segundos
            Thread.sleep(1500 + rand.nextInt(501));

            boolean ganaJugador1 = rand.nextBoolean();
            if (ganaJugador1) {
                setsJugador1++;
                resultados.add("Set " + set + ": " + jugador1.getNombre());
            } else {
                setsJugador2++;
                resultados.add("Set " + set + ": " + jugador2.getNombre());
            }
            set++;
        }

        // Imprime resultados del partido
        System.out.println(jugador1.getNombre() + " vs " + jugador2.getNombre());
        resultados.forEach(System.out::println);

        Jugador ganador = setsJugador1 == 2 ? jugador1 : jugador2;
        System.out.println("Ganador del partido: " + ganador.getNombre() + "\n");
        return ganador;
    }
}

