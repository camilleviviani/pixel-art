import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.net.URL;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JPanel implements ActionListener, MouseListener{
	Square[][] grid;
	Palette[][] palette;
	private int x;
	private int y;
	private int x2;
	private int y2;
	private int r;
	private int g;
	private int b;

	
	public Screen(){
		addMouseListener(this);
		grid = new Square[16][16];
		palette = new Palette[6][6];
		
		for(int r=0; r<grid.length; r++){
			for(int c=0; c<grid[r].length; c++){
				grid[r][c] = new Square(255,255,255);
			}
		}
		
		//purple
		palette[0][0] = new Palette(216,191,216);
		palette[0][1] = new Palette(128,0,128);
		palette[0][2] = new Palette(147,112,219);
		palette[0][3] = new Palette(148,0,211);
		palette[0][4] = new Palette(128,0,128);
		palette[0][5] = new Palette(75,0,130);
		
		//yellow
		palette[1][0] = new Palette(255,255,153);
		palette[1][1] = new Palette(255,228,81);
		palette[1][2] = new Palette(255,228,181);
		palette[1][3] = new Palette(238,232,170);
		palette[1][4] = new Palette(255,239,213);
		palette[1][5] = new Palette(240,230,140);
		
		//blue
		palette[2][0] = new Palette(176,224,230);
		palette[2][1] = new Palette(70,130,180);
		palette[2][2] = new Palette(100,149,237);
		palette[2][3] = new Palette(102,205,170);
		palette[2][4] = new Palette(64,224,208);
		palette[2][5] = new Palette(0,128,128);
		
		//green
		palette[3][0] = new Palette(144,238,144);
		palette[3][1] = new Palette(46,139,87);
		palette[3][2] = new Palette(60,179,113);
		palette[3][3] = new Palette(107,142,35);
		palette[3][4] = new Palette(34,139,34);
		palette[3][5] = new Palette(124,252,0);
		
		
		//pink
		palette[4][0] = new Palette(255,182,193);
		palette[4][1] = new Palette(199,21,133);
		palette[4][2] = new Palette(219,112,147);
		palette[4][3] = new Palette(255,20,147);
		palette[4][4] = new Palette(219,112,147);
		palette[4][5] = new Palette(255,105,180);
		
		//red
		palette[5][0] = new Palette(240,128,128);
		palette[5][1] = new Palette(220,20,60);
		palette[5][2] = new Palette(205,92,92);
		palette[5][3] = new Palette(255,69,0);
		palette[5][4] = new Palette(255,99,71);
		palette[5][5] = new Palette(205,92,92);
		
		r = 255;
		g = 255;
		b = 255;
	}
	
	public Dimension getPreferredSize(){
		//Sets the size of the panel
        return new Dimension(800,600);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		x = 50;
		y = 50;
		
		x2 = 530;
		y2 = 100;
		
		for(int r=0; r<grid.length-1; r++){
			for(int c=0; c<grid[r].length-1; c++){
				grid[r][c].drawMe(g,x,y);
				x += 30;
			}
			y+= 30;	
			x = 50;
		}
		
		for(int r=0; r<palette.length; r++){
			for(int c=0; c<palette[r].length; c++){
				palette[r][c].drawMe(g,x2,y2);
				x2 += 40;
			}
			y2+= 40;	
			x2 = 530;
		}
	}
	
	public void mousePressed(MouseEvent e){
		//Print location of x and y
        System.out.println("X: " + e.getX() + ", Y: " + e.getY());
 		int col = 0;
 		int row = 0;
 		
 		int col2 = 0;
 		int row2 = 0;
 		

 		if(e.getX() >=530 && e.getX() <= 770 && e.getY() >= 100 && e.getY() <= 340 ){
 			col2 = (int)((e.getX() - 550)/40);
 			row2 = (int)((e.getY() - 100)/40);
 			
 			r = palette[row2][col2].getR();
 			g = palette[row2][col2].getG();
 			b = palette[row2][col2].getB();
 			
 			
 		}
 		
 		if(e.getX() >=50 && e.getX() <= 530 && e.getY() >= 50 && e.getY() <= 530 ){
 			col = (int)((e.getX() - 50)/30);
 			row = (int)((e.getY() - 50)/30);
 			grid[row][col].changeColor(r,g,b);
 		}
 		  
        repaint();   
	}

	public void mouseReleased(MouseEvent e){
	
	}
	
	public void mouseEntered(MouseEvent e){
	
	}
	
	public void mouseExited(MouseEvent e){
	
	}
	
	public void mouseClicked(MouseEvent e){
	
	}
	
	public void actionPerformed(ActionEvent e){
	
	}


}