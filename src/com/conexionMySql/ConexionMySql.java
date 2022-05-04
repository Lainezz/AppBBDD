package com.conexionMySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexionMySql {

	/**
	 * Base de datos remota
	 */
	private String DB = "bdpeliculas";
    private String URL = "jdbc:mysql://localhost/"+this.DB;
    private String USER = "root";
    private String PASS = "";
    
    /**
     * Variable de clase que contiene la conexion a la BBDD
     */
    private Connection conn;
    /**
     * Variable de clase donde se va a guardar la instancia de la clase. Esta va a ser única.
     */
    public static ConexionMySql instancia;
    
    /**
     * Método para devolver la instancia única de clase.
     * @return instancia de la clase {@link ConexionMySql}
     */
    public static ConexionMySql getInstance() {
    	if(instancia == null) {
    		instancia = new ConexionMySql();
    	}
    	return instancia;
    }
    
    /**
     * Constructor de clase en privado para poder realizar el patron singleton de manera correcta.
     * Para llamar a la clase se debe utilizar el metodo {@link #getInstance()} que devuelve un objeto (unico) de tipo {@link ConexionMySql}
     * @see <a href="https://refactoring.guru/design-patterns/singleton">Patron Singleton</a>
     */
    private ConexionMySql() {}
	
    /**
     * Metodo que realiza una conexion a una base de datos MySQL.
     * La conexion la guarda en {@link #conn}
     */
	public void conectar() {
        try{
            //cargamos el Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // creamos la conexion
            conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
	}
	
	/**
	 * Metodo que, en el caso de existir una conexion a una base de datos, realiza la desconexion de la misma.
	 */
	public void desconectar() {
		try {
			if(conn != null || !conn.isClosed()) {
				conn.close();
				System.out.println("[Desconectado]");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
