package windows;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import logic.Connect;
import logic.Update;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AlterGroup extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String[] string = new String[20];

	public AlterGroup() {
		setTitle("\u4FEE\u6539\u5206\u7EC4\u540D");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 285);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u8FD4\u56DE");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u8FD4\u56DE");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {

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
		scrollPane.setBounds(10, 10, 175, 181);
		contentPane.add(scrollPane);
		
		String str = "select GroupName from ABGroup where UserId = ?";
		PreparedStatement ps = Connect.getPreparedStatement(str);
		try {
			
			ps.setString(1, login.string);
			ResultSet rs = ps.executeQuery();
			int i = 0;
			while(rs.next()) {
				String GroupName =  rs.getString(1);
				string[i] = GroupName;
				i++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JList<Object> list = new JList<Object>(string);
		scrollPane.setViewportView(list);
		textField = new JTextField();
		textField.setBounds(217, 50, 175, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.setBounds(217, 118, 175, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\January\\Pictures\\\u6570\u636E\u5E93\u8BFE\u8BBE\\TIM\u622A\u56FE20180702162925.png"));
		lblNewLabel.setBounds(0, 0, 451, 237);
		contentPane.add(lblNewLabel);
		
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				String str2 = (String) list.getSelectedValue();
				textField.setText(str2);
			}
			
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str2 = (String) list.getSelectedValue();
				String str1 = textField.getText();
				Update.ABGroup(str1, str2, login.string);
				dispose();
				AlterGroup ag = new AlterGroup();
				ag.setVisible(true);
			}
		});
	}
}
