/*Simular un torneo de tenis con 16 jugadores en formato de eliminacion directa.Cada partido se juga al mejor
de 3 sets(gana quien primero gana 2 sets). El ganador de cada partido avanza a la siguiente ronda.
Las rondas se jugan en simultaneo;la siguiente ronda inicia solo cuando todos los partidos de la ronda actual
han terminado.
La salida esperada es esta
===== OCTAVOS DE FINAL =====
Jugador 1 vs Jugador 16
Set 1: Jugador 16
Set 2: Jugador 1
Set 3: Jugador 1
Ganador del partido: Jugador 1

Jugador 2 vs Jugador 15
Set 1: Jugador 2
Set 2: Jugador 2
Ganador del partido: Jugador 2

Jugador 3 vs Jugador 14
Set 1: Jugador 3
Set 2: Jugador 14
Set 3: Jugador 14
Ganador del partido: Jugador 14

Jugador 4 vs Jugador 13
Set 1: Jugador 4
Set 2: Jugador 13
Set 3: Jugador 4
Ganador del partido: Jugador 4

Jugador 5 vs Jugador 12
Set 1: Jugador 12
Set 2: Jugador 12
Ganador del partido: Jugador 12

Jugador 6 vs Jugador 11
Set 1: Jugador 11
Set 2: Jugador 6
Set 3: Jugador 6
Ganador del partido: Jugador 6

Jugador 7 vs Jugador 10
Set 1: Jugador 10
Set 2: Jugador 7
Set 3: Jugador 10
Ganador del partido: Jugador 10

Jugador 8 vs Jugador 9
Set 1: Jugador 8
Set 2: Jugador 8
Ganador del partido: Jugador 8

===== CUARTOS DE FINAL =====
Jugador 1 vs Jugador 2
Set 1: Jugador 1
Set 2: Jugador 1
Ganador del partido: Jugador 1

Jugador 14 vs Jugador 4
Set 1: Jugador 14
Set 2: Jugador 4
Set 3: Jugador 14
Ganador del partido: Jugador 14

Jugador 12 vs Jugador 6
Set 1: Jugador 6
Set 2: Jugador 6
Ganador del partido: Jugador 6

Jugador 10 vs Jugador 8
Set 1: Jugador 8
Set 2: Jugador 10
Set 3: Jugador 10
Ganador del partido: Jugador 10

===== SEMIFINAL =====
Jugador 1 vs Jugador 14
Set 1: Jugador 14
Set 2: Jugador 1
Set 3: Jugador 1
Ganador del partido: Jugador 1

Jugador 6 vs Jugador 10
Set 1: Jugador 10
Set 2: Jugador 6
Set 3: Jugador 6
Ganador del partido: Jugador 6

===== FINAL =====
Jugador 1 vs Jugador 6
Set 1: Jugador 6
Set 2: Jugador 6
Ganador del partido: Jugador 6

🏆 ¡Campeón del torneo: Jugador 6!

RequisitosTcenicos:
-Ejecucion en consola
-Simular el timepo de duracion de cada partido en un rango comprometido de 1.5 a 2 seg
-Usar ExecutorService,Callable y Future para simular partidos
-Simular partidos con hasta 3 sets con reusltados visibles por set.
-Imprimir los emparejamientnos, resultados de sets y el ganador de cada partido
-Continua con las rondas hasta encontrar el campeon

*/

package ec.edu.utpl.carreras.computacion.PrA.s1;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Jugador> jugadores = new ArrayList<>();
        for (int i = 1; i <= 16; i++) {
            jugadores.add(new Jugador("Jugador " + i));
        }

        Torneo torneo = new Torneo(jugadores);
        torneo.iniciarTorneo();
    }
}

