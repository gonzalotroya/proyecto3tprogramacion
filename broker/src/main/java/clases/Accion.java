package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.UtilsDB;

public class Accion extends Operacion{

	private float porcentaje;
	private String eventosNoticias;
	
	
	
	public float getPorcentaje() {
		return porcentaje;
	}



	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
		
	}



	public String getEventosNoticias() {
		return eventosNoticias;
	}



	public void setEventosNoticias(String eventosNoticias) {
		this.eventosNoticias = eventosNoticias;
	}



	public Accion(float porcentaje, String eventosNoticias) {
		super();
		this.porcentaje = porcentaje;
		this.eventosNoticias = eventosNoticias;
	}



	public Accion() {
		// TODO Auto-generated constructor stub
	}



	public static void precio() {}
	
	
	public static ArrayList<Accion> getTodos() {
		Statement smt = UtilsDB.conectarBD();
		// Inicializamos un ArrayList para devolver.
		ArrayList<Accion> ret = new ArrayList<Accion>();

		try {
			ResultSet cursor = smt.executeQuery("select * from accion");
			while (cursor.next()) {
				Accion actual = new Accion();

				actual.porcentaje = cursor.getInt("porcentaje");
				actual.eventosNoticias = cursor.getString("eventosNoticias");
				

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
