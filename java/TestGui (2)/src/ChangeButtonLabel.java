import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChangeButtonLabel {
	JButton button;

	public ChangeButtonLabel() {
		JFrame frame = new JFrame("Change JButton Lebel");
		button = new JButton("Click Me");
		button.addActionListener(new MyAction());
		frame.add(button);
		frame.setSize(200, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public class MyAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String text = e.getActionCommand();
			if (text.equals("Click Me")) {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String st = df.format(new Date());
				button.setText(st);
			} else {
				button.setText("Click Me");
			}
		}
	}

	public static void main(String[] args) {
		ChangeButtonLabel cl = new ChangeButtonLabel();
	}
}