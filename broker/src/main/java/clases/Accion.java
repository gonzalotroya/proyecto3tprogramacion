package clases;

public class Accion extends Operacion{

	private float porcentaje;
	private String eventosNoticias;
	
	
	
	public float getPorcentaje() {
		return porcentaje;
	}



	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}



	public String getEventosNoticias() {
		return eventosNoticias;
	}



	public void setEventosNoticias(String eventosNoticias) {
		this.eventosNoticias = eventosNoticias;
	}



	public Accion(float porcentaje, String eventosNoticias) {
		super();
		this.porcentaje = porcentaje;
		this.eventosNoticias = eventosNoticias;
	}



	public static void precio() {}
}
