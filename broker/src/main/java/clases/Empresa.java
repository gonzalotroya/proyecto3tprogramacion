package clases;

import java.util.ArrayList;

public class Empresa {

	private String nombre;
	private ArrayList<Noticia>noticia;
	private Mercado mercado;
	private float valor;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Noticia> getNoticia() {
		return noticia;
	}
	public void setNoticia(ArrayList<Noticia> noticia) {
		this.noticia = noticia;
	}
	public Mercado getMercado() {
		return mercado;
	}
	public void setMercado(Mercado mercado) {
		this.mercado = mercado;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Empresa(String nombre, ArrayList<Noticia> noticia, Mercado mercado, float valor) {
		super();
		this.nombre = nombre;
		this.noticia = noticia;
		this.mercado = mercado;
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", noticia=" + noticia + ", mercado=" + mercado + ", valor=" + valor + "]";
	}
	
}
