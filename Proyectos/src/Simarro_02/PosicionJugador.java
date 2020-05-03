package Simarro_02;

public enum PosicionJugador {
	
	Portero(2000, 3000, 2),
	Defensa(2500, 3500, 5),
	Centrocampista(3500, 4000, 5),
	Delantero(4000, 5000, 4);
	
	private double min;
	private double max;
	private int maxPos;
	
	PosicionJugador(double min, double max, int maxPos) {
		this.min = min;
		this.max = max;
		this.maxPos = maxPos;
	}
	
	public double getMin() {
		return this.min;
	}
	public double getMax() {
		return this.max;
	}
	public int getMaxPos() {
		return this.maxPos;
	}
}
