import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    
    JButton loginButton1;
    JButton loginButton2;
    JTextField userText;
    JTextField passText;
    JTextField adminText;
    JTextField pass2Text;
    public Login(){
        super("Login");
        setLayout(new GridLayout(6,1,8,8));
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

        JPanel titlePanel2 = new JPanel();
        titlePanel2.setLayout(new GridLayout(1, 1, 12, 12));
        JLabel titleLabel2 = new JLabel("Admin Login");
        titleLabel2.setFont(fontBold);
        titlePanel2.add(titleLabel2);

        JPanel loginPanel2 = new JPanel();
        loginPanel2.setLayout(new GridLayout(2, 2, 8, 8));
        JLabel adminLabel = new JLabel("Username: ");
        adminLabel.setFont(fontRegular);
        adminText = new JTextField("");
        adminText.setFont(fontRegular);
        JLabel pass2Label = new JLabel("Password: ");
        pass2Label.setFont(fontRegular);
        pass2Text = new JTextField("");
        pass2Text.setFont(fontRegular);

        loginPanel2.add(adminLabel);
        loginPanel2.add(adminText);
        loginPanel2.add(pass2Label);
        loginPanel2.add(pass2Text);

        loginButton2 = new JButton("Login");
        loginButton2.addActionListener(this);
        loginButton2.setFont(fontRegular);

        add(titlePanel1);
        add(loginPanel1);
        add(loginButton1);
        add(titlePanel2);
        add(loginPanel2);
        add(loginButton2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
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
            String pass = passText.getText();
            if(auth.Check(user, pass)){
                new Dashboard();
                dispose();
            } else {
                new LoginFailure();
            }
        }
        if(e.getSource() == loginButton2){
            try{
                @SuppressWarnings("unused")
                String user = adminText.getText(); 
                @SuppressWarnings("unused")
                String pass = passText.getText();
            }catch(NullPointerException npe){
                new LoginFailure();
            }
            String user = adminText.getText();
            String pass = pass2Text.getText();
            if(auth.AdminCheck(user, pass)){
                new AdminDashboard();
                dispose();
            } else {
                new LoginFailure();
            }
        }
    }
}