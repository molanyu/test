
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
	private String text;/* 计算器显示的内容 */
	private float a, b;/* 操作数 */
	private String opt;/* 运算符 */
	private boolean isRes;/* 一轮运算结束之后显示运算结果，此时若按下数字键意味着新的一轮运算开始，应注意重置 */
	private JTextField textField;/* 充当计算器屏幕 */

	public Calculator() {

		/* 设置窗口基本属性 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("\u7B80\u6613\u8BA1\u7B97\u5668");
		setBounds(0, 0, 616, 307);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);

		setFrameAndListener();// 添加界面组件并为组建添加监听器
		initData();// 初始化数据

		this.setVisible(true);
	}

	/* 初始化计算器 */
	void initData() {
		a = b = 0.0f;
		opt = "";
		text = "0";
		isRes = false;
		textField.setText(text);
	}

	/* 添加界面组件并为组建添加监听器 */
	void setFrameAndListener() {

		/** 添加界面组件 **/
		/* 添加计算器显示屏 */
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setEditable(false);
		textField.setBounds(14, 13, 570, 24);
		getContentPane().add(textField);
		textField.setColumns(10);

		/* 添加计算器back ce c about键 */
		JPanel panel = new JPanel();
		panel.setBounds(14, 50, 570, 32);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 4, 3, 1));

		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("宋体", Font.BOLD, 15));
		backButton.setForeground(new Color(0, 0, 255));
		panel.add(backButton);

		JButton ceButton = new JButton("CE");
		ceButton.setFont(new Font("宋体", Font.BOLD, 15));
		ceButton.setForeground(Color.BLUE);
		panel.add(ceButton);

		JButton cButton = new JButton("C");
		cButton.setForeground(Color.BLUE);
		cButton.setFont(new Font("宋体", Font.BOLD, 15));
		panel.add(cButton);

		JButton aboutButton = new JButton("About");
		aboutButton.setForeground(Color.BLUE);
		aboutButton.setFont(new Font("Dialog", Font.BOLD, 12));
		panel.add(aboutButton);

		/* 添加数据键 */
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

		/* 添加运算符键和=键 */
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(306, 91, 278, 152);
		getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(4, 2, 0, 0));

		JButton divideButton = new JButton("/");
		divideButton.setForeground(Color.RED);
		divideButton.setFont(new Font("宋体", Font.BOLD, 15));

		panel_2.add(divideButton);

		JButton sqrtButton = new JButton("sqrt");
		sqrtButton.setForeground(new Color(0, 0, 0));
		sqrtButton.setFont(new Font("宋体", Font.BOLD, 15));
		panel_2.add(sqrtButton);

		JButton mulButton = new JButton("*");
		mulButton.setForeground(Color.RED);
		panel_2.add(mulButton);

		JButton percentButton = new JButton("%");
		percentButton.setFont(new Font("宋体", Font.PLAIN, 15));
		panel_2.add(percentButton);

		JButton subButton = new JButton("-");
		subButton.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));
		subButton.setForeground(Color.RED);
		panel_2.add(subButton);

		JButton reciprocalButton = new JButton("1/x");
		reciprocalButton.setFont(new Font("宋体", Font.BOLD, 15));
		panel_2.add(reciprocalButton);

		JButton addButton = new JButton("+");
		addButton.setFont(new Font("宋体", Font.BOLD, 15));
		addButton.setForeground(Color.RED);
		panel_2.add(addButton);

		JButton resButton = new JButton("=");
		resButton.setForeground(Color.RED);
		resButton.setFont(new Font("宋体", Font.BOLD, 15));
		panel_2.add(resButton);

		/** 添加监听器 **/
		/* back键清除最后输入的一位 */
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (text.length() > 1) {
					text = text.substring(0, text.length() - 1);
				} else
					text = "0";
				textField.setText(text);
			}
		});

		/* CE键完全清除输入的数字 */
		ceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text = "0";
				textField.setText(text);
			}
		});

		/* C键清除计算器中的算式 */
		cButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initData();
			}
		});

		/* 数字键和.键 */
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 数据输入键的目的是准确地输入数据，例举需要注意的情况； 如果当前屏幕上是数据，那么： 1、屏幕上的数据是0，此时将输入内容替换0即可，不需
				 *  前缀0
				 * 2、此时屏幕上的数据不是0，但却不是用户自己输入的数据，而是上次运算的结果，此时应将输入内容替换原有数据即可
				 *  3、其他情况下，直接将输入内容续于原数据之后即可 如果当前屏幕上是运算符，那么： 记录下运算符，将输入内容替换原有内容即可
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

		/* '+/-'键 符号键，将当前数据由正变负，或由负变正 */
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

		/* + - * / 键 二元运算符，将此前的数据记录为第一操作数中 */
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

		/* sqrt % 1/x 为一元运算符，及时更改数据即可 */
		/* sqrt键 */
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

		/* %键 */
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

		/* 1/x键 */
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

		/* =键 二元运算求解运算结果 */
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
