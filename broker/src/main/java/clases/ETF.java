package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import enums.EnumeracionSectores;
import utils.UtilsDB;

/**
 * 
 * @author gonzalo
 *
 */
public class ETF  {

	/**
	 * @param valor es el precio del etf
	 * @param sectores nombre del etf y su sector
	 * @param esComprada boolean que comprueba si esta comprada o no
	 */
	private float valor;
	private String sectores;
	private boolean esComprada;

	/**
	 * Constructor que posiciona todos los datos de etf  
	 * @param valor precio del etf
	 * @param sectores tipo de etf
	 * @param esComprada boolean que da true o false
	 */
	public ETF(float valor, String sectores, boolean esComprada) {
		super();
		this.valor = valor;
		this.sectores = sectores;
		this.esComprada = esComprada;
	}
	/**
	 * Devuelve un boolean que se que encargada de decir si se ha comprado o no
	 * @param b variable true o false
	 * @return true o false
	 */
	public boolean isEsComprada(boolean b) {
		return esComprada;
	}
	/**
	 * Devuelve un boolean que se que encargada de decir si se ha vendido o no
	 * @param b variable true o false
	 * @return true o false
	 */
	public boolean isEsVendida(boolean b) {
		return esComprada;
	}

	/**
	 * Funcion que se encarga de vender los etf actualizando en base de datos  el valor estaComprado como false
	 * @param text la variable que contiene el etf
	 * @throws SQLException Error sql que señala el fallo de base de datos
	 */
	public static void venderETF(String text) throws SQLException {
		Statement smt = UtilsDB.conectarBD();

		if (smt.executeUpdate("UPDATE etf set estaComprada=false where sectores='" + text + "';") > 0) {

		}

		UtilsDB.desconectarBD();
	}
	/**
	 * Funcion que se encarga de vender las etf actualizando en base de datos  el valor estaComprado como false
	 * @param text la variable que contiene la etf
	 * @throws SQLException Error sql que señala el fallo de base de datos
	 */
	public static void comprarETF(String text) throws SQLException {
		Statement smt = UtilsDB.conectarBD();

		if (smt.executeUpdate("UPDATE etf set estaComprada=true where sectores='" + text + "';") > 0) {

		}

		UtilsDB.desconectarBD();
	}
	
	/**
	 * Setter esComprada
	 * @param esComprada boolean true o false
	 * @throws SQLException Devuelve el error sql
	 */
	public void setEsComprada(boolean esComprada) throws SQLException {
		
		 this.esComprada = esComprada;
	}

	/**
	 * Getter sectores
	 * @return sectores devuelve un String 
	 */
	public String getSectores() {
		return sectores;
	}

	/**
	 * Setter sectores
	 * @param sectores Define un string
	 */
	public void setSectores(String sectores) {
		this.sectores = sectores;
	}

	

	/**
	 * toString de etf
	 */

	@Override
	public String toString() {
		return "ETF [valor=" + valor + ", sectores=" + sectores + ", esComprada=" + esComprada + "]";
	}
	/**
	 * Getter valor
	 * @return valor devuelve el precio
	 */
	public float getValor() {
		return valor;
	}
	/**
	 * Setter valor
	 * @param valor Define el precio del etf
	 */
	public void setValor(float valor) {
		this.valor = valor;
	}
	/**
	 * Funcion que define si esta comprado o no
	 * @return esComprada true o false
	 */
	public boolean isEsComprada() {
		return esComprada;
	}
	/**
	 * Constructor de etf que toma de base de datos los datos de etf mediante el sector insertado en la variable text
	 * @param text String que devuelve el nombre del sector
	 */
	public ETF(String text) {

		Statement smt = UtilsDB.conectarBD();
		// Inicializamos un ArrayList para devolver.

		try {
			ResultSet cursor = smt.executeQuery("select * from etf where sectores ='" + text + "'");
			while (cursor.next()) {
				ETF actual = new ETF(sectores);

				actual.setValor(cursor.getInt("valor"));
				actual.setSectores(cursor.getString("sectores"));
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
	/**
	 * Constructor vacio 
	 */
	public ETF() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Dao getTodos que toma todos los datos de etf desde base de datos
	 * @return ret ArrayList de etf que almacena el etf seleccionado
	 */
	public static ArrayList<ETF> getTodos() {
		Statement smt = UtilsDB.conectarBD();
		// Inicializamos un ArrayList para devolver.
		ArrayList<ETF> ret = new ArrayList<ETF>();

		try {
			ResultSet cursor = smt.executeQuery("select * from etf");
			while (cursor.next()) {
				ETF actual = new ETF();

				actual.setValor(cursor.getInt("valor"));
				actual.setSectores(cursor.getString("sectores"));
				actual.isEsComprada(cursor.getBoolean("estaComprada"));

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
	 * DAO que actualiza el desde base de datos y crea un precio aleatorio con un minimo y maximo  para actualizar los precios en la interfaz
	 * @return ETF.this devuelve la propia clase
	 */
	public ETF actualizar() {
		Statement smt = UtilsDB.conectarBD();
		boolean ret;
		try {

			Random r = new Random();
			float min = -3;
			float max = 3;
			for (float i = min; i <= max; i++) {
				this.valor = (float) (valor + (Math.random() * (max - min)) + min);
			}
			ret = smt.executeUpdate(
					"update etf set valor=" + this.valor + "where sectores='" + this.sectores + "';") > 0;
			this.getSectores();
		} catch (SQLException e) {
			UtilsDB.desconectarBD();
			return null;
		}
		UtilsDB.desconectarBD();
		return ETF.this;
	}
	/**
	 * Funcion que toma todos los etfs que han sido compradosy los alamacena en un arrayLIst 
	 * @return listaETF almacena los etf
	 */
	public static ArrayList<ETF> etfCompradas() {
		ArrayList<ETF> listaETF = new ArrayList<ETF>();

		Statement smt = UtilsDB.conectarBD();
		// Inicializamos un ArrayList para devolver.

		try {
			ResultSet cursor = smt.executeQuery("select * from etf where estaComprada =true");
			while (cursor.next()) {

				ETF actual = new ETF();

				actual.setValor(cursor.getInt("valor"));
				actual.setSectores(cursor.getString("sectores"));
				actual.isEsComprada(cursor.getBoolean("estaComprada"));
				listaETF.add(actual);

			}
		} catch (SQLException e) {
			// Si la conuslta falla no hay nada que devolver.
			e.printStackTrace();

		}
		// Si no hay usuarios en la tabla, va a devolver un arraylist vacio.
		// Si la consulta fue erronea se devuelve un arraylist null, que son cosas
		// distintas.
		UtilsDB.desconectarBD();
		return listaETF;
	}


}
