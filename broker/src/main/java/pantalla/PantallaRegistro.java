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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import java.awt.Color;
/**
 * 
 * @author gonzalo
 *
 */
public class PantallaRegistro extends JPanel {
	private Ventana ventana;
	private JTextField campoEmail;
	private JTextField campoUsuario;
	private JTextField campoFechaNacimiento;
	private JPasswordField campoContraseña;
	private JTextField campoDNI;
	private JTextField campoApellidos;
	private JTextField campoTelefono;
	private JTextField campoBanco;
	private final ButtonGroup grupoCondiciones = new ButtonGroup();
	/**
	 * Funcion que toma desde la clase ventana y posiciona una interfaz 
	 * @param v variable de la clase ventana
	 */
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

		JLabel labelUsuario = new JLabel("Nombre");
		labelUsuario.setForeground(new Color(51, 204, 255));
		labelUsuario.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		labelUsuario.setBounds(75, 136, 85, 14);
		add(labelUsuario);

		campoUsuario = new JTextField();
		campoUsuario.setBounds(225, 133, 117, 20);
		add(campoUsuario);
		campoUsuario.setColumns(10);

		JLabel labelContraseña = new JLabel("Contraseña");
		labelContraseña.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		labelContraseña.setForeground(new Color(51, 204, 255));
		labelContraseña.setBounds(75, 161, 105, 14);
		add(labelContraseña);

		campoContraseña = new JPasswordField();
		campoContraseña.setBounds(225, 158, 117, 20);
		add(campoContraseña);

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
		grupoCondiciones.add(botonAceptar);
		botonAceptar.setBounds(225, 209, 117, 23);
		add(botonAceptar);

		

		final JComboBox selectorPais = new JComboBox();
		selectorPais.setBounds(225, 236, 117, 20);
		selectorPais.setModel(new DefaultComboBoxModel(Paises.values()));
		add(selectorPais);

		JButton botonRegistro = new Boton("Registrarse");
		botonRegistro.setBounds(124, 261, 218, 45);
		add(botonRegistro);

		JButton botonAtras = new BotonAzul("Atrás");
		botonAtras.setBounds(471, 369, 111, 45);
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("pantallaLogin");
			}
		});
		add(botonAtras);
		
		JLabel labelDNI = new JLabel("DNI");
		labelDNI.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		labelDNI.setForeground(new Color(51, 204, 255));
		labelDNI.setBounds(73, 86, 46, 14);
		add(labelDNI);
		
		campoDNI = new JTextField();
		campoDNI.setBounds(225, 80, 117, 20);
		add(campoDNI);
		campoDNI.setColumns(10);
		
		JLabel labelApellidos = new JLabel("Apellidos");
		labelApellidos.setForeground(new Color(51, 204, 255));
		labelApellidos.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		labelApellidos.setBounds(352, 136, 85, 14);
		add(labelApellidos);
		
		campoApellidos = new JTextField();
		campoApellidos.setBounds(427, 134, 130, 20);
		add(campoApellidos);
		campoApellidos.setColumns(10);
		
		JLabel labelTelefono = new JLabel("Telefono");
		labelTelefono.setForeground(new Color(51, 204, 255));
		labelTelefono.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		labelTelefono.setBounds(352, 111, 72, 14);
		add(labelTelefono);
		
		campoTelefono = new JTextField();
		campoTelefono.setBounds(428, 109, 130, 20);
		add(campoTelefono);
		campoTelefono.setColumns(10);
		
		JLabel labelBanco = new JLabel("IBAN");
		labelBanco.setForeground(new Color(51, 204, 255));
		labelBanco.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		labelBanco.setBounds(352, 86, 46, 14);
		add(labelBanco);
		
		campoBanco = new JTextField();
		campoBanco.setBounds(427, 84, 130, 20);
		add(campoBanco);
		campoBanco.setColumns(10);
		
		JButton botonInforme = new JButton("Descargar manual");
		botonInforme.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File manual=new File("manual.txt");
				
				FileWriter m;
				try {
					m = new FileWriter(manual);
					PrintWriter q=new PrintWriter(m);
					q.println("Este es el manual de registro");
					q.println("Introduce todos tus datos segun lo indican los campos");
					q.println("Los campos con restricciones son email donde tendras que poner un @,");
					q.println("fecha de nacimiento que tendras que usar un formato dd/mm/yyyy,");
					q.println("tendras que aceptar los terminos de condiciones y no dejar la contraseña vacia");

					q.close();
					JOptionPane.showMessageDialog(ventana, "Descarga exitosa","Revise el manual",JOptionPane.PLAIN_MESSAGE);

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		botonInforme.setBounds(188, 386, 210, 23);
		add(botonInforme);
		
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setIcon(new ImageIcon("./grafico.jpg"));
		imagenFondo.setBounds(0, 0, 607, 415);
		add(imagenFondo);

		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int saldoInvertido=0;
					int saldoLibre=10000;
					ArrayList<Operacion> numeroAccionesCompradas =(ArrayList<Operacion>) null;
					String dni=campoDNI.getText();
					String email = campoEmail.getText();
					String nombre = campoUsuario.getText();
					String apellidos=campoApellidos.getText();
					String telefono=campoTelefono.getText();
					String cuentaBanco=campoBanco.getText();
					String contraseña = new String(campoContraseña.getPassword());
					String fechaEnTexto = campoFechaNacimiento.getText();
					String[] fechaNaciPartida = fechaEnTexto.split("/");
					LocalDate fechaNacimiento = LocalDate.of(Integer.parseInt(fechaNaciPartida[2]),
							Integer.parseInt(fechaNaciPartida[1]), Integer.parseInt(fechaNaciPartida[0]));
					String condiciones = null;
					if(botonAceptar.isSelected()) {
						condiciones="Aceptar";
					}
					Paises pais = (Paises) selectorPais.getSelectedItem();
					if(condiciones!=null) {			
						try {
							new Usuario(nombre,saldoInvertido, saldoLibre,apellidos,cuentaBanco,dni, telefono,email,contraseña,fechaNacimiento);
							JOptionPane.showMessageDialog(ventana, "Registro con exito","Registro correcto",JOptionPane.PLAIN_MESSAGE);
							ventana.cambiarAPantalla("pantallaLogin");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}catch (EmailValidoException e1) {
							JOptionPane.showMessageDialog(ventana, "Email invalido inserta @","Error",JOptionPane.ERROR_MESSAGE);

						
						}catch (ContraseñaVaciaException e1) {
						JOptionPane.showMessageDialog(ventana, "Contraseña vacia","Error",JOptionPane.ERROR_MESSAGE);

						}
						
						
					}else {
						JOptionPane.showMessageDialog(ventana, "Acepta las condiciones de uso","Error",JOptionPane.ERROR_MESSAGE);
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
