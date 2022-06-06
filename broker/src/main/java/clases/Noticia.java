package clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import superclases.EntidadConNombre;
import utils.UtilsDB;
/**
 * 
 * @author gonzalo
 *
 */
public class Noticia extends EntidadConNombre{
	protected String titular;
	protected LocalDate fecha;
	protected String cuerpo;
	/**
	 * Getter de fecha
	 * @return fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}
	/**
	 * Setter fecha que conecta con base de datos y actualiza
	 * @param fecha
	 * @throws SQLException
	 */
	public void setFecha(LocalDate fecha) throws SQLException {
Statement smt = UtilsDB.conectarBD();
		
		if(smt.executeUpdate("update noticias set fecha='"+fecha+"' where titular='"+this.titular+"'")>0) {
			this.fecha = fecha;
		}
		
		UtilsDB.desconectarBD();
	}
	/**
	 * Getter de cuerpo
	 * @return cuerpo
	 */
	public String getCuerpo() {
		return cuerpo;
	}
	/**
	 * Setter de cuerpo que conecta a la base de datos y la actualiza
	 * @param cuerpo
	 * @throws SQLException
	 */
	public void setCuerpo(String cuerpo) throws SQLException {
Statement smt = UtilsDB.conectarBD();
		
		if(smt.executeUpdate("update noticias set cuerpo='"+cuerpo+"' where titular='"+this.titular+"'")>0) {
			this.cuerpo = cuerpo;
		}
		
		UtilsDB.desconectarBD();
	}
	
	/**
	 * Constructor de noticia que toma solo su nombre para identificarlo por su nombre
	 * @param nombre
	 */
	public Noticia(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Getter de titular
	 * @return titular
	 */
	public String getTitular() {
		return titular;
	}
	/**
	 * Setter de titular que conecta a la base de datos y la actualiza
	 * @param titular
	 * @throws SQLException
	 */
	public void setTitular(String titular) throws SQLException {
Statement smt = UtilsDB.conectarBD();
		
		if(smt.executeUpdate("update noticias set titular='"+titular+"' where titular='"+this.titular+"'")>0) {
			this.titular = titular;
		}
		
		UtilsDB.desconectarBD();
	}
	/**
	 * Constructor que toma todos los datos de noticia y sirve para definir una noticia en su totalidad
	 * @param nombre
	 * @param titular
	 * @param fecha
	 * @param cuerpo
	 */
	public Noticia(String nombre, String titular, LocalDate fecha, String cuerpo) {
		super(nombre);
		this.titular = titular;
		this.fecha = fecha;
		this.cuerpo = cuerpo;
	}
	/**
	 * Constructor que toma solo tres variables y elimina la del titular para que el nombre sea el identificador principal
	 * @param nombre
	 * @param fecha
	 * @param cuerpo
	 */
	public Noticia(String nombre, LocalDate fecha, String cuerpo) {
		super(nombre);
		this.fecha = fecha;
		this.cuerpo = cuerpo;
	}
	/**
	 * toString que devuelve los datos de la noticia
	 */
	@Override
	public String toString() {
		return "Noticia [titular=" + titular + ", fecha=" + fecha + ", cuerpo=" + cuerpo + "]";
	}
	
	
	
}
