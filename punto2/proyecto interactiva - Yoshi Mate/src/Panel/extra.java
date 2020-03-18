package Panel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Random;

public class extra extends JPanel implements Runnable{

	private ImageIcon p = new ImageIcon("yoshy.gif");
	private JButton b = new JButton();	
	
	private ImageIcon p2 = new ImageIcon("yoshy.gif");
	private JButton b2 = new JButton();
	
	private ImageIcon p3 = new ImageIcon("yoshy.gif");
	private JButton b3 = new JButton();
	
	private ImageIcon p4 = new ImageIcon("yoshy.gif");
	private JButton b4 = new JButton();
		
	private ImageIcon p5 = new ImageIcon("yoshy.gif");
	private JButton b5 = new JButton();
	
	private Random ran = new Random();
	
	private Mario mario = new Mario("mario.gif", 55, 570); 
	private Huevo huevo = new Huevo("huevo.gif", 135, ran.nextInt(5)+1, true);
	
	private Thread hiloHuevo;

	private boolean estadoHilo;
	
	private Huevo[] muchosHuevos;
		
/////////////////////////////////////////////////////////////////////////////////	
	
	
	public extra(){
		super.setBackground(Color.BLACK);
		hiloHuevo=new Thread(this);
	
	
		for(int i=0; i<15; i++){
			muchosHuevos[i] = new Huevo("huevo.gif", 135, ran.nextInt(5)+1, true);
		}	
	}
	
	public Mario getmario() { return mario; }	 

	
	public void paint(Graphics g){
		super.paint(g);
		p.paintIcon(b, g, 50, 20);
		p2.paintIcon(b2, g, 180, 20);
		p3.paintIcon(b3, g, 310, 20);
		p4.paintIcon(b4, g, 440, 20);
		p5.paintIcon(b5, g, 570, 20);
		mario.dibuja(g);
		
		
		
	}
	
	public void iniciarHilo(){
		estadoHilo = true;
		hiloHuevo.start();
	}
	
	public void detenerHilo(){
		estadoHilo = false;
	}
	
	public void run(){
		
		//boolean agregar = false;
		while(estadoHilo){
			
			
			
			try{hiloHuevo.sleep(40);}
			catch(InterruptedException e){}
		}
	}
	

}