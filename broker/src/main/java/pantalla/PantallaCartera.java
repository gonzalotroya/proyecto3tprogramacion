package pantalla;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import clases.Accion;
import clases.Empresa;
import clases.Operacion;
import clases.Usuario;
import elementosvisuales.ElementoCartera;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaCartera extends JPanel{
private Ventana ventana;
	
	public PantallaCartera(Ventana v) {
		this.ventana=v;
		setLayout(new BorderLayout(0, 0));
		
		JLabel labelTitulo = new JLabel("Cartera");
		add(labelTitulo, BorderLayout.NORTH);
		
		JButton botonMercado = new JButton("Mercado");
		botonMercado.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			//ventana.recargarPantalla();
			ventana.cambiarAPantalla("Mercado");
		}
	});
		add(botonMercado, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel listaAcciones = new JPanel();
		scrollPane.setViewportView(listaAcciones);
		listaAcciones.setLayout(new BoxLayout(listaAcciones, BoxLayout.Y_AXIS));
		
		ArrayList<Empresa>to=Empresa.empresasCompradas();
		ArrayList<Accion>t=Accion.getTodos();
		for(int i=0;i<to.size();i++) {
			listaAcciones.add(new ElementoCartera(ventana,to.get(i)));
		}
	}

	

}
