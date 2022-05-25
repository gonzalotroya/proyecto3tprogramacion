package clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import exceptions.A�oInvalidoException;
import exceptions.Contrase�aVaciaException;
import exceptions.EmailValidoException;
import superclases.EntidadConNombre;
import utils.UtilsDB;

public class Usuario extends EntidadConNombre{

	private ArrayList<Operacion>numeroAccionesCompradas;
	private int saldoInvertido;
	private int saldoLibre;
	private String apellidos;
	private String cuentaBanco;
	private String dni;
	private String telefono;
	private String email;
	private String contrase�a;
	private LocalDate fechaNacimiento;
	private int id;
	
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
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
			String apellidos, String cuentaBanco, String dni, String telefono, String email, String contrase�a,
			LocalDate fechaNacimiento, int id) throws SQLException, Contrase�aVaciaException, EmailValidoException {
		super(nombre);
		
		if(contrase�a.isBlank()) {
			throw new Contrase�aVaciaException("La contrase�a no puede estar vacia.");
		}
		
		if(!this.emailValido(email)) {
			throw new EmailValidoException("El email tiene que tener @.");
		}
		
		Statement query=UtilsDB.conectarBD();
		//Insertar
		/*
		 * id int primary key,
	nombre varchar(200),
    apellidos VARchar(200),
    email varchar(400),
    contrasena varchar(30),
    fechaNacimiento date,
    numeroAcciones INT,
    saldo int,
    cuentaBanco VARCHAR(30),
    dni VARCHAR(10),
    telefono int*/
		
		if(query.executeUpdate("insert into usuario values(id,nombre,apellidos,email,contrase�a,fechaNacimiento,numeroAcciones,saldoInvertido,saldoLibre,cuentaBanco)"
				+ "('"+id+"','"+nombre+"','"+apellidos+"','"+dni+"','"+telefono+"','"+email+"','"+
				contrase�a+"',"+numeroAccionesCompradas+",'"+saldoInvertido+"','"+saldoLibre+"','"+cuentaBanco+"')")>0) {
			this.id=id;
			this.nombre = nombre;
			this.setEmail(email);
			this.setContrase�a(contrase�a);
			this.numeroAccionesCompradas = numeroAccionesCompradas;
			this.saldoInvertido = saldoInvertido;
			this.saldoLibre = saldoLibre;
			this.apellidos = apellidos;
			this.cuentaBanco = cuentaBanco;
			this.dni = dni;
			this.telefono = telefono;
			
		}else {
			throw new SQLException("No se ha podido insertar el usuario.");
		}
		UtilsDB.desconectarBD();
	}
		
		
		
	
	
	private boolean contrase�aValida(String pass) {
		return !pass.isBlank();
	}
	
	private boolean emailValido(String email) {
		return email.contains("@");
	}
	
	
	@Override
	public String toString() {
		return "Usuario [numeroAccionesCompradas=" + numeroAccionesCompradas + ", saldoInvertido=" + saldoInvertido
				+ ", saldoLibre=" + saldoLibre + ", apellidos=" + apellidos + ", cuentaBanco=" + cuentaBanco + ", dni="
				+ dni + ", telefono=" + telefono + ", email=" + email + "]";
	}
	
}
