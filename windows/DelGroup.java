package windows;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Connect;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class DelGroup extends JFrame {

	private JPanel contentPane;
	private String[] name = new String[20];

	public DelGroup() {
		setTitle("\u5220\u9664\u5206\u7EC4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 299, 278);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u8FD4\u56DE");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u8FD4\u56DE");
		menu.add(menuItem);
		
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				User user = new User();
				user.setVisible(true);
			}
			
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String str = "select GroupName from ABGroup where UserId = ?";
		PreparedStatement ps = Connect.getPreparedStatement(str);
		try {
			
			ps.setString(1, login.string);
			ResultSet rs = ps.executeQuery();
			int i = 0;
			while(rs.next()) {
				String GroupName =  rs.getString(1);
				name[i] = GroupName;
				i++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 260, 128);
		contentPane.add(scrollPane);
		
		JList<Object> list = new JList<Object>(name);
		scrollPane.setViewportView(list);
		
		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str1 = (String) list.getSelectedValue();
				String str2;
				String str3 = "delete from Contacts where UserId = ? and GroupName = ?";
				PreparedStatement ps1 = Connect.getPreparedStatement(str3);
				try {
					ps1.setString(1, login.string);
					ps1.setString(2, str1);
					ps1.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				str2 = "delete from ABGroup where UserId = ? and GroupName = ?";
				PreparedStatement ps = Connect.getPreparedStatement(str2);
				try {
					ps.setString(1, login.string);
					ps.setString(2, str1);
					ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
				DelGroup dg = new DelGroup();
				dg.setVisible(true);
				JOptionPane.showMessageDialog(null,"删除成功！！", "完成",JOptionPane.WARNING_MESSAGE);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(85, 161, 104, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\January\\Pictures\\\u6570\u636E\u5E93\u8BFE\u8BBE\\TIM\u622A\u56FE20180702162925.png"));
		lblNewLabel.setBounds(0, 0, 295, 228);
		contentPane.add(lblNewLabel);
	}
}
