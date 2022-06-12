package pantalla;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import clases.Accion;
import clases.ETF;
import clases.Empresa;
import clases.Operacion;
import clases.Usuario;
import elementosvisuales.ElementoCartera;
import elementosvisuales.ElementoETF;

import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * 
 * @author gonzalo
 *
 */
public class PantallaCartera extends JPanel{
private Ventana ventana;
/**
 * Funcion que toma desde la clase ventana y posiciona una interfaz 
 * @param v variable de la clase ventana
 */
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
		/**
		 * Muestra todas las empresas compradas
		 */
		ArrayList<Empresa>to=Empresa.empresasCompradas();
		ArrayList<ETF>tod=ETF.etfCompradas();
		ArrayList<Accion>t=Accion.getTodos();
		for(int i=0;i<to.size();i++) {
			listaAcciones.add(new ElementoCartera(ventana,to.get(i)));
		}
		for(int i=0;i<tod.size();i++) {
			listaAcciones.add(new ElementoETF(ventana,tod.get(i)));

		}
	}

	

}
