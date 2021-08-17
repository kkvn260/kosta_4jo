package group4.comm;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection {
	private static DBConnection instance=new DBConnection();
	public static DBConnection getDBConn() {
		return instance;
	}
	private DBConnection () {}
	
	public Connection getConnection() throws NamingException,SQLException {
		InitialContext initContext=new InitialContext();
		DataSource ds=(DataSource)initContext.lookup("java:comp/env/jdbc/kosta");
		Connection conn=ds.getConnection();
		 
		return conn;
	}
}