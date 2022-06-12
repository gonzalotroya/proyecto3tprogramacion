package pantalla;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import clases.ETF;
import clases.Empresa;
import clases.Usuario;
import elementosvisuales.ElementoCartera;
import elementosvisuales.ElementoETF;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Color;
/**
 * 
 * @author gonzalo
 *
 */
public class PantallaETF extends JPanel {
	private Ventana ventana;
	private Empresa empresa;
	/**
	 * Funcion que toma desde la clase ventana y posiciona una interfaz 
	 * @param v variable de la clase ventana
	 */
	public PantallaETF(final Ventana v) {
		setBackground(new Color(0, 204, 153));
		this.ventana = v;
		this.empresa = empresa;


		setLayout(new BorderLayout(0, 0));

		JLabel labelTitulo = new JLabel("Mercado");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		add(labelTitulo, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 204, 153));
		add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 204, 153));
		add(panel_1, BorderLayout.SOUTH);

		final JButton botonActualizar = new JButton("Actualizar");
		panel_1.add(botonActualizar);

		JButton verNoticias = new JButton("Noticias");
		panel_1.add(verNoticias);
	/**
	 * cambia la pantalla
	 */
		verNoticias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("pantallaNoticias");

			}
		});

		JButton botonlista2 = new JButton("cartera");
		botonlista2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("pantallaCartera");
			}
		});
		panel_1.add(botonlista2);
		
		JButton botonETF = new JButton("ETF");
		botonETF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("pantallaETF");
			}
		});
		panel_1.add(botonETF);

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		final JPanel listaEmpresa = new JPanel();
		listaEmpresa.setBackground(new Color(0, 204, 204));
		scrollPane.setViewportView(listaEmpresa);
		listaEmpresa.setLayout(new BoxLayout(listaEmpresa, BoxLayout.Y_AXIS));
		final ArrayList<ETF> todos = ETF.getTodos();
		botonActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

					for (int i = 0; i < todos.size(); i++) {
						listaEmpresa.add(new ElementoETF(v, todos.get(i).actualizar()));
					}
					repaint();
					ventana.cambiarAPantalla("pantallaETF");
				
			}
		});
		for (int i = 0; i < todos.size(); i++) {
			listaEmpresa.add(new ElementoETF(v, todos.get(i)));
		}

	}
}
