import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 public class MouseTest extends JFrame implements MouseListener,
 MouseMotionListener{
  int intX,intY;
  JPanel pnlMain;
  JLabel lblX,lblY,lblStatus;
  JTextField txtX,txtY,txtStatus;
  GridLayout glMain;
  public MouseTest(){
   pnlMain=new JPanel();
   getContentPane().add(pnlMain);
   glMain=new GridLayout(3,2);
   pnlMain.setLayout(glMain);
   
   lblX=new JLabel("当前鼠标X坐标:");
   lblY=new JLabel("当前鼠标Y坐标:");
   lblStatus=new JLabel("当前鼠标状态:");
   
   txtX=new JTextField(5);
   txtY=new JTextField(5);
   txtStatus=new JTextField(5);
   
   pnlMain.add(lblX);
   pnlMain.add(txtX);
   pnlMain.add(lblY);
   pnlMain.add(txtY);
   pnlMain.add(lblStatus);
   pnlMain.add(txtStatus);
   
   addMouseListener(this);
   addMouseMotionListener(this);
   
   setVisible(true);
   setTitle("鼠标例子");
   setSize(250,150);
   setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
 public void mouseClicked(MouseEvent me){
  
  }
 
 public void mousePressed(MouseEvent me){
  txtStatus.setText("按下");
  } 
 public void mouseEntered(MouseEvent me){
  txtStatus.setText("移入");
  } 
 public void mouseExited(MouseEvent me){
  txtStatus.setText("移出");
  } 
 public void mouseReleased(MouseEvent me){
  txtStatus.setText("释放");
  } 
 public void mouseMoved(MouseEvent me){
  intX=me.getX();
  intY=me.getY();
  txtX.setText(String.valueOf(intX));
  txtY.setText(String.valueOf(intY));
  } 
 public void mouseDragged(MouseEvent me){}//这也是空操作为什么啊，有什么用？

 public static void main(String[] args){
  MouseTest med=new MouseTest();//这是整个程序的入口可是它这形式怎么和一般的不一样啊？好像我见过的形如：new MouseEventDemo();这样的形式更多点吧，这和上面的这种形式有什么区别？
  }  
  }