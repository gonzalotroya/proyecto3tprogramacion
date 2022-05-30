package clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.UtilsDB;

public class Empresa {

	private String nombre;
	private ArrayList<Noticia>noticia;
	private Mercado mercado;
	private float valor;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		
		if(smt.executeUpdate("update empresa set nombre='"+nombre+"' where nombre='"+this.nombre+"'")>0) {
			this.nombre = nombre;
		}
		
		UtilsDB.desconectarBD();
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
	public void setMercado(Mercado mercado) throws SQLException {
Statement smt = UtilsDB.conectarBD();
		
		if(smt.executeUpdate("update empresa set mercado='"+mercado+"' where nombre='"+this.nombre+"'")>0) {
			this.mercado = mercado;
		}
		
		UtilsDB.desconectarBD();
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) throws SQLException {
Statement smt = UtilsDB.conectarBD();
		
		if(smt.executeUpdate("update empresa set valor='"+valor+"' where nombre='"+this.nombre+"'")>0) {
			this.valor = valor;
		}
		
		UtilsDB.desconectarBD();
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
