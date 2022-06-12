package clases;

import java.util.ArrayList;
/**
 * @author gonzalo
 */
public class Operacion {
	private int tipoOperacion;
	private String nombre;
		
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
	
public Operacion(int tipoOperacion, String nombre) {
		super();
		this.tipoOperacion = tipoOperacion;
		this.nombre = nombre;
	}
public Operacion() {}
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
