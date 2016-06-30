package Model;

import java.awt.Color;
import java.awt.Graphics;

public class Tren implements Figura{

	@Override
	public void dibuja(Graphics g) {
		// TODO Auto-generated method stub
		Color humo = new Color(189, 189, 189);
		g.setColor(humo);
		g.fillRect(90, 110, 10, 10);
		g.fillRect(100, 120, 10, 10);
		g.fillRect(120, 110, 10, 10);
		g.fillRect(120, 130, 10, 10);
		g.fillRect(140, 120, 10, 10);
		g.fillRect(150, 110, 10, 10);
		g.fillRect(170, 120, 20, 10);
		
		Color azul = new Color(69, 118, 167);
		g.setColor(azul);
		int tvx1 [] = {70, 150, 150, 160, 160, 180, 180, 190, 190, 180, 
				180, 190, 210, 220, 220, 210, 210, 220, 220, 230, 
				230, 220, 220, 230, 250, 220, 220, 190, 170, 160, 
				150, 140, 130, 120, 110, 90, 90, 100, 100, 110, 
				110, 90};
		int tvy1 [] = {150, 150, 190, 190, 180, 180, 190, 190, 170, 170, 
				150, 140, 140, 150, 170, 170, 190, 190, 200, 200, 
				220, 220, 230, 230, 260, 260, 240, 240, 220, 220, 
				230, 230, 220, 220, 230, 230, 210, 210, 200, 200, 
				170, 170};
		g.fillPolygon(tvx1, tvy1, 42);
		
		g.setColor(Color.BLACK);
		g.fillRect(120, 170, 20, 30);
		
		int tvx2 [] = {120, 130, 140, 140, 130, 120, 110, 110};
		int tvy2 [] = {230, 230, 240, 250, 260, 260, 250, 240};
		g.fillPolygon(tvx2, tvy2, 8);
		
		int tvx3 [] = {160, 170, 180, 180, 170, 160, 150, 150};
		int tvy3 [] = {230, 230, 240, 250, 260, 260, 250, 240};
		g.fillPolygon(tvx3, tvy3, 8);
		
		int tvx4 [] = {200, 210, 200, 190};
		int tvy4 [] = {240, 250, 260, 250};
		g.fillPolygon(tvx4, tvy4, 4);
		
	}
	
}
