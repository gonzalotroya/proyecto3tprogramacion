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
		
		campoNombre = new JTextField(this.noticiaVer.getTitular());		
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.gridx = 3;
		gbc_campoNombre.gridy = 1;
		getContentPane().add(campoNombre, gbc_campoNombre);
		campoNombre.setColumns(10);
		
		JLabel labelValor = new JLabel("Noticia");
		GridBagConstraints gbc_labelValor = new GridBagConstraints();
		gbc_labelValor.anchor = GridBagConstraints.EAST;
		gbc_labelValor.insets = new Insets(0, 0, 5, 5);
		gbc_labelValor.gridx = 2;
		gbc_labelValor.gridy = 2;
		getContentPane().add(labelValor, gbc_labelValor);
		
		campoValor = new JTextField(" "+this.noticiaVer.getCuerpo());
		GridBagConstraints gbc_campoValor = new GridBagConstraints();
		gbc_campoValor.insets = new Insets(0, 0, 5, 5);
		gbc_campoValor.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoValor.gridx = 3;
		gbc_campoValor.gridy = 2;
		getContentPane().add(campoValor, gbc_campoValor);
		campoValor.setColumns(10);
		
		JLabel labelContrase�a = new JLabel("Fecha");
		GridBagConstraints gbc_labelContrase�a = new GridBagConstraints();
		gbc_labelContrase�a.insets = new Insets(0, 0, 5, 5);
		gbc_labelContrase�a.anchor = GridBagConstraints.EAST;
		gbc_labelContrase�a.gridx = 2;
		gbc_labelContrase�a.gridy = 3;
		getContentPane().add(labelContrase�a, gbc_labelContrase�a);
		
		JButton botonAceptar = new JButton("Aceptar");
		final EmergenteNoticia thisRef=this;
		botonAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nuevoNombre=campoNombre.getText();
				String nuevoCuerpo=campoValor.getText();
				//LocalDate nuevaFecha=campoMercado.getText();
				try {
					noticiaVer.setTitular(nuevoNombre);
					noticiaVer.setCuerpo(nuevoCuerpo);
					//noticiaVer.setFecha(nuevaFecha);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(thisRef, e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(thisRef,"Tienes que poner un numero con decimales en el campo valor","Error",JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		
		campoMercado = new JTextField(" "+this.noticiaVer.getFecha().toString());
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