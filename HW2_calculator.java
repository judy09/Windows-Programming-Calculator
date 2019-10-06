import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;

public class HW2_calculator extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private double operand1; //操作數
	private double operand2;
	private String operator; //運算符
	private String express; //表達式
	//private String calResult;
	private double temp = 0;
	private double result = 0;
	private double temp_m = 0;
	Color mycolor;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HW2_calculator frame = new HW2_calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HW2_calculator() {
		setTitle("簡單計算器");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Panel panel = new Panel();
		panel.setBackground(Color.PINK);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("    ");
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("新細明體", Font.PLAIN, 24));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("    ");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 24));
		panel.add(lblNewLabel);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(221, 160, 221));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(5, 5, 0, 0));
		
		JButton btnNewButton_24 = new JButton("MC");
		btnNewButton_24.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton_24.getBackground();
				btnNewButton_24.setBackground(new Color(221, 160, 221));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_24.setBackground(mycolor);
			}
		});
		btnNewButton_24.setForeground(new Color(0, 0, 0));
		btnNewButton_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp_m = 0; 
				lblNewLabel_1.setText(" MC ");
				lblNewLabel.setText("");
			}
		});
		panel_1.add(btnNewButton_24);
		
		JButton btnNewButton_23 = new JButton("MR");
		btnNewButton_23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton_23.getBackground();
				btnNewButton_23.setBackground(new Color(221, 160, 221));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_23.setBackground(mycolor);
			}
		});
		btnNewButton_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp = temp_m;
				textField.setText(String.valueOf(temp_m));
				lblNewLabel_1.setText(" MR ");
				lblNewLabel.setText("");
			}
		});
		panel_1.add(btnNewButton_23);
		
		JButton btnNewButton_22 = new JButton("MS");
		btnNewButton_22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton_22.getBackground();
				btnNewButton_22.setBackground(new Color(221, 160, 221));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_22.setBackground(mycolor);
			}
		});
		btnNewButton_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setText(" MS ");
				lblNewLabel.setText("");
				temp_m = 0;
				if(temp == 0)
					temp_m = temp_m + operand1;
				if(temp != 0)
					temp_m = temp_m + temp;
			}
		});
		panel_1.add(btnNewButton_22);
		
		JButton btnNewButton_21 = new JButton("M+");
		btnNewButton_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton_21.getBackground();
				btnNewButton_21.setBackground(new Color(221, 160, 221));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_21.setBackground(mycolor);
			}
		});
		btnNewButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(temp == 0)
					temp_m = temp_m + operand1;
				if(temp != 0)
					temp_m = temp_m + temp;
				lblNewLabel.setText("");
				lblNewLabel_1.setText(" M+ ");
			}
		});
		panel_1.add(btnNewButton_21);
		
		JButton btnNewButton_20 = new JButton("M-");
		btnNewButton_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton_20.getBackground();
				btnNewButton_20.setBackground(new Color(221, 160, 221));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_20.setBackground(mycolor);
			}
		});
		btnNewButton_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(temp == 0)
					temp_m = temp_m - operand1;
				if(temp != 0)
					temp_m = temp_m - temp;
				lblNewLabel.setText("");
				lblNewLabel_1.setText(" M- ");
			}
		});
		panel_1.add(btnNewButton_20);
		
		//初始化
		operand1 = 0;
		operand2 = 0;
		operator = new String("#");
		express = new String();
		
		JButton btnNewButton_19 = new JButton("7");
		btnNewButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				express += "7";
				InputOperand(express);
			}
		});
		btnNewButton_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton_19.getBackground();
				btnNewButton_19.setBackground(new Color(221, 160, 221));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_19.setBackground(mycolor);
			}
		});
		panel_1.add(btnNewButton_19);
		
		JButton btnNewButton_18 = new JButton("8");
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				express += "8";
				InputOperand(express);
			}
		});
		btnNewButton_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton_18.getBackground();
				btnNewButton_18.setBackground(new Color(221, 160, 221));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_18.setBackground(mycolor);
			}
		});
		panel_1.add(btnNewButton_18);
		
		JButton btnNewButton_17 = new JButton("9");
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				express += "9";
				InputOperand(express);
			}
		});
		btnNewButton_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton_17.getBackground();
				btnNewButton_17.setBackground(new Color(221, 160, 221));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_17.setBackground(mycolor);
			}
		});
		panel_1.add(btnNewButton_17);
		
		JButton btnNewButton_16 = new JButton("/");
		btnNewButton_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton_16.getBackground();
				btnNewButton_16.setBackground(new Color(221, 160, 221));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_16.setBackground(mycolor);
			}
		});
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operator = "/";
				express = "";
				textField.setText("");
				lblNewLabel.setText(" / ");
			}
		});
		panel_1.add(btnNewButton_16);
		
		JButton btnNewButton_15 = new JButton("\u221A");
		btnNewButton_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton_15.getBackground();
				btnNewButton_15.setBackground(new Color(221, 160, 221));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_15.setBackground(mycolor);
			}
		});
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operator = "√";
				express = "";
				textField.setText("");
				lblNewLabel.setText(" √ ");
				if(operator.equals("√")) {
					if(temp == 0)
						result = Math.sqrt(operand1);
					else 
						result =  Math.sqrt(temp);
					textField.setText(String.valueOf(result));
				}
				lblNewLabel_1.setText("");
				temp = result;
			}
		});
		panel_1.add(btnNewButton_15);
		
		JButton btnNewButton_14 = new JButton("4");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				express += "4";
				InputOperand(express);
			}
		});
		btnNewButton_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton_14.getBackground();
				btnNewButton_14.setBackground(new Color(221, 160, 221));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_14.setBackground(mycolor);
			}
		});
		panel_1.add(btnNewButton_14);
		
		JButton btnNewButton_13 = new JButton("5");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				express += "5";
				InputOperand(express);
			}
		});
		btnNewButton_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton_13.getBackground();
				btnNewButton_13.setBackground(new Color(221, 160, 221));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_13.setBackground(mycolor);
			}
		});
		panel_1.add(btnNewButton_13);
		
		JButton btnNewButton_12 = new JButton("6");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				express += "6";
				InputOperand(express);
			}
		});
		btnNewButton_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton_12.getBackground();
				btnNewButton_12.setBackground(new Color(221, 160, 221));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_12.setBackground(mycolor);
			}
		});
		panel_1.add(btnNewButton_12);
		
		JButton btnNewButton_11 = new JButton("*");
		btnNewButton_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton_11.getBackground();
				btnNewButton_11.setBackground(new Color(221, 160, 221));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_11.setBackground(mycolor);
			}
		});
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operator = "*";
				express = "";
				textField.setText("");	
				lblNewLabel.setText(" * ");
			}
		});
		panel_1.add(btnNewButton_11);
		
		JButton btnNewButton_10 = new JButton("x^2");
		btnNewButton_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton_10.getBackground();
				btnNewButton_10.setBackground(new Color(221, 160, 221));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_10.setBackground(mycolor);
			}
		});
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operator = "^2";
				express = "";	
				lblNewLabel.setText(" ^2 ");
				if(operator.equals("^2")) {
					if(temp == 0)
						result = operand1 * operand1;
					else 
						result = temp * temp;
					textField.setText(String.valueOf(result));
				}
				lblNewLabel_1.setText("");
				temp = result;
			}
		});
		panel_1.add(btnNewButton_10);
		
		JButton btnNewButton_9 = new JButton("1");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				express += "1";
				InputOperand(express);
			}
		});
		btnNewButton_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton_9.getBackground();
				btnNewButton_9.setBackground(new Color(221, 160, 221));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_9.setBackground(mycolor);
			}
		});
		panel_1.add(btnNewButton_9);
		
		JButton btnNewButton_8 = new JButton("2");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				express += "2";
				InputOperand(express);
			}
		});
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton_8.getBackground();
				btnNewButton_8.setBackground(new Color(221, 160, 221));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_8.setBackground(mycolor);
			}
		});
		panel_1.add(btnNewButton_8);
		
		JButton btnNewButton_7 = new JButton("3");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				express += "3";
				InputOperand(express);
			}
		});
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton_7.getBackground();
				btnNewButton_7.setBackground(new Color(221, 160, 221));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_7.setBackground(mycolor);
			}
		});
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_6 = new JButton("-");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton_6.getBackground();
				btnNewButton_6.setBackground(new Color(221, 160, 221));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_6.setBackground(mycolor);
			}
		});
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operator = "-";
				express = "";
				textField.setText("");
				lblNewLabel.setText(" - ");
			}
		});
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("%");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton_5.getBackground();
				btnNewButton_5.setBackground(new Color(221, 160, 221));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_5.setBackground(mycolor);
			}
		});
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operator = "%";
				express = "";
				textField.setText("");
				lblNewLabel.setText(" % ");
			}
		});
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("0");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				express += "0";
				InputOperand(express);
			}
		});
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton_4.getBackground();
				btnNewButton_4.setBackground(new Color(221, 160, 221));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_4.setBackground(mycolor);
			}
		});
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_1 = new JButton("=");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton_1.getBackground();
				btnNewButton_1.setBackground(new Color(221, 160, 221));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(mycolor);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(operator.equals("#")) {
					textField.setText("");
				}else {
					if(operator.equals("+")) {
						if(temp == 0)
							result = operand1 + operand2;
						else 
							result = operand2+temp+temp_m;
					}
					if(operator.equals("-")) {
						if(temp == 0)
							result = operand1 - operand2;
						else 
							result = temp - operand2;
					}
					if(operator.equals("*")) {
						if(temp == 0)
							result = operand1 * operand2;
						else 
							result = operand2*temp;
					}
					if(operator.equals("/")) {
						if(temp == 0)
							result = operand1 / operand2;
						else 
							result = temp/operand2;
					}
					if(operator.equals("%")) {
						if(temp == 0)
							result = (int)operand1 % (int)operand2;
						else 
							result = temp % (int)operand2;
					}
					textField.setText(String.valueOf(result));
				}
				lblNewLabel.setText(" = ");
				lblNewLabel_1.setText("");
				temp = result;
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CE");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_2.setBackground(mycolor);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton_2.getBackground();
				btnNewButton_2.setBackground(new Color(221, 160, 221));
				
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetAll();
				textField.setText("");
				lblNewLabel.setText("  ");
			}
		});
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton.getBackground();
				btnNewButton.setBackground(new Color(221, 160, 221));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(mycolor);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operator = "+";
				express = "";
				textField.setText("");
				lblNewLabel.setText(" + ");
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Backspace");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mycolor = btnNewButton_3.getBackground();
				btnNewButton_3.setBackground(new Color(221, 160, 221));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_3.setBackground(mycolor);
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operator = "Backspace";
				express = "";
				String s1 = textField.getText();
				//String x;
				if(operator.equals("Backspace")) {
					int i = s1.length();
					if(i > 0) {
						s1 = s1.substring(0, i-1);
						textField.setText(s1);
					}
				}
				if(temp == 0) 
					operand1 = Double.valueOf(s1);
				if(temp != 0)
					temp = Double.valueOf(s1);
				lblNewLabel.setText(" Bspace ");
				lblNewLabel_1.setText("");
				//textField.setText(express);	
			}
		});
		panel_1.add(btnNewButton_3);
	}
		
	//鼠標單擊輸入數字
	public void InputOperand(String datastr) {
		double m = 0;
		try {
			m = Double.parseDouble(datastr);
		}catch(NumberFormatException ep) {
			System.out.println(ep.getMessage());
		}
		if(operator.equals("#")) {
			operand1 = m;
		}else {
			operand2 = m;
		}
		textField.setText(String.valueOf(m));
	}
	
	//完成一次計算後，清空操作數
	public void ResetAll() {
		operand1 = 0;
		operand2 = 0;
		temp = 0;
		operator = "#";
		express = "";
	}

}
