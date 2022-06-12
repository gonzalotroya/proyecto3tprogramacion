package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import enums.EnumeracionLugares;
import utils.UtilsDB;

/**
 * Clase empresa que tiene los datos de las empresas
 * 
 * @author gonzalo
 *
 */
public class Empresa {

	/**
	 * @param nombre             es el nombre de la empresa
	 * @param ArrayList<Noticia> noticia donde se almacenan las noticias
	 * @param mercado            El lugar donde esta la empresa
	 * @param valor              el precio al que cotiza
	 */
	private String nombre;
	private ArrayList<Noticia> noticia;
	private String mercado;
	private float valor;
	private boolean esComprada;

	public boolean isEsComprada(boolean b) {
		return esComprada;
	}
	public boolean isEsVendida(boolean b) {
		return esComprada;
	}

	public static void venderEmpresas(String text) throws SQLException {
		Statement smt = UtilsDB.conectarBD();

		if (smt.executeUpdate("UPDATE empresa set estaComprada=false where nombre='" + text + "';") > 0) {

		}

		UtilsDB.desconectarBD();
	}
	public static void comprarEmpresas(String text) throws SQLException {
		Statement smt = UtilsDB.conectarBD();

		if (smt.executeUpdate("UPDATE empresa set estaComprada=true where nombre='" + text + "';") > 0) {

		}

		UtilsDB.desconectarBD();
	}
	

	public void setEsComprada(boolean esComprada) throws SQLException {
		/*
		 * Statement smt = UtilsDB.conectarBD();
		 * 
		 * if (smt.executeUpdate("UPDATE empresa set estaComprada=true where nombre='" +
		 * this.nombre + "';") > 0) {
		 */this.esComprada = esComprada;/*
										 * }
										 * 
										 * UtilsDB.desconectarBD();
										 */
	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter de la variable nombre que toma sus datos y los conecta y actualiza a
	 * la base de datos, si falla salta una excepcion
	 * 
	 * @param nombre nombre de la empresa
	 * @throws SQLException da el error sql sea el que sea
	 */
	public void setNombre(String nombre) throws SQLException {
		/*
		 * Statement smt = UtilsDB.conectarBD();
		 * 
		 * if (smt.executeUpdate("update empresa set nombre='" + nombre +
		 * "' where nombre='" + this.nombre + "'") > 0) {
		 */this.nombre = nombre;/*
								 * }
								 * 
								 * UtilsDB.desconectarBD();
								 */
	}

	/**
	 * Getter del arraylist Noticia
	 * 
	 * @return noticia devulve una noticia
	 */
	public ArrayList<Noticia> getNoticia() {
		return noticia;
	}

	/**
	 * Setter del arrayList noticia
	 * 
	 * @param noticia establece una notcia en el array
	 */
	public void setNoticia(ArrayList<Noticia> noticia) {
		this.noticia = noticia;
	}

	/**
	 * Getter del Mercado que toma datos de Mercado
	 * 
	 * @return mercado devuelve el nombre del lugar donde esta la empresa
	 */
	public String getMercado() {
		return mercado;
	}

	/**
	 * Setter de Mercado que conecta con la base de datos
	 * 
	 * @param mercado es el nombre del lugar
	 * @throws SQLException da el error sql sea el que sea
	 */
	public void setMercado(String mercado) throws SQLException {
		/*
		 * Statement smt = UtilsDB.conectarBD();
		 * 
		 * if (smt.executeUpdate("update empresa set mercado='" + mercado +
		 * "' where nombre='" + this.nombre + "'") > 0) {
		 */this.mercado = mercado;/*
									 * }
									 * 
									 * UtilsDB.desconectarBD();
									 */
	}

	/**
	 * Getter de valor
	 * 
	 * @return valor devuelve el precio
	 */
	public float getValor() {
		return valor;
	}

	/**
	 * Setter de valor
	 * 
	 * @param valor Es el precio
	 * @throws SQLException da el error sql sea el que sea
	 */
	public void setValor(float valor) throws SQLException {
		/*
		 * Statement smt = UtilsDB.conectarBD();
		 * 
		 * if (smt.executeUpdate("update empresa set valor='" + valor +
		 * "' where nombre='" + this.nombre + "'") > 0) {
		 */this.valor = valor;/*
								 * }
								 * 
								 * UtilsDB.desconectarBD();
								 */
	}

	/**
	 * Constructor empresa en cual se toman todos los datos de la empresa
	 * 
	 * @param nombre  es el nombre de la empresa
	 * @param noticia el array de todas las noticias
	 * @param usa     lugar del mercado
	 * @param valor   precio
	 */
	public Empresa(String nombre, ArrayList<Noticia> noticia, String lugarMercado, float valor) {
		super();
		this.nombre = nombre;
		this.noticia = noticia;
		this.mercado = lugarMercado;
		this.valor = valor;
	}

	/**
	 * Constructor vacio de empresa, para insertar datos vacios
	 */
	public Empresa() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de empresa en el que se toman todos los datos de de la empresa
	 * 
	 * @param nombre  es el nombre de la empres
	 * @param noticia ArrayList de las noticias
	 * @param usa     lugar del mercado
	 * @param valor   precio de la empresa
	 */
	public Empresa(String nombre, ArrayList<Noticia> noticia, EnumeracionLugares usa, float valor) {
		super();
		this.nombre = nombre;
		this.noticia = noticia;
		this.getMercado();
		this.valor = valor;
	}

	/*
	 * public Empresa(float valor, String nombre, String mercado) {
	 * 
	 * super();
	 * 
	 * this.nombre = nombre; this.getMercado(); this.valor = valor; }
	 */
	/**
	 * Constructor que no toma los datos de la noticias para insertarlas
	 * 
	 * @param valor   precio
	 * @param nombre  nombre de la empresa
	 * @param mercado lugar donde esta la empresa
	 * @throws SQLException da el error sql sea el que sea
	 */
	public Empresa(float valor, String nombre, String mercado) throws SQLException {
		super();
		Statement query = UtilsDB.conectarBD();
		// Insertar

		if (query.executeUpdate(
				"insert into empresaCompradas VALUES ('" + valor + "','" + nombre + "','" + mercado + "')") > 0) {
			this.valor = valor;
			this.nombre = nombre;
			this.mercado = mercado;

		} else {
			throw new SQLException("No se ha podido insertar el usuario.");
		}
		UtilsDB.desconectarBD();

	}

	public Empresa(String text) {

		Statement smt = UtilsDB.conectarBD();
		// Inicializamos un ArrayList para devolver.

		try {
			ResultSet cursor = smt.executeQuery("select * from empresa where nombre ='" + text + "'");
			while (cursor.next()) {
				Empresa actual = new Empresa();

				actual.setNombre(cursor.getString("nombre"));
				actual.setValor(cursor.getInt("valor"));
				actual.setMercado(cursor.getString("mercado"));
				actual.isEsComprada(cursor.getBoolean("estaComprada"));

			}
		} catch (SQLException e) {
			// Si la conuslta falla no hay nada que devolver.
			e.printStackTrace();

		}
		// Si no hay usuarios en la tabla, va a devolver un arraylist vacio.
		// Si la consulta fue erronea se devuelve un arraylist null, que son cosas
		// distintas.
		UtilsDB.desconectarBD();

	}

	public static ArrayList<Empresa> empresasCompradas() {
		ArrayList<Empresa> listaEmpresa = new ArrayList<Empresa>();

		Statement smt = UtilsDB.conectarBD();
		// Inicializamos un ArrayList para devolver.

		try {
			ResultSet cursor = smt.executeQuery("select * from empresa where estaComprada =true");
			while (cursor.next()) {

				Empresa actual = new Empresa();
				actual.setNombre(cursor.getString("nombre"));
				actual.setValor(cursor.getInt("valor"));
				actual.setMercado(cursor.getString("mercado"));
				actual.isEsComprada(cursor.getBoolean("estaComprada"));
				listaEmpresa.add(actual);

			}
		} catch (SQLException e) {
			// Si la conuslta falla no hay nada que devolver.
			e.printStackTrace();

		}
		// Si no hay usuarios en la tabla, va a devolver un arraylist vacio.
		// Si la consulta fue erronea se devuelve un arraylist null, que son cosas
		// distintas.
		UtilsDB.desconectarBD();
		return listaEmpresa;
	}

	/**
	 * funcion que selecciona los datos de la empresa de base de datos
	 */
	private void cargaEmpresa() {

		Statement smt = UtilsDB.conectarBD();

		try {
			ResultSet cursor = smt.executeQuery("valor, nombre, mercado");

			while (cursor.next()) {
				ArrayList<Empresa> listaEmpresa = new ArrayList<Empresa>();

				float valor = cursor.getFloat("valor");
				String nombre = cursor.getString("nombre");
				String mercado = cursor.getString("mercado");

				Empresa Alphabet = new Empresa(valor, nombre, mercado);
				listaEmpresa.add(Alphabet);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		UtilsDB.desconectarBD();

	}

	/**
	 * funcion que inserta en base de datos si una empresa sea comprado
	 * 
	 * @param ret es el arrayList donde se almacena la empresa
	 */
	public void compraEmpresa(ArrayList<Empresa> ret) {

		Statement smt = UtilsDB.conectarBD();

		try {

			ResultSet cursor = smt.executeQuery(
					"insert into empresaCompradas VALUES ('" + valor + "','" + nombre + "','" + mercado + "')");

			while (cursor.next()) {
				ArrayList<Empresa> listaEmpresa = new ArrayList<Empresa>();

				float valor = cursor.getFloat("valor");
				String nombre = cursor.getString("nombre");
				String mercado = cursor.getString("mercado");

				Empresa emp = new Empresa(valor, nombre, mercado);
				listaEmpresa.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		UtilsDB.desconectarBD();

	}

	/**
	 * DAO de la clase Empres que conecta con la base de datos y inicia un arrayList
	 * de accion que toma mediante un resulset de la base de datos el get de
	 * nombre,valor,mercado y lo añade al arrayList, sino se cumple salta un catch
	 * que imprime un SQLexception
	 * 
	 * @return ret el arrayList donde se almacena la empresa
	 */
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
				actual.mercado = cursor.getString("mercado");

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
	 * toString que devuelve el valor de todas las variables de la clase
	 */
	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", noticia=" + noticia + ", mercado=" + mercado + ", valor=" + valor
				+ ", esComprada=" + esComprada + "]";
	}

	/**
	 * Funcion que toma de base de datos todas las empresas que han sido compradas
	 * 
	 * @return null si esta mal y salta el catch para que no modifique nada
	 */
	public static ArrayList<Empresa> getComprados() {
		Statement smt = UtilsDB.conectarBD();

		ArrayList<Empresa> retCompradas = new ArrayList<Empresa>();

		try {
			ResultSet cursor = smt.executeQuery("select * from empresaComprada");
			while (cursor.next()) {
				Empresa actual = new Empresa();

				actual.nombre = cursor.getString("nombre");
				actual.valor = cursor.getInt("valor");
				actual.mercado = cursor.getString("mercado");

				retCompradas.add(actual);
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
		return retCompradas;
	}

	/**
	 * Funcion que actualiza los precios de las empresas
	 * @return 
	 */
	public Empresa actualizar() {
		Statement smt = UtilsDB.conectarBD();
		boolean ret;
		try {

			Random r = new Random();
			float min = 0;
			float max = 3;
			for (float i = min; i <= max; i++) {
				this.valor = (float) (valor + (Math.random() * (max - min)) + min);
			}
			ret = smt.executeUpdate(
					"update empresa set valor=" + this.valor + "where nombre='" + this.nombre + "';") > 0;
			this.getNombre();
			this.getMercado();
		} catch (SQLException e) {
			UtilsDB.desconectarBD();
			return null;
		}
		UtilsDB.desconectarBD();
		return Empresa.this;
	}

}
