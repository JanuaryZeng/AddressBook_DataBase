package logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import windows.login;

public class Update {
	public static void ABUser( String UserPassWord,String User) {
		String str = "update ABUser set UserPassWord = ? where UserName = ?";
		PreparedStatement ps = Connect.getPreparedStatement(str);
		try {
			ps.setString(1, UserPassWord);
			ps.setString(2, User);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addNumber(String Cname, String UserId) {
		String str = "update Contacts set Cnumber = Cnumber + 1 where UserId = ? and CName = ?";
		PreparedStatement ps = Connect.getPreparedStatement(str);
		try {
			ps.setString(1, UserId);
			ps.setString(2, Cname);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void ABGroup(String GroupName, String oldName, String UserId) {
		String str = "update ABGroup set GroupName = ? where GroupName = ? and UserId = ?";
		PreparedStatement ps = Connect.getPreparedStatement(str);
		try {
			ps.setString(1, GroupName);
			ps.setString(2, oldName);
			ps.setString(3, UserId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void Contacts(UserData ud,String Cname,String UserId) {
		String str = "update Contacts set CName = ?, PhoneNumber = ?,MobileNumber = ?,EMail = ?,GroupName =?"
				+ ",UserId = ? ,Sex = ?,FamilyAddress = ?,QQ = ?,WeChat = ? where UserId = ? and Cname = ?";
		PreparedStatement ps = Connect.getPreparedStatement(str);
		try {
			ps.setString(1, ud.getName());
			ps.setString(2, ud.getPhone());
			ps.setString(3, ud.getMobile());
			ps.setString(4, ud.getEmail());
			ps.setString(5, ud.getGroupName());
			ps.setString(6, ud.getUserId());
			ps.setString(7, ud.getSex());
			ps.setString(8, ud.getFamilyAddress());
			ps.setString(9, ud.getQQ());
			ps.setString(10,ud.getWeChat());
			ps.setString(11, UserId);
			ps.setString(12, Cname);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void Note(NoteD nd,String Title, String Value) {
		String str = "update Note set Title = '"+Title+"', Value = '"
					+Value+"' where UserId = '"+login.string+"' and CName = '"+nd.getCName()+
					"' and Title = '"+nd.getTitle()+"' and NTime = '"+nd.getNtime()+"' and Way = '"
					+nd.getWay()+"'";
		Statement st = Connect.getStatement();
		try {
			st.executeUpdate(str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
