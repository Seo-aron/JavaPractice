package Practice11;

import javax.swing.*;
import java.awt.*;

public class PaintTest44 extends JFrame {
	PaintTest44(){
		super("1번 실습문제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		
		setSize(900,500);
		setVisible(true);
		
	}
	
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 빨간색 박스
			g.setColor(Color.RED);
			g.drawRect(1, 1, 191, 191); // 원
			g.setColor(Color.RED);
			g.drawRect(1, 201, 191, 191); // 마름모
			g.setColor(Color.RED);
			g.drawRect(201, 1, 270, 135); // 오륜기
			g.setColor(Color.RED);
			g.drawRect(201, 201, 101, 101); // 격자
			// (1) 삼색원
			g.fillArc(11,11,170,170,90,120);
			g.setColor(Color.BLUE);
			g.fillArc(11,11,170,170,210,120);
			g.setColor(Color.YELLOW);
			g.fillArc(11,11,170,170,330,120);
			// (2) 오륜기
			g.setColor(Color.BLUE);
			g.drawOval(211, 10, 77, 77);
			g.setColor(Color.BLACK);
			g.drawOval(298, 10, 77, 77);
			g.setColor(Color.RED);
			g.drawOval(385, 10, 77, 77);
			
			g.setColor(Color.YELLOW);
			g.drawOval(254, 48, 77, 77);
			g.setColor(Color.GREEN);
			g.drawOval(341, 48, 77, 77);
			// (3) 마름모
			g.setColor(Color.RED);
			int []x = {96, 1, 96, 192};
			int []y = {201, 295, 392, 295};
			g.drawPolygon(x, y, 4);
			// (4) 격자
			int a = 0;
			int b = 0;
			for(int i = 0; i < 9; i++) {
				g.drawLine(211+a, 201, 211+a, 302);
				g.drawLine(201, 211+b, 302, 211+b);
				a += 10;
				b += 10;
				}
		}
	}
	public static void main(String[] args) {
		new PaintTest44();
	}

}
