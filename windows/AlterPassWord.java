package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Select;
import logic.Update;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AlterPassWord extends JFrame {

	private JPanel contentPane;
	private JPasswordField oldPass;
	private JPasswordField newPass;
	private JPasswordField newPass2;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem menuItem;
	private JLabel lblNewLabel;

	public AlterPassWord() {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 332);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("\u8FD4\u56DE");
		menuBar.add(mnNewMenu);
		
		menuItem = new JMenuItem("\u8FD4\u56DE");
		mnNewMenu.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		oldPass = new JPasswordField();
		oldPass.setFont(new Font("宋体", Font.PLAIN, 20));
		oldPass.setBounds(146, 32, 262, 38);
		contentPane.add(oldPass);
		
		newPass = new JPasswordField();
		newPass.setFont(new Font("宋体", Font.PLAIN, 20));
		newPass.setBounds(146, 93, 262, 38);
		contentPane.add(newPass);
		
		newPass2 = new JPasswordField();
		newPass2.setFont(new Font("宋体", Font.PLAIN, 20));
		newPass2.setBounds(145, 152, 262, 38);
		contentPane.add(newPass2);
		
		JLabel label = new JLabel("\u65E7\u5BC6\u7801\uFF1A");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("宋体", Font.BOLD, 20));
		label.setBounds(17, 33, 86, 30);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("宋体", Font.BOLD, 20));
		label_1.setBounds(16, 94, 86, 30);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u786E\u8BA4\u65B0\u5BC6\u7801\uFF1A");
		label_2.setFont(new Font("宋体", Font.BOLD, 20));
		label_2.setBounds(17, 156, 127, 32);
		contentPane.add(label_2);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(150, 220, 139, 33);
		contentPane.add(button);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\January\\Pictures\\\u6570\u636E\u5E93\u8BFE\u8BBE\\TIM\u622A\u56FE20180702162938.png"));
		lblNewLabel.setBounds(0, 0, 455, 270);
		contentPane.add(lblNewLabel);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String oldpass = oldPass.getText();
				String newpass = newPass.getText();
				String newpass2= newPass2.getText();
				ResultSet rs1 = Select.ABUser(oldpass, login.string);
				try {
					boolean bool = rs1.next();
					if(bool) {
						if(newpass.equals(newpass2)) {
							Update.ABUser(newpass, login.string);
							JOptionPane.showMessageDialog(null, "修改完成！！", "正确", JOptionPane.WARNING_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "两次新密码输入不一致", "错误提示", JOptionPane.WARNING_MESSAGE);

						}
					}
					else {
						JOptionPane.showMessageDialog(null, "密码输入错误", "错误提示", JOptionPane.WARNING_MESSAGE);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				User user = new User();
				user.setVisible(true);
			}
			
		});
	}
}
