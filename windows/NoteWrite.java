package windows;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import logic.Connect;
import logic.Insert;
import logic.NoteD;
import logic.Select;
import logic.UserData;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class NoteWrite extends JFrame {

	private JPanel contentPane;
	private JTextField textTitle;
	private JTextArea textText;
	private NoteD nd;
	private String[] combox = {"座机","手机","邮件","QQ","微信"};
	private String s;

	public NoteWrite() {
		setTitle("\u8BB0\u5F55\u901A\u8BAF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 419);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u8FD4\u56DE");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u8FD4\u56DE");
		menu.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textTitle = new JTextField();
		textTitle.setBounds(74, 11, 342, 23);
		contentPane.add(textTitle);
		textTitle.setColumns(10);
		
		JLabel label = new JLabel("\u6807\u9898\uFF1A");
		label.setBounds(25, 16, 58, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5185\u5BB9\uFF1A");
		label_1.setBounds(26, 50, 58, 15);
		contentPane.add(label_1);
		
		textText = new JTextArea();
		textText.setBounds(28, 73, 523, 235);
		contentPane.add(textText);
		textText.setColumns(10);
		
		JLabel label_2 = new JLabel("\u901A\u8BAF\u4EBA\uFF1A");
		label_2.setBounds(38, 322, 58, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u901A\u8BAF\u65B9\u5F0F\uFF1A");
		label_3.setBounds(206, 318, 96, 22);
		contentPane.add(label_3);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");

		btnNewButton.setBounds(440, 318, 97, 23);
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox(combox);
		comboBox.setBounds(294, 318, 88, 22);
		contentPane.add(comboBox);
		
		UserData ud = new UserData(login.string);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(89, 318, 96, 23);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\January\\Pictures\\\u6570\u636E\u5E93\u8BFE\u8BBE\\TIM\u622A\u56FE20180702162925.png"));
		lblNewLabel.setBounds(0, 0, 578, 370);
		contentPane.add(lblNewLabel);
		
		while(ud.getBool()) {
			comboBox_1.addItem(ud.getName());
			ud.next();
		}
		
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Note note = new Note();
				note.setVisible(true);
			}
			
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				s = (String) comboBox.getSelectedItem();
				switch(s) {
				case "座机":s = "PhoneNumber";break;
				case "手机":s = "MobileNumber";break;
				case "邮件":s = "EMail";break;
				case "QQ": s = "QQ";break;
				case "微信": s = "WeChat";break;
				}
				nd = new NoteD();
				nd.setTitle(textTitle.getText());
				nd.setCName((String)comboBox_1.getSelectedItem());
				nd.setValue(textText.getText());
				nd.setWay(s);
				nd.setUserId(login.string);
				Date date = new Date();
				SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
				String da = dateFormat.format(date);
				nd.setNtime(da.split(" ")[0]);
				String str = "select "+nd.getWay()+" from Contacts where UserId = ? and CName = ?";
				PreparedStatement ps = Connect.getPreparedStatement(str);
				try {
					ps.setString(1, login.string);
					ps.setString(2, nd.getCName());
					ResultSet rs = ps.executeQuery();
					if(rs.next()) {
					nd.setNumber(rs.getString(1));
					Insert.Note(nd);
					JOptionPane.showMessageDialog(null, "添加成功！！", "成功", JOptionPane.WARNING_MESSAGE);}
					else {
					JOptionPane.showMessageDialog(null, "添加失败！！/n没有此联系人。", "失败", JOptionPane.WARNING_MESSAGE);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
