package NoteBook2;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class NoteBook2 implements Serializable{
	public static void main(String[] args) {
		//String s = null;
		new NoteBook2();
	}
	
	public NoteBook2(){
		JFrame frame = new JFrame("���±�");//����
		
		Container c = frame.getContentPane();//��ʼ��һ������
		JTextArea jt = new JTextArea();
		 JButton coc = new JButton("����");
		 JButton cod = new JButton("��");
		 coc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						StringTokenizer st = new StringTokenizer(jt.getText(), "\n");
						// �����һ���ַ����ǺŴ���������һ��������Ҫ������ַ�������һ������ʲô
						// �ֿ�����ַ�����������\n�Ȼس�����һ���س�����һ��δ������
						FileOutputStream fo = new FileOutputStream("C:\\Users\\86138\\Desktop\\���±�����.txt");
						PrintStream so = new PrintStream(fo);
						so.print(jt.getText());
						so.flush();
						so.close();
						System.out.println(jt.getText());
						while (st.hasMoreTokens())// �����δ������
							fo.close();
					} catch (IOException ee) {
					}
				}
			});
		 cod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FileInputStream fis = null;
					try {
						fis = new FileInputStream("C:\\Users\\86138\\Desktop\\���±�����.txt");
						byte[] bytes = new byte[4];//׼��һ�����飬��ʱһ���Զ�4���ֽ�
						int readCount = 0;
						String s = null;
						try {
							while((readCount = fis.read(bytes))!=-1){
								s=new String(bytes, 0, readCount);
								jt.setText(jt.getText()+s);
								
								System.out.print(s);//��byte����ת�����ַ������������ٸ�ת�����ٸ�
								
								
							}
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}finally{
						if(fis != null){
							try {
								fis.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
			}
		 
		
		
		
	});
	c.add(coc, BorderLayout.NORTH);
	c.add(cod, BorderLayout.SOUTH);
	
	c.add(jt);
	jt.setBounds(0, 0, 800, 600);
	frame.setVisible(true);//�ɼ���
	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//�رմ��ڽ�������
	frame.setBounds(500, 200, 1000, 700);//����λ��
	frame.setResizable(true);//���ÿɸı䴰���С
	}
	

}
