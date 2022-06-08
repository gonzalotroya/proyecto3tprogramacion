package dialogoemergente;

import javax.swing.JDialog;

import clases.Empresa;
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
	private Empresa empresaEditar;
	private JTextField campoValor;
	private JTextField campoNombre;
	private JTextField campoMercado;
	
	
	public EmergenteEditar(Ventana v,Empresa e) {
		this.madre=v;
		this.empresaEditar=e;
		this.setSize(500,400);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{91, 0, 0, 0, 0, 0, 0};
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
		
		campoNombre = new JTextField(this.empresaEditar.getNombre());		
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.gridx = 3;
		gbc_campoNombre.gridy = 1;
		getContentPane().add(campoNombre, gbc_campoNombre);
		campoNombre.setColumns(10);
		
		JLabel labelValor = new JLabel("Valor");
		GridBagConstraints gbc_labelValor = new GridBagConstraints();
		gbc_labelValor.anchor = GridBagConstraints.EAST;
		gbc_labelValor.insets = new Insets(0, 0, 5, 5);
		gbc_labelValor.gridx = 2;
		gbc_labelValor.gridy = 2;
		getContentPane().add(labelValor, gbc_labelValor);
		
		campoValor = new JTextField(" "+this.empresaEditar.getValor());
		GridBagConstraints gbc_campoValor = new GridBagConstraints();
		gbc_campoValor.insets = new Insets(0, 0, 5, 5);
		gbc_campoValor.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoValor.gridx = 3;
		gbc_campoValor.gridy = 2;
		getContentPane().add(campoValor, gbc_campoValor);
		campoValor.setColumns(10);
		
		JLabel labelContraseña = new JLabel("Mercado");
		GridBagConstraints gbc_labelContraseña = new GridBagConstraints();
		gbc_labelContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_labelContraseña.anchor = GridBagConstraints.EAST;
		gbc_labelContraseña.gridx = 2;
		gbc_labelContraseña.gridy = 3;
		getContentPane().add(labelContraseña, gbc_labelContraseña);
		
		JButton botonAceptar = new JButton("Aceptar");
		final EmergenteEditar thisRef=this;
		botonAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nuevoNombre=campoNombre.getText();
				try {
					float nuevoValor=Float.parseFloat(campoValor.getText());
					empresaEditar.setNombre(nuevoNombre);
					empresaEditar.setValor(nuevoValor);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(thisRef, e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(thisRef,"Tienes que poner un numero con decimales en el campo valor","Error",JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		
		campoMercado = new JTextField(" "+this.empresaEditar.getMercado());
		GridBagConstraints gbc_campoMercado = new GridBagConstraints();
		gbc_campoMercado.insets = new Insets(0, 0, 5, 5);
		gbc_campoMercado.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoMercado.gridx = 3;
		gbc_campoMercado.gridy = 3;
		getContentPane().add(campoMercado, gbc_campoMercado);
		campoMercado.setColumns(10);
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


		// TODO Auto-generated constructor stub

}