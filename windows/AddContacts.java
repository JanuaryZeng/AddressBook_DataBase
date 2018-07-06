package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Connect;
import logic.Select;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultButtonModel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AddContacts extends JFrame {

	private JPanel contentPane;
	private JTextField text_name;
	private JLabel label;
	private JTextField text_mobile;
	private JLabel label_1;
	private JTextField text_phone;
	private JLabel lblQq;
	private JTextField text_qq;
	private JTextField text_mail;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField text_wechat;
	private JLabel label_4;
	private JTextField text_familyAddress;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel lblNewLabel_1;	
	public String name;
	public String phone;
	public String mobile;
	public String email;
	public String groupName;
	public String userId;
	public String sex;
	public String familyAddress;
	public String QQ;
	public String WeChat;
	public PreparedStatement ps;
	public PreparedStatement ps1;
	public ResultSet rs;
	public ResultSet rs1;

	public AddContacts() {
		setTitle("\u6DFB\u52A0\u8054\u7CFB\u4EBA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 362);
		
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
		
		text_name = new JTextField();
		text_name.setBounds(151, 38, 222, 38);
		contentPane.add(text_name);
		text_name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(33, 49, 128, 27);
		contentPane.add(lblNewLabel);
		
		label = new JLabel("\u5BB6\u5EAD\u5EA7\u673A\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(33, 97, 128, 27);
		contentPane.add(label);
		
		text_mobile = new JTextField();
		text_mobile.setColumns(10);
		text_mobile.setBounds(151, 86, 222, 38);
		contentPane.add(text_mobile);
		
		label_1 = new JLabel("\u624B\u673A\u53F7\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(33, 145, 128, 27);
		contentPane.add(label_1);
		
		text_phone = new JTextField();
		text_phone.setColumns(10);
		text_phone.setBounds(151, 134, 222, 38);
		contentPane.add(text_phone);
		
		lblQq = new JLabel("QQ\uFF1A");
		lblQq.setFont(new Font("宋体", Font.PLAIN, 20));
		lblQq.setBounds(33, 193, 128, 27);
		contentPane.add(lblQq);
		
		text_qq = new JTextField();
		text_qq.setColumns(10);
		text_qq.setBounds(151, 182, 222, 38);
		contentPane.add(text_qq);
		
		text_mail = new JTextField();
		text_mail.setColumns(10);
		text_mail.setBounds(151, 230, 222, 38);
		contentPane.add(text_mail);
		
		label_2 = new JLabel("\u90AE\u7BB1\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(33, 241, 128, 27);
		contentPane.add(label_2);
		
		label_3 = new JLabel("\u7EC4\u522B\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(430, 49, 128, 27);
		contentPane.add(label_3);
		
		text_wechat = new JTextField();
		text_wechat.setColumns(10);
		text_wechat.setBounds(530, 86, 222, 38);
		contentPane.add(text_wechat);
		
		label_4 = new JLabel("\u5FAE\u4FE1\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));
		label_4.setBounds(430, 97, 128, 27);
		contentPane.add(label_4);
		
		text_familyAddress = new JTextField();
		text_familyAddress.setColumns(10);
		text_familyAddress.setBounds(530, 134, 222, 38);
		contentPane.add(text_familyAddress);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(530, 37, 222, 38);
		contentPane.add(comboBox);
		
		ResultSet rs2 = Select.ABGroup();
		try {
			while(rs2.next()) {
				comboBox.addItem(rs2.getString(1));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		label_5 = new JLabel("\u5BB6\u5EAD\u4F4F\u5740\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 20));
		label_5.setBounds(430, 145, 128, 27);
		contentPane.add(label_5);
		
		label_6 = new JLabel("\u6027\u522B\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 20));
		label_6.setBounds(430, 193, 128, 27);
		contentPane.add(label_6);
		
		JRadioButton man = new JRadioButton("\u7537");
		man.setBounds(574, 197, 54, 23);
		contentPane.add(man);
		
		JRadioButton woman = new JRadioButton("\u5973");
		woman.setBounds(659, 197, 48, 27);
		contentPane.add(woman);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(man);
		bg.add(woman);
		
		JButton button = new JButton("\u521B\u5EFA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					name = text_name.getText();
					phone = text_mobile.getText();
					mobile = text_phone.getText();
					email = text_mail.getText();
					groupName = (String) comboBox.getSelectedItem();
					userId = login.string;
					DefaultButtonModel model = (DefaultButtonModel) man.getModel();
					if(model.getGroup().isSelected(model)) 
						sex = "男";
					else
						sex = "女";
					familyAddress = text_familyAddress.getText();
					QQ = text_qq.getText();
					WeChat = text_wechat.getText();
					
					rs = Select.Contacts("CName", name, login.string );
					boolean bool = rs.next();
					
					rs1 = Select.ABGroup(groupName, login.string);
					boolean bool1 = rs1.next();
					
					if(bool) {
						JOptionPane.showMessageDialog(null,"添加失败！！\n 此用户名已经存在", "错误",JOptionPane.WARNING_MESSAGE);
					}
					else if(!bool1) {
						JOptionPane.showMessageDialog(null,"添加失败！！\n 此组名不存在", "错误",JOptionPane.WARNING_MESSAGE);
					}
					else {
						String str = "insert into Contacts values(?,?,?,?,?,?,?,?,?,?,?)";
						ps = Connect.getPreparedStatement(str);
						ps.setString(1, name);
						ps.setString(2, phone);
						ps.setString(3, mobile);
						ps.setString(4, email);
						ps.setString(5, groupName);
						ps.setString(6, userId);
						ps.setString(7, sex);
						ps.setString(8, familyAddress);
						ps.setString(9,QQ);
						ps.setString(10, WeChat);
						ps.setInt(11, 0);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"添加成功！！", "正确",JOptionPane.WARNING_MESSAGE);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(530, 230, 222, 38);
		contentPane.add(button);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\January\\Pictures\\\u6570\u636E\u5E93\u8BFE\u8BBE\\TIM\u622A\u56FE20180702163103.png"));
		lblNewLabel_1.setBounds(0, 0, 811, 306);
		contentPane.add(lblNewLabel_1);
		

	}
}
