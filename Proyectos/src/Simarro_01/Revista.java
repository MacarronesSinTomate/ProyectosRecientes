package Simarro_01;

import java.util.ArrayList;

public class Revista extends Publicacion{

	private ArrayList<Articulo> articulos;
	
	public Revista() {
		añadirPublicacion();
	}

	public ArrayList<Articulo> getArticulos() {
		return articulos;
	}
	public void setArticulos(ArrayList<Articulo> articulos) {
		this.articulos = articulos;
	}

	public void ordenarArticulos() {
		int index = 0;
		
		for (Articulo articulo : this.getArticulos())
			articulo.setNumArt(index++);
	}
	@Override
	public void añadirPublicacion() {
		super.añadirPublicacion();
		this.articulos = new ArrayList<Articulo>();
	}
	public void añadirArticulos() {
		try {
			System.out.println("\nIntroduce el autor: ");
			String autor = sc.nextLine();
			System.out.println("Introduce el numero de paginas: ");
			
			int numPag = Integer.parseInt(sc.nextLine());
			
			Articulo nuevoArticulo = new Articulo(autor, numPag);
			this.getArticulos().add(nuevoArticulo);
			ordenarArticulos();
			
		}catch(NumberFormatException e) {
			System.out.println("**ERROR**: " + e.getMessage());
		}catch(Exception e) {
			System.out.println("Excepcion no controlada...");
		}
	}
	public Articulo buscarArticulo(int numero) {
		for (Articulo articulo : this.getArticulos())
			if (articulo.getNumArt() == numero)
				return articulo;
		return null;
	}
	@Override
	public String toString() {
		return super.toString() + "\nTipo: Revista\n";
	}
}
