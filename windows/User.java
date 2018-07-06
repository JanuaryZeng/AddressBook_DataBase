package windows;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import logic.Connect;
import logic.Select;
import logic.Update;
import logic.UserData;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;

public class User extends JFrame {
	private static final String JButton = null;
	private JTextField textField;
	private Container scollPane;
	private String[] head = new String[] {"姓名", "座机号", "电话号", "邮箱", "组别", "家庭住址","QQ","微信"};
	private JTable table;
	static int iq = 0;

	
	public User() {
		setTitle("\u8054\u7CFB\u4EBA\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1032, 453);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u529F\u80FD");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u6CE8\u518C");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Registe rgt = new Registe();
				rgt.setVisible(true);
			}
			
		});
		
		JMenuItem menuItem_5 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mnNewMenu.add(menuItem_5);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u7BA1\u7406\u5458\u767B\u9646");
		mnNewMenu.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				login lo = new login();
				lo.setVisible(true);
			}
			
		});
		
		JMenu menu = new JMenu("\u5220\u9664");
		menuBar.add(menu);
		
		JMenuItem menuItem_2 = new JMenuItem("\u5220\u9664\u5206\u7EC4");
		menu.add(menuItem_2);
		menuItem_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				DelGroup dg = new DelGroup();
				dg.setVisible(true);
			}
			
		});
		
		JMenuItem menuItem_1 = new JMenuItem("\u5220\u9664\u8054\u7CFB\u4EBA");
		menu.add(menuItem_1);
		menuItem_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				DelContacts dg = new DelContacts();
				dg.setVisible(true);
			}
			
		});
		
		JMenu menu_1 = new JMenu("\u589E\u52A0");
		menuBar.add(menu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u6DFB\u52A0\u5206\u7EC4");
		menu_1.add(mntmNewMenuItem_1);
		
		JMenuItem menuItem = new JMenuItem("\u589E\u52A0\u8054\u7CFB\u4EBA");
		menu_1.add(menuItem);
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AddContacts ac = new AddContacts();
				ac.setVisible(true);
			}
			
		});
		mntmNewMenuItem_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AddGroup ag = new AddGroup();
				ag.setVisible(true);
			}
			
		});
		
		JMenu menu_2 = new JMenu("\u4FEE\u6539");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u4FEE\u6539\u5206\u7EC4\u540D");
		menu_2.add(menuItem_3);
		menuItem_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AlterGroup ag = new AlterGroup();
				ag.setVisible(true);
			}
			
		});
		
		JMenuItem menuItem_4 = new JMenuItem("\u4FEE\u6539\u8054\u7CFB\u4EBA\u4FE1\u606F");
		menu_2.add(menuItem_4);
		menuItem_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AlterContacts ac = new AlterContacts();
				ac.setVisible(true);
			}
			
		});
		
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setBounds(10, 11, 284, 51);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(319, 11, 94, 51);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 165, 1000, 215);
		getContentPane().add(scrollPane_1);
		
		table = new JTable();
		
		JButton btnNewButton_1 = new JButton("\u6240\u6709\u8054\u7CFB\u4EBA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("serial")
				DefaultTableModel tableModel2=new DefaultTableModel(queryData(),head){
		            public boolean isCellEditable(int row, int column)
		            {
		                return false;
		            }
		        };
		        table.setModel(tableModel2);
		        scrollPane_1.setViewportView(table);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(423, 4, 202, 64);
		getContentPane().add(btnNewButton_1);
		
		JButton button_2 = new JButton("\u5E38\u7528\u8054\u7CFB\u4EBA");
		button_2.setFont(new Font("宋体", Font.PLAIN, 20));
		button_2.setBounds(630, 4, 188, 64);
		getContentPane().add(button_2);
		
		JButton button = new JButton("\u901A\u8BAF\u7B80\u8BB0");
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(822, 4, 188, 64);
		getContentPane().add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(11, 83, 1000, 72);
		getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("\u5206\u7EC4");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setViewportView(panel);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panel.setLayout(fl_panel);
		
		@SuppressWarnings("serial")
		DefaultTableModel tableModel1=new DefaultTableModel(queryData(),head){
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        table.setModel(tableModel1);
        scrollPane_1.setViewportView(table);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\January\\Pictures\\\u6570\u636E\u5E93\u8BFE\u8BBE\\TIM\u622A\u56FE20180702163103_gaitubao_com_1006x596.png"));
        lblNewLabel_1.setBounds(0, -14, 1006, 398);
        getContentPane().add(lblNewLabel_1);
		
		//分组要放入这里面
		String select = "select GroupName from ABGroup where UserId = ?";
		
		PreparedStatement sql = Connect.getPreparedStatement(select);
		try {
			sql.setString(1, login.string);
		
		ResultSet rs = sql.executeQuery();
		while(rs.next()) {
			String str = rs.getString(1);
			JButton button1 = new JButton(str);
			panel.add(button1);
			button1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					@SuppressWarnings("serial")
					DefaultTableModel tableModel=new DefaultTableModel(queryData(str),head){
			            public boolean isCellEditable(int row, int column)
			            {
			                return false;
			            }
			        };
			        table.setModel(tableModel);
			        scrollPane_1.setViewportView(table);
				}
			});
		}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				iq = 0;
				String str = textField.getText();
				@SuppressWarnings("serial")
				DefaultTableModel tableModel=new DefaultTableModel(Data(str),head){
		            public boolean isCellEditable(int row, int column)
		            {
		                return false;
		            }
		        };
		        table.setModel(tableModel);
		        scrollPane_1.setViewportView(table);
			}
			
		});
		menuItem_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AlterPassWord apw = new AlterPassWord();
				apw.setVisible(true);
			}
			
		});
		
		button_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("serial")
				DefaultTableModel tableModel=new DefaultTableModel(queryData(true),head){
		            public boolean isCellEditable(int row, int column)
		            {
		                return false;
		            }
		        };
		        table.setModel(tableModel);
		        scrollPane_1.setViewportView(table);
			}
			
		});
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Note note = new Note();
				note.setVisible(true);
			}
			
		});
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
	
	public Object[][] queryData(String group){
        Object [][]data=new Object[200][8];
        UserData ud = new UserData(login.string,group);
        int i = 0;
        while(ud.getBool()) {
        	data[i][0] = ud.getName();
        	data[i][1] = ud.getPhone();
        	data[i][2] = ud.getMobile();
        	data[i][3] = ud.getEmail();
        	data[i][4] = ud.getGroupName();
        	data[i][5] = ud.getFamilyAddress();
        	data[i][6] = ud.getQQ();
        	data[i][7] = ud.getWeChat();
        	ud.next();
        	i++;
        }
        return data;
    }
	
	public Object[][] queryData(){
        Object [][]data=new Object[200][8];
        UserData ud = new UserData(login.string);
        int i = 0;
        while(ud.getBool()) {
        	data[i][0] = ud.getName();
        	data[i][1] = ud.getPhone();
        	data[i][2] = ud.getMobile();
        	data[i][3] = ud.getEmail();
        	data[i][4] = ud.getGroupName();
        	data[i][5] = ud.getFamilyAddress();
        	data[i][6] = ud.getQQ();
        	data[i][7] = ud.getWeChat();
        	ud.next();
        	i++;
        }
        return data;
    }
	
	public Object[][] queryData(String Cname,boolean bool){
        Object [][]data=new Object[200][8];
        UserData ud = new UserData(login.string,Cname,bool);
        int i = 0;
        while(ud.getBool()) {
        	data[i][0] = ud.getName();
        	data[i][1] = ud.getPhone();
        	data[i][2] = ud.getMobile();
        	data[i][3] = ud.getEmail();
        	data[i][4] = ud.getGroupName();
        	data[i][5] = ud.getFamilyAddress();
        	data[i][6] = ud.getQQ();
        	data[i][7] = ud.getWeChat();
        	ud.next();
        	i++;
        }
        return data;
    }
	
	public Object[][] queryData(boolean bool){
        Object [][]data=new Object[200][8];
        UserData ud = new UserData(login.string,bool);
        int i = 0;
        while(ud.getBool()) {
        	data[i][0] = ud.getName();
        	data[i][1] = ud.getPhone();
        	data[i][2] = ud.getMobile();
        	data[i][3] = ud.getEmail();
        	data[i][4] = ud.getGroupName();
        	data[i][5] = ud.getFamilyAddress();
        	data[i][6] = ud.getQQ();
        	data[i][7] = ud.getWeChat();
        	ud.next();
        	i++;
        }
        return data;
    }
	public Object[][] Data(String column){
        Object [][]data=new Object[200][8];
        
        ResultSet rs1 = Select.Contacts(column, "CName");
        ResultSet rs2 = Select.Contacts(column, "PhoneNumber");
        ResultSet rs3 = Select.Contacts(column, "MobileNumber");
        ResultSet rs4 = Select.Contacts(column, "EMail");
        ResultSet rs5 = Select.Contacts(column, "QQ");
        ResultSet rs6 = Select.Contacts(column, "WeChat");
        ResultSet rs7 = Select.Contacts(column, "FamilyAddress");
        ResultSet rs8 = Select.Contacts(column, "Sex");
        
        data = rewhile(rs1, data);
        data = rewhile(rs2, data);
        data = rewhile(rs3, data);
        data = rewhile(rs4, data);
        data = rewhile(rs5, data);
        data = rewhile(rs6, data);
        data = rewhile(rs7, data);
        data = rewhile(rs8, data);
        
		return data;
    }
	
	public Object[][] rewhile(ResultSet rs1,Object[][] data){
		try {
			while(rs1.next()) {
				data[iq][0] = rs1.getString("CName");
				data[iq][1] = rs1.getString("PhoneNumber");
				data[iq][2] = rs1.getString("MobileNumber");
				data[iq][3] = rs1.getString("EMail");
				data[iq][4] = rs1.getString("GroupName");
				data[iq][5] = rs1.getString("FamilyAddress");
				data[iq][6] = rs1.getString("QQ");
				data[iq][7] = rs1.getString("WeChat");
				Update.addNumber(rs1.getString("CName"), rs1.getString("UserId"));
				iq++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
