package logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import windows.login;

public class NoteD {
	public String CName;
	public String Way;
	public String Value;
	public String Title;
	public String UserId;
	public String Ntime;
	public String Number;
	ResultSet rs;
	public boolean bool;
	
	public NoteD(){
		String str = "select * from Note where UserId = ?";
		PreparedStatement ps = Connect.getPreparedStatement(str);
		try {
			ps.setString(1, login.string);
			rs = ps.executeQuery();
			if(rs.next()) {
				CName = rs.getString(1);
				Way = rs.getString(2);
				Value = rs.getString(3);
				Title = rs.getString(4);
				UserId = rs.getString(5);
				Ntime = rs.getString(6);
				Number = rs.getString(7);
				bool = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public NoteD(String date, String Cname, String way, String title){
		String str = "select * from Note where UserId = '"+login.string+"' and Ntime = '"
						+date+"' and Way = '"+way+ "' and Title = '"+ title+"' and CName = '"
						+ Cname+"'";
		Statement st = Connect.getStatement();
		ResultSet rs;
		try {
			rs = st.executeQuery(str);
			if(rs.next()) {
				CName = rs.getString(1);
				Way = rs.getString(2);
				Value = rs.getString(3);
				Title = rs.getString(4);
				UserId = rs.getString(5);
				Ntime = rs.getString(6);
				Number = rs.getString(7);
				bool = true;
			}	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void next() {
		try {
			if(rs.next()) {
				CName = rs.getString(1);
				Way = rs.getString(2);
				Value = rs.getString(3);
				Title = rs.getString(4);
				UserId = rs.getString(5);
				Ntime = rs.getString(6);
				Number = rs.getString(7);
				bool = true;
			}
			else {
				bool = false; return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getCName() {
		return CName;
	}

	public void setCName(String cName) {
		CName = cName;
	}

	public String getWay() {
		return Way;
	}

	public void setWay(String way) {
		Way = way;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getNtime() {
		return Ntime;
	}

	public void setNtime(String ntime) {
		Ntime = ntime;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

}
