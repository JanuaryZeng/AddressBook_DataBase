package logic;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
	
	public static void ABUser(String UserName, String UserPassWord) {
		String str = "insert into ABGroup values(?,?)";
		PreparedStatement ps = Connect.getPreparedStatement(str);
		try {
			ps.setString(1, UserName);
			ps.setString(2, UserPassWord);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void Note(NoteD nd) {
		String str = "insert into Note values('"+ nd.getCName()+"','"+ nd.getWay()+"','"
						+ nd.Value+"','"+ nd.getTitle()+"','"+ nd.getUserId()+"','"
						+ nd.getNtime()+"','"+ nd.getNumber()+"')";
		System.out.println(str);
		Statement st = Connect.getStatement();
		try {
			st.executeUpdate(str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
