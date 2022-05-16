package clases;

import enums.EnumeracionSectores;

public class ETF extends Operacion{

	private EnumeracionSectores sectores;
	
	
	
	 public EnumeracionSectores getSectores() {
		return sectores;
	}



	public void setSectores(EnumeracionSectores sectores) {
		this.sectores = sectores;
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
