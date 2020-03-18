package Panel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Huevo {
	
	private int coorx;
	private int coory;
	
	private ImageIcon huevo;
	private JButton b_huevo = new JButton();
	
	private int posicion;
	private boolean existe;
	
	////////////////////////////////////////////////////
	
	public int getcoorx() { return coorx; }	
	public void setcoorx(int coorx) { this.coorx = coorx; }

	public int getcoory() { return coory; }	
	public void setcoory(int coory) { this.coory = coory; }
	
	public int getposicion() { return posicion; }	
	public void setposicion(int posicion) { this.posicion = posicion; }

	public boolean getexiste() { return existe; }	
	public void setexiste(boolean existe) { this.existe = existe; }

////////////////////////////////////////////////////////

    public Huevo(String nombre, int coory, int posicion, boolean existe) {
    	this.coory=coory;
    	this.existe = existe;
    	this.posicion = posicion;
    	huevo =new ImageIcon(nombre);
    	
    }
    
    
    public void dibuja(Graphics g){	
    	if(this.posicion == 1) { coorx=84; }
    	if(this.posicion == 2) { coorx=214; }
    	if(this.posicion == 3) { coorx=344; }
    	if(this.posicion == 4) { coorx=474; }
    	if(this.posicion == 5) { coorx=604; }
    	if(existe)   huevo.paintIcon(b_huevo, g, coorx, coory);
    }
    
    public void mueve(){
    	if(existe)   coory +=5;
    }
 	public boolean compara(int linea){
 		if(coory == linea) return true;
 		else return false;
 		}   
}