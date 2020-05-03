package Simarro_03;

import java.util.ArrayList;

public abstract class Operacion {

	private String nombre;
	private String id;
	private ArrayList<Double> listadoOperandos;
	private double resultado;
	
	public Operacion(String nombre, String id) {
		this.nombre = nombre;
		this.id = id;
		this.listadoOperandos = new ArrayList<Double>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<Double> getListadoOperandos() {
		return listadoOperandos;
	}
	public void setListadoOperandos(ArrayList<Double> listadoOperandos) {
		this.listadoOperandos = listadoOperandos;
	}
	public double getResultado() {
		return resultado;
	}
	public void setResultado(double resultado) {
		this.resultado = resultado;
	}
	
	abstract void registrarOperando(double nuevoOperando);
	abstract double realizarOperación();
	abstract int realizarOperaciónRedondeada();
	abstract int eliminarOperandos(double v);
	abstract String imprimirOperacion();
}
