package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import superclases.EntidadConNombre;
import utils.UtilsDB;
/**
 * 
 * @author gonzalo
 *
 */
public class Noticia extends EntidadConNombre{
	/**
	 * @param titular String del titulo de la noticia
	 * @param fecha devuelve la fehca de la noticia
	 * @param cuerpo String que devuelve el texto de la noticia
	 */
	protected String titular;
	protected LocalDate fecha;
	protected String cuerpo;
	/**
	 * Getter de fecha
	 * @return fecha Devuelve una fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}
	/**
	 * Setter fecha que conecta con base de datos y actualiza
	 * @param fecha Define una fecha
	 * @throws SQLException Da el error del sql
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
	 * @return cuerpo Devuelve el texto de la noticia
	 */
	public String getCuerpo() {
		return cuerpo;
	}
	/**
	 * Setter de cuerpo que conecta a la base de datos y la actualiza
	 * @param cuerpo Define el texto de la noticia
	 * @throws SQLException Devuelve el error del sql
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
	 * @param nombre String del nombre de la noticia
	 */
	public Noticia(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Getter de titular
	 * @return titular Devuelve el titular de la noticia
	 */
	public String getTitular() {
		return titular;
	}
	/**
	 * Setter de titular que conecta a la base de datos y la actualiza
	 * @param titular Define el titular de la noticia
	 * @throws SQLException Da el error de sql
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
	 * @param nombre String da el nombre de la noticia
	 * @param titular String da el titular de la noticia
	 * @param fecha LocalDate que da la fecha
	 * @param cuerpo String del texto de la noticia
	 */
	public Noticia(String nombre, String titular, LocalDate fecha, String cuerpo) {
		super(nombre);
		this.titular = titular;
		this.fecha = fecha;
		this.cuerpo = cuerpo;
	}
	/**
	 * Constructor que toma solo tres variables y elimina la del titular para que el nombre sea el identificador principal
	 * @param nombre  String da el nombre de la noticia
	 * @param fecha LocalDate que da la fecha
	 * @param cuerpo String del texto de la noticia
	 */
	public Noticia(String nombre, LocalDate fecha, String cuerpo) {
		super(nombre);
		this.fecha = fecha;
		this.cuerpo = cuerpo;
	}
	/**
	 * Constructor vacio
	 */
	public Noticia() {
		super("");
		// TODO Auto-generated constructor stub
	}
	/**
	 * toString que devuelve los datos de la noticia
	 */
	@Override
	public String toString() {
		return "Noticia [titular=" + titular + ", fecha=" + fecha + ", cuerpo=" + cuerpo + "]";
	}
	/**
	 * Funcion que devuelve todos las noticias de base de datos
	 * @return ret Devuelve el query
	 */
	public static ArrayList<Noticia> getTodos() {
		Statement smt = UtilsDB.conectarBD();
		// Inicializamos un ArrayList para devolver.
		ArrayList<Noticia> ret = new ArrayList<Noticia>();

		try {
			ResultSet cursor = smt.executeQuery("select * from noticias");
			while (cursor.next()) {
				Noticia actual = new Noticia();

				actual.titular = cursor.getString("titular");
				actual.cuerpo = cursor.getString("cuerpo");
				actual.fecha = cursor.getDate("fecha").toLocalDate();
				

				ret.add(actual);
			}
		} catch (SQLException e) {
			// Si la conuslta falla no hay nada que devolver.
			e.printStackTrace();
			return null;
		}
		// Si no hay usuarios en la tabla, va a devolver un arraylist vacio.
		// Si la consulta fue erronea se devuelve un arraylist null, que son cosas
		// distintas.
		UtilsDB.desconectarBD();
		return ret;
	}
	/**
	 * Funcion para cargar des de base de datos sin uso actual
	 */
	private void cargaNoticia() {

        Statement smt = UtilsDB.conectarBD();

        try {
            ResultSet cursor = smt.executeQuery("titular, cuerpo, fecha");

            while (cursor.next()) {
        		ArrayList<Noticia> listaNoticia = new ArrayList<Noticia>();

        		String titular = cursor.getString("titular");
				String cuerpo = cursor.getString("cuerpo");
				LocalDate fecha = cursor.getDate("fecha").toLocalDate();

				Noticia actual = new Noticia();
                listaNoticia.add(actual);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        UtilsDB.desconectarBD();

    }
}
