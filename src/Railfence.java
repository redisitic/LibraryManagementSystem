import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;


public class Railfence extends JFrame implements ActionListener{

    GridLayout layout = new GridLayout(4, 2, 10, 10);
    Font plain = new Font("Segoe UI", Font.PLAIN, 20);
    Font bold = new Font("Segoe UI", Font.BOLD, 20);

    JTextField tf1;
    JTextField tf2;
    JTextField tf3;
    JButton button1;
    JButton button2;
    public Railfence(){

        JLabel l1 = new JLabel("Enter the sentence: ");
        l1.setFont(bold);
        JLabel l2 = new JLabel("Enter the Height: ");
        l2.setFont(bold);
        JLabel l3 = new JLabel("Output: ");
        l3.setFont(bold);
        
        tf1 = new JTextField("");
        tf1.setFont(plain);
        tf2 = new JTextField("");
        tf2.setFont(plain);
        tf3 = new JTextField("");
        tf3.setFont(bold);
        tf3.setBackground(new Color(0, 0, 0));
        tf3.setForeground(new Color(0, 255, 0));
        tf3.setEditable(false);

        button1 = new JButton("Encrypt");
        button1.addActionListener(this);
        button2 = new JButton("Decrypt");
        button2.addActionListener(this);

        this.add(l1);
        this.add(tf1);
        this.add(l2);
        this.add(tf2);
        this.add(button1);
        this.add(button2);
        this.add(l3);
        this.add(tf3);
        this.setTitle("Railfence Encryptor");
        this.setLayout(layout);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    public static String encrypt(String str, int n){
        int m = str.length();
        char[][] rail = new char[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(rail[i], '\n');
        boolean direction = false;
        int row = 0;
        int col = 0;
        for (int i = 0; i < m; i++) {
            if (row == 0 || row == (n - 1))
                direction = !direction;
            rail[row][col++] = str.charAt(i);
            if (direction)
                row++;
            else
                row--;
        }
        StringBuilder encryptedStr = new StringBuilder();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (rail[i][j] != '\n')
                    encryptedStr.append(rail[i][j]);
 
        return encryptedStr.toString();
    }

    public static String decrypt(String str, int n){
        int m = str.length();
        char[][] rail = new char[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(rail[i], '\n');
        boolean direction = true; 
        int row = 0, col = 0;
        for (int i = 0; i < m; i++) {
            if (row == 0)
                direction = true;
            if (row == n - 1)
                direction = false;
            rail[row][col++] = '*';
            if (direction)
                row++;
            else
                row--;
        }
        int index = 0;
        for (int i = 0; i <n; i++)
            for (int j = 0; j < m; j++)
                if (rail[i][j] == '*' && index < m)
                    rail[i][j] =str.charAt(index++); 
        StringBuilder result = new StringBuilder(); 
        row = 0;
        col = 0;
        for (int i = 0; i < m; i++) {
            if (row == 0)
                direction = true;
            if (row == n - 1)
                direction = false;
            if (rail[row][col] != '*')
                result.append(rail[row][col++]);
            if (direction)
                row++;
            else
                row--;
        }
        return result.toString();
    }

    public void actionPerformed(ActionEvent e){
        String str;
        int n;
        if(e.getSource() == button1){
            str = tf1.getText();
            n = Integer.parseInt(tf2.getText());
            tf3.setText(encrypt(str, n));
        }
        if(e.getSource() == button2){
            str = tf1.getText();
            n = Integer.parseInt(tf2.getText());
            tf3.setText(decrypt(str, n));
        }
    }
    public static void main(String args[]){
        new Railfence();
    }
}