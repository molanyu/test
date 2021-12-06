import java.awt.event.*;
import javax.swing.*;

class myEvent implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		JOptionPane jo = new JOptionPane();
		
		jo.showConfirmDialog(null, "标题", "内容", -1);
		System.out.println("一个健步跨出去了");
	}
}

public class TestButtonEvent3 extends JFrame {
	JButton jb = new JButton("鸣枪");
	JPanel jpanel = new JPanel();
	   JTextField textField;
	  private final JLabel label = new JLabel("");

	TestButtonEvent3() {
		getContentPane().add(jpanel);
		jpanel.setLayout(null);
		jb.setBounds(63, 5, 57, 23);
		jpanel.add(jb);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				label.setText("获得焦点");
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				label.setText("失去焦点");
			}
		});
		
		//textField.requestFocus(true);
		
		textField.setBounds(63, 82, 66, 21);
		jpanel.add(textField);
		textField.setColumns(10);
		label.setBounds(63, 119, 54, 15);
		
		jpanel.add(label);
		jb.addActionListener(new myEvent());
		setSize(200, 200);
		setVisible(true);
		
		textField.requestFocus(true);
	}

	public static void main(String args[]) {
		new TestButtonEvent3();
		
		
	}
}
