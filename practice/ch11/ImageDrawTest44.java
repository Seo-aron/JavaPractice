package Practice11;

import javax.swing.*;
import java.awt.*;

public class ImageDrawTest44 extends JFrame {
	ImageDrawTest44(){
		super("실습문제 2번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new SARPanel());
		
		setSize(300, 300);
		setVisible(true);
	}
	class SARPanel extends JPanel {
		public SARPanel() {
			setLayout(new FlowLayout());
			add(new JButton("Hello"));
		}
		ImageIcon icon = new ImageIcon("Images/back.jpg"); 
		Image img = icon.getImage();
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		}
	}

	public static void main(String[] args) {
		new ImageDrawTest44();
	}

}
