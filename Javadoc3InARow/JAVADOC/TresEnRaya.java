package JAVADOC;

import java.util.Scanner;

/**
 * @author Alejandro Ortega Maldonado
 * @author Aaron Rodriguez Gonzalez
 * @version 1.0
 * 
 * 
 * @param juego
 * @param jugadorActual
 * @param fila
 * @param columna
 * 
 * @see repaso1y2Trimestre.CELDA
 * @see repaso1y2Trimestre.GAME
 * @see repaso1y2Trimestre.JUGADOR
 * @see repaso1y2Trimestre.TABLERO
 *
 */
public class TresEnRaya {
	public static void main(String[] args) {

		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_BLACK = "\u001B[30m";
		final String ANSI_RED = "\u001B[31m";
		final String ANSI_GREEN = "\u001B[32m";
		final String ANSI_YELLOW = "\u001B[33m";
		final String ANSI_BLUE = "\u001B[34m";
		final String ANSI_PURPLE = "\u001B[35m";
		final String ANSI_CYAN = "\u001B[36m";
		final String ANSI_WHITE = "\u001B[37m";

		System.out.println(
				ANSI_RED + "THREE" + ANSI_RESET + ANSI_YELLOW + "INNA'" + ANSI_RESET + ANSI_GREEN + "ROW" + ANSI_RESET);

		Scanner sc = new Scanner(System.in);

		GAME juego = new GAME();

		System.out.println("Introduzca su nombre (PJ1, marca 'X'): ");
		juego.getJugador1().setName(ANSI_GREEN + sc.next() + ANSI_RESET);

		System.out.println("Introduzca su nombre (PJ2, marca '0'): ");
		juego.getJugador2().setName(ANSI_CYAN + sc.next() + ANSI_RESET);

		System.out.println(juego.getTablero());

		JUGADOR jugadorActual = juego.getJugador1();
		while (!juego.isFinDePartida()) {
			int fila = juego.pedirCoordenada(ANSI_BLUE + "fila" + ANSI_RESET);
			int columna = juego.pedirCoordenada(ANSI_PURPLE + "columna" + ANSI_RESET);

			if (!juego.getTablero().getCelda(fila, columna).isOcupada()) {
				juego.getTablero().setCelda(fila, columna, jugadorActual.getMarkup());
				System.out.println(juego.getTablero());

				// Comprobar si el jugador actual ha ganado
				if (juego.comprobarVictoria(jugadorActual)) {
					juego.setFinDePartida(true);
					juego.setGanador(jugadorActual);
				} else {
					jugadorActual = juego.cambiarJugador(jugadorActual);
				}
			} else {
				System.out.println(ANSI_RED + "Esta celda ya esta ocupada. Introduce otra coordenada." + ANSI_RESET);
			}
		}

		if (juego.getGanador() != null) {
			System.out.println(ANSI_WHITE + "Felicidades, " + ANSI_RESET + juego.getGanador().getName() + ANSI_YELLOW
					+ " con la marca (" + ANSI_RESET + juego.getGanador().getMarkup() + ANSI_YELLOW + ") has ganado."
					+ ANSI_RESET);
		} else {
			System.out.println(ANSI_WHITE + "Empate de" + ANSI_RESET + juego.getJugador1().getName() + ANSI_WHITE + ".");
		}
	}
}
