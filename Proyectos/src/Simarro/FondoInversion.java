package Simarro;

public class FondoInversion extends Cuenta{

	public FondoInversion() {
		super(0.34f);
	}
	
	@Override
	public void sacarDinero(float extraccion) throws NoSaldoException {
		try {
			if ((this.saldo - extraccion) < -500)
				throw new NoSaldoException(extraccion, -500);
			else {
				this.setSaldo(this.getSaldo() - extraccion);				
				System.out.println("Dinero extraido con exito");
			}
				
		}catch (NoSaldoException e) {
			System.out.println("**ERROR**:  " + e);
		}
	}
}
