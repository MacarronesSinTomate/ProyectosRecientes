package Simarro;

public class Cuenta {

	protected static int generator = 10000;
	
	protected int numCuenta;
	protected float saldo;
	protected float interes;
	protected float comision;
	protected int puntos;
	
	public Cuenta(float interes) {
		this.numCuenta = generator++;
		this.saldo = 0;
		this.comision = 0.6f;
		this.interes = interes;
	}
	
	public static int getGenerator() {
		return generator;
	}
	public static void setGenerator(int generator) {
		Cuenta.generator = generator;
	}
	public int getNumCuenta() {
		return numCuenta;
	}
	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public float getInteres() {
		return interes;
	}
	public void setInteres(float interes) {
		this.interes = interes;
	}
	public float getComision() {
		return comision;
	}
	public void setComision(float comision) {
		this.comision = comision;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public void ingresarDinero(float ingreso) {
		this.saldo += ingreso;
	}
	public void sacarDinero(float extraccion) throws NoSaldoException {
		try {
			if ((this.saldo - extraccion) < 0)
				throw new NoSaldoException(extraccion, 0);
			else {
				this.setSaldo(this.getSaldo() - extraccion);
				System.out.println("Dinero extraido con exito");
			}
				
		}catch (NoSaldoException e) {
			System.out.println("**ERROR**:  " + e);
		}
	}
	public float consultarSaldo() {
		return this.saldo;
	}
	public int consultarPuntos() {
		return this.puntos;
	}
	public void efectuarRevisionMensual() {
		this.setSaldo(this.getSaldo() + this.getInteres() - this.getComision());
	}
	public String toString() {
		return ("\nNumero de cuenta: " + this.numCuenta + "\nSaldo: " + this.saldo + "\nInteres: " + 
				this.interes + "\nComision: " + this.comision + "\nPuntos: " + this.puntos + "\n");
	}
}
