package Calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends MouseAdapter{  //MouseAdapter��������ʵ���˶���ӿ�
	JFrame list;
    JTextField show;
    JButton[] jbNum = new JButton[10];
    JPanel jpMain; // �����
    JPanel jpRight; // ���������Ҫ���ڴ��������͵Ⱥ�
    JPanel jpLight; // ����������ڴ������,����, ��.��
    JButton dight; // С����
    JButton add; // �Ӻ�
    JButton sub; // ����
    JButton multiply; // �˺�
    JButton divide; // ����
    JButton ce; // ���
    JButton equal; // ����
    JButton sqrt; // sqrt
    double sum = 0; // ��ʱ���
    boolean b = false; // ���������Ƿ񱻵��,�����Ƿ���֣�����ʵ����һ�ε����ťʱ���
    operator i = operator.un; // ��¼�Ⱥŷ����ǰĳһ������������������ʵ�����ӻ���������

    int op; // ��¼������	

// ������һ����+-*/
    enum operator {
        add, sub, mul, div, sqrt, un
    }

    void display() {
        // ���������ڣ����һ��Text��
        list = new JFrame("������");
        list.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���X�ر�
        list.setBounds(600, 550,360, 230);//���������С
        list.setResizable(false);//���ɷŴ󴰿�
        list.setLayout(new FlowLayout(FlowLayout.CENTER));//���������������м�
        show = new JTextField(31);//����Ϊ31���ı���ʾ��
        show.setHorizontalAlignment(JTextField.RIGHT); // �ı����������Ҷ���
        list.add(show);
        // ������岢���ò���
        jpMain = new JPanel();
        jpRight = new JPanel();
        jpLight = new JPanel();
        jpMain.setLayout(new GridLayout(1, 2));
        jpRight.setLayout(new GridLayout(4, 2, 3, 3));
        jpLight.setLayout(new GridLayout(4, 3, 3, 3));
        list.add(jpMain);
        jpMain.add(jpLight);
        jpMain.add(jpRight);
        // ����0~9��ť����
        for (int i = 9; i >= 0; i--) {
            jbNum[i] = new JButton(String.valueOf(i));//��ʾ����������
            //jbNum[i].setForeground(Color.BLUE);
            jpLight.add(jbNum[i]);
            jbNum[i].addMouseListener(this);
        }
        add = new JButton("+");
        sub = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");
        ce = new JButton("CE");
        equal = new JButton("=");
        sqrt = new JButton("sqrt");
        jpRight.add(divide);
        jpRight.add(sqrt);
        jpRight.add(multiply);
        jpRight.add(sub);
        jpRight.add(ce);
        jpRight.add(add);
        jpRight.add(equal);

        // �����а�ťע�������
        dight = new JButton(".");
        jpLight.add(dight);
        add.addMouseListener(this);
        sub.addMouseListener(this);
        multiply.addMouseListener(this);
        divide.addMouseListener(this);
        ce.addMouseListener(this);
        equal.addMouseListener(this);
        sqrt.addMouseListener(this);
        dight.addMouseListener(this);
        list.setVisible(true);

    }

    public void mouseClicked(MouseEvent e) {
        // 0~9������
        if (e.getSource() == jbNum[0]) {
            input(0, e);
        }
        if (e.getSource() == jbNum[1]) {
            input(1, e);
        }
        if (e.getSource() == jbNum[2]) {
            input(2, e);
        }
        if (e.getSource() == jbNum[3]) {
            input(3, e);
        }
        if (e.getSource() == jbNum[4]) {
            input(4, e);
        }
        if (e.getSource() == jbNum[5]) {
            input(5, e);
        }
        if (e.getSource() == jbNum[6]) {
            input(6, e);
        }
        if (e.getSource() == jbNum[7]) {
            input(7, e);
        }
        if (e.getSource() == jbNum[8]) {
            input(8, e);
        }
        if (e.getSource() == jbNum[9]) {
            input(9, e);
        }

        // С����,CE,�Ⱥ�
        if (e.getSource() == dight) {
            if (show.getText().indexOf('.') == -1) {
                show.setText(show.getText() + ".");
            }

        }
        if (e.getSource() == ce) {
            show.setText("0");
            sum = 0;
            i = operator.un;
            b = false;
        }
        outer: if (e.getSource() == equal) {
            try {
                if (i == operator.un) {
                    b = true;
                } else {
                    if (i == operator.add) {
                        sum += Double.parseDouble(show.getText());

                    }
                    if (i == operator.sub) {
                        sum -= Double.parseDouble(show.getText());

                    }
                    if (i == operator.mul) {
                        sum *= Double.parseDouble(show.getText());

                    }
                    if (i == operator.div) {
                        if (Double.parseDouble(show.getText()) != 0) {
                            sum /= Double.parseDouble(show.getText());

                        } else {
                            show.setText("ERROR");
                            b = true;
                            sum = 0;
                            break outer; // ��ִ��trimIn()���� ��Ļ��ʾ����
                        }
                    }
                  trimIn(sum);
                }
            } catch (Exception ex) {
                show.setText("ERROR");
                b = true;
                sum = 0;
            }

            sum = 0;
            i = operator.un;
            b = true;
        }
        if (e.getSource() == add) {
            cal(i);
            i = operator.add;
            b = true;

        }
        if (e.getSource() == sub) {
            cal(i);
            i = operator.sub;
            b = true;

        }
        if (e.getSource() == multiply) {
            cal(i);
            i = operator.mul;
            b = true;

        }
        if (e.getSource() == divide) {
            cal(i);
            i = operator.div;
            b = true;

        }
        try {
            if (show.getText() != "ERROR") {
                if (e.getSource() == sqrt) {
                    sum = Math.sqrt(Double.parseDouble(show.getText()));
                    trimIn(sum);
                    b = true;
                }
            }
        } catch (Exception ex) {
            show.setText("ERROR");
            b = true;
        }
    }

    // ����������������ݺ�ȡģ�ķ���
    public void cal(operator i) {
        try {
            if (show.getText() != "ERROR") {
                if (i == operator.un) {
                    sum = Double.parseDouble(show.getText());
                }
                if (i == operator.add) {
                    sum += Double.parseDouble(show.getText());
                    trimIn(sum);
                }
                if (i == operator.sub) {
                    sum -= Double.parseDouble(show.getText());
                    trimIn(sum);
                }
                if (i == operator.mul) {
                    sum *= Double.parseDouble(show.getText());
                    trimIn(sum);
                }
                if (i == operator.div) {
                    if (Double.parseDouble(show.getText()) != 0) {
                        sum /= Double.parseDouble(show.getText());
                        trimIn(sum);
                    } else {
                        //����0�󣬰�һ����������
                        show.setText("ERROR");
                        sum = 0;
                        b = true;
                        i=operator.un;
                    }
                }
            }
        } catch (Exception ex) {
            show.setText("ERROR");
            b = true;
        }
    }

    // �����������
    public void input(int i, MouseEvent e) {
        if (b == true) {
            show.setText(String.valueOf(i));//���ط���ԭʼֵ
            b = false;
        } else {
            //�ж�0��.���������ʱ����ĵ�
            if (show.getText().indexOf('0') == 0 && e.getSource() != dight) {
                show.setText(String.valueOf(i));
            } else {
                show.setText(show.getText() + String.valueOf(i));
            }
        }
    }

    // sum����ʾ��������ȥ��С�����0
    public void trimIn(double sum) {
        if (String.valueOf(sum).indexOf('.') != -1
                && String.valueOf(sum).endsWith("0")) {
            show.setText((String.valueOf(sum).substring(0, String.valueOf(sum)
                    .indexOf('.'))));

        } else if (Double.isNaN(sum)) {
            show.setText("ERROR");         //�� ������ʱ ��Ļ��ʾ���󣬲���sum����0 �������UN
            b = true;
            sum = 0;
            i = operator.un;
        } else if (Double.isInfinite(sum)) {
            show.setText("ERROR");          //����infinite(���޴�)ʱ��ʾ����SUM��0�������UN 
            b = true;
            sum = 0;
            i = operator.un;
        } else {
            show.setText(String.valueOf(sum));
        }
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.display();
    }

}




