package Practice09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FlowLayoutLabel extends JFrame{
	FlowLayoutLabel(){
		setTitle("FlowLayout Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		JLabel lb = new JLabel();
		contentPane.add(lb);
		contentPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		for(int i= 1; i <= 15; i++) {
			String text = Integer.toString(i);
			JButton button = new JButton("버튼"+text);
			contentPane.add(button);
			button.addActionListener(event -> {lb.setText("버튼"+text);});
		}
		
		setSize(400, 300);
		setVisible(true);
		
	}	

	public static void main(String[] args) {
		new FlowLayoutLabel();
	}
}
	
