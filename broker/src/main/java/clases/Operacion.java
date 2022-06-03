package clases;

public class Operacion {
	private int tipoOperacion;
	private String nombre;
	private int opeID;
		
	
 public int getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(int tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getOpeID() {
		return opeID;
	}
	public void setOpeID(int opeID) {
		this.opeID = opeID;
	}
	
public Operacion(int tipoOperacion, String nombre) {
		super();
		this.tipoOperacion = tipoOperacion;
		this.nombre = nombre;
	}
public Operacion() {
	// TODO Auto-generated constructor stub
}
public void comprar() {
 }
 public void vender() {}

}
