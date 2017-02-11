package main;

import singlenton.SinglentonCli;

/**
 * 
 * @author heriberto
 *
 */

public class PrincipalCliente {
	
	public static void main(String[] args){
		SinglentonCli cli = SinglentonCli.instancia();
		cli.conectar();
	}

}
