package pantalla;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.border.TitledBorder;

import elementosvisuales.Boton;
import elementosvisuales.BotonAzul;

import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaLogin extends JPanel {
	private Ventana ventana;
	private JTextField campoUsuario;
	private JPasswordField botonPassword;
	public PantallaLogin(Ventana v) {
		setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		setBackground(Color.ORANGE);
		this.ventana=v;
	
	        setLayout(null);

	        JLabel lblNewLabel = new JLabel("User loquete:");
	        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
	        lblNewLabel.setBounds(258, 101, 150, 42);
	        add(lblNewLabel);

	        campoUsuario = new JTextField();
	        campoUsuario.setBounds(258, 154, 123, 16);
	        add(campoUsuario);
	        campoUsuario.setColumns(10);

	        JLabel lblNewLabel_1 = new JLabel("Password maquinon:");
	        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
	        lblNewLabel_1.setBounds(258, 197, 150, 13);
	        add(lblNewLabel_1);

	        botonPassword = new JPasswordField();
	        botonPassword.setBounds(258, 226, 123, 16);
	        add(botonPassword);

	        JButton botonLogin = new Boton("Login");
	        botonLogin.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		System.out.println("Haciendo login");
	        		
	        	}
	        
	        });
	        botonLogin.setToolTipText("Login patata");
	        	
	        botonLogin.setFont(new Font("Arial", Font.ITALIC, 14));
	        botonLogin.setBounds(445, 119, 102, 51);
	        add(botonLogin);

	        JButton btnNewButton_1 = new BotonAzul("Sign up");
	        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Gonza\\eclipse-workspace\\com.practicaBDmarcos\\icono.png"));
	        btnNewButton_1.setFont(new Font("Arial", Font.ITALIC, 14));
	        //btnNewButton_1.setBackground(Color.LIGHT_GRAY);
	        btnNewButton_1.setBounds(49, 43, 123, 150);
	        add(btnNewButton_1);
	        
	        JProgressBar progressBar = new JProgressBar();
	        progressBar.setBounds(258, 266, 146, 14);
	        add(progressBar);
	        
	        JLabel boton = new JLabel("LOGIN");
	        
	        add(boton);
	        
	        JButton botonSignin = new BotonAzul("Sign in");
	        
	        botonSignin.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	}
	        });
	        add(botonSignin);

	   	
	}
}
