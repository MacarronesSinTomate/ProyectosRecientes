package Simarro_02;

import java.util.ArrayList;

public class Futbolista implements Deportista, Comparable<Futbolista>{

	private String nombre;
	private int edad;
	private PosicionJugador posJugador;
	private int anyosProfesional = 0;
	private ArrayList<String> listadoEquipos = new ArrayList<String>();
	private int totalTrofeos = 0;

	public Futbolista(String nombre, int edad, PosicionJugador posJugador) {
		this.nombre = nombre;
		this.edad = edad;
		this.posJugador = posJugador;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public PosicionJugador getPosJugador() {
		return posJugador;
	}
	public void setPosJugador(PosicionJugador posJugador) {
		this.posJugador = posJugador;
	}

	@Override
	public int getAnyosProfesional() {
		return anyosProfesional;
	}
	@Override
	public ArrayList<String> getListadoEquipos() {
		return listadoEquipos;
	}
	@Override
	public int getTotalTrofeos() {
		return totalTrofeos;
	}

	@Override
	public String toString(){
		return "Futbolista " + this.nombre + " con edad " + this.edad  + " que ocupa la posición " + this.posJugador + 
				". Su rango salarial estará entre " + this.posJugador.getMin() + " y " + this.posJugador.getMax() + ".";
	}

	@Override
	public int compareTo(Futbolista o) {
	    if (this.posJugador.getMax() < o.getPosJugador().getMax()) {
	        return -1;
	    }else if(this.posJugador.getMax() > o.getPosJugador().getMax()){
	        return 1;
	    }
	    	return 0;
	}
}













