import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelCalc extends JPanel{
	
	private JLabel label;//табло калбкулятора
	private String number1 = "", number2 = "";
	int oper;//номер выбранной операции
	boolean start = false;//для очистки памяти при вводе нового числа
	private String[] btnLabels = { "<-", "x^2", "√", "/", 
			   "7", "8", "9", "*", 
			   "4", "5", "6", "-", 
			   "1", "2", "3", "+",
			   "C", "0", ",", "=" }; //заготовка значений для кнопок
	
	public PanelCalc() {
		setLayout(new GridLayout(6,1));
		var font = new Font("Verdana", Font.BOLD, 40);
		
		label = new JLabel("0.0");
		label.setHorizontalAlignment(JLabel.RIGHT);
		label.setFont(font);
		label.setOpaque(true);
		label.setBackground(new Color(255, 255, 255));
		label.setBorder(new EmptyBorder(20,0,10,20));
		
		JButton btn[] = new JButton[20];
		var btnFont = new Font(null, Font.BOLD, 30);
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton();
			btn[i].setFont(btnFont);
			btn[i].setBackground(new Color(220, 220, 220));
			btn[i].setForeground(Color.BLACK);
			btn[i].setText(btnLabels[i]); //присвоение значений кнопкам
			btn[i].addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e)  {
					JButton btn = (JButton) e.getSource();//Получили кнопку на которую кликнули
					String str = btn.getText();
	
					if(str.equals("Выход")) {
						System.exit(0);
					}
					else if(str.equals("C")) {
						label.setText("0.0");
						number1 = "";
						number2 = "";
						start = false;
					}
					else if(str.equals("=")) {
						number2 = label.getText();
						if(oper == 1) {
							label.setText((Double.parseDouble(number1) + Double.parseDouble(number2))+"");
						}
						if(oper == 2) {
							label.setText("" + (Double.parseDouble(number1) - Double.parseDouble(number2)));
						}
						if(oper == 3) {
							label.setText("" + (Double.parseDouble(number1) * Double.parseDouble(number2)));
						}
						if(oper == 4) {
							if(number2.equals("0.0")) {
								try {
									throw new Exception("На 0 делить нельзя!");
								}
								catch (Exception e1) {
									System.out.println(e1.getMessage());
								}
							}
							label.setText("" + (Double.parseDouble(number1) / Double.parseDouble(number2)));
						}
						start = false;
					}
					else if(str.equals("√")) {
						number1 = label.getText();
						number2 = Math.sqrt(Double.parseDouble(number1))+"";
						label.setText("" + number2);
						start = false;
					}
					else if(str.equals("x^2")) {
						number1 = Double.parseDouble(label.getText())+"";
						number2 = ""+Math.pow(Double.parseDouble(number1), 2);
						label.setText("" + number2);
						start = false;
					}
					else if(str.equals("<-")) {
						number1 = label.getText();
						if(number1.length()==1) {
							label.setText("0.0");
							start = false;
						}
						else {
							number1 = number1.substring(0, number1.length() - 1);
							label.setText("" + number1);
							start = true;
						}
					}
					else if(str.equals(",")) {
						number1 = label.getText();
						if(number1.indexOf(",")==-1) {
							label.setText(number1+".");
				             }
						else {
							number2 = number1+".";
							label.setText(number1);
						}
						start = true;
					}
					else if(str.equals("+")) {
						oper = 1;
						number1 = Double.parseDouble(label.getText())+"";
						start = false;
					}
					else if(str.equals("-")) {
						oper = 2;
						number1 = Double.parseDouble(label.getText())+"";
						start = false;
					}
					else if(str.equals("*")) {
						oper = 3;
						number1 = Double.parseDouble(label.getText())+"";
						start = false;
					}
					else if(str.equals("/")) {
						oper = 4;
						number1 = Double.parseDouble(label.getText())+"";
						start = false;
					}
					else if(str.equals("0.0")) {
						if(start) {
							str = label.getText()+str;
							label.setText(str);
						}
						else {
							str = btn.getText();
							label.setText(str);
							start = false;
						}
					}
					else {
						if(start) {
							str = label.getText()+str;
							label.setText(str);
						}
						else {
							str = btn.getText();
							label.setText(str);
							start = true;
						}
					}
				}
			});
		}
		add(label);
		
		int j = -1;
		JPanel panel[] = new JPanel[5];
		for(int i =0; i < 20; i++) {
			if (i % 4 == 0) {
				j++;
				panel[j] = new JPanel();
				panel[j].setLayout(new GridLayout(1,4));
				add(panel[j]);
			}
			panel[j].add(btn[i]);
		}
	}
}
