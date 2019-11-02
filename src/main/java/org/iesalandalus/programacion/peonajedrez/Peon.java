package org.iesalandalus.programacion.peonajedrez;

public class Peon {
	private Color color;
	private Posicion posicion;
	
	public Peon() {
		setColor(Color.NEGRO);
		setPosicion(new Posicion(7,'d'));
	}
	
	public Peon(Color color) {
		if (color==Color.NEGRO) {
			setPosicion(new Posicion(7,'d'));
			setColor(Color.NEGRO);
		} else if (color==Color.BLANCO) {
			setPosicion(new Posicion(2,'d'));
			setColor(Color.BLANCO);
		}
	}
	
	public Peon(Color color,char columna) {
		setColor(color);
		if(color==Color.NEGRO) {
			setPosicion(new Posicion(7,columna));
			setColor(Color.NEGRO);
		}else if(color==Color.BLANCO) {
			setPosicion(new Posicion(2,columna));
			setColor(Color.BLANCO);
		}
		
	}
	
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
