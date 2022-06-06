package clases;

import java.util.ArrayList;
/**
 * 
 * @author gonzalo
 *
 */
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
 /**
  * Funcion que comprueba que se compra una accion 
  * @param numeroAccionesCompradas
  * @return
  */
public static boolean esComprada(ArrayList<Operacion> numeroAccionesCompradas) {
		if (numeroAccionesCompradas != null) {
			return true;
		} else {
			return false;
		}
	}

}
