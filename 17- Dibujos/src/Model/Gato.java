package Model;

import java.awt.Color;
import java.awt.Graphics;

public class Gato implements Figura{

	@Override
	public void dibuja(Graphics g) {
		int tvx1 [] = {120, 140, 140, 120, 110, 110, 130, 150, 170, 170, 
				190, 230, 250, 250, 220, 200, 170, 170, 180, 180, 
				150, 150, 130, 120, 120, 140, 140, 100, 90, 90};
		int tvy1 [] = {120, 120, 130, 150, 150, 180, 160, 160, 180, 140, 
				160, 160, 140, 200, 220, 220, 200, 230, 230, 250, 
				250, 210, 210, 220, 230, 230, 250, 250, 190, 150};
		Color gris = new Color(181, 190, 199);
		g.setColor(gris);
		g.fillPolygon(tvx1, tvy1, 30);
		
		Color azul = new Color(87, 149, 210);
		g.setColor(azul);
		g.fillRect(180, 170, 20, 20);
		g.fillRect(220, 170, 20, 20);
		
		g.setColor(Color.black);
		g.fillOval(185, 175, 10, 10);
		g.fillOval(225, 175, 10, 10);
		
		int tvx2 [] = {200, 210, 220};
		int tvy2 [] = {200, 190, 200};
		Color rosa = new Color (248, 219, 247);
		g.setColor(rosa);
		g.fillPolygon(tvx2, tvy2, 3);
	}

}
