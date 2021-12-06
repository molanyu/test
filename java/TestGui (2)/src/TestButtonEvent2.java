import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestButtonEvent2 extends JFrame {
	public TestButtonEvent2() {
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		TestButtonEvent2 be = new TestButtonEvent2();
		be.getContentPane().setLayout(new FlowLayout());
		final JTextField t1 = new JTextField(6);
		JLabel l1 = new JLabel("+");
		final JTextField t2 = new JTextField(6);
		JLabel l2 = new JLabel("=");
		final JTextField t3 = new JTextField(6);
		JButton bt = new JButton("º∆À„");

		be.getContentPane().add(t1);
		be.getContentPane().add(l1);
		be.getContentPane().add(t2);
		be.getContentPane().add(l2);
		be.getContentPane().add(t3);
		be.getContentPane().add(bt);
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = Double.valueOf(t1.getText());
				double b = Double.valueOf(t2.getText());
				t3.setText(String.valueOf(a + b));
			}
		});
		be.pack();
		be.setVisible(true);
	}
}
