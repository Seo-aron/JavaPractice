package Practice10;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class JTextArea extends JFrame {
	JTextArea ta = new JTextArea(7, 28);
	
	JTextAreaEx(){
		setTitle("파일 저장");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		Container c = getContentPane();		
		c.setLayout(new BorderLayout());
		CreatMenu();
		
		ta.setLineWrap(true); // 줄바꾸기 가능
		c.add(new JScrollPane(ta), BorderLayout.CENTER); // 스크롤
		
		setSize(300, 200);
		setVisible(true);
	}
	public void CreatMenu() { // 메뉴창
		JMenuBar mb = new JMenuBar();
		JMenu m = new JMenu("파일");
		JMenuItem mi = new JMenuItem("저장");
		
		mi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ta.getText().equals("")) { // 내용이 없을 경우
					JOptionPane.showMessageDialog(null, "내용이 없습니다", "에러", JOptionPane.ERROR_MESSAGE);
				}
				else {
					String fileName = JOptionPane.showInputDialog("저장할 파일명을 입력하세요");
					if(fileName == null) {
						return;
					}
					try {
						FileWriter fout = new FileWriter(fileName); // 파일 스트림 열기
						String t = ta.getText(); // 입력된 텍스트를 문자열로 얻어내기
						StringTokenizer st = new StringTokenizer(ta.getText(), "\n"); // 라인단위로 분리
						
						while(st.hasMoreTokens()) {
							fout.write(st.nextToken()); // 한 라인 쓰기
							fout.write("\r\n"); // 라인 끝에 다음줄로 넘어가는 문자 삽입
						}
						fout.close(); // 파일 스트림 닫기
					}
					catch (IOException e1) {};
				}
			}
		});
		
		m.add(mi);
		mb.add(m);
		
		setJMenuBar(mb);
	}
	public static void main(String[] args) {
		new JTextAreaEx();
	}

}
