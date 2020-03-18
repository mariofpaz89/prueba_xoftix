package Panel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrameUsuarios extends JFrame {

	private PanelUsuarios contentPane;

	/**
	 * Create the frame.
	 */
	public FrameUsuarios(String cadena) {
		super(cadena);
		contentPane = new PanelUsuarios();
		
		this.ConfigurarFrame();
	}
	
	public void ConfigurarFrame()
	{
		this.setContentPane(contentPane);
	}

}
