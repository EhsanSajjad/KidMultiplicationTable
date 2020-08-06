package kidsmultiplicationtable;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KidsMultiplicationTable extends JFrame {

    private Container c;
    private Font f;
    private JLabel imgLabel, textLabel;
    private ImageIcon img;
    private JButton btn;
    private JTextField tf;
    private JTextArea ta;
    private Cursor cur;

    KidsMultiplicationTable() {
        
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.MAGENTA);

        img = new ImageIcon(getClass().getResource("mul.gif"));
        this.setIconImage(img.getImage());

        f = new Font("Arial", Font.BOLD, 20);

        cur = new Cursor(Cursor.HAND_CURSOR);

        imgLabel = new JLabel(img);
        imgLabel.setBounds(20, 20, 280, 160);
        c.add(imgLabel);

        textLabel = new JLabel("Enter any number ");
        textLabel.setBounds(20, 200, 180, 30);
        textLabel.setForeground(Color.DARK_GRAY);
        textLabel.setFont(f);
        c.add(textLabel);

        tf = new JTextField();
        tf.setBounds(220, 200, 80, 30);
        tf.setBackground(Color.PINK);
        tf.setForeground(Color.BLACK);
        tf.setHorizontalAlignment(JTextField.CENTER);
        tf.setFont(f);
        c.add(tf);

        btn = new JButton("Clear");
        btn.setBounds(220, 240, 80, 30);
        btn.setBackground(Color.cyan);
        btn.setCursor(cur);
        c.add(btn);

        ta = new JTextArea();
        ta.setBackground(Color.pink);
        ta.setBounds(20, 300, 280, 290);
        ta.setForeground(Color.blue);
        ta.setFont(f);
        c.add(ta);

        tf.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String value = tf.getText();
                if (value.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You did not Enter any number.");
                } else {
                    ta.setText("");
                    int num = Integer.parseInt(tf.getText());

                    ta.setText("\n");
                    for (int i = 1; i <= 10; i++) {
                        int result = num * i;

                        String res = String.valueOf(result);
                        String n = String.valueOf(num);
                        String I = String.valueOf(i);

                        ta.append("  " + n + " X " + I + " = " + res + "\n");

                    }

                }

            }
        });

        btn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ta.setText("");
                tf.setText("");
            }
        });
    }

    public static void main(String[] args) {

        KidsMultiplicationTable frame = new KidsMultiplicationTable();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(KidsMultiplicationTable.EXIT_ON_CLOSE);
        frame.setBounds(850, 40, 335, 650);
        frame.setTitle("Kids Multiplication Table");
        
    }

}
