package clases;

import java.sql.ResultSet;
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
	public Empresa() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", noticia=" + noticia + ", mercado=" + mercado + ", valor=" + valor + "]";
	}
	public static ArrayList<Empresa> getTodos() {
		Statement smt = UtilsDB.conectarBD();
		// Inicializamos un ArrayList para devolver.
		ArrayList<Empresa> ret = new ArrayList<Empresa>();

		try {
			ResultSet cursor = smt.executeQuery("select * from empresa");
			while (cursor.next()) {
				Empresa actual = new Empresa();

				actual.nombre = cursor.getString("nombre");
				actual.valor = cursor.getInt("valor");
				actual.mercado = ((Empresa) cursor).getMercado();
				

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
