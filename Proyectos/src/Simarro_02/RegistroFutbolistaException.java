package Simarro_02;

public class RegistroFutbolistaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Futbolista futbolista;
	
	public RegistroFutbolistaException(Futbolista futbolista) {
		this.futbolista = futbolista;
		toString();
	}
	
	public String toString() {
		return "No se ha podido añadir al futbolista '" + this.futbolista.getNombre() + "' por que la posicion de '" + this.futbolista.getPosJugador() + 
				"' ya tiene los jugadores necesarios.";
	}
}
