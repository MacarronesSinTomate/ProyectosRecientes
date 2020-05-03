package Simarro;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws ClienteExisteException, NoSaldoException {
		
		ArrayList<Banco> bancos = new ArrayList<Banco>();
		
		Banco bancoActual = new Banco("PorDefecto_01");
		bancos.add(bancoActual);
		
		int opc = 0;
		int opc2 = 0;
		
		do {
			
			mostrarMenu(bancoActual);
			try {
				opc = Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("**Error** " + e.getMessage());
			}
			
			switch (opc) {
			case 1:
				
				do {
					
					mostrarSubMenu_01(bancoActual);
					try {
						opc2 = Integer.parseInt(sc.nextLine());
					}catch(NumberFormatException e) {
						System.out.println("**Error** " + e.getMessage());
					}
					
					switch(opc2){
						case 1:
							creacionBanco(bancos);
							break;
						case 2:
							revisarTodasLasCuentas(bancos);
							break;
						case 3:
							System.out.println("Volviendo al menu principal ...");
							break;
						default:
							System.out.println("Opcion incorrecta...");
							break;
					}

				}while(opc2 != 3);
				opc2 = 0;
				break;
			case 2:

				do {

					mostrarSubMenu_02(bancoActual);
					try {
						opc2 = Integer.parseInt(sc.nextLine());
					}catch(NumberFormatException e) {
						System.out.println("**Error** " + e.getMessage());
					}

					switch(opc2){
					
						case 1:
							altaCliente(bancoActual);
							break;
						case 2:
							bajaCliente(bancoActual);
							break;
						case 3:
							modificarCliente(bancoActual);
							break;
						case 4:
							System.out.println("Volviendo al menu principal ...");
							break;
						default:
							System.out.println("Opcion incorrecta...");
							break;
					}

				}while(opc2 != 4);
				opc2 = 0;
				break;
			case 3:
				
				do {
					
					mostrarSubMenu_03(bancoActual);
					try {
						opc2 = Integer.parseInt(sc.nextLine());
					}catch(NumberFormatException e) {
						System.out.println("**Error** " + e.getMessage());
					}

					switch(opc2){
						case 1:
							crearCuenta(bancoActual);
							break;
						case 2:
							ingresarDinero(bancoActual);
							break;
						case 3:
							sacarDinero(bancoActual);
							break;
						case 4:
							consultarSaldo(bancoActual);
							break;
						case 5:
							consultarPuntos(bancoActual);
							break;
						case 6:
							revisionMensual(bancoActual);
							break;
						case 7:
							System.out.println("Volviendo al menu");
							break;
						default:
							System.out.println("Opcion incorrecta...");
							break;
					}	
					
					
				}while(opc2 != 7);
				opc2 = 0;
				break;
			case 4:
				bancoActual = cambiarBanco(bancos, bancoActual);
				break;
			case 5:
				System.out.println("Te echaremos de menos :_)");
				break;
			default:
				System.out.println("Opcion incorrecta...");
				break;
			}
			
		}while(opc != 5);
		
		sc.close();
	}
	
	//Menus
	public static void mostrarMenu(Banco bancoActual) {
		System.out.println("********************** MENU **********************");
		System.out.println("            Banco actual: " + bancoActual.getNombre());
		System.out.println("1.- Administrador");
		System.out.println("2.- Gestión de clientes");
		System.out.println("3.- Gestión de cuentas");
		System.out.println("4.- Cambiar de banco");
		System.out.println("5.- Salir");
		System.out.println("**************************************************");
		System.out.println("Introduce una opcion: ");
	}
	public static void mostrarSubMenu_01(Banco bancoActual) {
		System.out.println("********************** SUBMENU **********************");
		System.out.println("            Banco actual: " + bancoActual.getNombre());
		System.out.println("1.- Crear un banco");
		System.out.println("2.- Revisión de todas las cuentas");
		System.out.println("3.- Volver al menu");
		System.out.println("*****************************************************");
		System.out.println("Introduce una opcion: ");
	}
	public static void mostrarSubMenu_02(Banco bancoActual) {
		System.out.println("********************** SUBMENU **********************");
		System.out.println("            Banco actual: " + bancoActual.getNombre());
		System.out.println("1.- Alta cliente");
		System.out.println("2.- Baja cliente");
		System.out.println("3.- Modificación cliente");
		System.out.println("4.- Volver al menu");
		System.out.println("*****************************************************");
		System.out.println("Introduce una opcion: ");
	}
	public static void mostrarSubMenu_03(Banco bancoActual) {
		System.out.println("********************** SUBMENU **********************");
		System.out.println("            Banco actual: " + bancoActual.getNombre());
		System.out.println("1.- Crear cuenta");
		System.out.println("2.- Ingresar dinero");
		System.out.println("3.- Sacar dinero");
		System.out.println("4.- Consultar saldo");
		System.out.println("5.- Consultar puntos");
		System.out.println("6.- Revision mensual");
		System.out.println("7.- Volver al menu");
		System.out.println("*****************************************************");
		System.out.println("Introduce una opcion: ");
	}

	//Funcionalidad
	public static void listarBancos(ArrayList<Banco> bancos) {
		System.out.println("\nBANCOS DISPONIBLES\n");
		for (Banco banco : bancos)
			System.out.println(banco);
	}
	public static void listarClientes(Banco bancoActual) {
		for (Cliente cliente : bancoActual.getClientes())
			System.out.println(cliente);
	}
	
	//Menu
	public static Banco cambiarBanco(ArrayList<Banco> bancos, Banco bancoActual) {
		
		listarBancos(bancos);
		
		System.out.println("Introduce el nombre del banco: ");
		String nombreBanco = sc.nextLine();
		
		for (Banco banco : bancos)
			if (banco.getNombre().compareTo(nombreBanco) == 0) {
				System.out.println("Banco cambiado");
				return banco;
			}
			
		System.out.println("Banco no cambiado");
		return bancoActual;
	}
	
	//Submenu_01
	public static void creacionBanco(ArrayList<Banco> bancos) {
		
		boolean encontrado = false;
		Banco nuevoBanco = null;

		encontrado = false;
		
		System.out.println("Introduce un nombre: ");
		String nombre = sc.nextLine();
		
		for (Banco banco : bancos)
			if(banco.getNombre().compareTo(nombre) == 0) {
				encontrado = true;
				break;
			}
		
		if (encontrado) {
			System.out.println("El banco ya existe");
		} else {
			nuevoBanco = new Banco(nombre);
			bancos.add(nuevoBanco);
			System.out.println("Banco creado con exito :)");
		}
			

		
	}
	public static void revisarTodasLasCuentas(ArrayList<Banco> bancos) {
		for (Banco banco : bancos)
			banco.revisarCuentas();
		
		System.out.println("Cuentas revisadas correctamente :)");
	}

	//Submenu_02
	public static void altaCliente(Banco bancoActual) throws ClienteExisteException {
		
		String dni;
		String nombre;
		String apellidos;
		String direccion;
		int telefono;
		
		System.out.println("Introduce el DNI: ");
		dni = sc.nextLine();
		
		System.out.println("Introduce el nombre: ");
		nombre = sc.nextLine();
		
		System.out.println("Introduce los apellidos: ");
		apellidos = sc.nextLine();
		
		System.out.println("Introduce la direccion: ");
		direccion = sc.nextLine();
		
		System.out.println("Introduce el telefono: ");
		telefono = Integer.parseInt(sc.nextLine());
		
		Cliente nuevoCliente = new Cliente(dni, nombre, apellidos, direccion, telefono);
		
		for ( Cliente cliente : bancoActual.getClientes() ) {
			try {
				if (cliente.getDni().compareTo(dni) == 0) {
					throw new ClienteExisteException(nuevoCliente);
				}
			}catch (ClienteExisteException e) {
				System.out.println("\n**ERROR**: " + e + "\n");
			}
		}

		bancoActual.getClientes().add(nuevoCliente);
	}
	public static void bajaCliente(Banco bancoActual) {
		String dni;
		
		System.out.println("Introduce el DNI: ");
		dni = sc.nextLine();
		
		for (Cliente cliente : bancoActual.getClientes())
			if (cliente.getDni().compareTo(dni) == 0) {
				bancoActual.getClientes().remove(cliente);
				System.out.println("El cliente ha sido dado de baja con exito :)");
				return;
			}
			
		System.out.println("No se ha encontrado el cliente...");
	}
	public static void modificarCliente(Banco bancoActual) throws ClienteExisteException {
		
		
		System.out.println("Introduce el DNI del cliente a modificar: ");
		String dni = sc.nextLine();
		
		for (Cliente cliente : bancoActual.getClientes())
			if (cliente.getDni().compareTo(dni) == 0) {
				
				System.out.println("Introduce el nuevo DNI: ");
				String dni_02 = sc.nextLine();
				
				System.out.println("Introduce el nombre: ");
				String nombre = sc.nextLine();
				
				System.out.println("Introduce los apellidos: ");
				String apellidos = sc.nextLine();
				
				System.out.println("Introduce la direccion: ");
				String direccion = sc.nextLine();
				
				System.out.println("Introduce el telefono: ");
				int telefono = Integer.parseInt(sc.nextLine());
				
				for ( Cliente cliente_02: bancoActual.getClientes() ) {
					if (cliente_02.getDni().compareTo(dni) == 0) {
						throw new ClienteExisteException(cliente_02);
					}
				}
				
				cliente.setDni(dni_02);
				cliente.setNombre(nombre);
				cliente.setApellidos(apellidos);
				cliente.setDireccion(direccion);
				cliente.setTelefono(telefono);
				
				System.out.println("Cliente modificado con exito :)");
			}
	}
	
	//Submenu_03
	public static void crearCuenta(Banco bancoActual) {
		
		bancoActual.listarClientes();
		
		System.out.println("Introduce el dni del propietario de la cuenta: ");
		String dni = sc.nextLine();
		Cliente propietario = bancoActual.buscarCliente(dni);
		
		int opc = 0;
		
		if (propietario != null) {
			try {
				System.out.println("Introduce el tipo de cuenta: \n1.- Cuenta corriente \n2.- Cuenta vivienda \n3.- FondoInversion"
						+ "\nIntroduce una opcion: ");
				
				opc = Integer.parseInt(sc.nextLine());
				
			}catch (NumberFormatException e){
				System.out.println("**Error** " + e.getMessage());
			}
			
			switch (opc) {
				case 1:
					Cuenta nuevaCuentaC = new CuentaCorriente();
					propietario.añadirCuenta(nuevaCuentaC);
					break;
				case 2:
					CuentaVivienda nuevaCuentaV = new CuentaVivienda();
					propietario.añadirCuenta(nuevaCuentaV);
					break;
				case 3:
					FondoInversion nuevaCuentaF = new FondoInversion();
					propietario.añadirCuenta(nuevaCuentaF);
					break;
				default:
					System.out.println("Opcion incorrecta...");
					break;
			}
		}else {
			System.out.println("Cliente no encontrado ...");
		}
	}
	public static void ingresarDinero(Banco bancoActual) {
		
		bancoActual.listarClientes();
		
		System.out.println("Introduce el dni del propietario de la cuenta: ");
		String dni = sc.nextLine();
		Cliente propietario = bancoActual.buscarCliente(dni);
		
		int numCuenta = 0;
		
		if (propietario != null) {
			
			propietario.listarCuentas();
			
			System.out.println("\nIntroduce el numero de la cuenta: ");
			try {
				numCuenta = Integer.parseInt(sc.nextLine());
			}catch (NumberFormatException e) {
				System.out.println("**Error** " + e.getMessage());
			}
			
			System.out.println("Dinero a ingresar: ");
			float dineroIngresar = Float.parseFloat(sc.nextLine());
			
			propietario.buscarCuentas(numCuenta).ingresarDinero(dineroIngresar);
			
			System.out.println("Dinero ingresado con exito");
			
		}else { 
			System.out.println("No se encontro el cliente ...");
		}
	}
	public static void sacarDinero(Banco bancoActual) throws NoSaldoException {
		
		bancoActual.listarClientes();
		
		System.out.println("Introduce el dni del propietario de la cuenta: ");
		String dni = sc.nextLine();
		Cliente propietario = bancoActual.buscarCliente(dni);
		
		int numCuenta = 0;
		
		if (propietario != null) {
			
			propietario.listarCuentas();
			
			System.out.println("\nIntroduce el numero de la cuenta: ");
			try {
				numCuenta = Integer.parseInt(sc.nextLine());
			}catch (NumberFormatException e) {
				System.out.println("**Error** " + e.getMessage());
			}
			
			System.out.println("Dinero a sacar: ");
			float dineroSacar = Float.parseFloat(sc.nextLine());
			
			propietario.buscarCuentas(numCuenta).sacarDinero(dineroSacar);
			
		}else { 
			System.out.println("No se encontro el cliente ...");
		}
	}
	public static void consultarSaldo(Banco bancoActual) {
		
		bancoActual.listarClientes();
		
		System.out.println("Introduce el dni del propietario de la cuenta: ");
		String dni = sc.nextLine();
		Cliente propietario = bancoActual.buscarCliente(dni);
		
		int numCuenta = 0;
		
		if (propietario != null) {
			
			propietario.listarCuentas();
			
			System.out.println("\nIntroduce el numero de la cuenta: ");
			try {
				numCuenta = Integer.parseInt(sc.nextLine());
			}catch (NumberFormatException e) {
				System.out.println("**Error** " + e.getMessage());
			}
			System.out.println("Saldo: " + propietario.buscarCuentas(numCuenta).consultarSaldo());
		}else { 
			System.out.println("No se encontro el cliente ...");
		}
	}
	public static void consultarPuntos(Banco bancoActual) {
		
		listarClientes(bancoActual);
		
		System.out.println("\nIntroduce el dni del propietario de la cuenta: ");
		String dni = sc.nextLine();
		Cliente propietario = bancoActual.buscarCliente(dni);
		
		int numCuenta = 0;
		
		if (propietario != null) {
			
			propietario.listarCuentas();
			
			System.out.println("\nIntroduce el numero de la cuenta: ");
			try {
				numCuenta = Integer.parseInt(sc.nextLine());
			}catch (NumberFormatException e) {
				System.out.println("**Error** " + e.getMessage());
			}
			System.out.println("Puntos: " + propietario.buscarCuentas(numCuenta).consultarPuntos());
			
		}else { 
			System.out.println("No se encontro el cliente ...");
		}
	}
	public static void revisionMensual(Banco bancoActual) {
		
		bancoActual.listarClientes();
		
		System.out.println("Introduce el dni del propietario de la cuenta: ");
		String dni = sc.nextLine();
		Cliente propietario = bancoActual.buscarCliente(dni);
		
		if (propietario != null) {
			for (Cuenta cuenta : propietario.getCuentas())
				cuenta.efectuarRevisionMensual();
			
			System.out.println("Cuentas revisadas :)");
		}else { 
			System.out.println("No se encontro el cliente ...");
		}
	}
}