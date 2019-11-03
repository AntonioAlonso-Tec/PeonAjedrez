package org.iesalandalus.programacion.peonajedrez;

import java.util.Objects;

import javax.naming.OperationNotSupportedException;

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
	
	public void Mover(Direccion direccion) throws OperationNotSupportedException {
		if(direccion==Direccion.IZQUIERDA&&color==Color.NEGRO) {
			throw new OperationNotSupportedException("El peon no puede moverse hacia atras");
		}else if(direccion==Direccion.IZQUIERDA&&color==Color.BLANCO) {
				setPosicion(new Posicion(posicion.getFila()+1,posicion.getColumna()));
		}
		
		if(direccion==Direccion.DERECHA&&color==Color.BLANCO) {
			throw new OperationNotSupportedException("El peon no puede moverse hacia atras");
		}else if(direccion==Direccion.DERECHA&&color==Color.NEGRO) {
				setPosicion(new Posicion(posicion.getFila()+1,posicion.getColumna()));
		}
	}
	
	public void Mover(int casillas) throws OperationNotSupportedException {
		if (casillas==2&&posicion.getFila()>=4&&color==Color.BLANCO) {
			throw new OperationNotSupportedException("Este movimiento no esta permitido");
		}
		
		if (casillas==2&&posicion.getFila()>=5&&color==Color.NEGRO) {
			throw new OperationNotSupportedException("Este movimiento no esta permitido");
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, posicion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Peon)) {
			return false;
		}
		Peon other = (Peon) obj;
		return color == other.color && Objects.equals(posicion, other.posicion);
	}
	
	
}

