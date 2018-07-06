package windows;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import logic.NoteD;
import logic.Select;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class Note extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private DefaultListModel DLM;
	private NoteD nd;
	public static String string;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Note frame = new Note();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public Note() {
		setTitle("\u901A\u8BAF\u7B80\u8BB0\u8868");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 521);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u529F\u80FD");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u8FD4\u56DE");
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u6DFB\u52A0");
		menu.add(menuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 428, 402);
		contentPane.add(scrollPane);
		
		DLM = setList();
		
		@SuppressWarnings("rawtypes")
		JList list = new JList();
		list.setFont(new Font("ËÎÌו", Font.PLAIN, 18));
		scrollPane.setViewportView(list);
		list.setModel(DLM);
		
		textField = new JTextField();
		textField.setBounds(10, 10, 263, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultListModel dlm = new DefaultListModel();
				String string = textField.getText();
				ResultSet rs1 = Select.Note(login.string, "Way", string);
				ResultSet rs2 = Select.Note(login.string, "Title", string);
				ResultSet rs3 = Select.Note(login.string, "Number", string);
				Pattern pattern = Pattern.compile("2018-[0-9][0-9]-[0-9][0-9]");
			    Matcher matcher = pattern.matcher(string);
			   
				if(matcher.matches()) 
				{
					ResultSet rs4 = Select.Note(login.string, "Ntime", string);
					dlm = setList(rs4, dlm);
				}
				ResultSet rs5 = Select.Note(login.string, "CName", string);
				ResultSet rs6 = Select.Note(login.string, "Value", string);

				dlm = setList(rs1, dlm);
				dlm = setList(rs2, dlm);
				dlm = setList(rs3, dlm);
				
				dlm = setList(rs5, dlm);
				dlm = setList(rs6, dlm);
				list.setModel(dlm);
			}
		});
		btnNewButton.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		btnNewButton.setBounds(283, 10, 155, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\January\\Pictures\\\u6570\u636E\u5E93\u8BFE\u8BBE\\TIM\u622A\u56FE20180702162925.png"));
		lblNewLabel.setBounds(0, 0, 458, 478);
		contentPane.add(lblNewLabel);
		
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				User user = new User();
				user.setVisible(true);
			}
		});
		
		menuItem_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				NoteWrite nw = new NoteWrite();
				nw.setVisible(true);
			}
			
		});
		
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				string = (String) list.getSelectedValue();
				dispose();
				NoteData notedata = new NoteData();
				notedata.setVisible(true);
			}
			
		});
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DefaultListModel setList() {
		nd = new NoteD();
		 DefaultListModel dlm = new DefaultListModel();
		while(nd.bool) {
			dlm.addElement(nd.getTitle()+" "+nd.getCName()+" "+nd.getNtime()+" "+nd.getWay());
			nd.next();
		}
		return dlm;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DefaultListModel setList(ResultSet rs, DefaultListModel dlm) {
		try {
			while(rs.next()) {
				dlm.addElement(rs.getString("Title")+" "+rs.getString("CName")+" "+rs.getString("Ntime")+" "+rs.getString("Way"));
				nd.next();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dlm;
	}
}
