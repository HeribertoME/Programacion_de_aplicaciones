package Model;

import java.awt.Graphics;

public class Paisaje implements Figura{

	@Override
	public void dibuja(Graphics g) {
				// Luna
				g.fillOval(30, 40, 80, 80);
				
				// Carretera
				g.drawLine(20, 280, 310, 280);
				g.drawLine(20, 330, 310, 330);
				g.fillRect(30, 300, 40, 10);
				g.fillRect(110, 300, 40, 10);
				g.fillRect(190, 300, 40, 10);
				g.fillRect(270, 300, 40, 10);
				
				// Casa
				g.drawRect(130, 170, 80, 80);	// Borde de la casa
				g.drawRect(140, 180, 20, 20);	// Ventana
				g.drawRect(180, 180, 20, 20);	// Ventana
				g.drawRect(160, 210, 20, 40);	// Puerta
				g.drawOval(160, 140, 20, 20);	// Luna
				// Vertices del triangulo
				int [] tx1 = {100, 170, 240};
				int [] ty1 = {170, 120, 170};
				
				g.drawPolygon(tx1,ty1,3);	// Techo
				
				// Niño
				g.drawOval(260, 220, 20, 20);	// Cabeza
				g.drawLine(270, 240, 270, 260);	// Cuerpo
				g.drawLine(270, 250, 260, 260);	// Brazo izq
				g.drawLine(270, 250, 280, 260);	// Brazo der
				g.drawLine(270, 260, 260, 280);	// Pierna izq
				g.drawLine(270, 260, 280, 280);	// Pierna der
				
				
				//Globo
				g.drawOval(280, 200, 30, 30);
				g.drawLine(280, 230, 280, 220);
				g.drawLine(280, 230, 290, 230);
				g.drawString("Hola", 281, 220);
									
	}
	
}
