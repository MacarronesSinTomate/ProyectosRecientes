package Simarro;

import java.util.ArrayList;

public class Banco {

	private String nombre;
	private ArrayList<Cliente> clientes;
	
	public Banco(String nombre) {
		this.nombre = nombre;
		this.clientes = new ArrayList<Cliente>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public void revisarCuentas() {
		for (Cliente cliente : this.clientes) {
			for (Cuenta cuenta : cliente.getCuentas())
				cuenta.efectuarRevisionMensual();
		}
	}
	public Cliente buscarCliente(String dni) {
		for (Cliente cliente : clientes)
			if (cliente.getDni().compareTo(dni) == 0)
				return cliente;
		
		return null;
	}
	public void listarClientes() {
		for (Cliente cliente : clientes)
			System.out.println(cliente);
	}
	@Override
	public String toString() {
		return "\nNombre: " + this.nombre + "\n";
	}
}
