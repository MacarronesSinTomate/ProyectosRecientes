package Simarro_03;

import java.util.Iterator;

public class Modulo extends Operacion {

	public Modulo(Double op1, Double op2) {
		super("Modulo");
		this.getListadoOperandos().add(op1);
		this.getListadoOperandos().add(op2);
	}
	
	@Override
	void registrarOperando(double nuevoOperando) {
		System.out.println("No se pueden añadir operandos al modulo.");
	}
	@Override
	double realizarOperación() {
		double resultado = 0;
		this.getListadoOperandos().set(0, (this.getListadoOperandos().get(0) * -1));
		
		resultado = this.getListadoOperandos().get(0) % this.getListadoOperandos().get(1);
		
		if (this.getListadoOperandos().get(0) < 0 || this.getListadoOperandos().get(1) < 0)
			this.setFlag(true);
		else
			this.setFlag(false);

		return resultado;
	}
	@Override
	int realizarOperaciónRedondeada() {
		return (int) Math.round(this.getResultado());
	}
	@Override
	int eliminarOperandos(double v) {
		
		int numBorrados = 0;
		
		Iterator<Double> itor = this.getListadoOperandos().iterator();
		
		try {
			
			if (this.getListadoOperandos().size() == 0)
				throw new SinOperandosNecesariosException(this);
			
			while (itor.hasNext()) {
				if (itor.next() == v) {
					itor.remove();
					numBorrados++;
				}
			}
		}catch (SinOperandosNecesariosException e){
			System.out.println("**ERROR**: " + e.getMessage());
		}

		return numBorrados;
	}
	@Override
	String imprimirOperacion() {
		
		String imprimir = "";
		Iterator<Double> itor = this.getListadoOperandos().iterator();

		while (itor.hasNext()) {
			imprimir += itor.next() + " % ";
		}
		
		return imprimir;
	}
}
