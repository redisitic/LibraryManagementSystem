import javax.swing.*;
import LibFuncs.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    public static String username;
    JButton loginButton1;
    JButton loginButton2;
    JButton quitButton;
    JTextField userText;
    JTextField passText;
    public Login(){
        super("Login");
        setLayout(new GridLayout(4,1,8,8));
        setSize(400, 300);

        Font fontRegular = new Font("Segoe UI", Font.PLAIN, 20);
        Font fontBold = new Font("Segoe UI", Font.BOLD, 20);
        
        JPanel titlePanel1 = new JPanel();
        titlePanel1.setLayout(new GridLayout(1, 1, 12, 12));
        JLabel titleLabel1 = new JLabel("User Login");
        titleLabel1.setFont(fontBold);
        titlePanel1.add(titleLabel1);

        JPanel loginPanel1 = new JPanel();
        loginPanel1.setLayout(new GridLayout(2, 2, 8, 8));
        JLabel userLabel = new JLabel("Username: ");
        userLabel.setFont(fontRegular);
        userText = new JTextField("");
        userText.setFont(fontRegular);
        JLabel passLabel = new JLabel("Password: ");
        passLabel.setFont(fontRegular);
        passText = new JTextField("");
        passText.setFont(fontRegular);

        loginPanel1.add(userLabel);
        loginPanel1.add(userText);
        loginPanel1.add(passLabel);
        loginPanel1.add(passText);

        loginButton1 = new JButton("Login");
        loginButton1.setFont(fontRegular);
        loginButton1.addActionListener(this);

        quitButton = new JButton("Quit");
        quitButton.addActionListener(this);
        quitButton.setFont(fontRegular);

        add(titlePanel1);
        add(loginPanel1);
        add(loginButton1);
        add(quitButton);

        titleLabel1.setHorizontalAlignment(JLabel.CENTER);
        userLabel.setHorizontalAlignment(JLabel.CENTER);
        passLabel.setHorizontalAlignment(JLabel.CENTER);
        loginButton1.setHorizontalAlignment(JButton.CENTER);
        quitButton.setHorizontalAlignment(JButton.CENTER);


    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Authenticate auth = new Authenticate();

        if(e.getSource() == loginButton1){
            try{
                @SuppressWarnings("unused")
                String user = userText.getText();
                @SuppressWarnings("unused")
                String pass = passText.getText();
            }catch(NullPointerException npe){
                new LoginFailure();
            }
            String user = userText.getText();
            username = user;
            String pass = passText.getText();
            if(auth.Check(user, pass)){
                new Dashboard();
                dispose();
            } else {
                new LoginFailure();
            }
        }
        if(e.getSource() == quitButton){
            dispose();
        }
    }
}