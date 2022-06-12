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

	private ArrayList<Noticia>noticia;
	private EnumeracionLugares lugarMercado;
	private ArrayList<Empresa>empresa;
	/**
	 * Getter del arrayList de noticia
	 * @return noticia
	 */
	public ArrayList<Noticia> getNoticia() {
		return noticia;
	}
	/**
	 * Setter del arrayList de noticia
	 * @param noticia
	 */
	public void setNoticia(ArrayList<Noticia> noticia) {
		this.noticia = noticia;
	}
	/**
	 * Getter Enum de lugares
	 * @return lugarMercado
	 */
	public EnumeracionLugares getLugarMercado() {
		return lugarMercado;
	}
	/**
	 * Setter del enum de lugarMercado
	 * @param lugarMercado
	 */
	public void setLugarMercado(EnumeracionLugares lugarMercado) {
		this.lugarMercado = lugarMercado;
	}
	/**
	 * Getter del arrayList de empresa
	 * @return empresa
	 */
	public ArrayList<Empresa> getEmpresa() {
		return empresa;
	}
	/**
	 * Setter de arrayList empresa
	 * @param empresa
	 */
	public void setEmpresa(ArrayList<Empresa> empresa) {
		this.empresa = empresa;
	}
	/**
	 * Constructor que toma todo los datos de la clase y el cual se usa para definir a el Mercado que pertenecen las empresas
	 * @param nombre
	 * @param noticia
	 * @param lugarMercado
	 * @param empresa
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

	public void verEmpresas(){}
	public void verNoticias(){}
	public void verIndices(){}

}
