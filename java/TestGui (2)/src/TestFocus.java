import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class TestFocus extends JFrame {

	private JPanel contentPane;
	private  JTextField textField;
	JLabel label = new JLabel("");
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFocus frame = new TestFocus();
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
	public TestFocus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				label.setText("得到焦点");
				}
			@Override
			public void focusLost(FocusEvent arg0) {
				label.setText("失去焦点");}
		});
		textField.setBounds(55, 121, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		label.setBounds(67, 169, 54, 15);
		contentPane.add(label);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(195, 75, 93, 23);
		contentPane.add(btnNewButton);
//		btnNewButton.requestFocus();
		
		
		
		
	}

}
