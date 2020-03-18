package Panel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.io.File;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Ventana extends JFrame implements KeyListener{
	
	Clip tono_pausa;	
	private MiPanel panelDibujo;
	public boolean pausar = true;
	
	public Ventana(String cadena){
		super(cadena);
	
		this.addWindowListener( new WindowAdapter() {
                		public void windowClosing(WindowEvent e) {
                    			Ventana.this.windowClosed();
                		}
            		}
        	);
		panelDibujo = new MiPanel();
		getContentPane().add(panelDibujo);
		addKeyListener(this);
		panelDibujo.iniciarHilo();
		
	}

	protected void windowClosed()  {
	        System.exit(0);
	}
	
	public void keyReleased(KeyEvent k){}
	public void keyTyped(KeyEvent k){}
	
	public void keyPressed(KeyEvent k){
		panelDibujo.getmario().mueve(k.getKeyCode());
		panelDibujo.repaint();
		
		char pausa = k.getKeyChar();
			if(pausa == 'p' || pausa == 'P'){
				if(pausar){
					panelDibujo.hiloHuevo.suspend();
					//panelDibujo.detenerHilo();
					pausar = false;
					try {
            			tono_pausa = AudioSystem.getClip();
            			tono_pausa.open(AudioSystem.getAudioInputStream(new File("sonidos/pause.wav")));
            			tono_pausa.start();
            			tono_pausa.loop(0);
          				//  Thread.sleep(10000);
          			} 
        	     	catch (Exception eventoINICIO){}
				
				}
				else{
					panelDibujo.hiloHuevo.resume();
					pausar = true;
									
				}
			}
		}
			

}

