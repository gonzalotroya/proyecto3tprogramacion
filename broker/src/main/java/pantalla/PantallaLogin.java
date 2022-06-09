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

import clases.Usuario;
import elementosvisuales.Boton;
import elementosvisuales.BotonAzul;
import enums.Paises;
import exceptions.AñoInvalidoException;
import exceptions.ContraseñaIncorrectaException;
import exceptions.ContraseñaVaciaException;
import exceptions.EmailValidoException;
import exceptions.UsuarioNoExisteException;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class PantallaLogin extends JPanel {
	private Ventana ventana;
	private JTextField campoUsuario;
	private JPasswordField campoContraseña;

	public PantallaLogin(Ventana v,String argN,String argC) {
		this.ventana = v;
		setLayout(null);
		
		JLabel labelTitulo = new JLabel("Login");
		labelTitulo.setForeground(new Color(0, 102, 255));
		labelTitulo.setBounds(255, 0, 92, 45);
		labelTitulo.setFont(new Font("Liberation Mono", Font.BOLD, 35));
		add(labelTitulo);

		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		labelUsuario.setForeground(new Color(51, 102, 255));
		labelUsuario.setBounds(73, 144, 90, 14);
		add(labelUsuario);

		campoUsuario = new JTextField(argN);
		campoUsuario.setBounds(196, 141, 150, 20);
		add(campoUsuario);
		campoUsuario.setColumns(10);

		JLabel labelContraseña = new JLabel("Contraseña");
		labelContraseña.setForeground(new Color(51, 102, 255));
		labelContraseña.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		labelContraseña.setBounds(73, 169, 78, 14);
		add(labelContraseña);

		campoContraseña = new JPasswordField(argC);
		campoContraseña.setBounds(196, 166, 150, 20);
		add(campoContraseña);

		JButton botonLogin = new Boton("Login");
		botonLogin.setBounds(95, 243, 251, 55);
		botonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//prueba argumentos
					//String nombre= System.getProperty("usuario");
					//String contraseña=System.getProperty("contraseña");
					
					String nombre = campoUsuario.getText();
					String contraseña = new String(campoContraseña.getPassword());
					
					ventana.usuarioLogado=new Usuario(nombre, contraseña);
					ventana.cambiarAPantalla("Mercado");
					
					JOptionPane.showMessageDialog(ventana, "Hola"+ventana.usuarioLogado.getNombre(),"Login correcto",JOptionPane.PLAIN_MESSAGE);
				} catch (DateTimeException |SQLException|ContraseñaIncorrectaException|UsuarioNoExisteException e1) {
					JOptionPane.showMessageDialog(
					ventana,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					
				} catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(
					ventana,"Formato de fecha incorrecto debe ser DD/MM/YYYY","Error",
					JOptionPane.ERROR_MESSAGE);
				
				} 
			}
		});
		botonLogin.setText("Login");
		add(botonLogin);
		
		JButton botonRegistrarse = new Boton("Registrarse");
		botonRegistrarse.setBounds(95, 348, 251, 55);
		botonRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("registro");
			}
		});
		botonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(botonRegistrarse);
		
				JButton botonAtras = new BotonAzul("Atrás");
				botonAtras.setBounds(416, 431, 135, 55);
				botonAtras.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						ventana.cambiarAPantalla("login");
					}
				});
				add(botonAtras);
				
				JLabel imagenFondo = new JLabel("");
				imagenFondo.setIcon(new ImageIcon("C:\\Users\\Gonza\\eclipse-workspace\\broker\\grafico.jpg"));
				imagenFondo.setBounds(0, 0, 602, 486);
				add(imagenFondo);

		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String nombre = campoUsuario.getText();
					String contraseña = new String(campoContraseña.getPassword());

					try {
						ventana.usuarioLogado=new Usuario(nombre, contraseña);
						ventana.cambiarAPantalla("Mercado");			

					} catch (SQLException | ContraseñaIncorrectaException | UsuarioNoExisteException e1) {
						JOptionPane.showMessageDialog(ventana,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					}
					} catch (DateTimeException e1) {
					JOptionPane.showMessageDialog(
					ventana,e1.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
					
					//TODO METER EL ERROR DEL SPLIT DE LA CONTRASEÑA
				} catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(
					ventana,"Formato de fecha incorrecto debe ser DD/MM/YYYY","Error",
					JOptionPane.ERROR_MESSAGE);
				}  
			}
		});
	}
}
	