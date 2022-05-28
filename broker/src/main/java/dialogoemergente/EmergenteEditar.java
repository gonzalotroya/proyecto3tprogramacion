package dialogoemergente;

import javax.swing.JDialog;

import clases.Usuario;
import exceptions.ContraseñaVaciaException;
import exceptions.EmailValidoException;
import pantalla.Ventana;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class EmergenteEditar extends JDialog{
	private Ventana madre;
	private Usuario usuarioEditar;
	private Usuario usuario;
	private JPasswordField campopasswd;
	private JTextField campoEmail;
	private JTextField campoNombre;
	
	
	public EmergenteEditar(Ventana v,Usuario u) {
		this.madre=v;
		this.usuarioEditar=u;
		this.setSize(500,400);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel labelNombre = new JLabel("Nombre");
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.anchor = GridBagConstraints.EAST;
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.gridx = 2;
		gbc_labelNombre.gridy = 1;
		getContentPane().add(labelNombre, gbc_labelNombre);
		
		campoNombre = new JTextField(this.usuarioEditar.getNombre());		
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.gridx = 3;
		gbc_campoNombre.gridy = 1;
		getContentPane().add(campoNombre, gbc_campoNombre);
		campoNombre.setColumns(10);
		
		JLabel labelEmail = new JLabel("Email");
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.anchor = GridBagConstraints.EAST;
		gbc_labelEmail.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmail.gridx = 2;
		gbc_labelEmail.gridy = 2;
		getContentPane().add(labelEmail, gbc_labelEmail);
		
		campoEmail = new JTextField(this.usuarioEditar.getEmail());
		GridBagConstraints gbc_campoEmail = new GridBagConstraints();
		gbc_campoEmail.insets = new Insets(0, 0, 5, 5);
		gbc_campoEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoEmail.gridx = 3;
		gbc_campoEmail.gridy = 2;
		getContentPane().add(campoEmail, gbc_campoEmail);
		campoEmail.setColumns(10);
		
		JLabel labelContraseña = new JLabel("Contraseña");
		GridBagConstraints gbc_labelContraseña = new GridBagConstraints();
		gbc_labelContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_labelContraseña.anchor = GridBagConstraints.EAST;
		gbc_labelContraseña.gridx = 2;
		gbc_labelContraseña.gridy = 3;
		getContentPane().add(labelContraseña, gbc_labelContraseña);
		
		campopasswd = new JPasswordField(this.usuarioEditar.getContraseña());
		GridBagConstraints gbc_campopasswd = new GridBagConstraints();
		gbc_campopasswd.insets = new Insets(0, 0, 5, 5);
		gbc_campopasswd.fill = GridBagConstraints.HORIZONTAL;
		gbc_campopasswd.gridx = 3;
		gbc_campopasswd.gridy = 3;
		getContentPane().add(campopasswd, gbc_campopasswd);
		
		JButton botonAceptar = new JButton("Aceptar");
		final EmergenteEditar thisRef=this;
		botonAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nuevoNombre=campoNombre.getText();
				String nuevoEmail=campoEmail.getText();
				String nuevoContraseña=new String (campopasswd.getPassword());
				try {
					usuarioEditar.setNombre(nuevoNombre);
					usuarioEditar.setContraseña(nuevoContraseña);
					usuarioEditar.setEmail(nuevoEmail);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(thisRef, e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		GridBagConstraints gbc_botonAceptar = new GridBagConstraints();
		gbc_botonAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_botonAceptar.gridx = 3;
		gbc_botonAceptar.gridy = 7;
		getContentPane().add(botonAceptar, gbc_botonAceptar);
		
		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_botonCancelar = new GridBagConstraints();
		gbc_botonCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_botonCancelar.gridx = 3;
		gbc_botonCancelar.gridy = 8;
		getContentPane().add(botonCancelar, gbc_botonCancelar);
	}

}