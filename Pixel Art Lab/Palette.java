import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

public class Palette{
	private int r;
	private int g;
	private int b;
	Color color;
	Color black;

	
	public Palette(int r, int g, int b){
		this.r = r;
		this.g = g;
		this.b = b;
		
		color = new Color(r, g, b);
		black = new Color(0,0,0);
		
	}
	
	public void drawMe(Graphics g, int x, int y){
		g.setColor(black);
		g.drawRect(x, y,40,40);
		
		g.setColor(color);
		g.fillRect(x, y,40,40);
		
	}
	
	public int getR(){
		return r;
	}
	
	public int getG(){
		return g;
	}
	
	public int getB(){
		return b;
	}
}