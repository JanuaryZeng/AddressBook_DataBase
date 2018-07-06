package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Connect;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AddGroup extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JMenuBar menuBar;
	private PreparedStatement ps;
	private PreparedStatement ps1;
	private ResultSet rs1;
	private JMenu mnF;
	private JMenuItem menuItem;
	private JLabel lblNewLabel;

	public AddGroup() {
		setTitle("\u6DFB\u52A0\u5206\u7EC4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 243, 246);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnF = new JMenu("\u8FD4\u56DE");
		menuBar.add(mnF);
		
		menuItem = new JMenuItem("\u8FD4\u56DE");
		mnF.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				User user = new User();
				user.setVisible(true);
			}
			
		});
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setBounds(52, 51, 134, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = textField.getText();
				String select = "select GroupName from ABGroup where GroupName = ? and UserId = ?";
				ps1 = Connect.getPreparedStatement(select);
				try {
					ps1.setString(1, str);
					ps1.setString(2, login.string);
					rs1 = ps1.executeQuery();
					boolean bool = rs1.next();
				
				if(bool) {
					JOptionPane.showMessageDialog(null, "此分组已经存在","错误提示",JOptionPane.WARNING_MESSAGE);
					}
				else {
					String txt = "insert into ABGroup values(?,?)";
					ps = Connect.getPreparedStatement(txt);
					ps.setString(1, str);
					ps.setString(2, login.string);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "添加分组成功","成功！！",JOptionPane.WARNING_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 20));
		button.setBounds(52, 129, 134, 40);
		contentPane.add(button);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\January\\Pictures\\\u6570\u636E\u5E93\u8BFE\u8BBE\\TIM\u622A\u56FE20180702162925.png"));
		lblNewLabel.setBounds(0, 0, 228, 186);
		contentPane.add(lblNewLabel);
	}
}
