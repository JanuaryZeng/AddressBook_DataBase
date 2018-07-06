package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Delete;
import logic.NoteD;
import logic.Update;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class NoteData extends JFrame {

	private JPanel contentPane;
	private String[] string = Note.string.split(" ");
	private String Title = string[0];
	private String Cname = string[1];
	private String date = string[2];
	private String Way = string[3];
	private NoteD nd;

	public NoteData() {
		setTitle("记录的信息");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 425);
		nd = new NoteD(date, Cname, Way, Title);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u529F\u80FD");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u8FD4\u56DE");
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5220\u9664");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Delete.Note(nd);
				dispose();
				Note note = new Note();
				note.setVisible(true);
			}
		});
		menu.add(menuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6807\u9898\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(47, 24, 86, 23);
		contentPane.add(label);
		
		JTextArea textText = new JTextArea();
		textText.setFont(new Font("宋体", Font.PLAIN, 19));
		textText.setBounds(33, 57, 523, 245);
		contentPane.add(textText);
		textText.setText(nd.getValue());
		
		JTextField textTitle = new JTextField();
		textTitle.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textTitle.setBounds(128, 11, 274, 36);
		contentPane.add(textTitle);
		textTitle.setText(nd.getTitle());
		
		JLabel label_1 = new JLabel("\u8054\u7CFB\u4EBA\uFF1A");
		label_1.setBounds(56, 328, 58, 15);
		contentPane.add(label_1);
		
		JTextField textContacts = new JTextField();
		textContacts.setEditable(false);
		textContacts.setBounds(118, 324, 86, 19);
		contentPane.add(textContacts);
		textContacts.setText(nd.getCName());
		
		JLabel label_2 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		label_2.setBounds(228, 328, 75, 15);
		contentPane.add(label_2);
		
		JTextField textWay = new JTextField();
		textWay.setEditable(false);
		textWay.setBounds(303, 324, 96, 19);
		contentPane.add(textWay);
		textWay.setText(nd.getWay());
		
		JTextField textNumber = new JTextField();
		textNumber.setEditable(false);
		textNumber.setBounds(409, 324, 147, 19);
		contentPane.add(textNumber);
		textNumber.setText(nd.getNumber());
		
		JButton button = new JButton("\u4FEE\u6539");

		button.setBounds(470, 11, 86, 28);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\January\\Pictures\\\u6570\u636E\u5E93\u8BFE\u8BBE\\TIM\u622A\u56FE20180702162925.png"));
		lblNewLabel.setBounds(0, -1, 584, 378);
		contentPane.add(lblNewLabel);
		
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Note note = new Note();
				note.setVisible(true);
			}
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String title = textTitle.getText();
				String value = textText.getText();
				Update.Note(nd, title, value);
				JOptionPane.showMessageDialog(null, "修改成功", "成功", JOptionPane.WARNING_MESSAGE);
			}
		});
	}
}

