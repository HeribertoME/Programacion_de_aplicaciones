package Model;

import java.awt.Color;
import java.awt.Graphics;

public class Flor implements Figura{

	@Override
	public void dibuja(Graphics g) {
		// TODO Auto-generated method stub
		// Hojas
				int tvx1 [] = {10, 50, 70, 90, 110, 110, 90, 90, 130, 170, 
						210, 210, 190, 190, 210, 230, 250, 290, 290, 250, 
						230, 210, 190, 190, 210, 210, 170, 130, 90, 90, 
						110, 110, 90, 70, 50, 10};
				int tvy1 [] = {150, 110, 110, 130, 130, 110, 90, 70, 30, 30, 
						70, 90, 110, 130, 130, 110, 110, 150, 190, 230, 
						230, 210, 210, 230, 250, 270, 310, 310, 270, 250, 230, 210, 210, 230, 230, 190};
				Color morado2 = new Color(132, 107, 161);
				g.setColor(morado2);
				g.fillPolygon(tvx1, tvy1, 36);
				
				// Boton
				int tvx2 [] = {130, 170, 190, 190, 170, 130, 110, 110};
				int tvy2 [] = {130, 130, 150, 190, 210, 210, 190, 150};
				Color morado = new Color(61, 51, 72);
				g.setColor(morado);
				g.fillPolygon(tvx2, tvy2, 8);
				
				// Tallo
				g.drawLine(190, 210, 290, 310);
				g.drawLine(290, 310, 290, 350);
				
				// Hojas de tallo
				g.drawLine(290, 310, 250, 290);
				int tvx3 []	= {210, 250, 230, 190, 190};
				int tvy3 [] = {290, 290, 350, 350, 330};
				Color verde = new Color(59, 136, 83);
				g.setColor(verde);
				g.fillPolygon(tvx3, tvy3, 5);
				int tvx4 [] = {270, 280, 290, 310, 310, 300};
				int tvy4 [] = {290, 250, 250, 270, 310, 290};
				g.fillPolygon(tvx4, tvy4, 6);
		
	}

}
