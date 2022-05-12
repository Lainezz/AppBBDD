package com.principal;

import com.conexionMySql.ConexionMySql;

public class Principal {

	public static void main(String[] args) {
		//Prueba de comentario
		ConexionMySql.getInstance().conectar();
		ConexionMySql.getInstance().desconectar();

	}

}
