import java.awt.event.*;
import javax.swing.*;

public class TestButtonEvent4 extends JFrame implements ActionListener {
	JTextField t1 = new JTextField(6);
	JTextField t2 = new JTextField(6);
	JTextField t3 = new JTextField(6);
	JButton jb1 = new JButton("+");
	JButton jb2 = new JButton("-");
	JButton jb3 = new JButton("*");
	JButton jb4 = new JButton("/");
	JPanel jpanel = new JPanel();

	TestButtonEvent4() {
		add(jpanel);
		jpanel.add(t1);
		jpanel.add(t2);
		jpanel.add(t3);
		jpanel.add(jb1);
		jpanel.add(jb2);
		jpanel.add(jb3);
		jpanel.add(jb4);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		setSize(280, 100);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		double a = Integer.parseInt(t1.getText());
		double b = Integer.parseInt(t2.getText());
		if (arg0.getActionCommand().equals("+")) {
			t3.setText(String.valueOf(a + b));
		}
	}

	public static void main(String args[]) {
		new TestButtonEvent4();
	}
}
