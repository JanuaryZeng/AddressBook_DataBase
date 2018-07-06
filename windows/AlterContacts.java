package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import logic.Connect;
import logic.Select;
import logic.Update;
import logic.UserData;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.DefaultButtonModel;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class AlterContacts extends JFrame {

	private JPanel contentPane;
	private JTextField sousuo;
	private JTextField Tname;
	private JTextField Tphone;
	private JTextField Tmobile;
	private JTextField Tmail;
	private JTextField TGroup;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField TfamilyAddress;
	private JTextField Tqq;
	private JTextField TweChat;
	private JLabel lblQq;
	private JLabel label_6;
	private JLabel label_7;
	private JRadioButton man;
	private JRadioButton woman;
	private String[] string1 = new String[200];
	private UserData ud;
	private String string;
	private JLabel lblNewLabel_1;
	
	public AlterContacts() {
		setTitle("\u4FEE\u6539\u8054\u7CFB\u4EBA\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 494);
		
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
		
		sousuo = new JTextField();
		sousuo.setFont(new Font("宋体", Font.PLAIN, 20));
		sousuo.setBounds(10, 10, 189, 47);
		contentPane.add(sousuo);
		sousuo.setColumns(10);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton.setBounds(216, 10, 129, 47);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 111, 335);
		contentPane.add(scrollPane);
		
		String str = "select CName from Contacts where UserId = ?";
		PreparedStatement ps = Connect.getPreparedStatement(str);
		try {
			
			ps.setString(1, login.string);
			ResultSet rs = ps.executeQuery();
			int i = 0;
			while(rs.next()) {
				String name =  rs.getString(1);
				string1[i] = name;
				i++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JList<Object> list = new JList<Object>(string1);
		scrollPane.setViewportView(list);
		
		Tname = new JTextField();
		Tname.setBounds(280, 86, 217, 47);
		contentPane.add(Tname);
		Tname.setColumns(10);
		
		Tphone = new JTextField();
		Tphone.setColumns(10);
		Tphone.setBounds(280, 157, 217, 47);
		contentPane.add(Tphone);
		
		Tmobile = new JTextField();
		Tmobile.setColumns(10);
		Tmobile.setBounds(280, 229, 217, 47);
		contentPane.add(Tmobile);
		
		Tmail = new JTextField();
		Tmail.setColumns(10);
		Tmail.setBounds(280, 304, 217, 47);
		contentPane.add(Tmail);
		
		TGroup = new JTextField();
		TGroup.setColumns(10);
		TGroup.setBounds(280, 374, 217, 47);
		contentPane.add(TGroup);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setBounds(163, 102, 93, 31);
		contentPane.add(lblNewLabel);
		
		label = new JLabel("\u5BB6\u5EAD\u5EA7\u673A\uFF1A");
		label.setFont(new Font("宋体", Font.BOLD, 20));
		label.setBounds(163, 172, 104, 31);
		contentPane.add(label);
		
		label_1 = new JLabel("\u624B\u673A\u53F7\uFF1A");
		label_1.setFont(new Font("宋体", Font.BOLD, 20));
		label_1.setBounds(163, 243, 93, 31);
		contentPane.add(label_1);
		
		label_2 = new JLabel("\u90AE\u7BB1\uFF1A");
		label_2.setFont(new Font("宋体", Font.BOLD, 20));
		label_2.setBounds(165, 319, 93, 31);
		contentPane.add(label_2);
		
		label_3 = new JLabel("\u7EC4\u522B\uFF1A");
		label_3.setFont(new Font("宋体", Font.BOLD, 20));
		label_3.setBounds(163, 390, 93, 31);
		contentPane.add(label_3);
		
		label_4 = new JLabel("\u5BB6\u5EAD\u4F4F\u5740\uFF1A");
		label_4.setFont(new Font("宋体", Font.BOLD, 20));
		label_4.setBounds(521, 102, 111, 31);
		contentPane.add(label_4);
		
		TfamilyAddress = new JTextField();
		TfamilyAddress.setColumns(10);
		TfamilyAddress.setBounds(655, 86, 217, 47);
		contentPane.add(TfamilyAddress);
		
		Tqq = new JTextField();
		Tqq.setColumns(10);
		Tqq.setBounds(656, 154, 217, 47);
		contentPane.add(Tqq);
		
		TweChat = new JTextField();
		TweChat.setColumns(10);
		TweChat.setBounds(657, 225, 217, 47);
		contentPane.add(TweChat);
		
		lblQq = new JLabel("QQ\uFF1A");
		lblQq.setFont(new Font("宋体", Font.BOLD, 20));
		lblQq.setBounds(521, 173, 111, 31);
		contentPane.add(lblQq);
		
		label_6 = new JLabel("\u5FAE\u4FE1\uFF1A");
		label_6.setFont(new Font("宋体", Font.BOLD, 20));
		label_6.setBounds(521, 245, 111, 31);
		contentPane.add(label_6);
		
		label_7 = new JLabel("\u6027\u522B\uFF1A");
		label_7.setFont(new Font("宋体", Font.BOLD, 20));
		label_7.setBounds(521, 320, 111, 31);
		contentPane.add(label_7);
		
		ButtonGroup jbg = new ButtonGroup();
		
		man = new JRadioButton("\u7537");
		man.setBounds(683, 325, 73, 23);
		contentPane.add(man);
		
		woman = new JRadioButton("\u5973");
		woman.setBounds(785, 325, 127, 23);
		contentPane.add(woman);
		
		jbg.add(man);
		jbg.add(woman);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_1.setBounds(659, 375, 213, 47);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\January\\Pictures\\\u6570\u636E\u5E93\u8BFE\u8BBE\\TIM\u622A\u56FE20180702163103.png"));
		lblNewLabel_1.setBounds(0, 0, 962, 434);
		contentPane.add(lblNewLabel_1);
		
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				string = (String) list.getSelectedValue();
				setText(string);
			}
			
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				string = sousuo.getText();
				ResultSet rs1 = Select.Contacts("CName", string, login.string);
				boolean bool;
				try {
					bool = rs1.next();
					if(bool) {
					setText(string);
					}
					else {
						JOptionPane.showMessageDialog(null, "此联系人不存在!!", "错误提示", JOptionPane.WARNING_MESSAGE);
					}
				}
				catch (SQLException e) {
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
		
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String Cname = Tname.getText();
				boolean bool = false;
				boolean bool1;
				try {
					if(Cname.equals(string)) {
						ResultSet rs1;
						rs1 = Select.Contacts("GroupName", string, login.string);
						bool1 = rs1.next();
					}
					else {
						ResultSet rs;
						rs = Select.Contacts("CName", Cname, login.string);
						bool = rs.next();
						
						ResultSet rs1;
						rs1 = Select.Contacts("GroupName", string, login.string);
						bool1 = rs1.next();
					}
					if(bool) {
						JOptionPane.showMessageDialog(null, "联系人名称不能和已有联系人相同!!", "错误提示", JOptionPane.WARNING_MESSAGE);
					}
					else if(!bool1) {
						JOptionPane.showMessageDialog(null, "分组必须选用已有分组!!", "错误提示", JOptionPane.WARNING_MESSAGE);
					}
					else {
						String sex;
						DefaultButtonModel model = (DefaultButtonModel) man.getModel();
						if(model.getGroup().isSelected(model)) 
							sex = "男";
						else
							sex = "女";
						ud.setName(Tname.getText());
						ud.setPhone(Tphone.getText());
						ud.setMobile(Tmobile.getText());
						ud.setEmail(Tmail.getText());
						ud.setGroupName(TGroup.getText());
						ud.setFamilyAddress(TfamilyAddress.getText());
						ud.setUserId(login.string);
						ud.setQQ(Tqq.getText());
						ud.setWeChat(TweChat.getText());
						ud.setSex(sex);
						Update.Contacts(ud, string, login.string);
						dispose();
						AlterContacts ac = new AlterContacts();
						ac.setVisible(true);
						JOptionPane.showMessageDialog(null, "联系人信息修改成功!!", "成功", JOptionPane.WARNING_MESSAGE);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		});
		
	}
	
	public void setText(String str) {
		ud = new UserData(login.string, str, true);
		Tname.setText(ud.getName());
		Tphone.setText(ud.getPhone());
		Tmobile.setText(ud.getMobile());
		TfamilyAddress.setText(ud.getFamilyAddress());
		Tmail.setText(ud.getEmail());
		TweChat.setText(ud.getWeChat());
		Tqq.setText(ud.getQQ());
		TGroup.setText(ud.getGroupName());
		if(ud.getSex().equals("男")) {
			man.setSelected(true);
		}
		else woman.setSelected(true);
	}
}
