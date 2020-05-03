package Simarro_03;

import java.util.*;

public class Suma extends Operacion{

	
	
	public Suma(double op1, double op2) {
		super("Suma", "01");
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
		double resultado = 0;
		Iterator<Double> itor = this.getListadoOperandos().iterator();
		
		while (itor.hasNext()) {
			resultado += itor.next();
		}
		
		return resultado;
	}
	@Override
	int realizarOperaciónRedondeada() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	int eliminarOperandos(double v) {
		
		int numBorrados = 0;
		
		Iterator<Double> itor = this.getListadoOperandos().iterator();
		
		while (itor.hasNext()) {
			if (itor.next() == v) {
				itor.remove();
				numBorrados++;
			}
				
		}
		
		return numBorrados;
	}
	@Override
	String imprimirOperacion() {
		// TODO Auto-generated method stub
		return null;
	}
}
