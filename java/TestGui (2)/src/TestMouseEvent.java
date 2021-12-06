import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestMouseEvent extends JFrame implements MouseListener, MouseMotionListener {
	JLabel lx = new JLabel("��ǰ���X����");
	JTextField txtX = new JTextField();
	JLabel ly = new JLabel("��ǰ���y����");
	JTextField txtY = new JTextField();
	JLabel ls = new JLabel("��ǰ���״̬");
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
		txtStatus.setText("����");
	}

	public void mouseEntered(MouseEvent me) {
		txtStatus.setText("����");
	}

	public void mouseExited(MouseEvent me) {
		txtStatus.setText("�Ƴ�");
	}

	public void mouseReleased(MouseEvent me) {
		txtStatus.setText("�ͷ�");
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
