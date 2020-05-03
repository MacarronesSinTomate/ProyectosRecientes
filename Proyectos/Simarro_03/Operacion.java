package Simarro_03;

import java.util.ArrayList;

public abstract class Operacion {

	private static int contId = 0;
	
	private String nombre;
	private String id;
	private ArrayList<Double> listadoOperandos;
	private double resultado;
	private boolean flag;
	
	public Operacion(String nombre) {
		this.nombre = nombre;
		this.id = contId++ + "";
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
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	abstract void registrarOperando(double nuevoOperando);
	abstract double realizarOperación();
	abstract int realizarOperaciónRedondeada();
	abstract int eliminarOperandos(double v);
	abstract String imprimirOperacion();
}
