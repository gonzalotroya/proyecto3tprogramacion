package pantalla;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Cursor;

public class Ventana extends JFrame{
	public Ventana() {
		this.setBounds(1000,1000, 1000, 1000);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("./icono.png").getImage());
		this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Ventana loco");
		this.setContentPane(new PantallaLogin(this));
		this.setResizable(false);
		this.setVisible(true);
		
	}
}
