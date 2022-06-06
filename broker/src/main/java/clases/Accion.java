package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.UtilsDB;
/**
 * 
 * @author gonzalo
 * **/
public class Accion extends Operacion{
	/**
	 * En esta clase se declaran varias variables que almacenan y realizan calculos matematicos donde obtienen un porcentaje y se obtiene 
	 * un ramdon de un evento
	 * @param porcentaje
	 * @param eventosNoticias
	 * @author gonzalo
	 * **/
	
	private float porcentaje;
	private String eventosNoticias;
	
	
	/**
	 * Getter de porcentaje
	 * @param porcentaje
	 */
	public float getPorcentaje() {
		return porcentaje;
	}


	/**
	 * Setter del porcentaje
	 * @param porcentaje
	 */
	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
		
	}

	/**
	 * Getter de eventosNoticias
	 * @param eventosNoticias
	 */

	public String getEventosNoticias() {
		return eventosNoticias;
	}


	/**
	 * Setter de la variable eventosNoticias
	 * @param eventosNoticias
	 */
	public void setEventosNoticias(String eventosNoticias) {
		this.eventosNoticias = eventosNoticias;
	}


/**
 * Construtor de la clase accion que usa las las variables porcentaje y eventosNoticas ,que sirve para poder usar y rellenar una accion
 * @param porcentaje
 * @param eventosNoticias
 */
	public Accion(float porcentaje, String eventosNoticias) {
		super();
		this.porcentaje = porcentaje;
		this.eventosNoticias = eventosNoticias;
	}


/**
 * Constructor vacio de la clase accion que sirve para insertar datos en la accion vacios
 */
	public Accion() {
		// TODO Auto-generated constructor stub
	}



	public static void precio() {}
	
	
	
	/**
	 * DAO de la clase Accion que conecta con la base de datos y inicia un arrayList de accion que toma mediante un resulset
	 * de la base de datos el get de pocentaje y lo añade al arrayList, sino se cumple salta un catch que imprime un SQLexception
	 * @return ret
	 */
	public static ArrayList<Accion> getTodos() {
		Statement smt = UtilsDB.conectarBD();
		// Inicializamos un ArrayList para devolver.
		ArrayList<Accion> ret = new ArrayList<Accion>();

		try {
			ResultSet cursor = smt.executeQuery("select * from acciones");
			while (cursor.next()) {
				Accion actual = new Accion();
				
				actual.porcentaje = cursor.getInt("porcentaje");
				

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
}
