package JAVADOC;

import java.util.Scanner;

/**
 * @author Alejandro Ortega Maldonado
 * @author Aaron Rodriguez Gonzalez
 * @version 1.0
 * @param tablero para inicializar el tablero
 * @see repaso1y2Trimestre.TABLERO;
 * @see repaso1y2Trimestre.JUGADOR;
 */
public class GAME {

	private TABLERO tablero;
	private JUGADOR jugador1;
	private JUGADOR jugador2;
	private boolean finDePartida;
	private JUGADOR ganador;

	/**
	 * @author Alejandro Ortega Maldonado
	 * @version 1.1
	 * @param jugador1 se inicializa en el constructor vacio con un nombre (Jugador
	 *                 1) y marca por defecto (X).
	 * @param jugador2 se inicializa en el constructor vacio con un nombre (Jugador
	 *                 2) y marca por defecto (O).
	 */
	public GAME() {
		this.tablero = new TABLERO();
		this.jugador1 = new JUGADOR("\u001B[32m" + "Jugador 1" + "\u001B[0m", 'X');
		this.jugador2 = new JUGADOR("\u001B[36m" + "Jugador 2" + "\u001B[0m", 'O');
		this.finDePartida = false;
		this.ganador = null;
	}

	public TABLERO getTablero() {
		return tablero;
	}

	public void setTablero(TABLERO tablero) {
		this.tablero = tablero;
	}

	public JUGADOR getJugador1() {
		return jugador1;
	}

	public void setJugador1(JUGADOR jugador1) {
		this.jugador1 = jugador1;
	}

	public JUGADOR getJugador2() {
		return jugador2;
	}

	public void setJugador2(JUGADOR jugador2) {
		this.jugador2 = jugador2;
	}

	public boolean isFinDePartida() {
		return finDePartida;
	}

	public void setFinDePartida(boolean finDePartida) {
		this.finDePartida = finDePartida;
	}

	public JUGADOR getGanador() {
		return ganador;
	}

	public void setGanador(JUGADOR ganador) {
		this.ganador = ganador;
	}

	/**
	 * @author Alejandro Ortega Maldonado
	 * @version 1.0
	 * @param DeployedBoard es un String inicializado vacio
	 * @return Devolvera la coordenada insertada de la fila o la columna
	 * @see repaso1y2Trimestre.TresEnRaya;
	 */
	public int pedirCoordenada(String tipo) {
		System.out.println("Introduce la " + tipo + " (0-2): ");
		Scanner sc = new Scanner(System.in);
		int coordenada = sc.nextInt();
		while (coordenada < 0 || coordenada > 2) {
			System.out.println("Coordenada no valida. Introduce la " + tipo + " (0-2): ");
			coordenada = sc.nextInt();
		}
		return coordenada;
	}

	/**
	 * @author Alejandro Ortega Maldonado
	 * @version 1.0
	 * @param jugadorActual
	 * @return Devolvera al jugador1 o jugador2 dependiendo de cual tenga asignado
	 *         previamente.
	 */
	public JUGADOR cambiarJugador(JUGADOR jugadorActual) {
		if (jugadorActual == this.jugador1) {
			return this.jugador2;
		} else {
			return this.jugador1;
		}
	}

	/**
	 * @author Alejandro Ortega Maldonado
	 * @version 1.0
	 * @param jugador
	 * @return Devolvera un booleano si la partida ha terminado por victoria de
	 *         algun jugador
	 */
	public boolean comprobarVictoria(JUGADOR jugador) {
		// Comprobar filas
		for (int fila = 0; fila < 3; fila++) {
			if (tablero.getCelda(fila, 0).getSimbolo() == jugador.getMarkup()
					&& tablero.getCelda(fila, 1).getSimbolo() == jugador.getMarkup()
					&& tablero.getCelda(fila, 2).getSimbolo() == jugador.getMarkup()) {
				setFinDePartida(true);
			}
		}

		// Comprobar columnas
		for (int columna = 0; columna < 3; columna++) {
			if (tablero.getCelda(0, columna).getSimbolo() == jugador.getMarkup()
					&& tablero.getCelda(1, columna).getSimbolo() == jugador.getMarkup()
					&& tablero.getCelda(2, columna).getSimbolo() == jugador.getMarkup()) {
				setFinDePartida(true);
			}
		}

		// Comprobar diagonales
		if (tablero.getCelda(0, 0).getSimbolo() == jugador.getMarkup()
				&& tablero.getCelda(1, 1).getSimbolo() == jugador.getMarkup()
				&& tablero.getCelda(2, 2).getSimbolo() == jugador.getMarkup()) {
			setFinDePartida(true);
		}

		if (tablero.getCelda(2, 0).getSimbolo() == jugador.getMarkup()
				&& tablero.getCelda(1, 1).getSimbolo() == jugador.getMarkup()
				&& tablero.getCelda(0, 2).getSimbolo() == jugador.getMarkup()) {
			setFinDePartida(true);
		}

		return isFinDePartida();
	}

	/**
	 * @author Alejandro Ortega Maldonado
	 * @version 1.0
	 * @return Devuelve un booleano en funcion de si todas las celdas estan
	 *         ocupadas, pero no hay un ganador, en dicho caso habria empate.
	 */
	public boolean comprobarEmpate() {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!this.tablero.getCelda(i, j).isOcupada()) {
					setFinDePartida(false);
				} else {
					setFinDePartida(true);
				}
			}
		}

		return isFinDePartida();
	}
	/**
	 * @author Alejandro Ortega Maldonado
	 * @version 1.3
	 * @param fila          para la coordenada de la i en el for del tablero
	 * @param columna       para la coordenada de la j en el for del tablero.
	 * @param jugadorActual para almacenar la informacion del jugador que le toca
	 *                      jugar en cada turno.
	 * 
	 */

}