package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionFactory {
	
	public static Connection getConnection(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return  DriverManager.getConnection("jdbc:mysql://localhost/dangerzone","root","");
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE,null,ex);
			throw new RuntimeException("Erro SqlException ao abrir conexão  em ConectionFactory",ex);
		} catch (ClassNotFoundException e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE,null,e);
			throw new RuntimeException("Erro ClassNotFoundException em ConectionFactory",e);
		}
	}
}
