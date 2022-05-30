package clases;

import java.sql.SQLException;
import java.sql.Statement;

import enums.EnumeracionSectores;
import utils.UtilsDB;

public class ETF extends Operacion{

	private EnumeracionSectores sectores;
	
	
	
	 public EnumeracionSectores getSectores() {
		return sectores;
	}



	public void setSectores(EnumeracionSectores sectores) throws SQLException {
Statement smt = UtilsDB.conectarBD();
		
		if(smt.executeUpdate("update etf set sectores='"+sectores+"' where sectores='"+this.sectores+"'")>0) {
			this.sectores = sectores;
		}
		
		UtilsDB.desconectarBD();
	}



	public ETF(EnumeracionSectores sectores) {
		super();
		this.sectores = sectores;
	}



	@Override
	public String toString() {
		return "ETF [sectores=" + sectores + "]";
	}



	public static  void precio() {}

}
