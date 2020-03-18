package Panel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Mario {
	
	private int coorx;
	private int coory;
	private int atrapados;
	
	private ImageIcon mario;
	private JButton b_mario = new JButton();
	
	////////////////////////////////////////////////////
	
	public int getcoorx() { return coorx; }	
	public void setcoorx(int coorx) { this.coorx = coorx; }

	public int getcoory() { return coory; }	
	public void setcoory(int coory) { this.coory = coory; }
	
	public int getatrapados() { return atrapados; }	
	
	////////////////////////////////////////////////////
	
    public Mario(String nombre, int coorx, int coory) {
    	this.coorx = coorx;
    	this.coory = coory;
    	mario = new ImageIcon(nombre);
    	atrapados=0;
    }
    
    public boolean atrapar(Huevo huevo){
    	
    	if(huevo.getcoorx()+18 >= this.getcoorx() && huevo.getcoorx()+18 <= this.getcoorx()+81 && huevo.getcoory()+22 >= this.getcoory() && huevo.getcoory()+22 <= this.getcoory()+40 )
    	{
    		atrapados++;
    		return true;
	    }
	    else return false;
    }
    
    public void dibuja(Graphics g){
    	mario.paintIcon(b_mario, g, coorx, coory);
    	
    }
    public void mueve( int k){
        if(k == KeyEvent.VK_LEFT){
        	if(coorx >= 180) 
        	{
        		coorx -= 132;
        	}
        }
        if(k == KeyEvent.VK_RIGHT){
        	if(coorx <= 500) 
        	{
        		coorx += 132;
        	}
        }
    } 
}