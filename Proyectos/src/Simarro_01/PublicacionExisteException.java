package Simarro_01;

public class PublicacionExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Publicacion publicacion;
	
	public PublicacionExisteException(Publicacion publicacion) {
		this.publicacion = publicacion;
	}
	
	@Override
	public String toString() {
		return "Ya existe la publicacion '" + this.publicacion.getNombre() + "' con ISBN: " + this.publicacion.getIsbn() + "\n";
	}
}
