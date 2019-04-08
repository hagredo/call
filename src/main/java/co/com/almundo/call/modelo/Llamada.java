package co.com.almundo.call.modelo;

import java.util.Random;

public class Llamada {
	public static final int DURACION_MINIMA_LLAMADA = 5;
	public static final int DURACION_MAXIMA_LLAMADA = 10;
	private String numeroLlamada;
	private int duracionLlamada;
	
	public Llamada(String numeroLlamada) {
		this.numeroLlamada = numeroLlamada;
		duracionLlamada = new Random().nextInt(DURACION_MAXIMA_LLAMADA - DURACION_MINIMA_LLAMADA + 1) + DURACION_MINIMA_LLAMADA;
	}
	
	public String getNumeroLlamada() {
		return numeroLlamada;
	}
	public void setNumeroLlamada(String numeroLlamada) {
		this.numeroLlamada = numeroLlamada;
	}
	public int getDuracionLlamada() {
		return duracionLlamada;
	}
	public void setDuracionLlamada(int duracionLlamada) {
		this.duracionLlamada = duracionLlamada;
	}
}
