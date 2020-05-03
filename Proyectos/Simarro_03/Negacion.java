package Simarro_03;

public class Negacion extends Operacion{

	public Negacion(Double op1) {
		super("Negacion");
		this.getListadoOperandos().add(op1);
	}
	
	@Override
	void registrarOperando(double nuevoOperando) {
		System.out.println("No se pueden añadir operandos a la negacion.");
	}
	@Override
	double realizarOperación() {
		double resultado = 0;
		this.getListadoOperandos().set(0, (this.getListadoOperandos().get(0) * -1));
		
		resultado = this.getListadoOperandos().get(0);
		
		if (resultado >= 0)
			this.setFlag(false);
		else
			this.setFlag(true);

		return 0;
	}
	@Override
	int realizarOperaciónRedondeada() {
		return (int) Math.round(this.getResultado());
	}
	@Override
	int eliminarOperandos(double v) {
		
		try {
			
			if (this.getListadoOperandos().size() == 0)
				throw new SinOperandosNecesariosException(this);
			
			if (this.getListadoOperandos().get(0) == v) {
				this.getListadoOperandos().remove(0);
				return 1;
			}
			
		}catch(SinOperandosNecesariosException e){
			System.out.println("**ERROR**: " + e.getMessage());
		}

		return 0;
	}
	@Override
	String imprimirOperacion() {
		return "NEG: " + this.getListadoOperandos().get(0);
	}
	

}
