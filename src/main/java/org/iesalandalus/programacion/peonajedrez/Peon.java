package org.iesalandalus.programacion.peonajedrez;

import java.util.Objects;

import javax.naming.OperationNotSupportedException;

public class Peon {
	private Color color;
	private Posicion posicion;

	public Peon() {
		setColor(Color.NEGRO);
		setPosicion(new Posicion(7, 'd'));
	}

	public Peon(Color color) {
		if (color == null) {
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		} else if (color == Color.NEGRO) {
			setPosicion(new Posicion(7, 'd'));
			setColor(Color.NEGRO);
		} else if (color == Color.BLANCO) {
			setPosicion(new Posicion(2, 'd'));
			setColor(Color.BLANCO);
		}
	}

	public Peon(Color color, char columna) {
		setColor(color);
		if (color == Color.NEGRO) {
			setPosicion(new Posicion(7, columna));
			setColor(Color.NEGRO);
		} else if (color == Color.BLANCO) {
			setPosicion(new Posicion(2, columna));
			setColor(Color.BLANCO);
		}

	}

	public Color getColor() {
		return color;
	}

	private void setColor(Color color) {

		if (color == null) {
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		} else if (color != Color.BLANCO && color != Color.NEGRO) {
			throw new IllegalArgumentException("El peon solo puede ser blanco o negro");
		} else {
			this.color = color;
		}
	}

	public Posicion getPosicion() {
		return posicion;
	}

	private void setPosicion(Posicion posicion) {
		if (posicion.getFila() < 1 || posicion.getFila() > 8) {
			throw new IllegalArgumentException("El numero de fila es incorecto");
		} else if (posicion.getColumna() < 'a' || posicion.getColumna() > 'h') {
			throw new IllegalArgumentException("Esta columna no existe");
		} else {
			this.posicion = posicion;
		}
	}

	public void mover(Direccion direccion) throws OperationNotSupportedException {

		int movimientoLateral = 1;
		int avance = 1;

		try {
			if (direccion == null) {
				throw new NullPointerException("ERROR: Mover el peón en una dirección nula no está permitido.");
			} else if (getColor() == Color.NEGRO) {
				if (direccion == Direccion.IZQUIERDA) {
					setPosicion(new Posicion(posicion.getFila() - avance,
							(char) (posicion.getColumna() - movimientoLateral)));
				} else if (direccion == Direccion.DERECHA) {
					setPosicion(new Posicion(posicion.getFila() - avance,
							(char) (posicion.getColumna() + movimientoLateral)));
				}
			} else if (getColor() == Color.BLANCO) {
				if (direccion == Direccion.IZQUIERDA) {
					setPosicion(new Posicion(posicion.getFila() + avance,
							(char) (posicion.getColumna() - movimientoLateral)));
				} else if (direccion == Direccion.DERECHA) {
					setPosicion(new Posicion(posicion.getFila() + avance,
							(char) (posicion.getColumna() + movimientoLateral)));
				}
			}
		} catch (IllegalArgumentException i) {
			throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
		}

	}

	public void mover(int casillas) throws OperationNotSupportedException {

		if (casillas < 1 || casillas > 2) {
			setPosicion(new Posicion(posicion.getFila(), posicion.getColumna()));
			throw new OperationNotSupportedException("ERROR: El peón sólo se puede mover 1 o 2 pasos.");
		}

		try {
			if (casillas == 2) {
				if (color == Color.BLANCO && posicion.getFila() > 2) {
					throw new OperationNotSupportedException(
							"ERROR: El peón sólo se puede mover 2 pasos cuando se encuentra en la casilla inicial.");
				} else if (color == Color.BLANCO && posicion.getFila() == 2) {
					setPosicion(new Posicion(posicion.getFila() + casillas, posicion.getColumna()));
				}
				if (color == Color.NEGRO && posicion.getFila() < 7) {
					throw new OperationNotSupportedException(
							"ERROR: El peón sólo se puede mover 2 pasos cuando se encuentra en la casilla inicial.");
				} else if (color == Color.NEGRO && posicion.getFila() == 7) {
					setPosicion(new Posicion(posicion.getFila() - casillas, posicion.getColumna()));
				}
			}

			if (casillas == 1) {
				if (color == Color.BLANCO) {
					setPosicion(new Posicion(posicion.getFila() + casillas, posicion.getColumna()));
				} else if (color == Color.NEGRO) {
					setPosicion(new Posicion(posicion.getFila() - casillas, posicion.getColumna()));
				}
			}
		} catch (IllegalArgumentException i) {
			throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
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

	@Override
	public String toString() {
		return "fila=" + posicion.getFila() + ", columna=" + posicion.getColumna() + ", color=" + getColor();
	}

}
