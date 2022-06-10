package pantalla;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

import clases.Empresa;
import clases.Noticia;
import elementosvisuales.ElementoCartera;
import elementosvisuales.ElementoNoticia;

import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PantallaNoticias extends JPanel{
	private Ventana ventana;

	public PantallaNoticias(Ventana v) {
		this.ventana=v;

		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		JLabel labelTitulo = new JLabel("Noticias");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		scrollPane.setColumnHeaderView(labelTitulo);
		
		JPanel panel = new JPanel();
		scrollPane.setRowHeaderView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JButton botonCartera = new JButton("cartera");  
		botonCartera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("cartera");

			}
		});
		panel.add(botonCartera);
		
		JButton botonMercado = new JButton("Mercado");
		botonMercado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("Mercado");
			}
		});
		panel.add(botonMercado);
		
		JScrollPane scrolPaneNot = new JScrollPane();
		scrollPane.setViewportView(scrolPaneNot);
		
		JPanel listaNoticia = new JPanel();
		scrolPaneNot.setViewportView(listaNoticia);
		listaNoticia.setLayout(new BoxLayout(listaNoticia, BoxLayout.Y_AXIS));
	
		final ArrayList<Noticia>not= Noticia.getTodos();
		
		for(int i=0;i<not.size();i++) {
			listaNoticia.add(new ElementoNoticia(v,not.get(i)));
		}	
			
	}
}
