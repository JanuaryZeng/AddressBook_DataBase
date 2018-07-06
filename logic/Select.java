package logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import windows.login;

public class Select {
	
	public static ResultSet Contacts(String column, String CName, String User) {
		String str = "select ? from Contacts where UserId = ? and CName = ?";
		ResultSet rs = null;
		PreparedStatement st = Connect.getPreparedStatement(str);
		try {
			st.setString(1, column);
			st.setString(2, User);
			st.setString(3, CName);
			rs = st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static ResultSet Contacts(String column, String columnName) {
		String str = "select * from Contacts where UserId = '"+login.string +"' and "+columnName+" = '"+column+"'";
		Statement st = Connect.getStatement();
		try {
			ResultSet rs = st.executeQuery(str);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static ResultSet ABGroup(String GroupName, String User) {
		String str = "select GroupName from ABGroup where UserId = ? and GroupName = ?";
		ResultSet rs = null;
		PreparedStatement st = Connect.getPreparedStatement(str);
		try {
			st.setString(1, User);
			st.setString(2, GroupName);
			rs = st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static ResultSet ABGroup() {
		String str = "select GroupName from ABGroup where UserId = ?";
		ResultSet rs = null;
		PreparedStatement st = Connect.getPreparedStatement(str);
		try {
			st.setString(1, login.string);
			rs = st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static ResultSet ABUser(String Password,String User) {
		String str = "select UserPassword from ABUser where UserName = ? and UserPassword = ?";
		ResultSet rs = null;
		PreparedStatement st = Connect.getPreparedStatement(str);
		try {
			st.setString(1, User);
			st.setString(2, Password);
			rs = st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static ResultSet ABUser(String User) {
		String str = "select UserPassword from ABUser where UserName = '"+User+"'";
		Statement st = Connect.getStatement();
		ResultSet rs = null;
		try {
			rs = st.executeQuery(str);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static ResultSet getResultSet(String table, String column, String where, String string,String user) {
		String str = "select ? from ? where UserId = ? and ? = ?";
		PreparedStatement st = Connect.getPreparedStatement(str);
		ResultSet rs = null;
		try {
			st.setString(1, column);
			st.setString(2, table);
			st.setString(3, user);
			st.setString(4, where);
			st.setString(5, string);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public static ResultSet Note(String UserId,String columnName,String column) {
		String str = "select * from Note where UserId = '"+ UserId+"' and "+columnName+" = '"+column+"'";
		Statement st = Connect.getStatement();
		try {
			ResultSet rs = st.executeQuery(str);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static ResultSet ABUser() {
		String str = "select * from ABUser";
		Statement st = Connect.getStatement();
		try {
			ResultSet rs = st.executeQuery(str);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
