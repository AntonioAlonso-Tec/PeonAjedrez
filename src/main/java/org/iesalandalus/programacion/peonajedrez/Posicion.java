package org.iesalandalus.programacion.peonajedrez;

import java.util.Objects;

public class Posicion {
	private int fila;
	private char columna;
	
	public Posicion(int fila,char columna){
		if ((fila<1||fila>8) || (columna<'a'||columna>'h')) {
			throw new IllegalArgumentException("La posicion en el tablero no es correcta");
		}else {
			setFila(fila);
			setColumna(columna);
		}
	}
	
	public Posicion(Posicion posicion) {
		this.fila=posicion.fila;
		this.columna=posicion.columna;
	}
	
	public int getFila() {
		return fila;
	}
	private void setFila(int fila) {
		
		if (fila<1 || fila>8) {
			throw new IllegalArgumentException("El numero de fila no es correcto");
		}else {
			this.fila = fila;
		}
	}
	public char getColumna() {
		return columna;
	}
	private void setColumna(char columna) {
		if (columna<'a'&&columna>'h') {
			throw new IllegalArgumentException("La columna no es correcta");
		}else {
			  this.columna = columna;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(columna, fila);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Posicion)) {
			return false;
		}
		Posicion other = (Posicion) obj;
		return columna == other.columna && fila == other.fila;
	}
	
	
}
