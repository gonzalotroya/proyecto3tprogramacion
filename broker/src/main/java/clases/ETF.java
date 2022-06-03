package clases;

import java.sql.SQLException;
import java.sql.Statement;

import enums.EnumeracionSectores;
import utils.UtilsDB;

public class ETF extends Operacion{

	private int etf_id;
	private int ope_id;
	private int sec_id;

	

	public ETF(int tipoOperacion, String nombre, int etf_id, int ope_id, int sec_id) {
		super(tipoOperacion, nombre);
		this.etf_id = etf_id;
		this.ope_id = ope_id;
		this.sec_id = sec_id;
	}



	public int getEtf_id() {
		return etf_id;
	}



	public void setEtf_id(int etf_id) {
		this.etf_id = etf_id;
	}



	public int getOpe_id() {
		return ope_id;
	}



	public void setOpe_id(int ope_id) {
		this.ope_id = ope_id;
	}



	public int getSec_id() {
		return sec_id;
	}



	public void setSec_id(int sec_id) {
		this.sec_id = sec_id;
	}



	public static  void precio() {}



	@Override
	public String toString() {
		return "ETF [etf_id=" + etf_id + ", ope_id=" + ope_id + ", sec_id=" + sec_id + "]";
	}

}
