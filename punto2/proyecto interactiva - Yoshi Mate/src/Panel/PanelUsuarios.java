package Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

public class PanelUsuarios extends JPanel {

	private JButton loginButton;
	private JButton newUserButton;
	private SpringLayout currentLayout;
	
	private JLabel lblUser;
	private JLabel lblPassword;

	private JTextField txtUser;
	private JPasswordField txtPass;
	
	/**
	 * Create the panel.
	 */
	public PanelUsuarios() {
		this.currentLayout = new SpringLayout();
		this.loginButton = new JButton("INGRESAR");
		this.newUserButton = new JButton("NUEVO USUARIO");
		
		this.lblUser = new JLabel("UserName");
		this.lblPassword = new JLabel("Password");
		
		this.txtUser = new JTextField();
		this.txtPass = new JPasswordField();
		
		ConfigurarPanel();
	}
	
	public void ConfigurarPanel()
	{
		final JPanel panel = this;
		
		this.setLayout(currentLayout);
		
		loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	panel.setVisible(false);
            }
        });
		
		this.add(loginButton);
		this.add(newUserButton);
		this.add(lblUser);
		this.add(lblPassword);
		this.add(txtUser);
		this.add(txtPass);
		
		currentLayout.putConstraint(SpringLayout.WEST, loginButton, 124, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.NORTH, lblUser, 49, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, lblUser, -240, SpringLayout.EAST, this);
		
		currentLayout.putConstraint(SpringLayout.NORTH, lblPassword, 19, SpringLayout.SOUTH, lblUser);
		currentLayout.putConstraint(SpringLayout.EAST, lblPassword, 0, SpringLayout.EAST, lblUser);
		
		currentLayout.putConstraint(SpringLayout.NORTH, txtUser, -3, SpringLayout.NORTH, lblUser);
		currentLayout.putConstraint(SpringLayout.WEST, txtUser, 25, SpringLayout.EAST, lblUser);
		currentLayout.putConstraint(SpringLayout.EAST, txtUser, -40, SpringLayout.EAST, this);
		
		currentLayout.putConstraint(SpringLayout.NORTH, loginButton, 20, SpringLayout.SOUTH, txtPass);
		currentLayout.putConstraint(SpringLayout.NORTH, txtPass, -3, SpringLayout.NORTH, lblPassword);
		currentLayout.putConstraint(SpringLayout.WEST, txtPass, 0, SpringLayout.WEST, txtUser);
		currentLayout.putConstraint(SpringLayout.EAST, txtPass, -40, SpringLayout.EAST, this);
		
		currentLayout.putConstraint(SpringLayout.SOUTH, newUserButton, -10, SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, newUserButton, -10, SpringLayout.EAST, this);
	}
}
