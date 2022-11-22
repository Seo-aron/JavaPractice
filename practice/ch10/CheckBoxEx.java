package Practice10;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CheckBoxEx extends JFrame {
	JCheckBox [] button = new JCheckBox [2];
	String [] name = {"버튼 비활성화", "버튼 감추기"};
	JButton b = new JButton("test button");
	
	CheckBoxEx(){
		setTitle("CheckBox와 Item Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		MyItemListener listener = new MyItemListener();
		for(int i = 0; i < button.length; i++) {
			button[i] = new JCheckBox(name[i]);
			c.add(button[i]);
			button[i].addItemListener(listener);
		}

		c.add(b);
		
		setSize(300, 150);
		setVisible(true);
	}
	
	class MyItemListener implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) { // 체크박스가 선택될 경우
				if(e.getItem() == button[0]) // 버튼 비활성화
					b.setEnabled(false);				
				else if(e.getItem() == button[1]) // 버튼 감추기
					b.setVisible(false);
			}
			else { // 체크박스가 해제될 경우
				if(e.getItem() == button[0]) // 버튼 활성화
					b.setEnabled(true);				
				else if(e.getItem() == button[1]) // 버튼 보이기
					b.setVisible(true);
			}
		}
	}
	
	public static void main(String[] args) {
		new CheckBoxEx();
	}

} 
