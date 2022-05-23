package pantalla;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Cursor;
import java.util.HashMap;
import java.util.Iterator;

public class Ventana extends JFrame{
	private HashMap<String, JPanel>pantallas;
	public Ventana() {
		pantallas=new HashMap<String,JPanel>();
		pantallas.put("login", new PantallaLogin(this));
		pantallas.put("registro", new PantallaRegistro(this));
		
		this.setBounds(1920,800,800,800);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("./icono.png").getImage());
		this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Broker");
		this.setContentPane(this.pantallas.get("login"));
		this.setResizable(false);
		this.setVisible(true);
		
	}
	public void cambiarAPantalla(String nombrePantalla) {
		Iterator it=this.pantallas.values().iterator();
		while(it.hasNext()) {
			JPanel actual=(JPanel)it.next();
			actual.setVisible(false);
		}
		this.pantallas.get(nombrePantalla).setVisible(true);
		this.setContentPane(this.pantallas.get(nombrePantalla));
	}
}
