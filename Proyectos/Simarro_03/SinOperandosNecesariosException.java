package Simarro_03;

public class SinOperandosNecesariosException extends OperandosException{

	private Operacion op;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SinOperandosNecesariosException(Operacion op) {
		this.op = op;
	}

	public String getMessage() {
		return "No se puede realizar la operacion '" + this.op.getId() + "' debido a que no tiene suficientes operandos.";
	}
}
