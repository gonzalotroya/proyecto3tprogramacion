package elementosvisuales;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import clases.Accion;
import clases.Empresa;
import clases.Usuario;
import dialogoemergente.EmergenteEditar;
import pantalla.Ventana;

public class ElementoCartera extends JPanel{
	private Ventana ventana;
	private Usuario usuario;
	private Empresa empresa;
	private Accion accion;
	
	public ElementoCartera(Ventana v,Usuario u,Empresa e,Accion a) {
		setBorder(new LineBorder(new Color(218, 165, 32), 3, true));
		this.ventana=v;
		this.usuario=u;
		this.empresa=e;
		this.accion=a;
		this.setMaximumSize(new Dimension(80000,70));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{50, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel fotoUsuario = new JLabel("");
		fotoUsuario.setIcon(new ImageIcon(".\\imagenes\\usuarioPorDefecto.png"));
		GridBagConstraints gbc_fotoUsuario = new GridBagConstraints();
		gbc_fotoUsuario.gridheight = 2;
		gbc_fotoUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_fotoUsuario.gridx = 0;
		gbc_fotoUsuario.gridy = 0;
		add(fotoUsuario, gbc_fotoUsuario);
		
		JLabel labelNombre = new JLabel(this.usuario.getNombre());
		labelNombre.setHorizontalAlignment(SwingConstants.LEFT);
		labelNombre.setFont(new Font("Segoe UI", Font.BOLD, 17));
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.anchor = GridBagConstraints.WEST;
		gbc_labelNombre.gridwidth = 3;
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.gridx = 1;
		gbc_labelNombre.gridy = 0;
		add(labelNombre, gbc_labelNombre);
		JButton botonBorrar = new JButton("");
		botonBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				usuario.eliminar();
			}
		});
		botonBorrar.setIcon(new ImageIcon(".\\iconos\\borrar.png"));
		GridBagConstraints gbc_botonBorrar = new GridBagConstraints();
		gbc_botonBorrar.insets = new Insets(0, 0, 5, 0);
		gbc_botonBorrar.gridx = 5;
		gbc_botonBorrar.gridy = 0;
		add(botonBorrar, gbc_botonBorrar);
		
		JLabel labelEmail = new JLabel(this.usuario.getEmail());
		labelEmail.setFont(new Font("Tahoma", Font.ITALIC, 11));
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.insets = new Insets(0, 0, 0, 5);
		gbc_labelEmail.gridx = 1;
		gbc_labelEmail.gridy = 1;
		add(labelEmail, gbc_labelEmail);
		
		JLabel labelGuion = new JLabel(" - ");
		GridBagConstraints gbc_labelGuion = new GridBagConstraints();
		gbc_labelGuion.insets = new Insets(0, 0, 0, 5);
		gbc_labelGuion.gridx = 2;
		gbc_labelGuion.gridy = 1;
		add(labelGuion, gbc_labelGuion);
		
		JLabel labelFechaNacimiento = new JLabel(this.empresa.getNombre());
		GridBagConstraints gbc_labelFechaNacimiento = new GridBagConstraints();
		gbc_labelFechaNacimiento.insets = new Insets(0, 0, 0, 5);
		gbc_labelFechaNacimiento.gridx = 3;
		gbc_labelFechaNacimiento.gridy = 1;
		add(labelFechaNacimiento, gbc_labelFechaNacimiento);
		
		JButton botonEditar = new JButton("");
		botonEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmergenteEditar editor=new EmergenteEditar(ventana,usuario);
				editor.setVisible(true);
			}
		});
		botonEditar.setIcon(new ImageIcon(".\\iconos\\editar.png"));
		GridBagConstraints gbc_botonEditar = new GridBagConstraints();
		gbc_botonEditar.gridx = 5;
		gbc_botonEditar.gridy = 1;
		add(botonEditar, gbc_botonEditar);
		
	}

}