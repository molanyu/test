
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private String text;/* ��������ʾ������ */
	private float a, b;/* ������ */
	private String opt;/* ����� */
	private boolean isRes;/* һ���������֮����ʾ����������ʱ���������ּ���ζ���µ�һ�����㿪ʼ��Ӧע������ */
	private JTextField textField;/* �䵱��������Ļ */

	public Calculator() {

		/* ���ô��ڻ������� */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("\u7B80\u6613\u8BA1\u7B97\u5668");
		setBounds(0, 0, 616, 307);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);

		setFrameAndListener();// ��ӽ��������Ϊ�齨��Ӽ�����
		initData();// ��ʼ������

		this.setVisible(true);
	}

	/* ��ʼ�������� */
	void initData() {
		a = b = 0.0f;
		opt = "";
		text = "0";
		isRes = false;
		textField.setText(text);
	}

	/* ��ӽ��������Ϊ�齨��Ӽ����� */
	void setFrameAndListener() {

		/** ��ӽ������ **/
		/* ��Ӽ�������ʾ�� */
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setEditable(false);
		textField.setBounds(14, 13, 570, 24);
		getContentPane().add(textField);
		textField.setColumns(10);

		/* ��Ӽ�����back ce c about�� */
		JPanel panel = new JPanel();
		panel.setBounds(14, 50, 570, 32);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 4, 3, 1));

		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("����", Font.BOLD, 15));
		backButton.setForeground(new Color(0, 0, 255));
		panel.add(backButton);

		JButton ceButton = new JButton("CE");
		ceButton.setFont(new Font("����", Font.BOLD, 15));
		ceButton.setForeground(Color.BLUE);
		panel.add(ceButton);

		JButton cButton = new JButton("C");
		cButton.setForeground(Color.BLUE);
		cButton.setFont(new Font("����", Font.BOLD, 15));
		panel.add(cButton);

		JButton aboutButton = new JButton("About");
		aboutButton.setForeground(Color.BLUE);
		aboutButton.setFont(new Font("Dialog", Font.BOLD, 12));
		panel.add(aboutButton);

		/* ������ݼ� */
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(14, 91, 278, 152);
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 3, 1, 1));
		JButton[] panel_1_Button;
		panel_1_Button = new JButton[10];
		for (int i = 0; i < 10; i++) {
			panel_1_Button[i] = new JButton(i + "");
			// panel_1_Button[i].setText(i + "");
			panel_1.add(panel_1_Button[i]);
		}
		JButton symbolButton = new JButton("+/-");
		panel_1.add(symbolButton);

		JButton dotButton = new JButton(".");
		panel_1.add(dotButton);

		/* ������������=�� */
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(306, 91, 278, 152);
		getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(4, 2, 0, 0));

		JButton divideButton = new JButton("/");
		divideButton.setForeground(Color.RED);
		divideButton.setFont(new Font("����", Font.BOLD, 15));

		panel_2.add(divideButton);

		JButton sqrtButton = new JButton("sqrt");
		sqrtButton.setForeground(new Color(0, 0, 0));
		sqrtButton.setFont(new Font("����", Font.BOLD, 15));
		panel_2.add(sqrtButton);

		JButton mulButton = new JButton("*");
		mulButton.setForeground(Color.RED);
		panel_2.add(mulButton);

		JButton percentButton = new JButton("%");
		percentButton.setFont(new Font("����", Font.PLAIN, 15));
		panel_2.add(percentButton);

		JButton subButton = new JButton("-");
		subButton.setFont(new Font("����", Font.BOLD | Font.ITALIC, 15));
		subButton.setForeground(Color.RED);
		panel_2.add(subButton);

		JButton reciprocalButton = new JButton("1/x");
		reciprocalButton.setFont(new Font("����", Font.BOLD, 15));
		panel_2.add(reciprocalButton);

		JButton addButton = new JButton("+");
		addButton.setFont(new Font("����", Font.BOLD, 15));
		addButton.setForeground(Color.RED);
		panel_2.add(addButton);

		JButton resButton = new JButton("=");
		resButton.setForeground(Color.RED);
		resButton.setFont(new Font("����", Font.BOLD, 15));
		panel_2.add(resButton);

		/** ��Ӽ����� **/
		/* back�������������һλ */
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (text.length() > 1) {
					text = text.substring(0, text.length() - 1);
				} else
					text = "0";
				textField.setText(text);
			}
		});

		/* CE����ȫ������������ */
		ceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text = "0";
				textField.setText(text);
			}
		});

		/* C������������е���ʽ */
		cButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initData();
			}
		});

		/* ���ּ���.�� */
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * �����������Ŀ����׼ȷ���������ݣ�������Ҫע�������� �����ǰ��Ļ�������ݣ���ô�� 1����Ļ�ϵ�������0����ʱ�����������滻0���ɣ�����
				 *  ǰ׺0
				 * 2����ʱ��Ļ�ϵ����ݲ���0����ȴ�����û��Լ���������ݣ������ϴ�����Ľ������ʱӦ�����������滻ԭ�����ݼ���
				 *  3����������£�ֱ�ӽ�������������ԭ����֮�󼴿� �����ǰ��Ļ�������������ô�� ��¼��������������������滻ԭ�����ݼ���
				 * 
				 * 
				 */
				if (text.equals("0"))
					text = ((JButton) e.getSource()).getText();
				else if (text.length() == 1 && "+=*/".indexOf(text) != -1) {
					opt = text;
					text = ((JButton) e.getSource()).getText();
				} else if (isRes) {
					isRes = false;
					text = ((JButton) e.getSource()).getText();
				} else
					text += ((JButton) e.getSource()).getText();
				textField.setText(text);
			}
		};
		for (int i = 0; i < 10; i++)
			panel_1_Button[i].addActionListener(listener);
		dotButton.addActionListener(listener);

		/* '+/-'�� ���ż�������ǰ���������为�����ɸ����� */
		symbolButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (text.equals("0") == false) {
					if (text.charAt(0) == '-') {
						text = text.substring(1);
					} else
						text = '-' + text;
					textField.setText(text);
				}
			}
		});

		/* + - * / �� ��Ԫ�����������ǰ�����ݼ�¼Ϊ��һ�������� */
		ActionListener listener1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ("+-*/".indexOf(text) == -1) {
					try {
						a = Float.parseFloat(text);
					} catch (Exception e1) {
						showMes(e1.getMessage());
						e1.printStackTrace();
					}
				}
				text = ((JButton) e.getSource()).getText();
				textField.setText(text);
			}
		};

		addButton.addActionListener(listener1);
		subButton.addActionListener(listener1);
		mulButton.addActionListener(listener1);
		divideButton.addActionListener(listener1);

		/* sqrt % 1/x ΪһԪ���������ʱ�������ݼ��� */
		/* sqrt�� */
		sqrtButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					float f = Float.parseFloat(text);
					f = (float) Math.sqrt(f);
					text = String.valueOf(f);
					if (opt.equals(""))
						a = f;
					else
						b = f;
					textField.setText(text);
				} catch (Exception e1) {
					showMes(e1.getMessage());
					e1.printStackTrace();
				}
			}
		});

		/* %�� */
		percentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					float f = Float.parseFloat(text);
					f = (float) f / 100;
					text = String.valueOf(f);
					if (opt.equals(""))
						a = f;
					else
						b = f;
					textField.setText(text);
				} catch (Exception e1) {
					showMes(e1.getMessage());
					e1.printStackTrace();
				}
			}
		});

		/* 1/x�� */
		reciprocalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					float f = Float.parseFloat(text);
					f = (float) 1 / f;
					text = String.valueOf(f);
					if (opt.equals(""))
						a = f;
					else
						b = f;
					textField.setText(text);
				} catch (Exception e1) {
					showMes(e1.getMessage());
					e1.printStackTrace();
				}
			}
		});

		/* =�� ��Ԫ������������� */
		resButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					float f = Float.parseFloat(text);
					if (opt.equals("")) {
						a = f;
					} else
						b = f;
				} catch (Exception e1) {
					showMes(e1.getMessage());
					e1.printStackTrace();
				}
				if (opt.equals("") == false) {
					float res = 0.0f;
					if (opt.equals("+")) {
						res = a + b;
					} else if (opt.equals("-")) {
						res = a - b;
					} else if (opt.equals("*")) {
						res = a * b;
					} else if (opt.equals("/")) {
						res = a / b;
					}
					System.out.println(a + opt + b + "=" + res);
					initData();
					isRes = true;
					text = String.valueOf(res);
					textField.setText(text);
				}
			}
		});
	}

	void showMes(String mes) {
		JOptionPane.showMessageDialog(this, "error", mes, JOptionPane.CLOSED_OPTION);
	}

	public static void main(String[] args) {
		Calculator main = new Calculator();
	}
}
