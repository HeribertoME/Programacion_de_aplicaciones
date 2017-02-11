package Model;

public class Option {
	
	public static Figura crearFigura (int opc){
		
		switch (opc){
		case Figura.PAISAJE: return new Paisaje(); 
		case Figura.GATO: return new Gato();
		case Figura.FLOR: return new Flor();
		case Figura.TREN: return new Tren();
		default: return null;
		}
		
	}

}
