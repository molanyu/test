
import javax.swing.*;

public class JOptionPaneTest {
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "消息区");
		int confirm = JOptionPane.showConfirmDialog(null, "消息区");
		String input = JOptionPane.showInputDialog(null, "消息区");
		int option = JOptionPane.showOptionDialog(null, "消息区", "标题", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), new String[] { "a", "b", "c", "d" }, "a");
		System.out.println("确认对话框=" + confirm);
		System.out.println("输入对话框=" + input);
		System.out.println("自定义对话框=" + option);// 选项的位置
	}
}
