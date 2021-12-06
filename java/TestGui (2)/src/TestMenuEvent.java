import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class TestMenuEvent extends JFrame {

	private JPanel contentPane;
	JTextField textField;
	JLabel label = new JLabel("标签");
	JLabel lblNewLabel = new JLabel("New label");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestMenuEvent frame = new TestMenuEvent();
					frame.setVisible(true);
					//textField.setFocusable(true);
//					textField.requestFocus(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 */
	public TestMenuEvent() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
			System.out.println("激活状态");
			}
			@Override
			public void windowOpened(WindowEvent arg0) {
				System.out.println("打开");
			}
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				System.out.println("非激活状态");}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u6587\u4EF6");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u6253\u5F00");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "消息区");

			}
		});
		menu.add(menuItem);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u6D4B\u8BD5");
		button.setBounds(82, 29, 93, 23);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				lblNewLabel.setText("获得焦点");
				System.out.println("获得焦点");
				textField.setText("获得焦点");
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				lblNewLabel.setText("失去焦点");
				textField.setText("失去焦点");
				System.out.println("失去焦点");}
		});
		textField.setBounds(97, 91, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		//textField.requestFocus(true);
		
//		JLabel label = new JLabel("");
//		label.setBounds(109, 141, 54, 15);
//		contentPane.add(label);
		
//		
//		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(97, 141, 54, 15);
		contentPane.add(lblNewLabel);
		
		
	}

}
