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
import clases.Noticia;
import dialogoemergente.EmergenteEditar;
import dialogoemergente.EmergenteNoticia;
import pantalla.Ventana;
/**
 * Funcion que toma desde la clase ventana y noticia  y posiciona una interfaz 
 * @param v variable de la clase ventana
 * @param n variable de la clase noticia
 */
	public class ElementoNoticia  extends JPanel{
		private Ventana ventana;
		private Noticia noticia;
		
		public ElementoNoticia(Ventana v,Noticia n) {
			setBorder(new LineBorder(new Color(218, 165, 32), 3, true));
			this.ventana=v;
			this.noticia=n;
			
			this.setMaximumSize(new Dimension(80000,70));
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{50, 0, 0, 0, 178, 0, 0};
			gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
			gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
			setLayout(gridBagLayout);
			
			JLabel fotoempresa = new JLabel("");
			fotoempresa.setIcon(new ImageIcon(".\\imagenes\\empresaPorDefecto.png"));
			GridBagConstraints gbc_fotoempresa = new GridBagConstraints();
			gbc_fotoempresa.gridheight = 3;
			gbc_fotoempresa.insets = new Insets(0, 0, 0, 5);
			gbc_fotoempresa.gridx = 0;
			gbc_fotoempresa.gridy = 0;
			add(fotoempresa, gbc_fotoempresa);
			
			JLabel labelNombre = new JLabel(this.noticia.getTitular());
			labelNombre.setHorizontalAlignment(SwingConstants.LEFT);
			labelNombre.setFont(new Font("Segoe UI", Font.BOLD, 17));
			GridBagConstraints gbc_labelNombre = new GridBagConstraints();
			gbc_labelNombre.anchor = GridBagConstraints.WEST;
			gbc_labelNombre.gridwidth = 3;
			gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
			gbc_labelNombre.gridx = 1;
			gbc_labelNombre.gridy = 0;
			add(labelNombre, gbc_labelNombre);
			/**
			 * botonVer llama al elemento emergenteNoticia para permitir ver la noticia
			 */
			JButton botonVer = new JButton("Ver");
			botonVer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					EmergenteNoticia editor=new EmergenteNoticia(ventana,noticia);
					editor.setVisible(true);
				}
			});
			botonVer.setIcon(new ImageIcon(".\\iconos\\editar.png"));
			GridBagConstraints gbc_botonVer = new GridBagConstraints();
			gbc_botonVer.insets = new Insets(0, 0, 5, 0);
			gbc_botonVer.gridx = 5;
			gbc_botonVer.gridy = 1;
			add(botonVer, gbc_botonVer);
			
			JLabel labelEmail = new JLabel(" "+this.noticia.getCuerpo());
			labelEmail.setFont(new Font("Tahoma", Font.ITALIC, 11));
			GridBagConstraints gbc_labelEmail = new GridBagConstraints();
			gbc_labelEmail.insets = new Insets(0, 0, 0, 5);
			gbc_labelEmail.gridx = 1;
			gbc_labelEmail.gridy = 2;
			add(labelEmail, gbc_labelEmail);
			
			JLabel labelGuion = new JLabel(" - ");
			GridBagConstraints gbc_labelGuion = new GridBagConstraints();
			gbc_labelGuion.insets = new Insets(0, 0, 0, 5);
			gbc_labelGuion.gridx = 2;
			gbc_labelGuion.gridy = 2;
			add(labelGuion, gbc_labelGuion);
			
			JLabel labelMercado = new JLabel(""+this.noticia.getFecha().toString());
			GridBagConstraints gbc_labelMercado = new GridBagConstraints();
			gbc_labelMercado.insets = new Insets(0, 0, 0, 5);
			gbc_labelMercado.gridx = 3;
			gbc_labelMercado.gridy = 2;
			add(labelMercado, gbc_labelMercado);
			
		}

	}

