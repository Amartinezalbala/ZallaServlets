package com.ipartek.ejemplos.alvaromartinez;

public class Corredor implements Runnable { // extends Thread
	private int dorsal, posicion;
	boolean seguirCorriendo = true;

	public void parar() {
		seguirCorriendo = false;
	}

	public Corredor(int dorsal) {
		this.dorsal = dorsal;
	}

	public int getPosicion() {
		return posicion;
	}

	// public void setPosicion(int posicion) {
	// this.posicion = posicion;
	// }

	public int getDorsal() {
		return dorsal;
	}

	// public void setDorsal(int dorsal) {
	// this.dorsal = dorsal;
	// }

	@Override
	public void run() {

		for (posicion = 0; posicion < 10 && seguirCorriendo; posicion++) {
			System.out.println("DENTRO " + dorsal + ":" + posicion);
			try {
				Thread.sleep((long) (Math.random() * 1000)); // milisegundos
			} catch (InterruptedException ie) {
			}
		}
	}

}
