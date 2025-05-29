package ec.edu.utpl.carreras.computacion.PrA.s1;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import java.util.*;
import java.util.concurrent.*;

public class Torneo {
    private final List<Jugador> jugadoresIniciales;

    public Torneo(List<Jugador> jugadores) {
        this.jugadoresIniciales = jugadores;
    }

    public void iniciarTorneo() throws InterruptedException, ExecutionException {
        List<Jugador> jugadoresRonda = new ArrayList<>(jugadoresIniciales);
        int ronda = 1;

        while (jugadoresRonda.size() > 1) {
            String nombreRonda = switch (jugadoresRonda.size()) {
                case 16 -> "OCTAVOS DE FINAL";
                case 8 -> "CUARTOS DE FINAL";
                case 4 -> "SEMIFINAL";
                case 2 -> "FINAL";
                default -> "RONDA";
            };

            System.out.println("===== " + nombreRonda + " =====");

            ExecutorService executor = Executors.newFixedThreadPool(jugadoresRonda.size() / 2);
            List<Future<Jugador>> resultados = new ArrayList<>();

            for (int i = 0; i < jugadoresRonda.size() / 2; i++) {
                Jugador j1 = jugadoresRonda.get(i);
                Jugador j2 = jugadoresRonda.get(jugadoresRonda.size() - 1 - i);
                resultados.add(executor.submit(new Partido(j1, j2)));
            }

            executor.shutdown();
            executor.awaitTermination(10, TimeUnit.MINUTES);

            List<Jugador> ganadores = new ArrayList<>();
            for (Future<Jugador> f : resultados) {
                ganadores.add(f.get());
            }

            jugadoresRonda = ganadores;
            ronda++;
        }

        System.out.println("🏆 ¡Campeón del torneo: " + jugadoresRonda.get(0).getNombre() + "!");
    }
}


