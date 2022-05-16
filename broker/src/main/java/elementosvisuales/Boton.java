package elementosvisuales;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import java.awt.event.MouseEvent;

public class Boton extends JButton {

	public Boton(String m) {
		super(m);
		estiloPorDefecto();

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

	private void estiloPorDefecto() {
		this.setForeground(Color.MAGENTA);
		this.setBackground(Color.GREEN);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
        this.setBounds(258, 43, 192, 42);
	}

}
