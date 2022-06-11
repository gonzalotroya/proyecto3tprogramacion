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

import clases.Empresa;
import clases.Usuario;
import elementosvisuales.ElementoCartera;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mercado extends JPanel{
	private Ventana ventana;
	private Empresa empresa;
	
	public Mercado(Ventana v) {
		ventana=v;
		
		setLayout(new BorderLayout(0, 0));
		
		
		
		JLabel labelTitulo = new JLabel("Mercado");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		add(labelTitulo, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JButton botonEuropa = new JButton("Europa");
		botonEuropa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel.add(botonEuropa);
		
		JButton botonUSA = new JButton("USA");
		botonUSA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel.add(botonUSA);
		
		JButton botonActualizar = new JButton("Actualizar");
		botonActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				empresa.actualizar();
				repaint();
			}
		});
		panel.add(botonActualizar);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		JButton verNoticias = new JButton("Noticias");
		panel_1.add(verNoticias);
		verNoticias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("noticias");

			}
		});
		
		JButton botonlista2 = new JButton("cartera");
		botonlista2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			ventana.cambiarAPantalla("cartera");
			}
		});
		panel_1.add(botonlista2);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel listaEmpresa = new JPanel();
		scrollPane.setViewportView(listaEmpresa);
		listaEmpresa.setLayout(new BoxLayout(listaEmpresa, BoxLayout.Y_AXIS));
		final ArrayList<Empresa>todos= Empresa.getTodos();
	
		for(int i=0;i<todos.size();i++) {
			listaEmpresa.add(new ElementoCartera(v,todos.get(i)));
		}	
			
	
	}
}
