package Simarro_01;

import java.util.Scanner;

public class App {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String []args) {
		
		int opc = -1;
		int opc2 = -1;

		
		System.out.println("Introduce el nombre de la biblioteca: ");
		String nombreBib = sc.nextLine();
		
		Biblioteca nuevaBib = new Biblioteca(nombreBib);
		
		do {
			
			mainMenu(nuevaBib);
			try {
				opc = Integer.parseInt(sc.nextLine());
			}catch (NumberFormatException e) {
				System.out.println("**ERROR**: " + e.getMessage());
			}
			
			switch(opc) {
				case 1:	
					do {
						subMenu_01(nuevaBib);
						try {
							opc2 = Integer.parseInt(sc.nextLine());
						}catch (NumberFormatException e) {
							System.out.println("**ERROR**: " + e.getMessage());
						}
						
						switch(opc2) {
							case 1:
								altaPublicacion(nuevaBib);
								break;
							case 2:
								borrarPublicacion(nuevaBib);
								break;
							case 0:
								System.out.println("Volviendo al menu ...");
								break;
							default:
								System.out.println("Opcion incorrecta.");
								break;
						}
						opc2 = -1;
					}while(opc2 != 0);
					break;
				case 2:
					do {
						subMenu_02(nuevaBib);
						try {
							opc2 = Integer.parseInt(sc.nextLine());
						}catch (NumberFormatException e) {
							System.out.println("**ERROR**: " + e.getMessage());
						}
						
						switch(opc2) {
							case 1:
								añadirArticuloARevista(nuevaBib);
								break;
							case 2:
								borrarArticulo(nuevaBib);
								break;
							case 0:
								System.out.println("Volviendo al menu ...");
								break;
							default:
								System.out.println("Opcion incorrecta.");
								break;	
						}
						opc2 = -1;
					}while(opc2 != 0);
					break;
				case 0:
					System.out.println("Gracias por utilizar el programa :)");
					break;
				default:
					System.out.println("Opcion incorrecta.");
					break;
			}
			
		}while(opc != 0);
	}
	
	//MOSTRAR MENUS
	public static void mainMenu(Biblioteca biblioActual) {
		System.out.println("************** MENU **************");
		System.out.println("       Biblioteca: " + biblioActual.getNombre());
		System.out.println("1.- Gestion de Publicaciones");
		System.out.println("2.- Gestion de Articulos");
		System.out.println("0.- Salir");
		System.out.println("**********************************");
		System.out.println("Introduce una opcion: ");
	}
	public static void subMenu_01(Biblioteca biblioActual) {
		System.out.println("************** SUBMENU **************");
		System.out.println("       Biblioteca: " + biblioActual.getNombre());
		System.out.println("1.- Alta de publicacion");
		System.out.println("2.- Borrar publicacion");
		System.out.println("0.- Volver al menu");
		System.out.println("*************************************");
		System.out.println("Introduce una opcion: ");
	}
	public static void subMenu_02(Biblioteca biblioActual) {
		System.out.println("************** SUBMENU **************");
		System.out.println("       Biblioteca: " + biblioActual.getNombre());
		System.out.println("1.- Añadir articulos a una revista");
		System.out.println("2.- Borrar articulo");
		System.out.println("0.- Volver al menu");
		System.out.println("*************************************");
		System.out.println("Introduce una opcion: ");
	}
	
	//FUNCIONALIDAD
	public static void listarPublicaciones(Biblioteca biblioActual) {
		System.out.println("\nPublicaciones actuales: \n");
		
		for (Publicacion publicacion : biblioActual.getPublicaciones())
			System.out.println(publicacion);
	}
	public static void listarRevistas(Biblioteca biblioActual) {
		System.out.println("\nListado de revistas: \n");
		
		for (Publicacion publicacion : biblioActual.getPublicaciones())
			if (publicacion instanceof Revista)
				System.out.println(publicacion);
	}
	public static void listarArticulos(Revista revista) {
		System.out.println("\nArticulos de la revista '" + revista.getNombre() + "' \n");
		
		for (Articulo articulo : revista.getArticulos())
			System.out.println(articulo);
	}
	public static boolean comprobarIgualdad(Publicacion pub, Biblioteca biblioActual) {
		for (Publicacion publicacion : biblioActual.getPublicaciones()) {
			if (publicacion instanceof Libro && pub instanceof Libro)
				if (publicacion.getIsbn() == pub.getIsbn() && publicacion.getNombre().compareTo(pub.getNombre()) == 0)
					return true;
			if (publicacion instanceof Revista && pub instanceof Revista)
				if (publicacion.getIsbn() == pub.getIsbn() && publicacion.getNombre().compareTo(pub.getNombre()) == 0)
					return true;
		}
				
		return false;
	}
	
	//SUBMENU_01
	public static void altaPublicacion(Biblioteca biblioActual) {
		
		int opc = 0;
		
		System.out.println("\nTipo de publicacion: ");
		System.out.println("\n1.- Libro");
		System.out.println("\n2.- Revista\n");
		System.out.println("\nIntroduce una opcion: ");
		
		try {
			opc = Integer.parseInt(sc.nextLine());
			
			switch (opc) {
				case 1:
					Libro nuevoLibro = new Libro();
					
					try {
						if (nuevoLibro.estaCorrecto() && comprobarIgualdad(nuevoLibro, biblioActual) == false) {
							biblioActual.getPublicaciones().add(nuevoLibro);
							System.out.println("\nLibro creado con exito :)\n");
						} else {
							throw new PublicacionExisteException(nuevoLibro);
						}
					}catch (PublicacionExisteException e) {
						System.out.println("**ERROR**: " + e);
					}
					break;
				case 2:
					Revista nuevaRevista = new Revista();

					try {
						if (nuevaRevista.estaCorrecto() && comprobarIgualdad(nuevaRevista, biblioActual) == false) {
							biblioActual.getPublicaciones().add(nuevaRevista);
							System.out.println("\nRevista creada con exito :)\n");
						} else {
							throw new PublicacionExisteException(nuevaRevista);
						}
					}catch (PublicacionExisteException e) {
						System.out.println("**ERROR**: " + e);
					}
					break;
				default:
					System.out.println("Opcion incorrecta");
					break;
			}
		}catch (NumberFormatException e) {
			System.out.println("**ERROR**: " + e.getMessage());
		}
	}
	public static void borrarPublicacion(Biblioteca biblioActual) {
		listarPublicaciones(biblioActual);
		
		System.out.println("\nIntroduce el nombre de la publicacion a borrar: ");
		String nombre = sc.nextLine();
		
		Publicacion publicacion = biblioActual.buscarPublicacion(nombre);
		
		if (publicacion instanceof Libro) {
			biblioActual.getPublicaciones().remove(publicacion);
		}else if (publicacion instanceof Revista){
			try {
				if (((Revista) publicacion).getArticulos().isEmpty()) {
					biblioActual.getPublicaciones().remove(publicacion);
					System.out.println("Publicacion borrada.");
				}else {
					throw new HayArticulosException((Revista)publicacion);
				}
			}catch(HayArticulosException e) {
				System.out.println("**ERROR**: " + e);
			}
		}
	}
	
	//SUBMENU_02
	public static void añadirArticuloARevista(Biblioteca biblioActual) {
		
		listarRevistas(biblioActual);
		
		System.out.println("\nIntroduce el nombre de la revista: ");
		String nombre = sc.nextLine();
		
		if (biblioActual.buscarPublicacion(nombre) instanceof Revista) {
			Revista revista = (Revista) biblioActual.buscarPublicacion(nombre);
			revista.añadirArticulos();
		}else {
			System.out.println("La publicacion NO es una revista.");
		}
	}
	public static void borrarArticulo(Biblioteca biblioActual) {
		
		listarRevistas(biblioActual);
		
		System.out.println("\nIntroduce el nombre de la revista: ");
		String nombreRevista = sc.nextLine();
		
		int numero = 0;
		
		if (biblioActual.buscarPublicacion(nombreRevista) instanceof Revista) {
			Revista revista = (Revista) biblioActual.buscarPublicacion(nombreRevista);	
			
			listarArticulos(revista);
			
			System.out.println("\nIntroduce el numero del articulo: ");
			try {
				numero = Integer.parseInt(sc.nextLine());
				
				if (revista.buscarArticulo(numero) != null) {
					
					revista.getArticulos().remove(revista.buscarArticulo(numero));
					
					revista.ordenarArticulos();
					
					System.out.println("Articulo eliminado");
					
				}else {
					System.out.println("Articulo no encontrado...");
				}
			}catch (NumberFormatException e) {
				System.out.println("**ERROR**: " + e.getMessage());
			}
		}else {
			System.out.println("La publicacion NO es una revista.");
		}
	}
}
