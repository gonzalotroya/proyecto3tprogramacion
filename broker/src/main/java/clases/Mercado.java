package clases;

import java.util.ArrayList;

import enums.EnumeracionLugares;
import superclases.EntidadConNombre;
/**
 * 
 * @author gonzalo
 *
 */
public class Mercado extends EntidadConNombre{

	/**
	 * @param ArrayList<Noticia> noticia almacena noticias
	 * @param EnumeracionLugares lugarMercado Enums de lugares 
	 * @param ArrayList<Empresa> empresa almacena las empresas
	 */
	private ArrayList<Noticia>noticia;
	private EnumeracionLugares lugarMercado;
	private ArrayList<Empresa>empresa;
	/**
	 * Getter del arrayList de noticia
	 * @return noticia Devuelve las noticias
	 */
	public ArrayList<Noticia> getNoticia() {
		return noticia;
	}
	/**
	 * Setter del arrayList de noticia
	 * @param noticia Define una noticia dentro de un arrayList
	 */
	public void setNoticia(ArrayList<Noticia> noticia) {
		this.noticia = noticia;
	}
	/**
	 * Getter Enum de lugares
	 * @return lugarMercado devuelve un lugar del Mercado
	 */
	public EnumeracionLugares getLugarMercado() {
		return lugarMercado;
	}
	/**
	 * Setter del enum de lugarMercado
	 * @param lugarMercado Define el lugarMercado
	 */
	public void setLugarMercado(EnumeracionLugares lugarMercado) {
		this.lugarMercado = lugarMercado;
	}
	/**
	 * Getter del arrayList de empresa
	 * @return empresa devuelve una Empresa
	 */
	public ArrayList<Empresa> getEmpresa() {
		return empresa;
	}
	/**
	 * Setter de arrayList empresa
	 * @param empresa Define una empresa en una lista
	 */
	public void setEmpresa(ArrayList<Empresa> empresa) {
		this.empresa = empresa;
	}
	/**
	 * Constructor que toma todo los datos de la clase y el cual se usa para definir a el Mercado que pertenecen las empresas
	 * @param nombre String de nombre
	 * @param noticia almacena una noticia
	 * @param lugarMercado enums de lugares
	 * @param empresa almacena una empresa
	 */
	public Mercado(String nombre, ArrayList<Noticia> noticia, EnumeracionLugares lugarMercado,
			ArrayList<Empresa> empresa) {
		super(nombre);
		this.noticia = noticia;
		this.lugarMercado = lugarMercado;
		this.empresa = empresa;
	}
	/**
	 * toString que devuelve todo los datos del mercado por pantalla
	 */
	@Override
	public String toString() {
		return "Mercado [noticia=" + noticia + ", lugarMercado=" + lugarMercado + ", empresa=" + empresa + "]";
	}
}
