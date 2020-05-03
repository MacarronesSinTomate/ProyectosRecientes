package Simarro;

public class CuentaVivienda extends Cuenta{

	public CuentaVivienda() {
		super(0.2f);
	}
	
	@Override
	public void efectuarRevisionMensual() {
		System.out.println("Los tipos de cuenta 'Vivienda' NO pagan comision bancaria.");
	}
	@Override
	public void sacarDinero(float extraccion) {
		System.out.println("Los tipos de cuenta 'Vivienda' NO pueden retirar dinero.");
	}
}
