package Simarro_02;

import java.util.Collections;

public class App {

	public static void main(String[] args) throws RegistroFutbolistaException {

		Equipo nuevoEquipo = new Equipo("PEPEGUEBOREPE");
		
		try {
			nuevoEquipo.anyadirFutbolista("Olwenn", 20, PosicionJugador.Defensa);
			nuevoEquipo.anyadirFutbolista("David", 22, PosicionJugador.Portero);
			nuevoEquipo.anyadirFutbolista("Oscar", 22, PosicionJugador.Centrocampista);
			nuevoEquipo.anyadirFutbolista("Salva", 22, PosicionJugador.Portero);
			nuevoEquipo.anyadirFutbolista("Kristian", 20, PosicionJugador.Centrocampista);
			nuevoEquipo.anyadirFutbolista("Juan", 20, PosicionJugador.Delantero);
			nuevoEquipo.anyadirFutbolista("Pepe", 20, PosicionJugador.Delantero);
			nuevoEquipo.anyadirFutbolista("Carlos", 20, PosicionJugador.Centrocampista);
			nuevoEquipo.anyadirFutbolista("Manu", 22, PosicionJugador.Portero);
		}catch(RegistroFutbolistaException e) {
			System.out.println("**ERROR**: " + e);
		}

		System.out.println("\nSIN ORDENAR\n");
		nuevoEquipo.listarFormacionEquipo();

		Collections.sort(nuevoEquipo.getFutbolistas());

		System.out.println("\n-----------------------------------------------");

		System.out.println("\nORDENADO\n");
		nuevoEquipo.listarFormacionEquipo();
	}
}
