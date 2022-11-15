package Practice12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class VibFrameSar44 extends JFrame implements Runnable {
	Thread th; // 스레드
	public VibFrameSar44() {
		super("진동하는 프레임 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 200);
		setLocation(300, 300);
		setVisible(true);
		
		getContentPane().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(!th.isAlive()) return; // 이미 스레드가 종료되었다면 그냥 리턴
				th.interrupt(); // 진동 스레드에게 InterruptedException을 보내 강제 종료
			}
		});
		
		th = new Thread(this);
		th.start();
	}
	
	public void run() { // 프레임의 진동 일으키기 위해 20ms마다 프레임의 위치를 랜덤하게 이동
		Random r = new Random();
		Container c = getContentPane();
		int i = 0;
		
		while(true) {
			try {
				Thread.sleep(20); // 20ms만큼 실행\
				if(i == 0) {
					c.setBackground(Color.RED);
					i++;
				}
				else if(i == 1) {
					c.setBackground(Color.YELLOW);
					i++;
				}
				else if(i == 2) {
					c.setBackground(Color.BLUE);
					i++;
				}
				else if(i == 3) {
					c.setBackground(Color.GREEN);
					i++;
				}
				else if(i == 4) {
					c.setBackground(Color.MAGENTA);
					i = 0;
				}
			}
			catch(InterruptedException e) {
				return;
			}
			int x = getX() + r.nextInt()%5; // x의 새 위치
			int y = getY() + r.nextInt()%5;
			setLocation(x, y);
		}
	}

	public static void main(String[] args) {
		new VibFrameSar44();
	}
}
