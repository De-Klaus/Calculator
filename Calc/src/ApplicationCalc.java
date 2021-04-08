import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ApplicationCalc {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 100, 640, 480);
		
        
        
        var menuBar = new JMenuBar();
		JMenu main = new JMenu("Файл");
		JMenu size = new JMenu("Вид");
		JMenu obout = new JMenu("Справка");
		var font = new Font(null,Font.BOLD,12);
		main.setFont(font);
		size.setFont(font);
		obout.setFont(font);
		
		var menuInner = new JMenu("Цвет панели");
		main.add(menuInner);
		var item1 = new JMenuItem("Жёлтый");
		item1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuBar.setBackground(new Color(255,255,225));
			}
		});
		var item2 = new JMenuItem("Зелёный");
		item2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuBar.setBackground(new Color(0,255,25));
			}
		});
		var item3 = new JMenuItem("Фиолетовый");
		item3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuBar.setBackground(new Color(255,0,225));;
			}
		});
		item1.setFont(font);item2.setFont(font);item3.setFont(font);
		menuInner.add(item1);menuInner.add(item2);menuInner.add(item3);
		main.addSeparator();
		var item4 = new JMenuItem("Выход");
		main.add(item4);
		item4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		var menuSize = new JMenu("Размер окна");
		size.add(menuSize);
		var size1 = new JMenuItem("640х480");
		size1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setBounds(500, 100, 640, 480);
			}
		});
		var size2 = new JMenuItem("450х320");
		size2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setBounds(500, 100, 450, 320);
			}
		});
		var size3 = new JMenuItem("120х50");
		size3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setBounds(500, 100, 120, 50);
			}
		});
		size1.setFont(font);size2.setFont(font);size3.setFont(font);
		menuSize.add(size1);menuSize.add(size2);menuSize.add(size3);
		
		var menuObout = new JMenuItem("О программе");
		menuObout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DialogWindow().setVisible(true);
			}
		});
		
		obout.add(menuObout);
		
		menuBar.add(main);
		menuBar.add(size);
		menuBar.add(obout);
		frame.setJMenuBar(menuBar);
		
		var panel = new PanelCalc();
        frame.add(panel);
        frame.setVisible(true);

	}

}
