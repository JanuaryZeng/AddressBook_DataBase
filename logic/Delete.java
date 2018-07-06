package logic;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import windows.login;

public class Delete {
	public static void values(String table,String user, String where, String string) {
		String str = "delete from ? where UserId = ? and ? = ?";
		PreparedStatement ps = Connect.getPreparedStatement(str);
		try {
			ps.setString(1, table);
			ps.setString(2, user);
			ps.setString(3, where);
			ps.setString(4, string);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void Note(NoteD nd) {
		String str = "delete from Note where UserId = '"+nd.getUserId()+"' and Ntime = '"
				+nd.getNtime()+"' and Way = '"+nd.getWay()+ "' and Title = '"+ nd.getTitle()+"' and CName = '"
				+ nd.getCName()+"'";
		Statement st = Connect.getStatement();
		try {
			st.executeUpdate(str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
