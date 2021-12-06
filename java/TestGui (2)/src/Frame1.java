import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Frame1 extends JFrame {
	BorderLayout borderLayout1 = new BorderLayout();
	JPanel jPanel1 = new JPanel();
	JPanel jPanel2 = new JPanel();
	JPanel jPanel3 = new JPanel();
	JLabel jLabel1 = new JLabel();
	JTextField jTextField1 = new JTextField();
	JButton jButton1 = new JButton();
	FlowLayout flowLayout1 = new FlowLayout();
	FlowLayout flowLayout2 = new FlowLayout();
	JButton jButton2 = new JButton();
	JButton jButton3 = new JButton();
	JButton jButton4 = new JButton();
	GridLayout gridLayout1 = new GridLayout();
	JScrollPane jScrollPane1 = new JScrollPane();
	JTable jTable1 = new JTable();

	public Frame1() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Frame1 frame1 = new Frame1();
		frame1.setSize(new Dimension(400, 350));
		frame1.setVisible(true);

	}

	private void jbInit() throws Exception {
		this.getContentPane().setLayout(borderLayout1);
		jPanel1.setBackground(Color.yellow);
		jPanel1.setLayout(flowLayout1);
		jPanel2.setBackground(Color.yellow);
		jPanel2.setLayout(flowLayout2);
		jPanel3.setBackground(Color.pink);
		jPanel3.setLayout(gridLayout1);
		jLabel1.setPreferredSize(new Dimension(100, 16));
		jLabel1.setText("请输入查询条件");
	
		jTextField1.setPreferredSize(new Dimension(140, 22));
		jTextField1.setText("");
		jButton1.setText("查询");
		jButton1.addActionListener(new Frame1_jButton1_actionAdapter(this));
		flowLayout1.setAlignment(FlowLayout.LEFT);
		flowLayout1.setHgap(5);
		flowLayout1.setVgap(10);
		jButton2.setText("增加");
		jButton3.setText("删除");
		jButton4.setText("修改");
		flowLayout2.setHgap(30);
		flowLayout2.setVgap(5);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().add(jPanel1, BorderLayout.NORTH);
		jPanel1.add(jLabel1, null);
		jPanel1.add(jTextField1, null);
		jPanel1.add(jButton1, null);
		this.getContentPane().add(jPanel2, BorderLayout.SOUTH);
		jPanel2.add(jButton2, null);
		jPanel2.add(jButton3, null);
		jPanel2.add(jButton4, null);
		this.getContentPane().add(jPanel3, BorderLayout.CENTER);
		jPanel3.add(jScrollPane1, null);
		jScrollPane1.setViewportView(jTable1);
	}

	// 模拟查询数据库
	void jButton1_actionPerformed(ActionEvent e) {
		try { // 制作表
			Vector vcol = new Vector(); // 列名
			Vector vrow = new Vector(); // 内容
			for (int col = 1; col < 31; col++) {
				vcol.addElement("列" + col);
			}
			for (int row = 1; row < 101; row++) {
				Vector vr1 = new Vector();
				for (int col = 1; col < 31; col++) {
					vr1.addElement(row + "/" + col);
				}
				vrow.addElement(vr1);
			}
			DefaultTableModel dtm = new DefaultTableModel(vrow, vcol);
			jTable1 = new JTable(vrow, vcol);
			jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // 滚动条设置左右滚
			this.jScrollPane1.setViewportView(jTable1);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}

	}
}
class Frame1_jButton1_actionAdapter implements java.awt.event.ActionListener {
	Frame1 adaptee;

	Frame1_jButton1_actionAdapter(Frame1 adaptee) {
		this.adaptee = adaptee;
	}
	public void actionPerformed(ActionEvent e) {
		adaptee.jButton1_actionPerformed(e);
	}
}