package Simarro_01;

public class Articulo {

	private int numArt;
	private String autor;
	private int numPag;
	
	public Articulo(String autor, int numPag) {
		this.autor = autor;
		this.numPag = numPag;
	}

	public int getNumArt() {
		return numArt;
	}
	public void setNumArt(int numArt) {
		this.numArt = numArt;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getNumPag() {
		return numPag;
	}
	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}
	
	@Override
	public String toString() {
		return ("\nNumero de articulo: " + this.getNumArt() + "\nAutor: " + this.getAutor() +
				"\nNumero de paginas: " + this.getNumPag() + "\n");
	}
}
