import java.awt.event.*;
import javax.swing.*;

public class TestButtonEvent extends JFrame{
	public static void main(String[] args) {
		TestButtonEvent be = new TestButtonEvent();
		be.setBounds(100, 100, 400, 300);
		be.setVisible(true);
		be.setLayout(null);
		JButton bt = new JButton("计算");
		bt.setBounds(150,100,80,50);
		be.add(bt);
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("正在计算，请稍后……");
			}
		});
	}
}
