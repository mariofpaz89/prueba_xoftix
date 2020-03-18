package Panel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Random;

import java.io.File;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

//boolean pausar = true;
public class MiPanel extends JPanel implements Runnable{
	
	private ImageIcon inicio2 = new ImageIcon("imagenes/fondo.gif");
	private JButton b_inicio = new JButton();
	
	private ImageIcon p = new ImageIcon("imagenes/yoshy.gif");
	private JButton b = new JButton();	

	private ImageIcon p2 = new ImageIcon("imagenes/yoshy.gif");
	private JButton b2 = new JButton();
	
	private ImageIcon p3 = new ImageIcon("imagenes/yoshy.gif");
	private JButton b3 = new JButton();
	
	private ImageIcon p4 = new ImageIcon("imagenes/yoshy.gif");
	private JButton b4 = new JButton();
		
	private ImageIcon p5 = new ImageIcon("imagenes/yoshy.gif");
	private JButton b5 = new JButton();
	
	private ImageIcon fondo = new ImageIcon("imagenes/fondo.gif");
	private JButton b_fondo = new JButton();
	
	
	
	private Random ran = new Random();
	
	private Mario mario = new Mario("imagenes/mario.gif", 55, 570); 
	private Huevo huevo = new Huevo("imagenes/huevo.gif", 135, ran.nextInt(5)+1, true);
	private Huevo vida = new Huevo("imagenes/estrella.gif", 135, ran.nextInt(5)+1, false);
	
	public Thread hiloHuevo;

	private boolean estadoHilo;
	boolean existe = true;
	private ArrayList listaHuevo = new ArrayList();
	boolean mensajeVida = false;
	boolean mensajeLevel = false;
	boolean mensajeFin = false;
	boolean ganaVida = false;
	boolean inicio = false;
	int aux;
	
	int perdidos;
	int atrapados;
	int restantes;
	int vidas;
	int nivel;
	int puntos;
	int cuenta_huevos;
	
	Clip tono_vida;
	Clip tono_perder;
	
		
/////////////////////////////////////////////////////////////////////////////////	
	public MiPanel(){
		perdidos=0;
		atrapados=0;
		restantes=15;
		vidas=3;
		nivel=1;
		puntos=0;
		cuenta_huevos=0;
		super.setBackground(Color.BLACK);
		hiloHuevo=new Thread(this);
		for(int i=0; i<6; i++){
			listaHuevo.add(new Huevo("imagenes/huevo.gif", 135, ran.nextInt(5)+1, false));
		}
	}
	
	
	public Mario getmario() { return mario; }	 

	public void paint(Graphics g){
		super.paint(g);
		inicio2.paintIcon(b_inicio, g, 0, 0);
		fondo.paintIcon(b_fondo, g, 0, 0);
	//	g.drawImage(fondo, getHeight(), getWidth());
		p.paintIcon(b, g, 50, 40);
		p2.paintIcon(b2, g, 180, 40);
		p3.paintIcon(b3, g, 310, 40);
		p4.paintIcon(b4, g, 440, 40);
		p5.paintIcon(b5, g, 570, 40);
		mario.dibuja(g);
		
		if(inicio){
			estadoHilo = true;
			hiloHuevo.start();
			
		}
			
		if(ganaVida){
			vida.setexiste(true);
			vida.dibuja(g);
		}
		
		for(Object o: listaHuevo){
			Huevo h =(Huevo)o;
		//	if( h.getexiste() ){
			   h.dibuja(g); 
		//	}
		}
		g.setColor(Color.white);
		g.setFont( new Font( "SansSerif", Font.BOLD,14 ) );	
		g.drawString("VIDAS : " + vidas,80,30);
		g.drawString("PERDIDOS : " + perdidos,190,30);
		g.drawString("NIVEL : " + nivel,325,30);
	  	g.drawString("RESTANTES : " + restantes,450,30);
		g.drawString("PUNTOS : " + puntos,600,30);
	    
	    if( !estadoHilo ){
	    	g.setFont( new Font( "SansSerif", Font.BOLD,36 ) );	
	    	g.drawString( "GAME OVER", 280, 300 );
	    }
	 	/*if(){
	    	g.setFont( new Font( "SansSerif", Font.BOLD,36 ) );	
	    	g.drawString( "PAUSA", 300, 300 );
	    }*/
	}
	
	public void iniciarHilo(){
		estadoHilo = true;
		hiloHuevo.start();
	}
	
	public void detenerHilo(){
		estadoHilo = false;
	}
	
	public void run(){
		boolean a =false;
		listaHuevo.add(huevo);
		aux=2;
		int linea = 350;	
		int t = 40;
		
		while(estadoHilo){
			
			vida.mueve();
			if(mario.atrapar(vida)){
				vidas++;
				vida.setexiste(false);
				ganaVida=false;
				vida.setcoory(135);
				vida.setposicion(ran.nextInt(5)+1);
				
				try {
            			tono_vida = AudioSystem.getClip();
            			tono_vida.open(AudioSystem.getAudioInputStream(new File("sonidos/up.wav")));
            			tono_vida.start();
            			tono_vida.loop(0);
          				//  Thread.sleep(10000);
          		} 
        	     catch (Exception eventoINICIO){}
				 
			}
			
			for(Object o : listaHuevo){
				Huevo h = (Huevo)o;
				h.mueve();
				
				if(mario.atrapar(h)){
					atrapados++;
					restantes--;
					cuenta_huevos++;
	    			puntos += 500;
					h.setcoory(135);
					h.setposicion(ran.nextInt(5)+1);
					
				}
				
				if(a){
					h.setexiste(true);
			     	//h.setposicion(ran.nextInt(5)+1);
					}
				 
				if(h.compara(linea) && atrapados == aux){
					//h.getposicion();
	                aux+=10;	
	                a = true;
		            linea -=50;
		            t-=2;
		            //listaHuevo.remove(h);
		          	//listaHuevo.add(new Huevo("huevo.gif", 135, ran.nextInt(5)+1, true));
										
				}
				
				else
					 a = false;
				
				if(h.compara(750)){
					perdidos++;
					h.setcoory(135);
					h.setposicion(ran.nextInt(5)+1);
				}
				
				if(perdidos == 3){
	    			vidas--;
	    			perdidos = 0;
	    		}
	    		
	    		if(restantes == 0){
	   				nivel++;
	   				restantes = 15;
	   				
	    		}
	    		
	    		if(cuenta_huevos == 40){
	    			ganaVida=true;
	    			cuenta_huevos = 0;
	    		}
	    	
	    		if(vidas <= 0 || nivel == 60){
	    			detenerHilo();	
	    			try {
            			tono_perder = AudioSystem.getClip();
            			tono_perder.open(AudioSystem.getAudioInputStream(new File("sonidos/gameover.wav")));
            			tono_perder.start();
            			tono_perder.loop(0);
          				//  Thread.sleep(10000);
          			} 
        	     	catch (Exception eventoINICIO){}
	    		}
	    		
				repaint();
	    	
	    		
			}//For
			
	    		
			try{hiloHuevo.sleep(t);}
			catch(InterruptedException e){}
		}//While
		tono_vida.close();
	}//Run

}
	

