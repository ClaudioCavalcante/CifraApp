package com.claudio.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.tomcat.jdbc.pool.DataSource;




public class DataSourceFactory {
	
	
	private static final ThreadLocal<Connection> currentConnection = new ThreadLocal<Connection>();
	
	public static void openConnection(){
		try {
			DataSource ds  = new DataSource();	
			Context initCtx = new InitialContext();
			ds = (DataSource) initCtx.lookup("java:/comp/env/jdbc/CifraDB");
			
			if (currentConnection.get() == null) {
				currentConnection.set(ds.getConnection());
			}
				
			/*ds.setDriverClassName("com.mysql.jdbc.Driver");
			ds.setUrl("jdbc:mysql://localhost/cifra_db");
			ds.setUsername("admin_db");
			ds.setPassword("Rotina@123");*/
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}//fim de getConnection
	
	public static void closeConnection() {
		
		Connection c = currentConnection.get();
		try {
			if (c != null && !c.isClosed()) {
				c.close();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static Connection getConnection() {
		return currentConnection.get();
	}
	
}
