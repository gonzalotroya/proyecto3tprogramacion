package superclases;

import clases.Usuario;
/**
 * 
 * @author gonzalo
 *
 */
public class EntidadConNombre {

	public String nombre;
	/**
	 * Getter nombre
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
/**
 * Setter nombre
 * @param nombre
 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
/**
 * Constructor de la clase
 * @param nombre
 */
	public EntidadConNombre(String nombre) {
		super();
		this.nombre = nombre;
	}
/**
 * to string the nombre
 */
	@Override
	public String toString() {
		return "EntidadConNombre [nombre=" + nombre + "]";
	}
/**
 * Funcion comparar que toma los diferentes nombre de un usuario y los comparas
 * @param o variable de usuario
 * @return
 */
	public int compareTo(Object o) {
		Usuario otro=(Usuario)o;
		return this.nombre.compareTo(otro.nombre);
	}
	
}
