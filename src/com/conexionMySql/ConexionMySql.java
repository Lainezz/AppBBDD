package com.conexionMySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexionMySql {

	
	public String db = "notarbd";
    public String url = "jdbc:mysql://localhost/"+db;
    public String user = "root";
    public String pass = "";
	
	public Connection conectar() {
		Connection con = null;

        try{
            //cargamos el Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // creamos un enlace
            con = DriverManager.getConnection(this.url, this.user, this.pass);
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return con;
	}
}
