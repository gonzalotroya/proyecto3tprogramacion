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

public class PantallaRegistro extends JPanel {
	private Ventana ventana;
	private JTextField campoEmail;
	private JTextField campoUsuario;
	private JTextField campoFechaNacimiento;
	private JPasswordField campoContrase�a;

	public PantallaRegistro(Ventana v) {
		this.ventana = v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 101, 0, 92, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel labelTitulo = new JLabel("Registro");
		labelTitulo.setFont(new Font("Liberation Mono", Font.BOLD, 35));
		GridBagConstraints gbc_labelTitulo = new GridBagConstraints();
		gbc_labelTitulo.gridwidth = 5;
		gbc_labelTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_labelTitulo.gridx = 0;
		gbc_labelTitulo.gridy = 0;
		add(labelTitulo, gbc_labelTitulo);

		JLabel labelEmail = new JLabel("Email");
		labelEmail.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelEmail.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmail.gridx = 1;
		gbc_labelEmail.gridy = 2;
		add(labelEmail, gbc_labelEmail);

		campoEmail = new JTextField();
		GridBagConstraints gbc_campoEmail = new GridBagConstraints();
		gbc_campoEmail.gridwidth = 2;
		gbc_campoEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoEmail.insets = new Insets(0, 0, 5, 5);
		gbc_campoEmail.gridx = 2;
		gbc_campoEmail.gridy = 2;
		add(campoEmail, gbc_campoEmail);
		campoEmail.setColumns(10);

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

		JLabel labelContrase�a = new JLabel("Contrase�a");
		GridBagConstraints gbc_labelContrase�a = new GridBagConstraints();
		gbc_labelContrase�a.anchor = GridBagConstraints.WEST;
		gbc_labelContrase�a.insets = new Insets(0, 0, 5, 5);
		gbc_labelContrase�a.gridx = 1;
		gbc_labelContrase�a.gridy = 4;
		add(labelContrase�a, gbc_labelContrase�a);

		campoContrase�a = new JPasswordField();
		GridBagConstraints gbc_campoContrase�a = new GridBagConstraints();
		gbc_campoContrase�a.gridwidth = 2;
		gbc_campoContrase�a.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoContrase�a.insets = new Insets(0, 0, 5, 5);
		gbc_campoContrase�a.gridx = 2;
		gbc_campoContrase�a.gridy = 4;
		add(campoContrase�a, gbc_campoContrase�a);

		JLabel labelFechaNacimiento = new JLabel("FechaNacimiento");
		GridBagConstraints gbc_labelFechaNacimiento = new GridBagConstraints();
		gbc_labelFechaNacimiento.anchor = GridBagConstraints.WEST;
		gbc_labelFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_labelFechaNacimiento.gridx = 1;
		gbc_labelFechaNacimiento.gridy = 5;
		add(labelFechaNacimiento, gbc_labelFechaNacimiento);

		campoFechaNacimiento = new JTextField();
		GridBagConstraints gbc_campoFechaNacimiento = new GridBagConstraints();
		gbc_campoFechaNacimiento.gridwidth = 2;
		gbc_campoFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_campoFechaNacimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoFechaNacimiento.gridx = 2;
		gbc_campoFechaNacimiento.gridy = 5;
		add(campoFechaNacimiento, gbc_campoFechaNacimiento);
		campoFechaNacimiento.setColumns(10);

		JLabel labelGenero = new JLabel("Genero");
		GridBagConstraints gbc_labelGenero = new GridBagConstraints();
		gbc_labelGenero.anchor = GridBagConstraints.WEST;
		gbc_labelGenero.insets = new Insets(0, 0, 5, 5);
		gbc_labelGenero.gridx = 1;
		gbc_labelGenero.gridy = 6;
		add(labelGenero, gbc_labelGenero);

		final JRadioButton generoHombre = new JRadioButton("Hombre");
		GridBagConstraints gbc_generoHombre = new GridBagConstraints();
		gbc_generoHombre.insets = new Insets(0, 0, 5, 5);
		gbc_generoHombre.gridx = 2;
		gbc_generoHombre.gridy = 6;
		add(generoHombre, gbc_generoHombre);

		final JRadioButton generoMujer = new JRadioButton("Mujer");
		GridBagConstraints gbc_generoMujer = new GridBagConstraints();
		gbc_generoMujer.insets = new Insets(0, 0, 5, 5);
		gbc_generoMujer.gridx = 3;
		gbc_generoMujer.gridy = 6;
		add(generoMujer, gbc_generoMujer);

		ButtonGroup grupoGenero = new ButtonGroup();
		grupoGenero.add(generoHombre);
		grupoGenero.add(generoMujer);

		JLabel labelLocalizacion = new JLabel("Localizaci�n");
		labelLocalizacion.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_labelLocalizacion = new GridBagConstraints();
		gbc_labelLocalizacion.insets = new Insets(0, 0, 5, 5);
		gbc_labelLocalizacion.anchor = GridBagConstraints.WEST;
		gbc_labelLocalizacion.gridx = 1;
		gbc_labelLocalizacion.gridy = 7;
		add(labelLocalizacion, gbc_labelLocalizacion);

		final JComboBox selectorPais = new JComboBox();
		selectorPais.setModel(new DefaultComboBoxModel(Paises.values()));
		GridBagConstraints gbc_selectorPais = new GridBagConstraints();
		gbc_selectorPais.gridwidth = 2;
		gbc_selectorPais.insets = new Insets(0, 0, 5, 5);
		gbc_selectorPais.fill = GridBagConstraints.HORIZONTAL;
		gbc_selectorPais.gridx = 2;
		gbc_selectorPais.gridy = 7;
		add(selectorPais, gbc_selectorPais);

		JButton botonRegistro = new Boton("Registrarse");

		GridBagConstraints gbc_botonRegistro = new GridBagConstraints();
		gbc_botonRegistro.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonRegistro.gridwidth = 3;
		gbc_botonRegistro.insets = new Insets(0, 0, 5, 5);
		gbc_botonRegistro.gridx = 1;
		gbc_botonRegistro.gridy = 8;
		add(botonRegistro, gbc_botonRegistro);

		JButton botonAtras = new BotonAzul("Atr�s");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("login");
			}
		});
		GridBagConstraints gbc_botonAtras = new GridBagConstraints();
		gbc_botonAtras.anchor = GridBagConstraints.EAST;
		gbc_botonAtras.gridx = 5;
		gbc_botonAtras.gridy = 10;
		add(botonAtras, gbc_botonAtras);

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
					String genero = (generoHombre.isSelected() ? "Hombre" : "Mujer");
					Paises pais = (Paises) selectorPais.getSelectedItem();
					System.out.println(genero);
					System.out.println(pais);

					
				} catch (DateTimeException e1) {
					JOptionPane.showMessageDialog(
					ventana,e1.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
					
					//TODO METER EL ERROR DEL SPLIT DE LA CONTRASE�A
				} 
			}
		});
	}
}
