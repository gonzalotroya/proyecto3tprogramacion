package pantalla;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import clases.Accion;
import clases.Empresa;
import clases.Usuario;
import elementosvisuales.ElementoCartera;

public class PantallaCartera extends JPanel{
private Ventana ventana;
	
	public PantallaCartera(Ventana v) {
		this.ventana=v;
		setLayout(new BorderLayout(0, 0));
		
		JLabel labelTitulo = new JLabel("Cartera");
		add(labelTitulo, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel listaAcciones = new JPanel();
		scrollPane.setViewportView(listaAcciones);
		listaAcciones.setLayout(new BoxLayout(listaAcciones, BoxLayout.Y_AXIS));
		
		ArrayList<Empresa>to=Empresa.getTodos();
		ArrayList<Accion>t=Accion.getTodos();
		for(int i=0;i<to.size();i++) {
			listaAcciones.add(new ElementoCartera(ventana,to.get(i)));
		}
	}

}
