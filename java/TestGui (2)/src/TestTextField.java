
import java.awt.FlowLayout;
//import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TestTextField extends JFrame implements ActionListener {

private JTextField jt = new JTextField(10);
private JTextField jt1 = new JTextField(10);
//private JTextField jt2 = new JTextField(10);
private JButton jb1 = new JButton("jb1");

private JButton jb2 = new JButton("jb2",new ImageIcon("a.gif"));

public TestTextField() {
   this.setLayout(new FlowLayout());
   this.add(jt);
   this.add(jt1);

   jb2.setSize(28,29);
   this.add(jb1);
   this.add(jb2);
   //jb2.setSize(29, 29); 
   jb1.addActionListener(this);//按钮
   jb2.addActionListener(this);
   
   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

public static void main(String[] args) {
   TestTextField t = new TestTextField();
   t.setBounds(300, 300, 300, 300);
   t.setVisible(true);

}

public void actionPerformed(ActionEvent e) {

   JButton jb = (JButton) e.getSource();
      
   if (jb == jb1) {
    jt.setText("你按下了jb1");
   } else if (jb == jb2) {
    jt1.setText("你按下了jb2");
   }
}

}