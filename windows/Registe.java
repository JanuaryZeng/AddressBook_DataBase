package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Connect;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Registe extends JFrame {

	private JPanel contentPane;
	private final JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");

	
	public Registe() {
		setTitle("\u6CE8\u518C");
		internalFrame.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 339);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u767B\u9646");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u767B\u9646");
		menu.add(menuItem);
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				login lo = new login();
				lo.setVisible(true);
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setBounds(187, 62, 291, 35);
		contentPane.add(textArea);
		
		JLabel label1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		label1.setFont(new Font("新宋体", Font.BOLD, 20));
		label1.setBounds(82, 61, 138, 35);
		contentPane.add(label1);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801\uFF1A");
		label_2.setFont(new Font("新宋体", Font.BOLD, 20));
		label_2.setBounds(82, 138, 138, 35);
		contentPane.add(label_2);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea_2.setBounds(187, 139, 291, 35);
		contentPane.add(textArea_2);
		
		JButton button = new JButton("\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = "select UserName from ABUser where UserName = ?";
				PreparedStatement ps = Connect.getPreparedStatement(str);
				try {
					
					ps.setString(1,textArea.getText());				
					ResultSet rs = ps.executeQuery();
					boolean bool = rs.next();
					if(bool) {
						JOptionPane.showMessageDialog(null,"此名字已经被其他用户使用", "错误提示",JOptionPane.WARNING_MESSAGE);
					}
					
					else {
						String name = textArea.getText();
						String password = textArea_2.getText();
						String string = "insert into ABUser " + "values(?, ?)";
						PreparedStatement sql = Connect.getPreparedStatement(string);
						sql.setString(1,name);
						sql.setString(2, password);
						sql.executeUpdate();
						JOptionPane.showMessageDialog(null,"注册成功","成功",JOptionPane.WARNING_MESSAGE);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(155, 211, 219, 35);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\January\\Pictures\\\u6570\u636E\u5E93\u8BFE\u8BBE\\TIM\u622A\u56FE20180702162925.png"));
		lblNewLabel.setBounds(0, 0, 554, 288);
		contentPane.add(lblNewLabel);
	}
}
