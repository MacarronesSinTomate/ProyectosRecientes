package Simarro_01;

public class HayArticulosException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Revista revista;
	
	public HayArticulosException(Revista revista) {
		this.revista = revista;
	}
	
	@Override
	public String toString() {
		return "La revista '" + this.revista.getNombre() + "' no se puede borrar por que tiene : " +
				this.revista.getArticulos().size() + " articulo/s.\n";
				
	}
}
