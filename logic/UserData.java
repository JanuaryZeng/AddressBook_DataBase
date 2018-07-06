package logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import windows.login;

public class UserData {
	String name;
	String phone;
	String mobile;
	String email;
	String groupName;
	String userId;
	String sex;
	String familyAddress;
	String QQ;
	String WeChat;
	int Cnumber;
	PreparedStatement st;
	ResultSet rs;
	Boolean bool = true;

//	public static void main(String args[]) {
//		UserData ud = new UserData("January");
//		while(ud.bool) {
//			System.out.print(ud.name);
//			System.out.print(ud.phone);
//			System.out.print(ud.mobile);
//			System.out.print(ud.email);
//			System.out.print(ud.groupName);
//			System.out.print(ud.userId);
//			System.out.print(ud.sex);
//			System.out.print(ud.familyAddress);
//			System.out.print(ud.QQ);
//			System.out.print(ud.WeChat);
//			ud.next();
//			System.out.println();
//			}
//	}
	public UserData(String userId){
		String str = "select * from Contacts where UserId = ?";
		st = Connect.getPreparedStatement(str);
		try {
			st.setString(1, userId);
			rs = st.executeQuery();
			
			if(rs.next()) {
				name = rs.getString(1);
				phone = rs.getString(2);
				mobile = rs.getString(3);
				email = rs.getString(4);
				groupName = rs.getString(5);
				userId = rs.getString(6);
				sex = rs.getString(7);
				familyAddress = rs.getString(8);
				QQ = rs.getString(9);
				WeChat = rs.getString(10);
				Cnumber = rs.getInt(11);
				bool = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public UserData(String userId, String group){
		String str = "select * from Contacts where UserId = ? and GroupName = ?";
		st = Connect.getPreparedStatement(str);
		try {
			st.setString(1, userId);
			st.setString(2, group);
			rs = st.executeQuery();
			
			if(rs.next()) {
				name = rs.getString(1);
				phone = rs.getString(2);
				mobile = rs.getString(3);
				email = rs.getString(4);
				groupName = rs.getString(5);
				userId = rs.getString(6);
				sex = rs.getString(7);
				familyAddress = rs.getString(8);
				QQ = rs.getString(9);
				WeChat = rs.getString(10);
				Cnumber = rs.getInt(11);
				bool = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public UserData(String userId ,String CName,boolean b){
		if(b) {
		String str = "select * from Contacts where UserId = ? and CName = ?";
		st = Connect.getPreparedStatement(str);
		try {
			st.setString(1, userId);
			st.setString(2, CName);
			rs = st.executeQuery();
			
			if(rs.next()) {
				name = rs.getString(1);
				phone = rs.getString(2);
				mobile = rs.getString(3);
				email = rs.getString(4);
				groupName = rs.getString(5);
				userId = rs.getString(6);
				sex = rs.getString(7);
				familyAddress = rs.getString(8);
				QQ = rs.getString(9);
				WeChat = rs.getString(10);
				Cnumber = rs.getInt(11);
				bool = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else {
			
		}
	}
	public UserData(String userId,boolean b) {
		String str = "select * from Contacts where Cnumber>=5 and UserId = ? order by Cnumber DESC";
		st = Connect.getPreparedStatement(str);
		try {
			st.setString(1, userId);
			rs = st.executeQuery();
			
			if(rs.next()) {
				name = rs.getString(1);
				phone = rs.getString(2);
				mobile = rs.getString(3);
				email = rs.getString(4);
				groupName = rs.getString(5);
				userId = rs.getString(6);
				sex = rs.getString(7);
				familyAddress = rs.getString(8);
				QQ = rs.getString(9);
				WeChat = rs.getString(10);
				Cnumber = rs.getInt(11);
				bool = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void next() {
		try {
			if(rs.next()) {
				name = rs.getString(1);
				phone = rs.getString(2);
				mobile = rs.getString(3);
				email = rs.getString(4);
				groupName = rs.getString(5);
				userId = rs.getString(6);
				sex = rs.getString(7);
				familyAddress = rs.getString(8);
				QQ = rs.getString(9);
				WeChat = rs.getString(10);
				Cnumber = rs.getInt(11);
				bool = true;
			}
			else {bool = false; return;}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

	public String getGroupName() {
		return groupName;
	}

	public String getUserId() {
		return userId;
	}

	public String getSex() {
		return sex;
	}

	public String getFamilyAddress() {
		return familyAddress;
	}

	public String getQQ() {
		return QQ;
	}

	public String getWeChat() {
		return WeChat;
	}

	public Boolean getBool() {
		return bool;
	}
	public int getCnumber() {
		return Cnumber;
	}

	public void setCnumber(int cnumber) {
		Cnumber = cnumber;
	}
	
	public void setWeChat(String weChat) {
		WeChat = weChat;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setFamilyAddress(String familyAddress) {
		this.familyAddress = familyAddress;
	}

	public void setQQ(String qQ) {
		QQ = qQ;
	}

	public void setBool(Boolean bool) {
		this.bool = bool;
	}


}
