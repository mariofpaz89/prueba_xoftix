package Panel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.io.File;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class VentanaPrincipal extends JFrame {
	
	Clip tono_pausa;	
	private MiPanel panelDibujo;
	public boolean pausar = true;
	
	public VentanaPrincipal(String cadena){
		super(cadena);
	
		this.addWindowListener( new WindowAdapter() {
                		public void windowClosing(WindowEvent e) {
                    			VentanaPrincipal.this.windowClosed();
                		}
            		}
        	);
		panelDibujo = new MiPanel();
		getContentPane().add(panelDibujo);
		panelDibujo.iniciarHilo();
		
	}

	protected void windowClosed()  {
	        System.exit(0);
	}		
}

