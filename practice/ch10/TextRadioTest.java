package Practice10;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TextRadioTest extends JFrame {
	JRadioButton [] rb = new JRadioButton[4];
	String [] name = {"decimal", "binary", "octal", "hex"};
	
	TextRadioTest(){
		setTitle("Digit Changer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		
		JTextField src = new JTextField(8); // 입력용 텍스트필드
		JTextField dest = new JTextField(8); // 출력용 텍스트필드		
		c.add(src);
		c.add(dest);
		//int n = Integer.parseInt(src.getText()); // Exception in thread "main" java.lang.NumberFormatException: For input string: "" 에러 떠서 주석처리
		
		ButtonGroup g = new ButtonGroup(); // 버튼 그룹 객체 생성 (라디오버튼)
		
		for(int i = 0; i < rb.length; i++) {
			rb[i] = new JRadioButton(name[i]);
			g.add(rb[i]);
			c.add(rb[i]);
			
			rb[i].addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED && !src.getText().equals("")) {
					if(e.getItem() == rb[0]) { // 10진수
						dest.setText(Integer.toString(Integer.parseInt(src.getText())));
					}
					else if(e.getItem() == rb[1]) { // 2진수
						dest.setText(Integer.toBinaryString(Integer.parseInt(src.getText())));
					}
					else if(e.getItem() == rb[2]) { // 8진수
						dest.setText(Integer.toOctalString(Integer.parseInt(src.getText())));
					}
					else { // 16진수
						dest.setText(Integer.toHexString(Integer.parseInt(src.getText())));
					}
				}
			}	
		});	
	}
		setSize(260,150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new TextRadioTest();
	}

}
