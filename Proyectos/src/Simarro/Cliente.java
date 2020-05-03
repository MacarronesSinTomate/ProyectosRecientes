package Simarro;

import java.util.ArrayList;

public class Cliente {
	
	private String dni;
	private String nombre;
	private String apellidos;
	private String direccion;
	private int telefono;
	private ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();

	public Cliente() {

	}

	public Cliente(String dni, String nombre, String apellidos, String direccion, int telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.cuentas = new ArrayList<Cuenta>();
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}
	public void setCuentas(ArrayList<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public void añadirCuenta(Cuenta cuenta) {
		this.cuentas.add(cuenta);
	}
	public void listarCuentas() {
		for (Cuenta cuenta : this.getCuentas())
			System.out.println(cuenta);
	}
	public Cuenta buscarCuentas (int numCuenta) {
		for (Cuenta cuenta : this.getCuentas())
			if (cuenta.getNumCuenta() == numCuenta)
				return cuenta;
		return null;
	}
	@Override
	public String toString() {
		return ("\nDNI: " + this.dni + "\nNombre: " + this.nombre + "\nApellidos: " + this.apellidos + "\nDireccion: " + this.direccion + 
				"\nTelefono: " + this.telefono + "\n");
	}
}
