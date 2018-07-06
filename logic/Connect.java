package logic;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connect {
	public static Statement getStatement() {
		Connection con = null;
		Statement sql = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://127.0.0.1:7040;databaseName=AddressBook";  
			con = DriverManager.getConnection(url,"sa","123456");
			sql = con.createStatement();
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {	
			e.printStackTrace();
		}
        return sql;
	}
	public static PreparedStatement  getPreparedStatement (String str) {
		Connection con = null;
		PreparedStatement  sql = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://127.0.0.1:7040;databaseName=AddressBook";  
			con = DriverManager.getConnection(url,"sa","123456");
			sql = con.prepareStatement(str);
        } catch (SQLException e) {
        	e.printStackTrace();
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return sql;
	}
}

