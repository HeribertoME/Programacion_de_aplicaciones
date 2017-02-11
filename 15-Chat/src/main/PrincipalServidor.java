package main;

import singlenton.SinglentonSer;

/**
 * 
 * @author heriberto
 *
 */

public class PrincipalServidor {
	
	public static void main(String[] args){
		SinglentonSer ser = SinglentonSer.instancia();
		ser.conectar();		
	}	
}
