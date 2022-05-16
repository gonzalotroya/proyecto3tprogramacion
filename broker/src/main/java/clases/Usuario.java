package clases;

import java.util.ArrayList;

import superclases.EntidadConNombre;

public class Usuario extends EntidadConNombre{

	private ArrayList<Operacion>numeroAccionesCompradas;
	private int saldoInvertido;
	private int saldoLibre;
	private String apellidos;
	private String cuentaBanco;
	private String dni;
	private String telefono;
	private String email;
	public ArrayList<Operacion> getNumeroAccionesCompradas() {
		return numeroAccionesCompradas;
	}
	public void setNumeroAccionesCompradas(ArrayList<Operacion> numeroAccionesCompradas) {
		this.numeroAccionesCompradas = numeroAccionesCompradas;
	}
	public int getSaldoInvertido() {
		return saldoInvertido;
	}
	public void setSaldoInvertido(int saldoInvertido) {
		this.saldoInvertido = saldoInvertido;
	}
	public int getSaldoLibre() {
		return saldoLibre;
	}
	public void setSaldoLibre(int saldoLibre) {
		this.saldoLibre = saldoLibre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCuentaBanco() {
		return cuentaBanco;
	}
	public void setCuentaBanco(String cuentaBanco) {
		this.cuentaBanco = cuentaBanco;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Usuario(String nombre, ArrayList<Operacion> numeroAccionesCompradas, int saldoInvertido, int saldoLibre,
			String apellidos, String cuentaBanco, String dni, String telefono, String email) {
		super(nombre);
		this.numeroAccionesCompradas = numeroAccionesCompradas;
		this.saldoInvertido = saldoInvertido;
		this.saldoLibre = saldoLibre;
		this.apellidos = apellidos;
		this.cuentaBanco = cuentaBanco;
		this.dni = dni;
		this.telefono = telefono;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Usuario [numeroAccionesCompradas=" + numeroAccionesCompradas + ", saldoInvertido=" + saldoInvertido
				+ ", saldoLibre=" + saldoLibre + ", apellidos=" + apellidos + ", cuentaBanco=" + cuentaBanco + ", dni="
				+ dni + ", telefono=" + telefono + ", email=" + email + "]";
	}
	
}
