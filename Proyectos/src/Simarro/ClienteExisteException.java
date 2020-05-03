package Simarro;

public class ClienteExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	
	public ClienteExisteException(Cliente cliente) {
		this.cliente = cliente;
	}
	

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return ("El cliente con DNI: '" + this.getCliente().getDni() + "' ya existe.");
	}
}
