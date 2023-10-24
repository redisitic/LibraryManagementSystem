import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    JLabel welcomeLabel;
    JButton addBook;
    JButton searchBook;
    JButton logOutButton;

    public Dashboard() {
        super("Dashboard");
        setLayout(new GridLayout(4,1,8,8));
        setSize(400, 300);

        welcomeLabel = new JLabel("Welcome, " + Login.username);
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        addBook = new JButton("Add Book");
        addBook.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        addBook.addActionListener(this);
        searchBook = new JButton("Search Book");
        searchBook.addActionListener(this);
        searchBook.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        logOutButton = new JButton("Log Out");
        logOutButton.addActionListener(this);
        logOutButton.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        add(welcomeLabel);
        add(addBook);
        add(searchBook);
        add(logOutButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBook) {
            new AddBook();
            dispose();
        }
        if (e.getSource() == searchBook) {
            new SearchBook();
            dispose();
        }
        if(e.getSource() == logOutButton){
            new Login();
            dispose();
        }
    }
}