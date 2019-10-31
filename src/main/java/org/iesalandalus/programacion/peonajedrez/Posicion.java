package org.iesalandalus.programacion.peonajedrez;

public class Posicion {
	private int fila;
	private char columna;
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		
		if (fila<1 || fila>8) {
			throw new IllegalArgumentException("El numero de fila no es correcto");
		}else {
			this.fila = fila;
		}
	}
	public char getColumna() {
		return columna;
	}
	public void setColumna(char columna) {
		if (columna<'a'&&columna>'h') {
			throw new IllegalArgumentException("La columna no es correcta");
		}else {
			  this.columna = columna;
		}
	}
}
