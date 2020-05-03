package Simarro_01;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public abstract class Publicacion {

	public static Scanner sc = new Scanner(System.in);
	
	protected int isbn;
	protected String nombre;
	protected Date fecha;
	
	public static Scanner getSc() {
		return sc;
	}
	public static void setSc(Scanner sc) {
		Publicacion.sc = sc;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public boolean estaCorrecto() {
		//false --> Hay errores
		//true --> No hay errores
		if (nombre != null && fecha != null)
			return true;
		return false;
	}
	public void añadirPublicacion() {
		
		try {
				
			System.out.println("Introduce el ISBN: ");
			int isbn = Integer.parseInt(sc.nextLine());
			System.out.println("Introduce el nombre de la publicacion: ");
			String nombre = sc.nextLine();
			Calendar calendario = Calendar.getInstance();
			Date fecha = calendario.getTime();
			
			this.setIsbn(isbn);
			this.setNombre(nombre);
			this.setFecha(fecha);
		}catch(NumberFormatException e) {
			System.out.println("**ERROR**: " + e.getMessage());
			return;
		}catch(Exception e) {
			System.out.println("Excepcio no controlada...");
			return;
		}
		
	}
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return ("\nISBN: " + this.isbn + "\nNombre: " + this.getNombre() + "\nFecha: " + sdf.format(this.getFecha()));
	}
}
