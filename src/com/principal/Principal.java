package com.principal;

import com.conexionMySql.ConexionMySql;

public class Principal {

	public static void main(String[] args) {
		ConexionMySql.getInstance().conectar();
		ConexionMySql.getInstance().desconectar();

	}

}
