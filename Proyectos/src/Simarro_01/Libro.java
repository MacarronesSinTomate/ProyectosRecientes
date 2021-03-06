package Simarro_01;

public class Libro extends Publicacion {

	private String autor;
	
	public Libro() {
		aņadirPublicacion();
	}

	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public void aņadirPublicacion() {
		super.aņadirPublicacion();
		System.out.println("Introduce el nombre del autor: ");
		String autor = sc.nextLine();
		this.setAutor(autor);

	}
	@Override
	public String toString() {
		return super.toString() + "\nAutor: " + this.getAutor() + "\nTipo: Libro\n";
	}
}
