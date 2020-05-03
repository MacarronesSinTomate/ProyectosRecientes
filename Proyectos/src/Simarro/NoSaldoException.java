package Simarro;

public class NoSaldoException extends Exception{

	float num, limite;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NoSaldoException(float num, float limite) {
		this.num = num;
		this.limite = limite;
	}
	
	@Override
	public String toString() {
		return "No puede sacar " + this.num + " euros por que excederias el limite de " + this.limite;
	}
}
