package clases;

public class Opcion extends Operacion {

	private int interes;
	private int call;
	private int corto;
	
	
	
	public int getInteres() {
		return interes;
	}



	public void setInteres(int interes) {
		this.interes = interes;
	}



	public int getCall() {
		return call;
	}



	public void setCall(int call) {
		this.call = call;
	}



	public int getCorto() {
		return corto;
	}



	public void setCorto(int corto) {
		this.corto = corto;
	}



	public Opcion(int interes, int call, int corto) {
		super();
		this.interes = interes;
		this.call = call;
		this.corto = corto;
	}



	@Override
	public String toString() {
		return "Opcion [interes=" + interes + ", call=" + call + ", corto=" + corto + "]";
	}



	public static void precio() {}

}
