package clases;

import java.sql.SQLException;
import java.sql.Statement;

import utils.UtilsDB;

/**
 * 
 * @author gonzalo
 *
 */
public class Opcion extends Operacion {

	private int interes;
	private int calls;
	private int corto;

	/**
	 * Getter de interes
	 * 
	 * @return interes Devuelve un porcentaje
	 */
	public int getInteres() {
		return interes;
	}

	/**
	 * Setter de interes que conecta a la base de datos y la actualiza
	 * @param interes define un porcentaje
	 * @throws SQLException devuelve un error de sql
	 */

	public void setInteres(int interes) throws SQLException {
		Statement smt = UtilsDB.conectarBD();

		if (smt.executeUpdate("update opcion set interes='" + interes + "' where interes='" + this.interes + "'") > 0) {
			this.interes = interes;
		}

		UtilsDB.desconectarBD();
	}
	/**
	 * Getter de calls
	 * @return calls Devuelve el precio del call
	 */
	public int getCall() {
		return calls;
	}
	/**
	 * Setter de call que conecta a la base de datos y la actualiza
	 * @param call Define el precio 
	 * @throws SQLException devuelve un error de sql
	 */
	public void setCall(int call) throws SQLException {
		Statement smt = UtilsDB.conectarBD();

		if (smt.executeUpdate("update opcion set calls='" + calls + "' where interes='" + this.interes + "'") > 0) {
			this.calls = calls;
		}

		UtilsDB.desconectarBD();
	}
	/**
	 * Getter de corto
	 * @return corto Devuelve el precio de corto
	 */
	public int getCorto() {
		return corto;
	}
	/**
	 * Setter de corto que conecta a la base de datos y la actualiza
	 * @param corto Define el precio de corto
	 * @throws SQLException devuelve un error de sql
	 */
	public void setCorto(int corto) throws SQLException {
		Statement smt = UtilsDB.conectarBD();

		if (smt.executeUpdate("update opcion set corto='" + corto + "' where interes='" + this.interes + "'") > 0) {
			this.corto = corto;
		}

		UtilsDB.desconectarBD();
	}
	/**
	 * Construtctor que define todos los datos de opcion de una empresa
	 * @param interes Porcentaje  del interes
	 * @param calls Define el precio
	 * @param corto Define el precio
	 */
	public Opcion(int interes, int calls, int corto) {
		super();
		this.interes = interes;
		this.calls = calls;
		this.corto = corto;
	}
	/**
	 * toString de opcion
	 */
	@Override
	public String toString() {
		return "Opcion [interes=" + interes + ", calls=" + calls + ", corto=" + corto + "]";
	}
}
