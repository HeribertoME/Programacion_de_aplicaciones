
public class Fabrica {
	
	public static Animal crearObjeto(int tipo)
	{
		switch( tipo){
		case Animal.PERRO: return new Perro();
		case Animal.GATO: return new Gato();
		case Animal.ZORRO: return new Zorro();
		default: return null;

		}
		
	}

}
