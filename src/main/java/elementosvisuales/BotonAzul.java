package elementosvisuales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class BotonAzul extends Boton{
	public BotonAzul(String m) {
			super(m);
			estiloPorDefecto();
			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					setBackground(new Color(200,250,255));
					setForeground(new Color(30,30,80));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					estiloPorDefecto();
				}

			});
		}
	private void estiloPorDefecto() {
		this.setForeground(Color.gray);
		this.setBackground(Color.blue);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));

	}

}
