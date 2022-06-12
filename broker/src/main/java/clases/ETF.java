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
public class ETF extends Operacion {

	private float valor;
	private String sectores;
	private boolean esComprada;

	
	public ETF(int tipoOperacion, String nombre, float valor, String sectores, boolean esComprada) {
		super(tipoOperacion, nombre);
		this.valor = valor;
		this.sectores = sectores;
		this.esComprada = esComprada;
	}
	public boolean isEsComprada(boolean b) {
		return esComprada;
	}
	public boolean isEsVendida(boolean b) {
		return esComprada;
	}

	public static void venderETF(String text) throws SQLException {
		Statement smt = UtilsDB.conectarBD();

		if (smt.executeUpdate("UPDATE etf set estaComprada=false where sectores='" + text + "';") > 0) {

		}

		UtilsDB.desconectarBD();
	}
	public static void comprarETF(String text) throws SQLException {
		Statement smt = UtilsDB.conectarBD();

		if (smt.executeUpdate("UPDATE etf set estaComprada=true where sectores='" + text + "';") > 0) {

		}

		UtilsDB.desconectarBD();
	}
	

	public void setEsComprada(boolean esComprada) throws SQLException {
		
		 this.esComprada = esComprada;
	}

	public String getSectores() {
		return sectores;
	}

	public void setSectores(String sectores) {
		this.sectores = sectores;
	}

	

	

	@Override
	public String toString() {
		return "ETF [valor=" + valor + ", sectores=" + sectores + ", esComprada=" + esComprada + "]";
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public boolean isEsComprada() {
		return esComprada;
	}
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
	public ETF() {
		// TODO Auto-generated constructor stub
	}
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
