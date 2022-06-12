package clases;

import java.sql.SQLException;
import java.sql.Statement;

import enums.EnumeracionSectores;
import utils.UtilsDB;

public class Sector {
	private EnumeracionSectores nombreSector;

	/**
	 * Getter nombreSector
	 * @return nombreSector Devuelve el nombre del sector
	 */
	public EnumeracionSectores getNombreSector() {
		return nombreSector;
	}
/**
 * Setter nombreSector
 * @param nombreSector  String que da un nombre
 */
	public void setNombreSector(EnumeracionSectores nombreSector) {
		this.nombreSector = nombreSector;
	}

	public EnumeracionSectores getSectores() {
		return nombreSector;
	}
	/**
	 * Setter de sector
	 * @param sectores String nombre del sector
	 * @throws SQLException Devuelve el error de sql
	 */
	public void setSectores(EnumeracionSectores sectores) throws SQLException {
		Statement smt = UtilsDB.conectarBD();

		if (smt.executeUpdate(
				"update etf set nombreSector='" + nombreSector + "' where nombreSector='" + this.nombreSector + "'") > 0) {
			this.nombreSector = nombreSector;
		}

		UtilsDB.desconectarBD();
	}
/**
 * Constructor de secotr que toma la enumeracion de Sectores
 * @param nombreSector String nombre del sector
 */
	public Sector(EnumeracionSectores nombreSector) {
		super();
		this.nombreSector = nombreSector;
	}
/**
 * toString Sector
 */
	@Override
	public String toString() {
		return "Sector [nombreSector=" + nombreSector + "]";
	}

}
