package clases;

import java.sql.SQLException;
import java.sql.Statement;

import enums.EnumeracionSectores;
import utils.UtilsDB;

public class Sector {
	private EnumeracionSectores nombreSector;
	private int secId;
	
	
	
	 public EnumeracionSectores getNombreSector() {
		return nombreSector;
	}



	public void setNombreSector(EnumeracionSectores nombreSector) {
		this.nombreSector = nombreSector;
	}



	public int getSecId() {
		return secId;
	}



	public void setSecId(int secId) {
		this.secId = secId;
	}



	public EnumeracionSectores getSectores() {
		return nombreSector;
	}



	public void setSectores(EnumeracionSectores sectores) throws SQLException {
Statement smt = UtilsDB.conectarBD();
		
		if(smt.executeUpdate("update etf set nombreSector='"+nombreSector+"' where secID='"+this.secId+"'")>0) {
			this.nombreSector = nombreSector;
		}
		
		UtilsDB.desconectarBD();
	}



	public Sector(EnumeracionSectores nombreSector, int secId) {
		super();
		this.nombreSector = nombreSector;
		this.secId = secId;
	}



	@Override
	public String toString() {
		return "Sector [nombreSector=" + nombreSector + ", secId=" + secId + "]";
	}



	


	

}
