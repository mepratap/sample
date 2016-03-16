package com.cubic.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractDAO {
	private static final String NEXT_SQL_QUERY="SELECT PERSON_SEQ.NEXTVAL FROM DUAL"; 
	protected Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection dbConnection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pratap", "pratap");
		return dbConnection;
	}
protected void close(final Connection connection){
	if(connection!=null){
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
protected void close(final PreparedStatement stmt){
	if(stmt!=null){
		try{
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
protected Long getNextSequence(final Connection connection) throws SQLException{
	Long id=null;
	PreparedStatement stmt=connection.prepareStatement(NEXT_SQL_QUERY);
	ResultSet result=stmt.executeQuery();
	if(result!=null && result.next()){
		id=result.getLong(1);
	}
	stmt.close();
	return id;
}
}
