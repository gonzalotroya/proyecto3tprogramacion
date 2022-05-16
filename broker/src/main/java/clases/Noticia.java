package clases;

import java.time.LocalDate;

import superclases.EntidadConNombre;

public class Noticia extends EntidadConNombre{

	private LocalDate fecha;
	private String cuerpo;
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	
	public Noticia(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}
	
	public Noticia(String nombre, LocalDate fecha, String cuerpo) {
		super(nombre);
		this.fecha = fecha;
		this.cuerpo = cuerpo;
	}
	@Override
	public String toString() {
		return "Noticia [fecha=" + fecha + ", cuerpo=" + cuerpo + "]";
	}
	
	
}
