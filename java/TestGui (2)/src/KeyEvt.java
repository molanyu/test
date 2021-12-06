import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;
class MyKeyListener implements KeyListener{ 
  public void keyPressed(KeyEvent evt) { 
    System.out.println("\n����������"); 
    showKeyEventMsg(evt); 
  } 
  public void keyReleased(KeyEvent evt){ } 
  public void keyTyped(KeyEvent evt) { } 
  private void showKeyEventMsg(KeyEvent evt){//��ʾ�����¼���Ϣ 
    //�õ�������Ӧ��������
    int code = evt.getKeyCode(); 
    //���ذ����¼���������ַ� 
    char c = evt.getKeyChar(); 
    //�õ����������ַ��� 
    String szText = evt.getKeyText(code); 
    if (code != KeyEvent.VK_UNDEFINED) 
        System.out.println("\n������Ӧ����������"+code); 
    if (c != KeyEvent.CHAR_UNDEFINED) 
        System.out.println("\n�밴������ϵ���ַ���"+c); 
    if (evt.isShiftDown()) 
        System.out.println("\n����Shift������"); 
    System.out.println("\n����������ַ�����"+szText); 
  } 
} 
class ButtonPanel extends JPanel{ 
    public ButtonPanel() { 
    //�½�һ���ı������
    tf = new JTextField(20); 
    add(tf); 
    //ָ����������ð�ť�¼��ļ���������ΪJPanel����
    myListener = new MyKeyListener(); 
    tf.addKeyListener(myListener); 
  } 
    private JTextField tf; 
    private MyKeyListener myListener; 
  } 
class ButtonFrame extends JFrame{ 
  public ButtonFrame() { 
    setTitle("�����¼�ʾ������"); 
    setSize(300, 200); 
    setLocation(100,100); 
    addWindowListener(new WindowAdapter() { 
  public void windowClosing(WindowEvent e) 
    { System.exit(0); 
  } 
  }); 
    Container ctPane = getContentPane(); 
    ctPane.add(new ButtonPanel()); 
 } 
} 
public class KeyEvt{ 
  public static void main(String[] args) { 
    JFrame frame = new ButtonFrame(); 
    frame.setVisible(true); 
  } 
}
