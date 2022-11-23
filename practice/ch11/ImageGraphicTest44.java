package Practice11;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ImageGraphicTest44 extends JFrame {
	ImageGraphicTest44(){
		super("실습문제 6번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new AronPanel());
		
		setSize(300, 300);
		setVisible(true);
	}
	
	class AronPanel extends JPanel{
		ImageIcon icon = new ImageIcon("Images/apple.jpg"); 
		Image img = icon.getImage();
		 int x = img.getWidth(this); 
		 int y = img.getHeight(this);
		 
		 public AronPanel() {
			 addKeyListener(new KeyAdapter() {
				 public void keyPressed(KeyEvent e) {
						if(e.getKeyChar() == '+') {
							x = x + x/10;
							y = y + y/10;
						}
						else if(e.getKeyChar() == '-') {
							x = x - x/10;
							y = y - y/10;
						}
						repaint();
					}
			 });
			 
			 setFocusable(true);
			 requestFocus();
		 }
		 
		 public void paintComponent(Graphics g) {
				super.paintComponent(g);
				
				g.drawImage(img, 10, 10, x, y, this);
			}
	}
	
	public static void main(String[] args) {
		new ImageGraphicTest44();
	}
}
