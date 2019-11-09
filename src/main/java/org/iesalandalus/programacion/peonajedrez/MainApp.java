package org.iesalandalus.programacion.peonajedrez;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.utilidades.*;

public class MainApp {
	static Peon peon;

	public static void main(String[] args) {

		System.out.println("Programa para aprender a colocar y mover un peÃ³n en el tablero de ajedrez");
		System.out.println("-------------------------------------------------------------------------");

		mostrarMenu();
		ejecutarOpcion();

		System.out.println("Hasta luego Lucas!!!!");
	}

	private static void mostrarPeon() {
		System.out.println(peon.toString());
	}

	private static void mostrarMenu() {
		System.out.println("1.- CREAR UN PEON POR DEFECTO");
		System.out.println("2.- CREAR PEON DE COLOR: BLANCO/NEGRO");
		System.out.println("3.- CREAR PEON DE COLOR CON COLUMNA INICIAL");
		System.out.println("4.- MOVER PEON");
		System.out.println("0.- SALIR");
	}

	private static int elegirOpcion() {
		int opcionMenu;
		do {
			System.out.print("Escoge una opcion: ");
			opcionMenu = Entrada.entero();
			if (opcionMenu < 0 || opcionMenu > 4) {
				System.out.println("Opción incorrecta");
			}
		} while (opcionMenu < 0 || opcionMenu > 4);
		return opcionMenu;
	}

	private static void ejecutarOpcion() {
		switch (elegirOpcion()) {
		case 1:
			crearPeonDefecto();
			mostrarPeon();
			mostrarMenu();
			ejecutarOpcion();
			break;
		case 2:
			crearPeonColor();
			mostrarPeon();
			mostrarMenu();
			ejecutarOpcion();
			break;
		case 3:
			crearPeonColorColumna();
			mostrarPeon();
			mostrarMenu();
			ejecutarOpcion();
			break;
		case 4:
			if (peon == null) {
				System.out.println("Crea un peon antes de continuar");
				mostrarMenu();
				ejecutarOpcion();
			}
			mostrarMenuMovimientos();
			mover();
			break;
		case 0:
			break;
		}

	}

	private static void crearPeonDefecto() {
		peon = new Peon();
		if (peon == null) {
			System.out.println("peon null");
		}
	}

	private static void crearPeonColor() {
		peon = new Peon(elegirColor());
		if (peon == null) {
			System.out.println("peon null");
		}
	}

	private static Color elegirColor() {
		Color colorPeon = null;
		char letraColor;
		do {
			System.out.print("Escoge un color: (b)lanco o (n)egro: ");
			letraColor = Entrada.caracter();
			if (letraColor == 'n') {
				colorPeon = Color.NEGRO;
			} else if (letraColor == 'b') {
				colorPeon = Color.BLANCO;
			}
		} while (colorPeon == null);
		return colorPeon;
	}

	private static void crearPeonColorColumna() {
		peon = new Peon(elegirColor(), elegirColumnaInicial());
		if (peon == null) {
			System.out.println("peon null");
		}
	}

	private static char elegirColumnaInicial() {
		char columnaInicial;
		do {
			System.out.print("Escoge una columna inicial para el peon: ");
			columnaInicial = Entrada.caracter();
		} while (columnaInicial < 'a' || columnaInicial > 'h');

		return columnaInicial;
	}

	private static void mover() {
		try {
			realizarMovimiento();
		} catch (OperationNotSupportedException o) {
			System.out.println(o.getMessage());
		}
	}

	private static void mostrarMenuMovimientos() {
		System.out.println("ESCOGE UN MOVIMIENTO");
		System.out.println("---------------------------------");
		System.out.println("1.-AVANZAR PEON UN PASO");
		System.out.println("2.-AVANZAR PEON DOS PASOS");
		System.out.println("3.-MOVER PEON A LA IZQUIERDA");
		System.out.println("4.-MOVER PEON A LA DERECHA");
		System.out.println("5.-VOLVER ATRAS");
	}

	private static int elegirMovimiento() {
		int opcionMovimiento;
		do {
			System.out.print("Introduce tu opción: ");
			opcionMovimiento = Entrada.entero();
		} while (opcionMovimiento < 1 || opcionMovimiento > 5);

		return opcionMovimiento;
	}

	private static void realizarMovimiento() throws OperationNotSupportedException {
		int moverCasillas = 0;
		try {
			switch (elegirMovimiento()) {
			case 1:
				moverCasillas = 1;
				peon.mover(moverCasillas);
				mostrarPeon();
				mostrarMenuMovimientos();
				mover();
				break;
			case 2:
				moverCasillas = 2;
				peon.mover(moverCasillas);
				mostrarPeon();
				mostrarMenuMovimientos();
				mover();
				break;
			case 3:
				peon.mover(Direccion.IZQUIERDA);
				mostrarPeon();
				mostrarMenuMovimientos();
				mover();
				break;
			case 4:
				peon.mover(Direccion.DERECHA);
				mostrarPeon();
				mostrarMenuMovimientos();
				mover();
				break;
			case 5:
				mostrarMenu();
				ejecutarOpcion();
			}
		} catch (OperationNotSupportedException o) {
			System.out.println("Esta operacion no es posible");
		}
	}

}
