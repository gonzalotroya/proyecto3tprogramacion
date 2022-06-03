package pantalla;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Usuario;

import java.awt.Cursor;
import java.util.HashMap;
import java.util.Iterator;

public class Ventana extends JFrame{
	private JPanel pantallaActual;
	protected Usuario usuarioLogado;

	public Ventana() {
		
		this.setBounds(800,700,700,700);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("./icono.png").getImage());
		this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Broker");
		this.pantallaActual = new PantallaLogin(this);
		this.setContentPane(pantallaActual);
		this.setResizable(false);
		this.setVisible(true);
		
	}
	public void cambiarAPantalla(String nombrePantalla) {
		this.pantallaActual.setVisible(false);
		this.pantallaActual = null;

		switch (nombrePantalla) {
		case "login":
			this.pantallaActual=new PantallaLogin(this);
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
}
