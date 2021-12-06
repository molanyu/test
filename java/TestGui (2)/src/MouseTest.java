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
   
   lblX=new JLabel("��ǰ���X����:");
   lblY=new JLabel("��ǰ���Y����:");
   lblStatus=new JLabel("��ǰ���״̬:");
   
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
   setTitle("�������");
   setSize(250,150);
   setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
 public void mouseClicked(MouseEvent me){
  
  }
 
 public void mousePressed(MouseEvent me){
  txtStatus.setText("����");
  } 
 public void mouseEntered(MouseEvent me){
  txtStatus.setText("����");
  } 
 public void mouseExited(MouseEvent me){
  txtStatus.setText("�Ƴ�");
  } 
 public void mouseReleased(MouseEvent me){
  txtStatus.setText("�ͷ�");
  } 
 public void mouseMoved(MouseEvent me){
  intX=me.getX();
  intY=me.getY();
  txtX.setText(String.valueOf(intX));
  txtY.setText(String.valueOf(intY));
  } 
 public void mouseDragged(MouseEvent me){}//��Ҳ�ǿղ���Ϊʲô������ʲô�ã�

 public static void main(String[] args){
  MouseTest med=new MouseTest();//���������������ڿ���������ʽ��ô��һ��Ĳ�һ�����������Ҽ��������磺new MouseEventDemo();��������ʽ�����ɣ���������������ʽ��ʲô����
  }  
  }