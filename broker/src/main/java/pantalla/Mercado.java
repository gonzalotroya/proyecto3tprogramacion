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

import clases.Usuario;

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
	
	public Mercado(Ventana v) {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Lista de Usuarios");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JButton sacaDialogoBoton = new JButton("Dialogo texto");
		sacaDialogoBoton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String mensaje=JOptionPane.showInputDialog(ventana,"Dime algo","Dime algo",JOptionPane.YES_NO_OPTION);
			}
		});
		panel.add(sacaDialogoBoton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		JButton botonQuitar = new JButton("Quitar elemento");
		
		panel_1.add(botonQuitar);
		
		JButton botonlista2 = new JButton("Ir a lista 2");
		botonlista2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			ventana.cambiarAPantalla("listav2");
			}
		});
		panel_1.add(botonlista2);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		//te hara falta para el proyecto
		final JList listaUsuario = new JList();
		final ArrayList<Usuario>todos= Usuario.getTodos();
		
		listaUsuario.setModel(new AbstractListModel() {

			public int getSize() {
				return todos.size();
			}
			public Object getElementAt(int index) {
				return todos.get(index);
			}
		});
		scrollPane.setRowHeaderView(listaUsuario);
		ventana=v;
		botonQuitar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			Usuario selecionado=(Usuario)listaUsuario.getSelectedValue();
			if(!ventana.usuarioLogado.equals(selecionado)) {
			todos.remove(selecionado);
			listaUsuario.repaint();
			JOptionPane.showMessageDialog(ventana, "Usuario"+selecionado.getNombre()+" eliminado","Eliminado con exito",JOptionPane.INFORMATION_MESSAGE);
			selecionado.eliminar();
			}else {
				int opcion=JOptionPane.showConfirmDialog(ventana,"Vas a borrarte a ti mismo, estas seguro?","Alerta",JOptionPane.WARNING_MESSAGE);
				if(opcion==0) {
					todos.remove(selecionado);
					listaUsuario.repaint();
					selecionado.eliminar();
					ventana.usuarioLogado=null;
					ventana.cambiarAPantalla("login");
				}else {
					JOptionPane.showMessageDialog(ventana, "Cancelado","Cancelado",JOptionPane.INFORMATION_MESSAGE);
				}
			
			}
			}
		});
	}
}
