package pantalla;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import clases.Operacion;
import clases.Usuario;
import elementosvisuales.Boton;
import elementosvisuales.BotonAzul;
import enums.Paises;
import exceptions.A�oInvalidoException;
import exceptions.Contrase�aVaciaException;
import exceptions.EmailValidoException;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import java.awt.Color;

public class PantallaRegistro extends JPanel {
	private Ventana ventana;
	private JTextField campoEmail;
	private JTextField campoUsuario;
	private JTextField campoFechaNacimiento;
	private JPasswordField campoContrase�a;

	public PantallaRegistro(Ventana v) {
		this.ventana = v;
		setLayout(null);

		JLabel labelTitulo = new JLabel("Registro");
		labelTitulo.setForeground(new Color(51, 204, 255));
		labelTitulo.setBounds(163, 0, 140, 45);
		labelTitulo.setFont(new Font("Liberation Mono", Font.BOLD, 35));
		add(labelTitulo);

		JLabel labelEmail = new JLabel("Email");
		labelEmail.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		labelEmail.setForeground(new Color(51, 204, 255));
		labelEmail.setBounds(75, 111, 145, 14);
		labelEmail.setHorizontalAlignment(SwingConstants.LEFT);
		add(labelEmail);

		campoEmail = new JTextField();
		campoEmail.setBounds(225, 108, 117, 20);
		add(campoEmail);
		campoEmail.setColumns(10);

		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setForeground(new Color(51, 204, 255));
		labelUsuario.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		labelUsuario.setBounds(75, 136, 85, 14);
		add(labelUsuario);

		campoUsuario = new JTextField();
		campoUsuario.setBounds(225, 133, 117, 20);
		add(campoUsuario);
		campoUsuario.setColumns(10);

		JLabel labelContrase�a = new JLabel("Contrase�a");
		labelContrase�a.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		labelContrase�a.setForeground(new Color(51, 204, 255));
		labelContrase�a.setBounds(75, 161, 105, 14);
		add(labelContrase�a);

		campoContrase�a = new JPasswordField();
		campoContrase�a.setBounds(225, 158, 117, 20);
		add(campoContrase�a);

		JLabel labelFechaNacimiento = new JLabel("FechaNacimiento");
		labelFechaNacimiento.setForeground(new Color(51, 204, 255));
		labelFechaNacimiento.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		labelFechaNacimiento.setBounds(75, 186, 130, 14);
		add(labelFechaNacimiento);

		campoFechaNacimiento = new JTextField();
		campoFechaNacimiento.setBounds(225, 183, 117, 20);
		add(campoFechaNacimiento);
		campoFechaNacimiento.setColumns(10);

		JLabel labelTerminos = new JLabel("Condiciones de uso");
		labelTerminos.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		labelTerminos.setForeground(new Color(51, 204, 255));
		labelTerminos.setBounds(75, 212, 141, 14);
		add(labelTerminos);

		final JRadioButton botonAceptar = new JRadioButton("Aceptar");
		botonAceptar.setBounds(225, 208, 117, 23);
		add(botonAceptar);

		ButtonGroup grupoGenero = new ButtonGroup();
		grupoGenero.add(botonAceptar);

		JLabel labelLocalizacion = new JLabel("Localizaci�n");
		labelLocalizacion.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		labelLocalizacion.setForeground(new Color(51, 204, 255));
		labelLocalizacion.setBounds(75, 239, 105, 14);
		labelLocalizacion.setHorizontalAlignment(SwingConstants.LEFT);
		add(labelLocalizacion);

		final JComboBox selectorPais = new JComboBox();
		selectorPais.setBounds(225, 236, 117, 20);
		selectorPais.setModel(new DefaultComboBoxModel(Paises.values()));
		add(selectorPais);

		JButton botonRegistro = new Boton("Registrarse");
		botonRegistro.setBounds(124, 261, 218, 45);
		add(botonRegistro);

		JButton botonAtras = new BotonAzul("Atr�s");
		botonAtras.setBounds(471, 369, 111, 45);
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("login");
			}
		});
		add(botonAtras);
		
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setIcon(new ImageIcon("C:\\Users\\Gonza\\eclipse-workspace\\broker\\grafico.jpg"));
		imagenFondo.setBounds(0, 0, 607, 414);
		add(imagenFondo);

		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String email = campoEmail.getText();
					String nombre = campoUsuario.getText();
					String contrase�a = new String(campoContrase�a.getPassword());
					String fechaEnTexto = campoFechaNacimiento.getText();
					String[] fechaNaciPartida = fechaEnTexto.split("/");
					LocalDate fechaNacimiento = LocalDate.of(Integer.parseInt(fechaNaciPartida[2]),
							Integer.parseInt(fechaNaciPartida[1]), Integer.parseInt(fechaNaciPartida[0]));
					String condiciones = null;
					if(botonAceptar.isSelected()) {
						condiciones="Aceptar";
					}else {
						condiciones="";
					}
					Paises pais = (Paises) selectorPais.getSelectedItem();
					if(condiciones!=null) {
					//constructor
						
						JOptionPane.showMessageDialog(ventana, "Registro con exito","Registro correcto",JOptionPane.PLAIN_MESSAGE);
						ventana.cambiarAPantalla("login");
					}else {
						JOptionPane.showMessageDialog(ventana, "Acepta las condiciones de uso","Error",JOptionPane.ERROR_MESSAGE);
					}

					
					
				} catch (DateTimeException e1) {
					JOptionPane.showMessageDialog(
					ventana,e1.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
					
					//TODO METER EL ERROR DEL SPLIT DE LA CONTRASE�A
				} catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(
					ventana,"Formato de fecha incorrecto debe ser DD/MM/YYYY","Error",
					JOptionPane.ERROR_MESSAGE);
				} 
			}
		});
	}
}
