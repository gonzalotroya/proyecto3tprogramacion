package clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import superclases.EntidadConNombre;
import utils.UtilsDB;

public class Noticia extends EntidadConNombre{
	protected String titular;
	protected LocalDate fecha;
	protected String cuerpo;
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) throws SQLException {
Statement smt = UtilsDB.conectarBD();
		
		if(smt.executeUpdate("update noticias set fecha='"+fecha+"' where titular='"+this.titular+"'")>0) {
			this.fecha = fecha;
		}
		
		UtilsDB.desconectarBD();
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) throws SQLException {
Statement smt = UtilsDB.conectarBD();
		
		if(smt.executeUpdate("update noticias set cuerpo='"+cuerpo+"' where titular='"+this.titular+"'")>0) {
			this.cuerpo = cuerpo;
		}
		
		UtilsDB.desconectarBD();
	}
	
	public Noticia(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}
	
	
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) throws SQLException {
Statement smt = UtilsDB.conectarBD();
		
		if(smt.executeUpdate("update noticias set titular='"+titular+"' where titular='"+this.titular+"'")>0) {
			this.titular = titular;
		}
		
		UtilsDB.desconectarBD();
	}
	
	public Noticia(String nombre, String titular, LocalDate fecha, String cuerpo) {
		super(nombre);
		this.titular = titular;
		this.fecha = fecha;
		this.cuerpo = cuerpo;
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
