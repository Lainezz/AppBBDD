package com.conexionMySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexionMySql {

	
	public String db = "bdpeliculas";
    public String url = "jdbc:mysql://localhost/"+db;
    public String user = "root";
    public String pass = "";
    
    private Connection conn;
    
    public static ConexionMySql instancia;
    
    public static ConexionMySql getInstance() {
    	if(instancia == null) {
    		instancia = new ConexionMySql();
    	}
    	return instancia;
    }
    
    private ConexionMySql() {
    	
    }
	
	public Connection conectar() {
        try{
            //cargamos el Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // creamos un enlace
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return conn;
	}
	
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
