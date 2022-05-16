package clases;

import java.util.ArrayList;

import enums.EnumeracionLugares;
import superclases.EntidadConNombre;

public class Mercado extends EntidadConNombre{

	private ArrayList<Noticia>noticia;
	private EnumeracionLugares lugarMercado;
	private ArrayList<Empresa>empresa;
	public ArrayList<Noticia> getNoticia() {
		return noticia;
	}
	public void setNoticia(ArrayList<Noticia> noticia) {
		this.noticia = noticia;
	}
	public EnumeracionLugares getLugarMercado() {
		return lugarMercado;
	}
	public void setLugarMercado(EnumeracionLugares lugarMercado) {
		this.lugarMercado = lugarMercado;
	}
	public ArrayList<Empresa> getEmpresa() {
		return empresa;
	}
	public void setEmpresa(ArrayList<Empresa> empresa) {
		this.empresa = empresa;
	}
	public Mercado(String nombre, ArrayList<Noticia> noticia, EnumeracionLugares lugarMercado,
			ArrayList<Empresa> empresa) {
		super(nombre);
		this.noticia = noticia;
		this.lugarMercado = lugarMercado;
		this.empresa = empresa;
	}
	@Override
	public String toString() {
		return "Mercado [noticia=" + noticia + ", lugarMercado=" + lugarMercado + ", empresa=" + empresa + "]";
	}

	public void verEmpresas(){}
	public void verNoticias(){}
	public void verIndices(){}

}
