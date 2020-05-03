package Simarro_03;

import java.util.*;

public class Suma extends Operacion{
	
	public Suma(double op1, double op2) {
		super("Suma");
		registrarOperando(op1);
		registrarOperando(op2);
		this.setResultado(realizarOperación());
	}

	@Override
	void registrarOperando(double nuevoOperando) {
		this.getListadoOperandos().add(nuevoOperando);
	}
	@Override
	double realizarOperación() {
		double resultado = this.getListadoOperandos().get(0);
		Iterator<Double> itor = this.getListadoOperandos().iterator();

		while (itor.hasNext()) {
			resultado += itor.next();
		}

		if (resultado >= 0)
			this.setFlag(false);
		else
			this.setFlag(true);
		
		return resultado;
	}
	@Override
	int realizarOperaciónRedondeada() {
		return (int) Math.round(this.getResultado());
	}
	@Override
	int eliminarOperandos(double v) {
		
		int numBorrados = 0;
		
		try {
			
			if (this.getListadoOperandos().size() == 0)
				throw new SinOperandosNecesariosException(this);
			
			Iterator<Double> itor = this.getListadoOperandos().iterator();
			
			while (itor.hasNext()) {
				if (itor.next() == v) {
					itor.remove();
					numBorrados++;
				}
			}
		}catch (SinOperandosNecesariosException e) {
			System.out.println("**ERROR**: " + e.getMessage());
		}
		
		return numBorrados;
	}
	@Override
	String imprimirOperacion() {
		
		String imprimir = "";
		Iterator<Double> itor = this.getListadoOperandos().iterator();

		while (itor.hasNext()) {
			imprimir += itor.next() + " + ";
		}
		
		return imprimir;
	}
}
