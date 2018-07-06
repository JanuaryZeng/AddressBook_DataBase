package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Connect;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class DelContacts extends JFrame {

	private JPanel contentPane;
	private String[] string1 = new String[200];
	private String[] string2 = new String[200];
	private String[] string3 = new String[200];

	public DelContacts() {
		setTitle("\u5220\u9664\u8054\u7CFB\u4EBA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 319);
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 85, 163);
		contentPane.add(scrollPane);
		
		String str = "select Cname,MobileNumber,QQ from Contacts where UserId = ?";
		PreparedStatement ps = Connect.getPreparedStatement(str);
		try {
			
			ps.setString(1, login.string);
			ResultSet rs = ps.executeQuery();
			int i = 0;
			while(rs.next()) {
				String name =  rs.getString(1);
				String mobile =  rs.getString(2);
				String qq =  rs.getString(3);
				string1[i] = name;
				string2[i] = mobile;
				string3[i] = qq;
				i++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JList<Object> list = new JList<Object>(string1);
		scrollPane.setViewportView(list);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(126, 10, 153, 163);
		contentPane.add(scrollPane_1);
		
		JList<Object> list_1 = new JList<Object>(string2);
		scrollPane_1.setViewportView(list_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(308, 10, 153, 163);
		contentPane.add(scrollPane_2);
		
		JList<Object> list_2 = new JList<Object>(string3);
		scrollPane_2.setViewportView(list_2);
		
		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str1 = (String) list.getSelectedValue();
				String str2 = "delete from Contacts where UserId = ? and Cname = ?";
				PreparedStatement ps1 = Connect.getPreparedStatement(str2);
				try {
					ps1.setString(1, login.string);
					ps1.setString(2, str1);
					ps1.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				DelContacts dc = new DelContacts();
				dc.setVisible(true);
				JOptionPane.showMessageDialog(null,"删除成功！！", "完成",JOptionPane.WARNING_MESSAGE);
			}
		});
		btnNewButton.setBounds(10, 211, 85, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str1 = (String) list.getSelectedValue();
				String str2 = "delete from Contacts where UserId = ? and MobileNumber = ?";
				PreparedStatement ps1 = Connect.getPreparedStatement(str2);
				try {
					ps1.setString(1, login.string);
					ps1.setString(2, str1);
					ps1.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				DelContacts dc = new DelContacts();
				dc.setVisible(true);
				JOptionPane.showMessageDialog(null,"删除成功！！", "完成",JOptionPane.WARNING_MESSAGE);
			}
		});
		btnNewButton_1.setBounds(126, 211, 153, 23);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("\u5220\u9664");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str1 = (String) list.getSelectedValue();
				String str2 = "delete from Contacts where UserId = ? and QQ = ?";
				PreparedStatement ps1 = Connect.getPreparedStatement(str2);
				try {
					ps1.setString(1, login.string);
					ps1.setString(2, str1);
					ps1.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				DelContacts dc = new DelContacts();
				dc.setVisible(true);
				JOptionPane.showMessageDialog(null,"删除成功！！", "完成",JOptionPane.WARNING_MESSAGE);
			}
		});
		button.setBounds(308, 211, 153, 23);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setBounds(37, 186, 58, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u624B\u673A\u53F7");
		label.setBounds(178, 186, 58, 15);
		contentPane.add(label);
		
		JLabel lblQq = new JLabel("QQ\u53F7");
		lblQq.setBounds(372, 186, 58, 15);
		contentPane.add(lblQq);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\January\\Pictures\\\u6570\u636E\u5E93\u8BFE\u8BBE\\TIM\u622A\u56FE20180702162925.png"));
		lblNewLabel_1.setBounds(0, 0, 490, 258);
		contentPane.add(lblNewLabel_1);
		

	}
}
