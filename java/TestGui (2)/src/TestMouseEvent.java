import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestMouseEvent extends JFrame implements MouseListener, MouseMotionListener {
	JLabel lx = new JLabel("当前鼠标X坐标");
	JTextField txtX = new JTextField();
	JLabel ly = new JLabel("当前鼠标y坐标");
	JTextField txtY = new JTextField();
	JLabel ls = new JLabel("当前鼠标状态");
	JTextField txtStatus = new JTextField();

	TestMouseEvent() {
		setLayout(new GridLayout(3, 2));
		add(lx);
		add(txtX);
		add(ly);
		add(txtY);
		add(ls);
		add(txtStatus);
		addMouseListener(this);
		addMouseMotionListener(this);
		pack();
		setVisible(true);
	}

	public void mouseClicked(MouseEvent me) {
	}

	public void mousePressed(MouseEvent me) {
		txtStatus.setText("按下");
	}

	public void mouseEntered(MouseEvent me) {
		txtStatus.setText("移入");
	}

	public void mouseExited(MouseEvent me) {
		txtStatus.setText("移出");
	}

	public void mouseReleased(MouseEvent me) {
		txtStatus.setText("释放");
	}

	public void mouseMoved(MouseEvent me) {
		int X = me.getX();
		int Y = me.getY();
		txtX.setText(String.valueOf(X));
		txtY.setText(String.valueOf(Y));
	}

	public void mouseDragged(MouseEvent me) {
	}

	public static void main(String[] args) {
		new TestMouseEvent();
	}
}
