package superclases;

public class EntidadConNombre {

	public String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EntidadConNombre(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "EntidadConNombre [nombre=" + nombre + "]";
	}
	
}
