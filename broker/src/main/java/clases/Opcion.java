package clases;

import java.sql.SQLException;
import java.sql.Statement;

import utils.UtilsDB;

public class Opcion extends Operacion {

	private int interes;
	private int calls;
	private int corto;
	
	
	
	public int getInteres() {
		return interes;
	}



	public void setInteres(int interes) throws SQLException {
Statement smt = UtilsDB.conectarBD();
		
		if(smt.executeUpdate("update opcion set interes='"+interes+"' where interes='"+this.interes+"'")>0) {
			this.interes = interes;
		}
		
		UtilsDB.desconectarBD();
	}



	public int getCall() {
		return calls;
	}



	public void setCall(int call) throws SQLException {
Statement smt = UtilsDB.conectarBD();
		
		if(smt.executeUpdate("update opcion set calls='"+calls+"' where interes='"+this.interes+"'")>0) {
			this.calls = calls;
		}
		
		UtilsDB.desconectarBD();
	}



	public int getCorto() {
		return corto;
	}



	public void setCorto(int corto) throws SQLException {
Statement smt = UtilsDB.conectarBD();
		
		if(smt.executeUpdate("update opcion set corto='"+corto+"' where interes='"+this.interes+"'")>0) {
			this.corto = corto;
		}
		
		UtilsDB.desconectarBD();
	}



	public Opcion(int interes, int calls, int corto) {
		super();
		this.interes = interes;
		this.calls = calls;
		this.corto = corto;
	}



	@Override
	public String toString() {
		return "Opcion [interes=" + interes + ", calls=" + calls + ", corto=" + corto + "]";
	}



	public static void precio() {}

}
