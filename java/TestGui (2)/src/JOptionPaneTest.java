
import javax.swing.*;

public class JOptionPaneTest {
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "��Ϣ��");
		int confirm = JOptionPane.showConfirmDialog(null, "��Ϣ��");
		String input = JOptionPane.showInputDialog(null, "��Ϣ��");
		int option = JOptionPane.showOptionDialog(null, "��Ϣ��", "����", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), new String[] { "a", "b", "c", "d" }, "a");
		System.out.println("ȷ�϶Ի���=" + confirm);
		System.out.println("����Ի���=" + input);
		System.out.println("�Զ���Ի���=" + option);// ѡ���λ��
	}
}
