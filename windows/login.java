package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Connect;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

public class login extends JFrame {

	public static String string = null; 
	private JPanel contentPane;
	private JTextField tfd1;
	private JPasswordField passwordField_1;

	public login() {
		setTitle("\u901A\u8BAF\u5F55\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 360);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfd1 = new JTextField();
		tfd1.setBounds(98, 90, 334, 29);
		contentPane.add(tfd1);
		tfd1.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(98, 147, 334, 29);
		contentPane.add(passwordField_1);
		
		JButton btn1 = new JButton("\u767B\u9646");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = tfd1.getText();
				string = name;
				String password = passwordField_1.getText();
				
				if(name.equals("admin")&&password.equals("admin")){
					dispose();
					Admin ad = new Admin();
					ad.setVisible(true);
				}else {
					PreparedStatement  sql = Connect.getPreparedStatement ("select * from ABUser where UserName = ? and UserPassword = ?");
					try {
						sql.setString(1, name);
				
					sql.setString(2, password);	
					ResultSet rs = sql.executeQuery();
					boolean bool  = rs.next();
					if(bool) {
						dispose();
						User user = new User();
						user.setVisible(true);}
					else {
						JOptionPane.showMessageDialog(null, "登陆信息错误", "错误提示", JOptionPane.WARNING_MESSAGE);
					}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		btn1.setBounds(126, 230, 103, 36);
		contentPane.add(btn1);
		JButton btn2 = new JButton("\u6CE8\u518C");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Registe rg = new Registe();
				rg.setVisible(true);
			}
		});
		btn2.setBounds(292, 230, 103, 36);
		contentPane.add(btn2);
		
		JLabel label = new JLabel("\u8D26\u53F7\uFF1A");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("宋体", Font.BOLD, 15));
		label.setBounds(29, 90, 58, 25);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("宋体", Font.BOLD, 15));
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(29, 154, 58, 15);
		contentPane.add(label_1);
		
		ImageIcon img = new ImageIcon("C:\\Users\\January\\Pictures\\数据库课设\\TIM截图20180702162938.png");
		img.setImage(img.getImage().getScaledInstance(916,574,Image.SCALE_DEFAULT));
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("C:\\Users\\January\\Pictures\\\u6570\u636E\u5E93\u8BFE\u8BBE\\TIM\u622A\u56FE20180702162925.png"));
		
		JLabel lblNewLabel_1 = new JLabel("\u901A\u8BAF\u5F55\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("隶书", Font.BOLD, 30));
		lblNewLabel_1.setBounds(148, 0, 271, 80);
		contentPane.add(lblNewLabel_1);
		lblNewLabel.setBounds(0, 0, 524, 321);
		contentPane.add(lblNewLabel);
	}
}
