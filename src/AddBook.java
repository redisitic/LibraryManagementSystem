import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddBook extends JFrame implements ActionListener {
    JButton backDash;
    JButton add;
    TextField title;
    TextField author;
    TextField quantity;
    TextField description;

    AddBook(){
        super("Dashboard");
        setLayout(new GridLayout(5,2,8,8));
        setSize(400, 300);

        JLabel titleLabel = new JLabel("Title: ");
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        title = new TextField("");
        title.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        JLabel authorLabel = new JLabel("Author: ");
        authorLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        author = new TextField("");
        author.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        
        JLabel quantityLabel = new JLabel("Quantity: ");
        quantityLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        quantity = new TextField("");
        quantity.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        JLabel descriptionLabel = new JLabel("Description: ");
        descriptionLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        description = new TextField("");
        description.setFont(new Font("Segoe UI", Font.PLAIN, 10));

        add = new JButton("Add");
        add.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        add.addActionListener(this);

        backDash = new JButton("Go Back");
        backDash.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        backDash.addActionListener(this);

        add(titleLabel);
        add(title);
        add(authorLabel);
        add(author);
        add(quantityLabel);
        add(quantity);
        add(descriptionLabel);
        add(description);
        add(add);
        add(backDash);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backDash){
            new Dashboard();
            dispose();
        }
        if(e.getSource() == add){
            String title = this.title.getText();
            String author = this.author.getText();
            int quantity = Integer.parseInt(this.quantity.getText());
            String description = this.description.getText();
            Book book = new Book(title, author, quantity, description);
            new Dashboard();
            dispose();
        }
    }
    public static void main(String[] args) {
        new AddBook();
    }
}