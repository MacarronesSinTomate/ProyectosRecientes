package Simarro_02;

import java.util.ArrayList;
import java.util.Iterator;

public class Equipo {

	private String nombre;
	private ArrayList<Futbolista> futbolistas;
	//Exception "RegistroFutbolistaException"
	
	public Equipo(String nombre) {
		this.nombre = nombre;
		this.futbolistas = new ArrayList<Futbolista>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Futbolista> getFutbolistas() {
		return futbolistas;
	}
	public void setFutbolistas(ArrayList<Futbolista> futbolistas) {
		this.futbolistas = futbolistas;
	}
	
	public void anyadirFutbolista(String nombre, int edad, PosicionJugador posJugador) throws RegistroFutbolistaException {
		
		Futbolista nuevoFutbolista = new Futbolista(nombre, edad, posJugador);
		int cont = 0;
		
		for (Futbolista f : this.futbolistas)
			if (f.getPosJugador() == posJugador)
				cont++;
		
		if (cont < posJugador.getMaxPos()) {
			futbolistas.add(nuevoFutbolista);
		}else {
			throw new RegistroFutbolistaException(nuevoFutbolista);
		}
	}
	public void listarFormacionEquipo() {
		Iterator<Futbolista> itor = futbolistas.iterator();
		
		while(itor.hasNext())
			System.out.println(itor.next());
	}
}
