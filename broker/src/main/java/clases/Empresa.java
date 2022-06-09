package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enums.EnumeracionLugares;
import utils.UtilsDB;
/**
 * Clase empresa que tiene los datos de las empresas
 * @author gonzalo
 *
 */
public class Empresa {

	private String nombre;
	private ArrayList<Noticia>noticia;
	private String mercado;
	private float valor;
	public String getNombre() {
		return nombre;
	}
/**
 * Setter de la variable nombre que toma sus datos y los conecta y actualiza a la base de datos, si falla salta una excepcion
 * @param nombre
 * @throws SQLException
 */
	public void setNombre(String nombre) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		
		if(smt.executeUpdate("update empresa set nombre='"+nombre+"' where nombre='"+this.nombre+"'")>0) {
			this.nombre = nombre;
		}
		
		UtilsDB.desconectarBD();
	}
	/**
	 * Getter del arraylist Noticia
	 * @return
	 */
	public ArrayList<Noticia> getNoticia() {
		return noticia;
	}
	/**
	 * Setter del arrayList noticia
	 * @param noticia
	 */
	public void setNoticia(ArrayList<Noticia> noticia) {
		this.noticia = noticia;
	}
	/**
	 * Getter del Mercado  que toma datos de Mercado
	 * @return
	 */
	public String getMercado() {
		return mercado;
	}
	/**
	 * Setter de Mercado que conecta con la base de datos
	 * @param mercado
	 * @throws SQLException
	 */
	public void setMercado(String mercado) throws SQLException {
Statement smt = UtilsDB.conectarBD();
		
		if(smt.executeUpdate("update empresa set mercado='"+mercado+"' where nombre='"+this.nombre+"'")>0) {
			this.mercado = mercado;
		}
		
		UtilsDB.desconectarBD();
	}
	/**
	 * Getter de valor
	 * @return
	 */
	public float getValor() {
		return valor;
	}
	/**
	 * Setter de valor
	 * @param valor
	 * @throws SQLException
	 */
	public void setValor(float valor) throws SQLException {
Statement smt = UtilsDB.conectarBD();
		
		if(smt.executeUpdate("update empresa set valor='"+valor+"' where nombre='"+this.nombre+"'")>0) {
			this.valor = valor;
		}
		
		UtilsDB.desconectarBD();
	}
	/**
	 * Constructor empresa en cual se toman todos los datos de la empresa
	 * @param nombre
	 * @param noticia
	 * @param usa
	 * @param valor
	 */
	public Empresa(String nombre, ArrayList<Noticia> noticia, String lugarMercado, float valor) {
		super();
		this.nombre = nombre;
		this.noticia = noticia;
		this.mercado = lugarMercado;
		this.valor = valor;
	}
	/**
	 * Constructor vacio de empresa, para insertar datos vacios
	 */
	public Empresa() {
		// TODO Auto-generated constructor stub
	}
	public Empresa(String nombre, ArrayList<Noticia> noticia, EnumeracionLugares usa, float valor) {
		super();
		this.nombre = nombre;
		this.noticia = noticia;
		this.getMercado();
		this.valor = valor;
	}
	public Empresa(float valor, String nombre, String mercado) {

		super();
		this.nombre = nombre;
		this.getMercado();
		this.valor = valor;
	}
	private void cargaEmpresa() {

        Statement smt = UtilsDB.conectarBD();

        try {
            ResultSet cursor = smt.executeQuery("valor, nombre, mercado");

            while (cursor.next()) {
        		ArrayList<Empresa> listaEmpresa = new ArrayList<Empresa>();

                float valor = cursor.getFloat("valor");
                String nombre = cursor.getString("nombre");
                String mercado = cursor.getString("mercado");

                Empresa Alphabet = new Empresa(valor, nombre, mercado);
                listaEmpresa.add(Alphabet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        UtilsDB.desconectarBD();

    }
	/**
	 * toString  que devuelve el valor de todas las variables de la clase
	 */
	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", noticia=" + noticia + ", mercado=" + mercado + ", valor=" + valor + "]";
	}
	
	/**
	 * DAO de la clase Empres que conecta con la base de datos y inicia un arrayList de accion que toma mediante un resulset
	 * de la base de datos el get de nombre,valor,mercado y lo añade al arrayList, sino se cumple salta un catch que imprime un SQLexception
	 * @return ret
	 */
	public static ArrayList<Empresa> getTodos() {
		Statement smt = UtilsDB.conectarBD();
		// Inicializamos un ArrayList para devolver.
		ArrayList<Empresa> ret = new ArrayList<Empresa>();

		try {
			ResultSet cursor = smt.executeQuery("select * from empresa");
			while (cursor.next()) {
				Empresa actual = new Empresa();

				actual.nombre = cursor.getString("nombre");
				actual.valor = cursor.getInt("valor");
				actual.mercado = cursor.getString("mercado");
				

				ret.add(actual);
			}
		} catch (SQLException e) {
			// Si la conuslta falla no hay nada que devolver.
			e.printStackTrace();
			return null;
		}
		// Si no hay usuarios en la tabla, va a devolver un arraylist vacio.
		// Si la consulta fue erronea se devuelve un arraylist null, que son cosas
		// distintas.
		UtilsDB.desconectarBD();
		return ret;
	}
	
	
	
	
}
