package Panel;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

public class PanelOpciones extends JPanel {

	private JButton jugarButton;
	private JButton configButton;
	private JButton usuariosButton;
	private JButton salirButton;
	
	private SpringLayout currentLayout;
	
	/**
	 * Create the panel.
	 */
	public PanelOpciones() {
		Dimension btnDim = new Dimension(80, 40);
		
		this.currentLayout = new SpringLayout();
		this.jugarButton = new JButton("JUGAR");
		jugarButton.setPreferredSize(btnDim);
		
		currentLayout.putConstraint(SpringLayout.WEST, jugarButton, 43, SpringLayout.WEST, this);
		this.configButton = new JButton("OPCIONES");
		configButton.setPreferredSize(btnDim);
		currentLayout.putConstraint(SpringLayout.NORTH, jugarButton, 43, SpringLayout.SOUTH, configButton);
		this.usuariosButton = new JButton("USUARIOS");
		usuariosButton.setPreferredSize(btnDim);
		
		this.salirButton = new JButton("Salir");
		
		ConfigurarPanel();
	}
	
	public void ConfigurarPanel()
	{
		this.setLayout(currentLayout);
		this.add(jugarButton);
		this.add(configButton);
		this.add(usuariosButton);
		this.add(salirButton);
	}
}
