package Simarro_01;

import java.util.ArrayList;

public class Biblioteca {

	private String nombre;
	private ArrayList<Publicacion> publicaciones;
	
	public Biblioteca() {
		
	}
	
	public Biblioteca(String nombre) {
		this.nombre = nombre;
		this.publicaciones = new ArrayList<Publicacion>();
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public Publicacion buscarPublicacion(String nombre) {
		for (Publicacion publicacion : this.getPublicaciones())
			if (publicacion.getNombre().compareTo(nombre) == 0)
				return publicacion;
		return null;
	}
	@Override
	public String toString(){
		return "\nNombre: " + this.getNombre() + " \nPublicaciones: " + 
				this.getPublicaciones().size() + "\n";
	}
}
