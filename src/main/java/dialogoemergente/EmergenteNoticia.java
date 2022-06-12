package dialogoemergente;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clases.Empresa;
import clases.Noticia;
import pantalla.Ventana;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class EmergenteNoticia extends JDialog{
	private Ventana madre;
	private Noticia noticiaVer;
	private JTextField campoValor;
	private JTextField campoNombre;
	private JTextField campoMercado;
	
	
	public EmergenteNoticia(Ventana v,Noticia n) {
		this.madre=v;
		this.noticiaVer=n;
		this.setSize(500,400);
		getContentPane().setLayout(null);
		
		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		labelNombre.setForeground(Color.ORANGE);
		labelNombre.setBounds(98, 33, 60, 14);
		getContentPane().add(labelNombre);
		
		campoNombre = new JTextField(this.noticiaVer.getTitular());
		campoNombre.setBounds(163, 30, 256, 20);
		getContentPane().add(campoNombre);
		campoNombre.setColumns(10);
		
		JLabel labelValor = new JLabel("Noticia");
		labelValor.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		labelValor.setBackground(Color.WHITE);
		labelValor.setForeground(Color.ORANGE);
		labelValor.setBounds(98, 88, 55, 14);
		getContentPane().add(labelValor);
		
		campoValor = new JTextField(" "+this.noticiaVer.getCuerpo());
		campoValor.setBounds(163, 85, 256, 20);
		getContentPane().add(campoValor);
		campoValor.setColumns(10);
		
		JLabel labelContraseña = new JLabel("Fecha");
		labelContraseña.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		labelContraseña.setForeground(Color.ORANGE);
		labelContraseña.setBounds(98, 149, 52, 14);
		getContentPane().add(labelContraseña);
		final EmergenteNoticia thisRef=this;
		
		campoMercado = new JTextField(" "+this.noticiaVer.getFecha().toString());
		campoMercado.setBounds(163, 146, 256, 20);
		getContentPane().add(campoMercado);
		campoMercado.setColumns(10);
		
		JButton botonCancelar = new JButton("Cerrar");
		botonCancelar.setBounds(211, 270, 93, 23);
		botonCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		getContentPane().add(botonCancelar);
		
		JLabel labelFoto = new JLabel("");
		labelFoto.setIcon(new ImageIcon("./kaiser.jpg"));
		labelFoto.setBounds(0, 0, 484, 361);
		getContentPane().add(labelFoto);
	}
}