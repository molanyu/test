import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;


public class TestFoucus3 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JLabel label = new JLabel("");
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFoucus3 frame = new TestFoucus3();
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
	public TestFoucus3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
			label.setText("获得焦点");
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				label.setText("失去焦点");}
		});
		textField.setBounds(56, 39, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		label.setBounds(56, 89, 54, 15);
		contentPane.add(label);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(163, 38, 93, 23);
		contentPane.add(btnNewButton);
	}

}
