package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import logic.Select;
import logic.Update;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private String[] string = new String[200];
	private String userName;

	public Admin() {
		setTitle("\u7BA1\u7406\u5458\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u7528\u6237\u767B\u9646");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u7528\u6237\u767B\u5F55");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				login l = new login();
				l.setVisible(true);
			}
		});
		menu.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ResultSet rs1 = Select.ABUser();
		try {
			int cou = 0;
			while(rs1.next()) {
				string[cou] = rs1.getString(1);
				cou++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JList<Object> list = new JList<Object>(string);
		list.setBounds(10, 56, 107, 172);
		contentPane.add(list);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setBounds(217, 99, 176, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u5BC6\u7801\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(127, 106, 85, 29);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");

		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(239, 181, 129, 29);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_1.setBounds(10, 10, 158, 36);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u641C\u7D22");
		btnNewButton_1.setBounds(197, 10, 114, 36);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\January\\Pictures\\\u6570\u636E\u5E93\u8BFE\u8BBE\\0008020212604272_b.jpg"));
		lblNewLabel.setBounds(0, 0, 446, 248);
		contentPane.add(lblNewLabel);
		
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				userName = (String) list.getSelectedValue();
				ResultSet st2 = Select.ABUser(userName);
				try {
					st2.next();
					textField.setText(st2.getString(1));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Update.ABUser(textField.getText(), userName);
				JOptionPane.showMessageDialog(null, "修改成功！！！", "成功", JOptionPane.WARNING_MESSAGE);
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userName = textField_1.getText();
				ResultSet st2 = Select.ABUser(userName);
				try {
					if(st2.next()) {
						textField.setText(st2.getString(1));}
					else {
						JOptionPane.showMessageDialog(null, "没有此用户名！！！", "错误提示", JOptionPane.WARNING_MESSAGE);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
