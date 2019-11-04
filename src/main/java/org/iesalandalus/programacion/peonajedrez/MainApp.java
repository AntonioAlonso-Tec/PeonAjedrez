package org.iesalandalus.programacion.peonajedrez;

import org.iesalandalus.programacion.utilidades.*;

public class MainApp {
	Peon peon;
	

	public static void main(String[] args) {
	
		
		System.out.println("Programa para aprender a colocar y mover un peón en el tablero de ajedrez");
		System.out.println("-------------------------------------------------------------------------");
		
		
		
		System.out.println("Hasta luego Lucas!!!!");
	}
	
	private static void mostrarPeon() {

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
	
	private static int elegirOpcion(int opcionMenu) {
		System.out.print("Escoge una opcion");
		opcionMenu=Entrada.entero();
		return opcionMenu;
	}
	
	private static Color elegirColor(Color colorPeon) {
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
	
	private static char elegirColumnaInicia(char columnaInicial) {
		
		do {
			System.out.print("Escoge una columna inicial para el peon");
			columnaInicial=Entrada.caracter();
		} while(columnaInicial<'a'||columnaInicial>'h');
		
		return columnaInicial;
	}
	
}
