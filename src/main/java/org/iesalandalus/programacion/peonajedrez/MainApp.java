package org.iesalandalus.programacion.peonajedrez;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.utilidades.*;

public class MainApp {
	static Peon peon;
	

	public static void main(String[] args) {
	
		
		System.out.println("Programa para aprender a colocar y mover un peón en el tablero de ajedrez");
		System.out.println("-------------------------------------------------------------------------");
		
		
		
		System.out.println("Hasta luego Lucas!!!!");
	}
	
	private static void crearPeonDefecto() {
		peon=new Peon();
	}
	
	private static void crearPeonColor() {
		Color colorPieza=elegirColor();
		peon=new Peon(colorPieza);
	}
	
	private static void crearPeonColorColumna() {
		Color colorPieza=elegirColor();
		char columna=elegirColumnaInicial();
		peon=new Peon(colorPieza,columna);
	}
	private static void mostrarPeon() {
		System.out.println(peon.toString());
	}
	
	private static void mostrarMenu() {
		System.out.println("Vamos a proceder a crear un peon de ajedrez");
		System.out.println("");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("1.- CREAR UN PEON POR DEFECTO");
		System.out.println("2.- ESCOGER COLOR: BLANCO/NEGRO");
		System.out.println("3.- ESTABLECER COLUMNA INICIAL");
		System.out.println("4.- MOSTRAR DATOS DEL PEON CREADO");
		System.out.println("5.- MOVER PEON");
		System.out.println("6.- SALIR");
	}
	
	private static int elegirOpcion() {
		int opcionMenu;
		System.out.print("Escoge una opcion");
		opcionMenu=Entrada.entero();
		return opcionMenu;
	}
	
	private static void ejecutarOpcion() throws OperationNotSupportedException {
		int opcion=elegirOpcion();
		do {
			mostrarMenu();
			switch(opcion){
			case 1:
				crearPeonDefecto();
				break;
			case 2:
				elegirColor();
				crearPeonColor();
				break;
			case 3:
				elegirColumnaInicial();
				crearPeonColorColumna();
				break;
			case 4:
				mostrarPeon();
				break;
			case 5:
				mover();
				break;
			case 6:
				break;
			}
		}while(opcion!=6);
	}
	
	private static Color elegirColor() {
		Color colorPeon=Color.BLANCO;
		char letraColor;
		
		do {
			System.out.print("Escoge un color: (b)lanco o (n)egro");
			letraColor=Entrada.caracter();
		}while(letraColor!='n'||letraColor!='b');
		
		if (letraColor=='n') {
			colorPeon=Color.NEGRO;
		}else if(letraColor=='b') {
			colorPeon=Color.BLANCO;
		}
		
		return colorPeon;
	}
	
	private static char elegirColumnaInicial() {
		char columnaInicial;
		do {
			System.out.print("Escoge una columna inicial para el peon");
			columnaInicial=Entrada.caracter();
		} while(columnaInicial<'a'||columnaInicial>'h');
		
		return columnaInicial;
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
			System.out.println("Introduce tu opci�n");
			opcionMovimiento=Entrada.entero();
		}while(opcionMovimiento<1 || opcionMovimiento>5);
		
		return opcionMovimiento;
	}
	
	private static void realizarMovimiento() throws OperationNotSupportedException {
		int opcionEscogida=elegirMovimiento();
		int moverCasillas=0;
		try {
			switch(opcionEscogida) {
			case 1:
				moverCasillas=1;
				peon.Mover(moverCasillas);
				break;
			case 2:
				moverCasillas=2;
				peon.Mover(moverCasillas);
				break;
			case 3:
				peon.Mover(Direccion.IZQUIERDA);
				moverCasillas=0;
				break;
			case 4:
				peon.Mover(Direccion.DERECHA);
				moverCasillas=0;
				break;
			}
		}catch(OperationNotSupportedException o) {
			System.out.println("Esta operacion no es posible");
		}
	}
	
	
	
	private static void mover()throws OperationNotSupportedException {
		mostrarMenuMovimientos();
		elegirMovimiento();
		realizarMovimiento();	
	}
	
	
}
