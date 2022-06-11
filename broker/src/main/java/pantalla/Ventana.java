package pantalla;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Empresa;
import clases.Usuario;

import java.awt.Cursor;
import java.util.HashMap;
import java.util.Iterator;

public class Ventana extends JFrame{
	private JPanel pantallaActual;
	protected Usuario usuarioLogado;
	private Empresa empresa;
	private String argN;
	private String argC;
	public HashMap<String,JPanel> pantallas;


	public Ventana(String argN,String argC) {
		pantallas = new HashMap<String,JPanel>();

		pantallas.put("pantallaLogin", new PantallaLogin(this,argN,argC));
		pantallas.put("pantallaRegistro", new PantallaRegistro(this));
		pantallas.put("Mercado", new Mercado(this));
		pantallas.put("pantallaCartera", new PantallaCartera(this));
		pantallas.put("pantallaNoticias", new PantallaNoticias(this));
		
		
		
		this.setSize(630,520);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("./icono.png").getImage());
		this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Broker");
		//this.pantallaActual = new PantallaLogin(this,argN,argC);
		this.setContentPane(this.pantallas.get("pantallaLogin"));
		this.setResizable(false);
		this.setVisible(true);
		
	}
	public void cambiarAPantalla(String nombrePantalla) {
		Iterator it = this.pantallas.values().iterator();
		while(it.hasNext()) {
			JPanel actual = (JPanel) it.next();
			actual.setVisible(false);
		}
		this.pantallas.get(nombrePantalla).setVisible(true);
		this.setContentPane(this.pantallas.get(nombrePantalla));
	}
/*
	public void cambiarAPantalla(String nombrePantalla) {
		this.pantallaActual.setVisible(false);
		this.pantallaActual = null;
		

		switch (nombrePantalla) {
		case "login":
			this.pantallaActual=new PantallaLogin(this,argN,argC);
		break;
		case "registro":
			this.pantallaActual=new PantallaRegistro(this);
		break;
		case "Mercado":
			this.pantallaActual=new Mercado(this);
		break;
		case "cartera":
			this.pantallaActual=new PantallaCartera(this, null);
		break;
		case "noticias":
			this.pantallaActual=new PantallaNoticias(this);
		break;
		}
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);

	}
	*/
}
