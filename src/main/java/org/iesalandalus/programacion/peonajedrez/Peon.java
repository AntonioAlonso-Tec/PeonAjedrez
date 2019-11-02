package org.iesalandalus.programacion.peonajedrez;

public class Peon {
	private Color color;
	private Posicion posicion;
	
	public Color getColor() {
		return color;
	}
	private void setColor(Color color) {
		
	if (color!=Color.BLANCO&&color!=Color.NEGRO) {
		throw new IllegalArgumentException("El peon solo puede ser blanco o negro");
	}else {
		this.color = color;
	}
	}
	public Posicion getPosicion() {
		return posicion;
	}
	private void setPosicion(Posicion posicion) {
		if (posicion.getFila()<1||posicion.getFila()>8) {
			throw new IllegalArgumentException("El numero de fila es incorecto");
		}else if(posicion.getColumna()<'a'||posicion.getColumna()>'h') {
			throw new IllegalArgumentException("Esta columna no existe");
		}else {
			this.posicion = posicion;
		}
	}
}
