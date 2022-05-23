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

public class PantallaLogin extends JPanel {
	private Ventana ventana;
	private JTextField campoUsuario;
	private JPasswordField campoContraseña;

	public PantallaLogin(Ventana v) {
		this.ventana = v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 101, 0, 92, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 105, 74, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel labelTitulo = new JLabel("Login");
		labelTitulo.setFont(new Font("Liberation Mono", Font.BOLD, 35));
		GridBagConstraints gbc_labelTitulo = new GridBagConstraints();
		gbc_labelTitulo.gridwidth = 5;
		gbc_labelTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_labelTitulo.gridx = 0;
		gbc_labelTitulo.gridy = 0;
		add(labelTitulo, gbc_labelTitulo);

		JLabel labelUsuario = new JLabel("Usuario");
		GridBagConstraints gbc_labelUsuario = new GridBagConstraints();
		gbc_labelUsuario.anchor = GridBagConstraints.WEST;
		gbc_labelUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_labelUsuario.gridx = 1;
		gbc_labelUsuario.gridy = 3;
		add(labelUsuario, gbc_labelUsuario);

		campoUsuario = new JTextField();
		GridBagConstraints gbc_campoUsuario = new GridBagConstraints();
		gbc_campoUsuario.gridwidth = 2;
		gbc_campoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_campoUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoUsuario.gridx = 2;
		gbc_campoUsuario.gridy = 3;
		add(campoUsuario, gbc_campoUsuario);
		campoUsuario.setColumns(10);

		JLabel labelContraseña = new JLabel("Contraseña");
		GridBagConstraints gbc_labelContraseña = new GridBagConstraints();
		gbc_labelContraseña.anchor = GridBagConstraints.WEST;
		gbc_labelContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_labelContraseña.gridx = 1;
		gbc_labelContraseña.gridy = 4;
		add(labelContraseña, gbc_labelContraseña);

		campoContraseña = new JPasswordField();
		GridBagConstraints gbc_campoContraseña = new GridBagConstraints();
		gbc_campoContraseña.gridwidth = 2;
		gbc_campoContraseña.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_campoContraseña.gridx = 2;
		gbc_campoContraseña.gridy = 4;
		add(campoContraseña, gbc_campoContraseña);

		JButton botonLogin = new Boton("Login");
		botonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonLogin.setText("Login");

		GridBagConstraints gbc_botonLogin = new GridBagConstraints();
		gbc_botonLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonLogin.gridwidth = 3;
		gbc_botonLogin.insets = new Insets(0, 0, 5, 5);
		gbc_botonLogin.gridx = 1;
		gbc_botonLogin.gridy = 6;
		add(botonLogin, gbc_botonLogin);

		JButton botonAtras = new BotonAzul("Atrás");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("login");
			}
		});
		
		JButton botonRegistrarse = new Boton("Registrarse");
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
		GridBagConstraints gbc_botonRegistrarse = new GridBagConstraints();
		gbc_botonRegistrarse.gridwidth = 3;
		gbc_botonRegistrarse.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonRegistrarse.insets = new Insets(0, 0, 5, 5);
		gbc_botonRegistrarse.gridx = 1;
		gbc_botonRegistrarse.gridy = 7;
		add(botonRegistrarse, gbc_botonRegistrarse);
		GridBagConstraints gbc_botonAtras = new GridBagConstraints();
		gbc_botonAtras.anchor = GridBagConstraints.EAST;
		gbc_botonAtras.gridx = 5;
		gbc_botonAtras.gridy = 8;
		add(botonAtras, gbc_botonAtras);

		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String nombre = campoUsuario.getText();
					String contraseña = new String(campoContraseña.getPassword());

					//new Usuario(nombre, contraseña);
				} catch (DateTimeException e1) {
					JOptionPane.showMessageDialog(
					ventana,e1.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
					
					//TODO METER EL ERROR DEL SPLIT DE LA CONTRASEÑA
				} 
			}
		});
	}
}
	