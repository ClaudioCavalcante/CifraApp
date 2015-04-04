package com.claudio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.claudio.jdbc.DataSourceFactory;

public abstract class BaseDAO {

	protected PreparedStatement stmt;
	protected ResultSet rs;
	protected Connection connection = DataSourceFactory.getConnection();
	
	
	protected void setStatement(String context) throws SQLException{
		stmt = connection.prepareStatement(context);
	}//fim de setStatement
	
	protected void endConnection() throws SQLException{
		rs.close();
		stmt.close();
	}//fim de endConnection()
}//fim da classe BaseDAO
