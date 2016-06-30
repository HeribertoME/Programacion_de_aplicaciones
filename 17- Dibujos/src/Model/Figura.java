package Model;

import java.awt.Graphics;

public interface Figura{
	public static final int PAISAJE = 1;
	public static final int GATO = 2;
	public static final int FLOR = 3;
	public static final int TREN = 4;
	
	public void dibuja(Graphics g);

}
