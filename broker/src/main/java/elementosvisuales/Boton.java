package elementosvisuales;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import java.awt.event.MouseEvent;
/**
 * 
 * @author gonzalo
 *
 */
public class Boton extends JButton {

	public Boton(String m) {
		super(m);
		estiloPorDefecto();
/**
 * define un estilo cuando entra en el boton
 */
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(240,255,240));
				setFont(new Font("Arial",Font.ITALIC,26));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				estiloPorDefecto();
			}

		});

	}
	/**
	 * define un estilo por defecto
	 */
	private void estiloPorDefecto() {
		this.setForeground(Color.CYAN);
		this.setBackground(Color.DARK_GRAY);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
	}

}
